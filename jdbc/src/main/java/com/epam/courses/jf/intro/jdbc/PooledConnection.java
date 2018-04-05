package com.epam.courses.jf.intro.jdbc;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PooledConnection implements Connection {

    @Delegate(excludes = Closeable.class)
    Connection connection;

    Consumer<PooledConnection> closer;

    @Override
    public void close() {
        closer.accept(this);
    }

}
