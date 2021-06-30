package com.ua.foxminded.school.dao.impl;

import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.GenericDao;
import com.ua.foxminded.school.dao.mapper.Mapper;
import com.ua.foxminded.school.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GroupDaoImpl extends GenericDao<Group> implements GroupDao {

    private final DataSource connectionProvider;

    public GroupDaoImpl(DataSource connectionProvider, Mapper<Group> mapper) {
        super(connectionProvider, mapper);
        this.connectionProvider = connectionProvider;
    }

    @Override
    protected String getInsertQuery() {
        return "insert into groups (group_name) values (?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from groups where group_id = (?)";
    }

    @Override
    protected String getAllQuery() {
        return "select * from groups";
    }

    @Override
    protected String getByIdQuery() {
        return "select * from groups where group_id=?";
    }

    @Override
    public Group getGroupByName(String groupName) {
        Group group = new Group();
        String sqlQuery = "select * from groups where group_name=?";

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)){
            statement.setString(1, groupName);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    group.setId(resultSet.getInt(1));
                    group.setName(resultSet.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }
}
