package com.ua.foxminded.school.dao.impl;

import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.GenericDao;
import com.ua.foxminded.school.dao.mapper.Mapper;
import com.ua.foxminded.school.model.Course;

public class CourseDaoImpl extends GenericDao<Course> implements CourseDao {

    public CourseDaoImpl(DataSource connectionProvider, Mapper<Course> mapper) {
        super(connectionProvider, mapper);
    }

    @Override
    protected String getInsertQuery() {
        return "insert into courses(course_name, course_description) values (?, ?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from courses where course_id=?";
    }

    @Override
    protected String getAllQuery() {
        return "select * from courses";
    }

    @Override
    protected String getByIdQuery() {
        return "select * from courses where course_id=?";
    }
}
