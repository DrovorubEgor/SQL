package com.ua.foxminded.school.dao.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface Mapper<T> {

    void prepareForInsert(PreparedStatement statement, T entity);

    void setId(ResultSet resultSet, T entity);

    void prepareForDelete(PreparedStatement statement, T entity);

    T map(ResultSet resultSet);
}
