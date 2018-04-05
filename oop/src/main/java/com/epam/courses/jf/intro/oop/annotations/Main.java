package com.epam.courses.jf.intro.oop.annotations;

@Test1("Мама мыла раму!")
public class Main {
    public static void main(String... args) {
        Test1 test1 = Main.class.getDeclaredAnnotation(Test1.class);
        System.out.println(test1.value());
    }
}
