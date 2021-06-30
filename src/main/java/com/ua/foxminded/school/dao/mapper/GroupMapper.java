package com.ua.foxminded.school.dao.mapper;

import com.ua.foxminded.school.model.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements Mapper<Group> {

    @Override
    public void prepareForInsert(PreparedStatement statement, Group group) {
        try {
            statement.setString(1, group.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setId(ResultSet resultSet, Group group) {
        try {
            group.setId(resultSet.getInt("group_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForDelete(PreparedStatement statement, Group group) {
        try {
            statement.setInt(1, group.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group map(ResultSet resultSet) {
        Group group = new Group();
        try {
            group.setId(resultSet.getInt("group_id"));
            group.setName(resultSet.getString("group_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }
}
