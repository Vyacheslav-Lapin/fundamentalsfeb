package com.epam.spb.chr.courses.java.fundamentals.feb.oop.interfaces;

import lombok.Value;

import static java.lang.Math.PI;

@Value
public class CircleGO implements GeometricObject {

    double radius;

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}
