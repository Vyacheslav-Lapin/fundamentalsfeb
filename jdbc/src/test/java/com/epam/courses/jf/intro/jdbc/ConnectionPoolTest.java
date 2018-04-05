package com.epam.courses.jf.intro.jdbc;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class ConnectionPoolTest {

    public static final String SQL =
            "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

    @Test
    @SneakyThrows
    @DisplayName("Get method works correctly")
    void get() {
        val connectionPool = new ConnectionPool();
        try (Connection connection = connectionPool.get();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            if (resultSet.next())
                System.out.printf("Hello, %s", resultSet.getString("first_name"));
        }
    }
}