package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
    
        if (string == null) {throw new TooShortStringException();}
        
        String[] list = string.split(" ");
         
        if (list.length < 5){throw new TooShortStringException();}

        return list[1] + " " + list[2] + " " + list[3] + " " + list[4];
    }
    

    public static class TooShortStringException extends RuntimeException {
    }
}
