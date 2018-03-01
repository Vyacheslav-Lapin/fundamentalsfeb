package com.epam.spb.chr.courses.java.fundamentals.feb.oop.interfaces;

import lombok.Value;

@Value
public class RectangleGO implements GeometricObject {

    double sideA;
    double sideB;

    @Override
    public double getArea() {
        return sideA * sideB;
    }
}
