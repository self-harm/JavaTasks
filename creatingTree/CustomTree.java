import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{

    /*тк мы создаем дерево, то нам недоступны стандартные и привычные методы List'ов
    * таким образом переопределяем некоторые методы ниже*/
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
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
    }
}
