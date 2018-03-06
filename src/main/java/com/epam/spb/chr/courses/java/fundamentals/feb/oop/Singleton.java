package com.epam.spb.chr.courses.java.fundamentals.feb.oop;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class Singleton {

    static Singleton instance;

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
