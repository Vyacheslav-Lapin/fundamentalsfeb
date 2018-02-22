package com.epam.spb.chr.courses.java.fundamentals.feb.oop;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null)
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        return instance;
    }

    public static void m1() {
        //...
    }
}
