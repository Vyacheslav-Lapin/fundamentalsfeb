package com.epam.spb.chr.courses.java.fundamentals.feb.oop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public final class TestUtils {

    private TestUtils() {
        throw new UnsupportedOperationException();
    }

    public static String fromSystemOut(Runnable runnable) {

        PrintStream realOut = System.out;

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             PrintStream printStream = new PrintStream(out)) {

            System.setOut(printStream);
            runnable.run();

            return new String(out.toByteArray());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.setOut(realOut);
        }
    }

    public static void main(String... args) {
        String out = fromSystemOut(() -> m());
        if (out.equals("Мама мыла раму!"))
            System.out.println("Всё хорошо!");
        else
            System.out.println("Всё плохо!");
    }

    public static void m() {
        System.out.print("Мама мыла раму!");
    }
}
