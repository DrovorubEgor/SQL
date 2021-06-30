package com.ua.foxminded.school.dao.mapper;

import com.ua.foxminded.school.model.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements Mapper<Course>{

    @Override
    public void prepareForInsert(PreparedStatement statement, Course course) {
        try {
            statement.setString(1, course.getName());
            statement.setString(2, course.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setId(ResultSet resultSet, Course course) {
        try {
            course.setId(resultSet.getInt("course_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForDelete(PreparedStatement statement, Course course) {
        try {
            statement.setInt(1, course.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course map(ResultSet resultSet) {
        Course course = new Course();
        try {
            course.setId(resultSet.getInt("course_id"));
            course.setName(resultSet.getString("course_name"));
            course.setDescription(resultSet.getString("course_description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}
