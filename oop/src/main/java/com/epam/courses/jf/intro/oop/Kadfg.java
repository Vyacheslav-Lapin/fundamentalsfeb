package com.epam.courses.jf.intro.oop;

import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class Kadfg extends AboutJava {

    public Kadfg(int x, int a, int b, int c, int d, int e, int f, double y, int[] xs, List<String> stringList) {
        super(x, a, b, c, d, e, f, y, xs, stringList);
    }


    public boolean equals(Object o) {
        return o == this || (
                o instanceof Kadfg && (
                        ((Kadfg) o).canEqual(this)
                                && super.equals(o)
                )
        );
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
