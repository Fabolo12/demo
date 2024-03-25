package com.jr.module4.lesson8;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    private static final List<Connection> CONNECTIONS_POOL = new ArrayList<>();

    public static void main(String[] args) {
//        initPool();
//        transaction();
//        transaction2();
//        savePoint();
//        executePrepareStatementExamples();
//        batchExamplesStatement();
        batchExamplesPreparedStatement();
    }

    @SneakyThrows
    private static void batchExamplesStatement() {
        try (final Connection connection = JdbcUtil.createConnection()) {
            final Statement statement = connection.createStatement();

            statement.addBatch("UPDATE clients SET name = 'TEST'");
            setAge(connection, "59017358-dc1f-4241-92e9-34d617c2d4fa", 0);
            statement.addBatch("UPDATE clients SET age = 999");

            statement.executeBatch();
        }
    }

    @SneakyThrows
    private static void batchExamplesPreparedStatement() {
        try (final Connection connection = JdbcUtil.createConnection()) {
            final PreparedStatement statement = connection.prepareStatement("UPDATE clients SET name = ?");
            statement.setString(1, "TEST");
            statement.addBatch();
            statement.executeBatch();
        }
    }

    private static void executePrepareStatementExamples() {
        executeStatement("59017358-dc1f-4241-92e9-34d617c2d4fa");
        executeStatement("");
        executeStatement("' OR '1'='1");
        executePrepareStatement("59017358-dc1f-4241-92e9-34d617c2d4fa");
        executePrepareStatement("");
        executePrepareStatement("' OR '1'='1");
        executePrepareStatement("' OR '1'='1'");
    }

    @SneakyThrows
    private static void savePoint() {
        final Connection connection = JdbcUtil.createConnection();
        printAllInfo(connection);
        connection.setAutoCommit(false);
        Savepoint savepoint = null;
        try {
            setAge(connection, "59017358-dc1f-4241-92e9-34d617c2d4fa", 15);
            savepoint = connection.setSavepoint("Stage 1");
            setAge(connection, "59017358-dc1f-4241-92e9-34d617c2d4fa", 0);
            connection.commit();
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            if (savepoint != null) {
                System.out.println("Rollback to " + savepoint.getSavepointName());
                connection.rollback(savepoint);
            } else {
                System.out.println("Rollback to  begin transaction");
                connection.rollback();
            }
        }
        printAllInfo(connection);
    }

    private static void initPool() {
        for (int i = 0; i < 5; i++) {
            CONNECTIONS_POOL.add(JdbcUtil.createConnection());
        }
    }

    private static Connection getConnectionFromPool() {
        return CONNECTIONS_POOL.get(0);
    }

    @SneakyThrows
    private static void transaction() {
        final Connection connection = getConnectionFromPool();
        printAllInfo(connection);
        connection.setAutoCommit(false);
        try {
            setAge(connection, "59017358-dc1f-4241-92e9-34d617c2d4fa", 15);
            printAllInfo(connection);
            setAge(connection, "59017358-dc1f-4241-92e9-34d617c2d4fa", 0);
            connection.commit();
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            connection.rollback();
        }
        connection.setAutoCommit(true);

        final Connection connection2 = JdbcUtil.createConnection();
        printAllInfo(connection2);
    }

    @SneakyThrows
    private static void transaction2() {
        final Connection connection = getConnectionFromPool();
        setAge(connection, "59017358-dc1f-4241-92e9-34d617c2d4fa", 99);

        final Connection connection2 = JdbcUtil.createConnection();
        printAllInfo(connection2);
    }

    @SneakyThrows
    private static void setAge(final Connection connection, final String id, final int newAge) {
        try (final Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "UPDATE clients SET age = %d WHERE id = '%s'".formatted(newAge, id)
            );
        }
        if (newAge == 0) {
            throw new IllegalArgumentException("Age can't be less then 1");
        }
    }

    @SneakyThrows
    private static void executeStatement(final String conditions) {
        try (final Connection connection = JdbcUtil.createConnection()) {
            final Statement statement = connection.createStatement();
            final boolean rc = statement.executeQuery(String.format("SELECT * FROM clients WHERE id = '%s'",
                    conditions)).next();
            System.out.println("executeStatement: " + rc);
        }
    }

    @SneakyThrows
    private static void executePrepareStatement(final String conditions) {
        final String query = "SELECT * FROM clients  WHERE id = ?";

        try ( final Connection connection = JdbcUtil.createConnection()) {
            final PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, conditions);
            final boolean rc = statement.executeQuery().next();
            System.out.println("executePrepareStatement: " + rc);
        }
    }

    @SneakyThrows
    private static void printAllInfo(final Connection connection) {
        try (final Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            while (resultSet.next()) {
                System.out.printf("""
                                id: %s, name: %s, age: %d%n
                                """,
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                );
            }
        }
    }
}
