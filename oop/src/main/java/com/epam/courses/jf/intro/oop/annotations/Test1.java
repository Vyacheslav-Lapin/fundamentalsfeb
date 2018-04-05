package com.epam.courses.jf.intro.oop.annotations;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Test1 {

    String value();
}
