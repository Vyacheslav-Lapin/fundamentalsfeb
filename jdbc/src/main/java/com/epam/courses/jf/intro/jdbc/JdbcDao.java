package com.epam.courses.jf.intro.jdbc;

import com.epam.courses.jf.functional.CheckedConsumer;
import io.vavr.CheckedFunction1;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface JdbcDao extends Supplier<Connection> {

    @SneakyThrows
    default <T> T mapConnection(CheckedFunction1<Connection, T> connectionMapper) {
        Function<Connection, T> mapper = connectionMapper.unchecked();
        try (val connection = get()) {
            return mapper.apply(connection);
        }
    }

    @SneakyThrows
    default void withConnection(CheckedConsumer<Connection> connectionConsumer) {
        Consumer<Connection> consumer = connectionConsumer.unchecked();
        try (val connection = get()) {
            consumer.accept(connection);
        }
    }

    default <T> T mapStatement(CheckedFunction1<Statement, T> statementMapper) {
        Function<Statement, T> mapper = statementMapper.unchecked();
        return mapConnection(connection -> {
            try (val statement = connection.createStatement()) {
                return mapper.apply(statement);
            }
        });
    }

    default void withStatement(CheckedConsumer<Statement> statementConsumer) {
        Consumer<Statement> consumer = statementConsumer.unchecked();
        withConnection(connection -> {
            try (val statement = connection.createStatement()) {
                consumer.accept(statement);
            }
        });
    }

    default <T> T mapPreparedStatement(CheckedFunction1<PreparedStatement, T> preparedStatementMapper,
                                       String sql,
                                       Object... params) {

        Function<PreparedStatement, T> mapper = preparedStatementMapper.unchecked();

        return mapConnection(connection -> {
            @Cleanup val preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; ) {
                Object param = params[i];
                preparedStatement.setObject(++i, param);
            }

            return mapper.apply(preparedStatement);
        });
    }

}
