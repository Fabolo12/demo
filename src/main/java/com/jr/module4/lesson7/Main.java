package com.jr.module4.lesson7;

import com.jr.module4.lesson7.controllers.Registration;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/test";

    private static final String DATABASE_USER = "postgres";

    private static final String DATABASE_PASSWORD = "root";

    @SneakyThrows
    public static void main(String[] args) {
        examples();
    }

    @SneakyThrows
    private static void examples() {
        final Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

//        executeQuery(connection);
//        sqlInjection(connection);
        executeQuery(connection, " WHERE password = 'qwert'");
        executeQuery(connection, " WHERE password = 'qwerty'");
        executeQuery(connection, " WHERE password = 'q' or 1=1");

        System.out.println("End");
        connection.close();
    }

    private static void sqlInjection(final Connection connection) {
        executeQuery(connection, "");
        executeQuery(connection, " WHERE age > 25");
        execute(connection, "; UPDATE clients SET age = 1;");
        executeQuery(connection);
    }

    @SneakyThrows
    private static void executeQuery(final Connection connection, final String conditions) {
        try (final Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM clients %s", conditions));
            printResult(resultSet);
        }
    }

    @SneakyThrows
    private static void execute(final Connection connection, final String conditions) {
        try (final Statement statement = connection.createStatement()) {
            statement.execute(String.format("SELECT * FROM clients %s", conditions));
        }
    }

    @SneakyThrows
    private static void executeQuery(final Connection connection) {
        try (final Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            printResult(resultSet);
        }
    }

    @SneakyThrows
    private static void printResult(final ResultSet resultSet) {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("age"));
            System.out.println(resultSet.getBoolean("active"));

            System.out.println(resultSet.getDate("created"));
            System.out.println(resultSet.getTime("created"));
            System.out.println(resultSet.getTimestamp("created"));
            System.out.println(resultSet.getObject("created", LocalDate.class));
            System.out.println();
        }
    }
}
