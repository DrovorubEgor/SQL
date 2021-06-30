package com.ua.foxminded.school.dao.impl;

import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.GenericDao;
import com.ua.foxminded.school.dao.mapper.Mapper;
import com.ua.foxminded.school.model.Course;
import com.ua.foxminded.school.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDaoImpl extends GenericDao<Student> implements StudentDao {

    private final DataSource connectionProvider;

    public StudentDaoImpl(DataSource connectionProvider, Mapper<Student> mapper) {
        super(connectionProvider, mapper);
        this.connectionProvider = connectionProvider;
    }

    @Override
    protected String getInsertQuery() {
        return "insert into students(group_id, first_name, last_name) values (?, ?, ?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from students where student_id=?";
    }

    @Override
    protected String getAllQuery() {
        return "select * from students";
    }

    @Override
    protected String getByIdQuery() {
        return "select * from students where student_id=?";
    }

    @Override
    public void addCourse(Student student, Course course) {
        final String sqlQuery = "insert into student_course(student_id, course_id) values (?, ?)";
        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, student.getId());
            statement.setInt(2, course.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
