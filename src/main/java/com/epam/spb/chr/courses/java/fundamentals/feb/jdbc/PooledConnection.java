package com.epam.spb.chr.courses.java.fundamentals.feb.jdbc;

import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.io.Closeable;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class PooledConnection implements Connection {

    @Delegate(excludes = Closeable.class)
    Connection connection;

    @Override
    public void close() {
        //...
    }

}
