package com.epam.courses.jf.intro.jdbc;

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        for (int i = 0; i < poolSize; i++)
            connectionQueue.add(new PooledConnection(connectionFactory.get(),
                    this::closePolledConnection));

        String initScriptsPath = connectionFactory.getInitScriptsPath();

        String sql = IntStream.range(1, 100)
                .mapToObj(value -> initScriptsPath + "/" + value + ".sql")
                .map(File::new)
                .filter(File::exists)
                .map(ConnectionPool::getFileAsString)
                .reduce("", (s, s2) -> s + s2);

        try (Connection connection = get();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
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

    @SneakyThrows
    private static String getFileAsString(File file) {
        return Files.readAllLines(Paths.get(file.toURI()))
        .stream()
        .collect(Collectors.joining());
    }
}
