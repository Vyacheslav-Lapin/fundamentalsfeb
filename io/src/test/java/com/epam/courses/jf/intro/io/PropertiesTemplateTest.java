package com.epam.courses.jf.intro.io;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PropertiesTemplateTest {

    PropertiesTemplate propertiesTemplate =
            PropertiesTemplate.from("props");

    @Test
    void getAndRemove() {
        assertThat(
                propertiesTemplate.getAndRemove("prop1")
                        .orElseGet(() -> fail("have no prop1 key")),
                is("val1"));
        assertTrue(propertiesTemplate.containsKeysOnly("prop2"));
    }

    @Test
    void containsKeysOnly() {
        assertTrue(propertiesTemplate.containsKeysOnly("prop1", "prop2"));
    }

}