package com.epam.courses.jf.intro.oop.interfaces.functional;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
public interface FunInt {

    int getInt();

    default int getInt2() {
        return 1;
    }

    static void main(String... args) {

        Consumer<String> stringConsumer = System.out::println;

        stringConsumer.accept("Hello, World!");

        Supplier<Date> dateSupplier = Date::new;

        System.out.println(dateSupplier.get());
    }
}
