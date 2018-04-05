package com.epam.courses.jf.intro.oop.interfaces.defaults;

public interface Int1 {

    String m1();

    default String m2() {
        return "";
    }

    static String sm() {
        return "";
    }
}
