package com.epam.spb.chr.courses.java.fundamentals.feb.oop.interfaces.defaults;

public interface Int1 {

    String m1();

    default String m2() {
        return "";
    }

    static String sm() {
        return "";
    }
}
