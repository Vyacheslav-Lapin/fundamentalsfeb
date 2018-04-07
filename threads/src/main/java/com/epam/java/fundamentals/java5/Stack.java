package com.epam.java.fundamentals.java5;

import lombok.experimental.FieldDefaults;
import lombok.val;

import java.util.concurrent.atomic.AtomicReference;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public class Stack<T> {
    AtomicReference<Element<T>> headRef = new AtomicReference<>(null);

    public void push(T value) {
        val newHead = new Element<T>();
        newHead.value = value;
        Element oldHead;
        do {
            oldHead = headRef.get();
            newHead.next = oldHead;
        } while (!headRef.compareAndSet(oldHead, newHead));
    }

    public T pop() {
        Element<T> oldHead;
        Element<T> newHead;
        do {
            oldHead = headRef.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!headRef.compareAndSet(oldHead, newHead));
        return oldHead.value;
    }

    public static class Element<T> {
        T value;
        Element next;
    }
}
