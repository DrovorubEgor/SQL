package com.ua.foxminded.school.dao.impl;

import com.ua.foxminded.school.dao.Dao;
import com.ua.foxminded.school.model.Course;
import com.ua.foxminded.school.model.Student;

public interface StudentDao extends Dao<Student> {
    void addCourse(Student student, Course course);
}
