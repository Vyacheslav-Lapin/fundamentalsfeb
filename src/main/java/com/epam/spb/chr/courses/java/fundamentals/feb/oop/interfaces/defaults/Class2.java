package com.epam.spb.chr.courses.java.fundamentals.feb.oop.interfaces.defaults;

public class Class2 implements Int1, Int2 {

    @Override
    public String m1() {
        return "Hello, World!";
    }

    @Override
    public int getX() {
        return Int1.super.getX();
    }

}
