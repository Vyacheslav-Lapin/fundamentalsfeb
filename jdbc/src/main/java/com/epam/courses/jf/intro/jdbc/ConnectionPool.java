package com.epam.courses.jf.intro.jdbc;

import io.vavr.CheckedFunction1;
import io.vavr.Function2;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.epam.courses.jf.intro.io.PropsDemo.getFromProperties;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class ConnectionPool implements Supplier<Connection> {

    BlockingQueue<Connection> connectionQueue;

    @SneakyThrows
    public ConnectionPool() {

        ConnectionFactory connectionFactory = getFromProperties(
                ConnectionFactory.class, "db");

        int poolSize = connectionFactory.getPoolSize();
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        IntStream.range(0, poolSize)
                .mapToObj(__ -> connectionFactory.get())
                .map(connection -> new PooledConnection(connection, this::closePolledConnection))
                .forEach(connectionQueue::add); // TODO: 06/04/2018 write collector

        val getFileAsString = Function2.narrow(ConnectionPool::getFileAsString)
                .apply(connectionFactory.getInitScriptsPath());

        try (Connection connection = get();
             val statement = connection.createStatement()) {
            statement.executeUpdate(
                    IntStream.iterate(1, operand -> operand + 1)
                            .mapToObj(String::valueOf)
                            .map(getFileAsString)
                            .takeWhile(Optional::isPresent)
                            .map(Optional::get)
                            .collect(Collectors.joining()));
        }
    }

    @SneakyThrows
    private static Optional<String> getFileAsString(String initScriptsPath, String name) {
        val path = String.format("/%s/%s.sql", initScriptsPath, name);
        return Optional.ofNullable(ConnectionPool.class.getResource(path))
                .map(CheckedFunction1.narrow(URL::toURI).unchecked())
                .map(Paths::get)
                .map(CheckedFunction1.<Path, Stream<String>>narrow(Files::lines).unchecked())
                .map(stringStream -> stringStream.collect(Collectors.joining()));
    }

    @SneakyThrows
    private void closePolledConnection(Connection connection) {
        if (connection.isClosed())
            throw new RuntimeException("Attempting to close closed connection.");
        if (connection.isReadOnly())
            connection.setReadOnly(false);
        if (!connectionQueue.offer(connection))
            throw new SQLException("Error allocating connection in the pool.");
    }

    public Connection takeConnection() throws ConnectionPoolException {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(
                    "Error connecting to the data source.", e);
        }
    }

    @Override
    public Connection get() {
        return takeConnection();
    }
}
