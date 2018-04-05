package com.epam.courses.jf.intro.io;

import com.epam.courses.jf.intro.io.ResourceProperties;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class ResourcePropertiesTest {

    ResourceProperties resourceProperties =
            ResourceProperties.from("PropsDemo");

    @Test
    void getAndRemove() {
        assertThat(
                resourceProperties.getAndRemove("prop1")
                        .orElseGet(() -> fail("have no prop1 key")),
                is("val1"));
        assertTrue(resourceProperties.containsKeysOnly("prop2"));
    }
    @Test
    void containsKeysOnly() {
        assertTrue(resourceProperties.containsKeysOnly("prop1", "prop2"));
    }

}