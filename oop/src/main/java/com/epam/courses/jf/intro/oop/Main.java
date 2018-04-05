package com.epam.courses.jf.intro.oop;

import java.util.Objects;

//@FieldDefaults(level = PRIVATE)
public class Main {
    protected int x;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Main)) return false;
        Main main = (Main) o;
        return x == main.x;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x);
    }
}
