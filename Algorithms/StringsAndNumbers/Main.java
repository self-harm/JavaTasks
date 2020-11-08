import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
/* 
Задача по алгоритмам
*/

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()) {
            String s = reader.readLine();
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for(int i=0; i< array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (!isNumber(array[i]) && !isNumber(array[j])){  //строки
                    if(isGreaterThan(array[i], array[j])){
                        String a = array[i];
                        array[i]=array[j];
                        array[j]=a;
                    }
                }
                else if(isNumber(array[j]) && isNumber(array[i]) && ((Integer.parseInt(array[i])) < (Integer.parseInt(array[j])))){  //числа
                    String a = array[i];
                    array[i]=array[j];
                    array[j]=a;
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];

            // есть '-' внутри строки
            if (i != 0 && character == '-') {
                return false;
            }

            // не цифра и не начинается с '-'
            if (!Character.isDigit(character) && character != '-') {
                return false;
            }

            // одиночный '-'
            if (chars.length == 1 && character == '-') {
                return false;
            }
        }

        return true;
    }
}
