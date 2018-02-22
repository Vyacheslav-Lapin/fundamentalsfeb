package com.epam.spb.chr.courses.kotlin;

import com.epam.spb.chr.courses.java.fundamentals.feb.oop.AboutJava;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class First {

    private static final Logger log = LogManager.getLogger(First.class);

    public static void main(String... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        log.info("Java уже здесь!!!");
        AboutJava aboutJava = new AboutJava();
        //aboutJava.printReleaseData();
//        aboutJava.getClass()
        Method printReleaseData = AboutJava.class.getDeclaredMethod("printReleaseData");
        printReleaseData.setAccessible(true);
        printReleaseData.invoke(aboutJava);
    }
}
