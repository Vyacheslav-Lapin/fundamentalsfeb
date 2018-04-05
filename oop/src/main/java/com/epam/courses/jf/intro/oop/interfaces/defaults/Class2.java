package com.epam.courses.jf.intro.oop.interfaces.defaults;

public class Class2 implements Int1, Itt2 {

    @Override
    public String m1() {
        return "Hello, World!";
    }

    @Override
    public String m2() {
        return Int1.super.m2();
    }


    public static void main(String... args) {
        Int1.sm();
    }
}
