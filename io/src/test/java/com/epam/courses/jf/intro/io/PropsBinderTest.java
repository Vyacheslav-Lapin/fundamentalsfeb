package com.epam.courses.jf.intro.io;

import lombok.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PropsBinderTest {

    @Test
    @DisplayName("GetFromProperties method works correctly")
    void getFromProperties() {
        assertThat(PropsBinder.getFromProperties(Props.class, "props"),
                is(new Props("val1", 2)));
    }

    @Value
    static class Props {
        String prop1;
        int prop2;
    }
}