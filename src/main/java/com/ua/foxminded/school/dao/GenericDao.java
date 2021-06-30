package com.ua.foxminded.school.dao;

import com.ua.foxminded.school.dao.mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T> implements Dao<T> {

    private final DataSource connectionProvider;
    private final Mapper<T> mapper;

    public GenericDao(DataSource connectionProvider, Mapper<T> mapper) {
        this.connectionProvider = connectionProvider;
        this.mapper = mapper;
    }

    protected abstract String getInsertQuery();

    @Override
    public T insert(T entity) {

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(getInsertQuery(), Statement.RETURN_GENERATED_KEYS)) {
            mapper.prepareForInsert(statement, entity);
            statement.execute();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    mapper.setId(resultSet, entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    protected abstract String getDeleteQuery();

    @Override
    public void delete(T entity) {

        try (Connection connection = connectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(getDeleteQuery())) {
            mapper.prepareForDelete(statement, entity);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getAllQuery();

    @Override
    public List<T> getAll() {

        List<T> entities = new ArrayList<>();
        try (Connection connection = connectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(getAllQuery());
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                entities.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    protected abstract String getByIdQuery();

    @Override
    public T getById(int id) {

        try (Connection connection = connectionProvider.getConnection();
            PreparedStatement statement = connection.prepareStatement(getByIdQuery(), Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapper.map(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Cannot find by id");
    }
}
