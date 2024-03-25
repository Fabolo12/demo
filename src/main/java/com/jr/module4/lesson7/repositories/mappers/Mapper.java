package com.jr.module4.lesson7.repositories.mappers;

import java.sql.ResultSet;
import java.util.Map;

public interface Mapper<T> {
    T mapFrom(ResultSet row);

    Map<String, Object> mapTo(T t);
}
