package com.ua.foxminded.school.service.inserter;

import com.ua.foxminded.school.dao.impl.CourseDao;
import com.ua.foxminded.school.model.Course;
import com.ua.foxminded.school.service.creator.DataCreator;

public class CourseDataInserter implements DataInserter{

    private final DataCreator<Course> courseCreator;
    private final CourseDao courseDao;

    public CourseDataInserter(DataCreator<Course> courseCreator, CourseDao courseDao) {
        this.courseCreator = courseCreator;
        this.courseDao = courseDao;
    }

    @Override
    public void insert() {
        for (Course course : courseCreator.generateData()) {
            courseDao.insert(course);
        }
    }
}
