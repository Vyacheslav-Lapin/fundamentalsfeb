package com.epam.courses.jf.functional;

import java.util.function.Consumer;

import static lombok.Lombok.sneakyThrow;

@FunctionalInterface
public interface CheckedConsumer<T> extends io.vavr.CheckedConsumer<T> {

    /**
     * Returns an unchecked function that will <em>sneaky throw</em> if an exceptions occurs when applying the function.
     *
     * @return a new Function1 that throws a {@code Throwable}.
     */
    default Consumer<T> unchecked() {
        return t -> {
            try {
                this.accept(t);
            } catch(Throwable e) {
                throw sneakyThrow(e);
            }
        };
    }
}
