package io.harmed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    /*1. Create several instances of Runnable interface with different implementation using lambda expressions.
	     Use them with threads.*/

        //Thread-0
        Runnable fInstance = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("There's an exception in " + Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName() + " : \"I'm the slowest :(\"");
        };

        //Thread-1
        Runnable sInstance = () -> {
            System.out.println(Thread.currentThread().getName() + " : \"Apparently, I'm faster than others!\"");
        };

        //Thread-2
        Runnable tInstance = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("There's an exception in " + Thread.currentThread().getName());
            }
            System.out.println(Thread.currentThread().getName() + " : \"I'm running now!\"");
            IntStream.of(4124, 4156, 7654, 123, 5, 7)
                    .filter(x -> x%2 == 0)
                    .mapToObj(x -> x/2)
                    .forEach(System.out::println);
        };

        new Thread(fInstance).start();
        new Thread(sInstance).start();
        new Thread(tInstance).start();

        /*1. an array of Persons;
          2. two instances of Comparator<Person> interface using lambda expressions:
          first one for comparing by name, second one – by age;
          3. Then sort them using these comparators;
          4. Use forEach method for printing information about all the persons.
           Use the method reference;*/

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Kseniia", 23));
        persons.add(new Person("Alice", 25));

        //sorted by name
        Collections.sort(persons, Comparator.comparing(obj -> obj.getName()));
        Stream<Person> firstStream = persons.stream();
        firstStream.forEach(System.out::println);

        //sorted by age
        Collections.sort(persons, Comparator.comparingInt(obj -> obj.getAge()));
        Stream<Person> secondStream = persons.stream();
        secondStream.forEach(System.out::println);

        /*1. Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.)
          using lambda expressions.
          2. Create your own functional interface and add several its implementations
          using both lambda expressions and inner anonymous classes.
          3. Add few default methods to it and use them.
          4. Add few static methods to it and use them.*/

        //Predicate<T>: is first letter a vowel?
        Predicate<Person> isPositive = obj -> "AEIOUaeiou".indexOf(obj.getName().charAt(0)) != -1;
        System.out.println(isPositive.test(new Person("Adam", 5)) == true? "First letter of the name is a vowel."
                : "First letter of the name is a consonant.");

        //Consumer<T>: print ("employee" + name)
        Consumer<Person> printerOfEmployee = obj -> System.out.println("Employee " + obj.getName());
        printerOfEmployee.accept(new Person("Eva", 7));

        //Supplier<T>: getting new Person from console
        Supplier<Person> personFactory = () ->{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ваше имя?");
            String name = "";
            int age = 0;
            try {
                name = reader.readLine();
                age = Integer.parseInt(reader.readLine());

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ooops, there's an exception in Supplier<T> functional interface.");
            }
            return new Person(name, age);
        };

        Person person = personFactory.get();
        System.out.println(person.toString());

        //BinaryOperator<T>: sum of two numbers
        BinaryOperator<Integer> add = (a, b) -> a+b;
        System.out.println(add.apply(1, 5));

        //UnaryOperator<T>: increasing on 10%
        UnaryOperator<Double> increase = x -> x*1.1;
        System.out.println(increase.apply((double)3));

        //Creating my own functional interface: this interface transforms messages in right format
        Function<String, String> messageFormat = s -> "\"" + s + "\nTake care,\nyour best friend\"";

        Function<String, String> messageFormat1 = new Function<>() {
            @Override
            public String apply(String s) {
                return "\"" + s + "\nTake care,\nyour best friend\"";
            }
        };

        System.out.println(messageFormat.apply("hi"));
        System.out.println(messageFormat1.apply("hi"));

        //Creating my own functional interface: this interface multiply a given number
        Function<Integer, Integer> multiply = x -> x*x;

        Function<Integer, Integer> multiply1 = new Function<>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        System.out.println(multiply.apply(5));
        System.out.println(multiply1.apply(5));

        FlyingBird duck = new Duck();
        duck.sound();
        System.out.println("Высота полета птиц: " + FlyingBird.getHeight() + "\nСкорость полета птиц: " + FlyingBird.getSpeed());

    }
}
