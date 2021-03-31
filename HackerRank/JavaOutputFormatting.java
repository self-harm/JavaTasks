package io.harmed;

import java.util.Scanner;

public class Main {
    //нерабочая ерундистика - напоминание мне, что я пишу говнокод
    //и должна практиковаться on a daily basis!, чтобы писать так, как показано ниже(после говнокода)
/*    public static void main(String[] args) {
        Character ch = ' ';

        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();

            System.out.print(s1);

            for (int j = 0; j < 16; j++) {
                System.out.print(ch);
            }
            if (x < 10) {
                System.out.print("00" + x);
            } else if (x < 100) {
                System.out.print("0" + x);
            } else {
                System.out.println(x);
            }
            System.out.println("\n");

        }
        System.out.println("\n" + "================================");
    }*/

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
    }
}
