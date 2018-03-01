package com.epam.spb.chr.courses.java.fundamentals.feb.oop.interfaces;

import lombok.val;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class GeometricObjectComparator implements Comparator<GeometricObject> {

    public static void main(String... args) {
        val comparator = new GeometricObjectComparator();
        Set<GeometricObject> set = new TreeSet<>(comparator);
        set.add(new RectangleGO(4, 5));
        set.add(new CircleGO(40));
        set.add(new CircleGO(40));
        set.add(new RectangleGO(4, 1));

        Arrays.sor

        System.out.println("A sorted set of geometric objects");

        for (GeometricObject object : set) {
            System.out.printf("area = %s on object %s%n", object.getArea(), object);
        }
    }

    public int compare(GeometricObject o1, GeometricObject o2) {

        double area1 = o1.getArea();
        double area2 = o2.getArea();

        return Double.compare(area1, area2);
    }

}
