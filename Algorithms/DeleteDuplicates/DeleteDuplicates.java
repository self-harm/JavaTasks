/*Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.

Требования:
Программа не должна выводить текст на экран.
Программа не должна считывать значения с клавиатуры.
Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей.
Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().*/

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class DeleteDuplicates {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put("LastName"+i, "FirstName"+i);
        }
    return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);

        for (String name : copy.values()) {
            int count = 0;
            for (String nameTmp : map.values()) {
                if (nameTmp.equals(name)) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, name);
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
