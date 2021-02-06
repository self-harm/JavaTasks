package io.harmed;

@FunctionalInterface
public interface FlyingBird {
    void sound();

    default void fly() {
        System.out.println("Я лечу!");
    }

    default void hungry(){
        System.out.println("Я голоден!");
    }

    static Integer getSpeed(){
        return 10;
    }
    static Integer getHeight(){
        return 5;
    }
}
