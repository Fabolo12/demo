package com.jr.module4.lesson8;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/test";

    private static final String DATABASE_USER = "postgres";

    private static final String DATABASE_PASSWORD = "root";

    @SneakyThrows
    static Connection createConnection() {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
