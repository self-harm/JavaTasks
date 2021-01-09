import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    /*Стартовый корень для дерева*/
    Entry<String> root;

    /**Коллекия для хранения элементов дерева
    * состоит из элементов-объектов класса Entry<>*/
    private transient ArrayList<Entry<String>> queue;

    public CustomTree() {
        this.root = new Entry<>(null);
        root.newLineRootElement = true;
        root.lineNumber = 0;
    }

    /**
     * Метод getParent принимает значение String value, ищет в древе Entry c значением elementName эквивалентным
     * значению value, и возвращает значение elementName у найденного Entry (Entry.parent)
     *
     * @param value elementName переданного Entry
     * @return parent.elementName найденного Entry (Entry.parent)
     */
    public String getParent(String value){
        setValidCollection();
        String s = null;
        for (Entry<String> entry : queue) {
            if (entry.lineNumber != 1) {
                if (entry.elementName.equals(value)) {
                    s = entry.parent.elementName;
                    break;
                }
            }
        }
        return s;
    }

    /**
     * Метод setUpCollection проходит по дереву, начиная с элемента Entry<String> root и перезаписывает все элементы в
     * queue;
     *
     * @param root начальный элемент Entry<String> для вертикального прохода по дереву.
     */
    private void setUpCollection(Entry<String> root){
        queue = new ArrayList<>();
        Queue<Entry<String>> subQueue = new LinkedList<Entry<String>>();
        queue.add(root);
        subQueue.add(root);
        do {
            if (!subQueue.isEmpty()) {
                root = subQueue.poll();
            }
            if (root.leftChild != null) {
                queue.add(root.leftChild);
                subQueue.add(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.add(root.rightChild);
                subQueue.add(root.rightChild);
            }
        } while (!subQueue.isEmpty());

    }

    /**
     * Метод setValidCollection записывает полную коллекцию элементов дерева, а затем удаляет 1 элемент коллекции,
     * который является изначальным корнем.
     * Используется в методах remove и т.д. для валидного прохода по коллекции.
     */
    private void setValidCollection() {
        setUpCollection(root);
        queue.remove(0);
    }

    /**
     * Метод add добавляет элемент в дерево. Сначала устанавливается полная коллекция элементов, потом происходит
     * итерация по элементам. При итерации каждый элемент проверяется методом checkChildren на возможность иметь
     * ветви. isAvailableToAddChildren() возвращает true если такая возможность имеется; После чего создается и
     * инициализируется новый элемент Entry<String>, добавляется в коллекцию. После чего коллекция заного
     * проверяется и инициализируется с помощью setValidCollection();
     *
     * @param s строка (String) которую необходимо добавить в коллекцию;
     * @return true после добавления нового элемента;
     */
    @Override
    public boolean add(String s) {
        setUpCollection(root);
        for (Entry<String> entry : queue) {
            entry.checkChildren();
            if (entry.isAvailableToAddChildren()) {
                createChild(entry, s);
                setValidCollection();
                return true;
            }
        }
        return false;
    }

    /**
     * Доп. метод для подстраховки. При удалении иногда получается 2 элемента newLineRootElement;
     * Этот метод собирает вертикально все такие элементы и снимает флаги newLineRootElement;
     *
     * @param entry Entry<String> со значением true переменной newLineRootElement, которая подлежит
     *              изменению;
     * @return список начиная с Entry<String> entry и заканчивая всеми его parent со значением true
     * переменной newLineRootElement, которая подлежит изменению;
     */
    private List<Entry<String>> getNewLineRootElementsCollection(Entry<String> entry) {
        ArrayList<Entry<String>> list = new ArrayList<>();
        list.add(entry);
        if ((entry.parent != null) && (entry.parent.newLineRootElement)) {
            list.addAll(getNewLineRootElementsCollection(entry.parent));
        }
        return list;
    }

    /**
     * Метод createChild создает новый элемент Entry<String> и устанавливает значение переменной parent
     *
     * @param parent родительский элемент Entry<String>;
     * @param s      значение elementName для нового элемента Entry<String>;
     */
    private void createChild(Entry<String> parent, String s) {
        Entry<String> newOne = new Entry<String>(s);
        newOne.parent = parent;
        newOne.lineNumber = parent.lineNumber + 1;
        setChild(parent, newOne);
    }

    /**
     * Метод setChild присваивает переменным left/rightChild родителя ссылку на элемент Entry<String> child;
     * Если переменная newLineRootElement родителя имела значение true, то это значение передастся ребенку, у
     * родителя изменится на false;
     *
     * @param parent родительский элемент Entry<String>
     * @param child  элемент-потомок Entry<String>
     */
    private void setChild(Entry<String> parent, Entry<String> child) {
        if (parent.availableToAddLeftChildren) {
            parent.leftChild = child;
            parent.availableToAddLeftChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) {
                    entry.newLineRootElement = false;
                }
                child.newLineRootElement = true;
            }
        } else {
            parent.rightChild = child;
            parent.availableToAddRightChildren = false;
            if (parent.newLineRootElement) {
                List<Entry<String>> list = getNewLineRootElementsCollection(parent);
                for (Entry<String> entry : list) {
                    entry.newLineRootElement = false;
                }
                child.newLineRootElement = true;
            }
        }
    }

    /*тк мы создаем дерево, то нам недоступны стандартные и привычные методы List'ов
    * таким образом переопределяем некоторые методы ниже*/
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return Размер коллекции элементов Entry<String>;
     */
    @Override
    public int size() {
        /*убираем корневое значение(первый root)*/
        setValidCollection();
        return queue.size();
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }
    public String remove(int index){
        throw new UnsupportedOperationException();
    }
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }

    /*создаем вложенный параметизированный класс для описания элементов дерева*/
    static class Entry<T> implements Serializable{

        int lineNumber;
        boolean newLineRootElement;
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        /*метод возвращает дизьюнкцию полей availableToAddLeftChildren, availableToAddRightChildren*/
        /*Дизью́нкция, логи́ческое сложе́ние, логи́ческое ИЛИ, включа́ющее ИЛИ;
         иногда просто ИЛИ — логическая операция, по своему применению максимально приближённая к союзу «или»
         в смысле «или то, или это, или оба сразу».*/
        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        private void checkChildren() {
            if (this.leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (this.rightChild != null) {
                availableToAddRightChildren = false;
            }
        }
    }
}
