/*Разные методы для разных типов В этой задаче тебе нужно: 
Считывать с консоли данные, пока не будет введено слово "exit". 

Для каждого значения, кроме "exit", вызвать метод print(). 
Если значение: содержит точку '.', вызвать метод print() для Double; 
больше нуля, но меньше 128, вызвать метод print() для short; 
меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer; 
иначе — вызвать метод print() для String.

Требования:

1)Программа должна считывать данные с клавиатуры.
2)Программа должна прекращать считывать данные с клавиатуры после того, как введена строка "exit".
3)Если введенная строка содержит точку("."), и ее можно корректно преобразовать в число типа Double - должен быть вызван метод print(Double value).
4)Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0, но меньше 128 - должен быть вызван метод print(short value).
5)Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
6)Во всех остальных случаях должен быть вызван метод print(String value).*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

/*
Разные методы для разных типов
*/


public class DifferentTypes {

    public static void main(String[] args) throws IOException, NumberFormatException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = reader.readLine();
            if(s.equals("exit")) break;
            if(s.contains(".")){
                try{
                    double num = Double.parseDouble(s);
                    print(num);}
                catch(Exception e){
                    print(s);}
            }
            else{
                try{
                    int num;
                    num = Integer.parseInt(s);
                    if(num > 0 && num < 128){
                        print((short)num);
                    }
                    else{
                        print((Integer)num);
                    }
                }
                catch(Exception e){
                    print(s);
                }

            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
