package com.jr.module4.lesson7.repositories;

import com.jr.module4.lesson7.models.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Optional;

public class UserRepository {
    @SneakyThrows
    public Optional<Boolean> findUserByUsername(final String username) {
        try (final Connection connection = JdbcUtil.createConnection()) {
            final String sql = String.format("SELECT * FROM clients WHERE name = '%s'", username);
            final Statement statement = connection.createStatement();
            return Optional.of(statement.executeQuery(sql).next());
        }
    }
}
