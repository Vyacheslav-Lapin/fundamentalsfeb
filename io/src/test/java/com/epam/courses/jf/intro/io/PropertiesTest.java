package com.epam.courses.jf.intro.io;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PropertiesTest {

    static String PROPS_FILE_NAME = "/props.properties";
    static Properties properties = new Properties();

    @SneakyThrows
    @BeforeAll
    static void setUp() {
        @Cleanup val inputStream = PropertiesTest.class .getResourceAsStream(PROPS_FILE_NAME);
        properties.load(inputStream);
    }

    @Test
    @DisplayName("getProperties method works correctly")
    void getProperties() {
        assertThat(properties.getProperty("prop1"), is("val1"));
        assertThat(properties.getProperty("prop2", "3"), is("2"));
        assertThat(properties.getProperty("prop3", "3"), is("3"));
    }
}
