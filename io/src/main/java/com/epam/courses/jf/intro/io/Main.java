package com.epam.courses.jf.intro.io;

import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Scanner;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class Main {

    public static Scanner getScannerWithSin() {
        return new Scanner(new NonCloseableIn(System.in));
//        return new Scanner(System.in);
    }

    public static void main(String... args) {

        try (Scanner scanner = getScannerWithSin()) {
            System.out.println(scanner.nextInt());
        }

        try (Scanner scanner = getScannerWithSin()) {
            System.out.println(scanner.nextInt());
        }

    }
}

@FieldDefaults(level = PRIVATE, makeFinal = true)
class NonCloseableIn extends InputStream {
    @Delegate(excludes = Closeable.class)
    final InputStream in;

    public NonCloseableIn(InputStream in) {
        this.in = in;
    }

    @Override
    public void close() {
    }
}