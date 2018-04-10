package com.epam.courses.jf.intro.jdbc;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class JdbcDaoTest {

    static String SQL =
            "select first_name from Person";

    static JdbcDao jdbcDao = ((Supplier<Connection>) new ConnectionPool())::get;

    @Test
    @DisplayName("MapPreparedStatement method works correctly")
    void mapPreparedStatement() {
        String firstName = jdbcDao.mapStatement(statement -> {
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                return resultSet.getString("first_name");
            } else return null;
        });
        assertThat(firstName, is("Jose"));
    }
}