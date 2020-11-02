/*
TableAdapter
*/

public class Main {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable{  //create adapter of interface ATable and interface BTable;
        private ATable aTable;

        public TableAdapter(ATable aTable) {
            this.aTable = aTable;
        }

        public String getHeaderText() {
            return String.format("[%s] : %s", aTable.getCurrentUserName(), aTable.getTableName());
        }
    }


    public interface ATable {
        String getCurrentUserName();

        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}

/*Требования:

Класс TableAdapter должен адаптировать ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".

Пример, "[Amigo] : DashboardTable"

•	Класс Solution должен содержать public static интерфейс ATable.
•	Класс Solution должен содержать public static интерфейс BTable.
•	Класс Solution должен содержать public static класс TableAdapter.
•	Класс TableAdapter должен реализовывать интерфейс BTable.
•	Класс TableAdapter должен содержать приватное поле aTable типа ATable.
•	Класс TableAdapter должен содержать конструктор с параметром ATable.
•	Класс TableAdapter должен переопределять метод getHeaderText согласно заданию.*/