package io.harmed;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        /** 1s task*/
//        Scanner scan = new Scanner(System.in);
//
//        while (scan.hasNext()){
//            int a = scan.nextInt();
//            System.out.println(a);
        
        /** 2d task*/
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double d = scan.nextDouble();
        
        /*: If you use the nextLine() method immediately following the nextInt() method,
         recall that nextInt() reads integer tokens; because of this, the last newline
         character for that line of integer input is still queued in the input buffer
         and the next nextLine() will be reading the remainder of the integer line (which is empty).

         we need to clear the buffer by using scan.nextLine();*/
        scan.nextLine();
        String s = scan.nextLine();
        
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

        }
    }
