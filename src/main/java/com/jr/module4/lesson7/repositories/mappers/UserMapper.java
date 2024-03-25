package com.jr.module4.lesson7.repositories.mappers;

import com.jr.module4.lesson7.models.User;

import java.sql.ResultSet;
import java.util.Map;

public class UserMapper implements Mapper<User> {
    @Override
    public User mapFrom(final ResultSet row) {
        return null;
    }

    @Override
    public Map<String, Object> mapTo(final User o) {
        return null;
    }
}
