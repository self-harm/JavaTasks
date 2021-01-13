import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
find factorial

Факториал Напиши метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа, включая его.

Пример вычислений: 4! = factorial(4) = 123*4 Пример вывода: 24

Для этого: Введи с консоли число меньше либо равно 150. Реализуй функцию factorial. Если введенное число меньше 0, выведи 0. 0! = 1

Требования:

1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить на экран факториал введенного числа.
3. Метод factorial должен возвращать строковое представление факториала числа, переданного ему в качестве параметра.
4. Метод factorial должен принимать один параметр типа int.
*/

public class Factorial {

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(reader.readLine()); //read from the keyboard;
            reader.close();  //close the stream;
            System.out.println(factorial(input));
        }

        public static String factorial(int n){  // method 'find a factorial';
            ArrayList<Integer> list = new ArrayList<Integer>(); //create new arraylist;
            BigInteger fact = BigInteger.valueOf(1);

            for(int i = 1; i <= n; i++){
                fact= fact.multiply(BigInteger.valueOf(i));
            }
            if(n == 0){
                fact = BigInteger.valueOf(1);
            }
            else if(n < 0){
                fact = BigInteger.valueOf(0);
            }
            String str1 = fact.toString(); //transform BigInteger to String and return it; 
            return str1;
        }
    }
