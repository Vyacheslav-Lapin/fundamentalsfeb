package com.epam.courses.jf.intro.jdbc;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
class ConnectionPoolTest {

    static final String SQL =
            "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

    @Test
    @SneakyThrows
    @DisplayName("Get method works correctly")
    void get() {
        @Cleanup
        val connectionPool = new ConnectionPool();

        try (Connection connection = connectionPool.get();
             val statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            if (resultSet.next())
                System.out.printf("Hello, %s", resultSet.getString("first_name"));
        }
    }
}