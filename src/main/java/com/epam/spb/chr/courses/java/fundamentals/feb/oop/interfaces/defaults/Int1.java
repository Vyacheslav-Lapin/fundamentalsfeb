package com.epam.spb.chr.courses.java.fundamentals.feb.oop.interfaces.defaults;

public interface Int1 {
    String m1();

    default int getX() {
        return 5;
    }
}
