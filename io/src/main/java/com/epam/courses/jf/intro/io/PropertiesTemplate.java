package com.epam.courses.jf.intro.io;

import lombok.SneakyThrows;
import lombok.val;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.Supplier;

public interface PropertiesTemplate extends Supplier<Properties> {

    @SneakyThrows
    static PropertiesTemplate from(String resourceName) {
        val properties = new Properties();
        String res = String.format("/%s.properties", resourceName);
        try (InputStream resourceAsStream =
                     PropertiesTemplate.class.getResourceAsStream(res)) {
            properties.load(resourceAsStream);
        }
        return () -> properties;
    }

    default Optional<String> getAndRemove(String key) {
        return Optional.ofNullable(
                (String) get().remove(key)
        );
    }

    default boolean containsKeysOnly(String... keys) {
        Set<String> stringSet = get().stringPropertyNames();

        if (stringSet.size() != keys.length)
            return false;

        for (String key : keys)
            if (!stringSet.contains(key))
                return false;

        return true;
    }
}
