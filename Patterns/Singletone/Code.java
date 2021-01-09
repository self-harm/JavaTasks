package io.harmed;

/**неленивая инициализация - создание объекта непосредственно сразу!
 1. использую final static поле

 + Простая и прозрачная реализация
 + Потокобезопасность
 - Не ленивая инициализация
 */

public class Singletone {
    public static final Singletone INSTANCE = new Singletone();
}
/**
 2. используя enum

 + Остроумно
 + Сериализация из коробки
 + Потокобезопасность из коробки
 + Возможность использования EnumSet, EnumMap и т.д.
 + Поддержка switch
 - Не ленивая инициализация
 */

public enum Singleton {
    INSTANCE;
}

/**Отложенная (ленивая) инициализация (англ. Lazy initialization) — приём в программировании,
когда некоторая ресурсоёмкая операция (создание объекта, вычисление значения) выполняется
непосредственно перед тем, как будет использован её результат. Таким образом, инициализация
выполняется «по требованию», а не заблаговременно.

 создание объекта по "требованию"
 1. Synchronized Accessor

 + Ленивая инициализация
 - Низкая производительность (критическая секция) в наиболее типичном доступе
 */

public class Singleton {
    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**2. Double Checked Locking & volatile

 + Ленивая инициализация
 + Высокая производительность
 - Поддерживается только с JDK 1.5 [5]

 без volatile не работает. Хоть и проблема была частично решена, использовать Double Checked Lock без volatile крайне опасно.
 В некоторых случаях, зависящих от реализации JVM, операционной среды, планировщика и т.д., такой подход может не работать.
 */

public class Singleton {
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }
}

/**3.  On Demand Holder idiom

 + Ленивая инициализация
 + Высокая производительность
 - Невозможно использовать для не статических полей класса
 */

public class Singleton {

    public static class SingletonHolder {
        public static final Singleton HOLDER_INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
