package com.ua.foxminded.school.menu.component;

import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.impl.CourseDao;
import com.ua.foxminded.school.dao.impl.StudentDao;
import com.ua.foxminded.school.dao.impl.StudentDaoImpl;
import com.ua.foxminded.school.dao.mapper.StudentMapper;
import com.ua.foxminded.school.menu.Menu;

public class StudentCourseInserter implements Menu {

    private final StudentDao studentDao = new StudentDaoImpl(new DataSource(), new StudentMapper());
    //private final CourseDao studentDao = new StudentDaoImpl(new DataSource(), new StudentMapper());


    @Override
    public void execute() {

    }

    @Override
    public String getDescription() {
        return "Add a student to the course.";
    }
}
