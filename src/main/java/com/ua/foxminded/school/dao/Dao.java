package com.ua.foxminded.school.dao;

import java.util.List;

public interface Dao<T>{

    T insert(T entity);

    void delete(T entity);

    List<T> getAll();

    T getById(final int id);
}
