package com.epam.spb.chr.courses.java.fundamentals.feb.oop;

import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class Kadfg extends AboutJava {

    public Kadfg(int x, int a, int b, int c, int d, int e, int f, double y, int[] xs, List<String> stringList) {
        super(x, a, b, c, d, e, f, y, xs, stringList);
    }


    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Kadfg)) return false;
        final Kadfg other = (Kadfg) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Kadfg;
    }
}
