package com.epam.courses.jf.intro.oop;

import lombok.experimental.FieldDefaults;
import lombok.val;

import static java.lang.Enum.valueOf;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class WaterBottle {
    String brand;
    boolean empty;

    public static void main(String... args) {
        val wb = new WaterBottle();
        System.out.print("Empty = " + wb.empty);
        System.out.print(", Brand = " + wb.brand);
    }
}
