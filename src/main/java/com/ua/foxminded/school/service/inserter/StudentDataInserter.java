package com.ua.foxminded.school.service.inserter;

import com.ua.foxminded.school.dao.impl.CourseDao;
import com.ua.foxminded.school.dao.impl.StudentDao;
import com.ua.foxminded.school.model.Student;
import com.ua.foxminded.school.service.creator.StudentDataCreator;

public class StudentDataInserter implements DataInserter {

    private final StudentDataCreator studentDataCreator;
    private final StudentDao studentDao;
    private final CourseDao courseDao;

    public StudentDataInserter(StudentDataCreator studentCreator, StudentDao studentDao, CourseDao courseDao) {
        this.studentDataCreator = studentCreator;
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }

    @Override
    public void insert() {
        for (Student student : studentDataCreator.generateData()) {
            studentDao.insert(student);
            addCourse(student);
        }
    }

    private void addCourse(Student student) {
        int courseAmount = (int) (Math.random() * 3) + 1;
        for (int counter = 0; counter < courseAmount; ++counter) {
            int index = (int) (Math.random() * 10);
            studentDao.addCourse(student, courseDao.getAll().get(index));
        }
    }
}
