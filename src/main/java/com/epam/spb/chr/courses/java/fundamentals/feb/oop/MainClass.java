package com.epam.spb.chr.courses.java.fundamentals.feb.oop;

public class MainClass {

    private int x;
    private static int y;

    public MainClass(int x) {
        this.x = x;
    }

    public String getString(){
        return "";
    }

    public static void main(String... strings) {

        MainClass mainClass = new MainClass(1);
        mainClass.x = 55;

        y = 76;
        System.out.println(y); //76

//        System.out.println(x);
//        getString();

        AboutJava object = new AboutJava();
        object.printReleaseData();
    }
}
