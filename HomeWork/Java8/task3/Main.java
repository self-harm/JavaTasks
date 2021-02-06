package io.harmed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. Write your own functional interface ThreeFunction (it takes three arguments and produce result).
        //2. Implement this with two different lambdas
        ThreeFunction<Integer, Integer, Integer, String> multiply = (a,b,c) -> {
          if((a * b * c) > 100) return "enough";
          else return "not enough";
        };

        ThreeFunction<Integer, Integer, Integer, String> divide = (a,b,c) -> {
            if((a / b / c) < 5) return "enough";
            else return "not enough";
        };

        System.out.println(multiply.apply(10, 10, 0));
        System.out.println(divide.apply(10, 5, 1));

        //3. Provide client code with usage of this lambdas
        System.out.println("Пожалуйста, укажите:\n1. Вашу месячную зарплату;\n2. Ваши месячные расходы;\n3. Сколько месяцев собираетесь копить;");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int salary = Integer.parseInt(reader.readLine());
        int expenses = Integer.parseInt(reader.readLine());
        int months = Integer.parseInt(reader.readLine());

        ThreeFunction<Integer, Integer, Integer, String> save = (a,b,c) -> {
          return "Вы накопите " + ((a-b) * c + "!");
        };

        System.out.println(save.apply(salary, expenses, months));
    }
}
