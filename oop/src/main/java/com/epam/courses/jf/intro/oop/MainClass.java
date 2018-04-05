package com.epam.courses.jf.intro.oop;

import lombok.Data;

import java.util.function.IntSupplier;

@Data
public class MainClass {

    private static int y;

    public MainClass(int x) {
        this.x = x;
    }

    private int x;

    public String getString(){
        IntSupplier intSupplier = () -> x;

        return "";
    }

    public static void main(String... strings) {

        MainClass mainClass = new MainClass(1);
        mainClass.x = 55;

        y = 76;
        System.out.println(y); //76

//        System.out.println(x);
//        getString();

//        AboutJava object = new AboutJava();
//        object.printReleaseData();
    }
}
