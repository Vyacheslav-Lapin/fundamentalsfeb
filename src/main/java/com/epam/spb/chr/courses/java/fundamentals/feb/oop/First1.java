package com.epam.spb.chr.courses.java.fundamentals.feb.oop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

public class First1 {

    private static final Logger log = LogManager.getLogger(First1.class);

    public static void main(String... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("Java уже здесь!!!");
//        AboutJava aboutJava = new AboutJava();
//        aboutJava.printReleaseData();
//        aboutJava.getClass()
//        Method printReleaseData = AboutJava.class.getDeclaredMethod("printReleaseData");
//        printReleaseData.setAccessible(true);
//        printReleaseData.invoke(aboutJava);
    }
}
