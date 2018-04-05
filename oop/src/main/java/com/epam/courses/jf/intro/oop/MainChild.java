package com.epam.courses.jf.intro.oop;

import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = PRIVATE)
public class MainChild extends Main {
    int y;

}
