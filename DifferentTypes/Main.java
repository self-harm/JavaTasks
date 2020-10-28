import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

/*
Разные методы для разных типов
*/


public class Main {

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