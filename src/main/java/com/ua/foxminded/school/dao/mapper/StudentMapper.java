package com.ua.foxminded.school.dao.mapper;

import com.ua.foxminded.school.model.Group;
import com.ua.foxminded.school.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements Mapper<Student>{
    @Override
    public void prepareForInsert(PreparedStatement statement, Student student) {
        try {
            statement.setInt(1, student.getGroup().getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setId(ResultSet resultSet, Student student) {
        try {
            student.setId(resultSet.getInt("student_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForDelete(PreparedStatement statement, Student student) {
        try {
            statement.setInt(1, student.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student map(ResultSet resultSet) {
        Student student = new Student(new Group());
        try {
            student.setId(resultSet.getInt("student_id"));
            student.getGroup().setId(resultSet.getInt("group_id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
