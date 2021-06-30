package com.ua.foxminded.school.service;

import com.ua.foxminded.school.service.inserter.CourseDataInserter;
import com.ua.foxminded.school.service.inserter.GroupDataInserter;
import com.ua.foxminded.school.service.inserter.StudentDataInserter;

public class SchoolCombiner implements DataCombiner{

    private final StudentDataInserter studentDataInserter;
    private final GroupDataInserter groupDataInserter;
    private final CourseDataInserter courseDataInserter;

    public SchoolCombiner(StudentDataInserter studentDataInserter, GroupDataInserter groupDataInserter, CourseDataInserter courseDataInserter) {
        this.studentDataInserter = studentDataInserter;
        this.groupDataInserter = groupDataInserter;
        this.courseDataInserter = courseDataInserter;
    }

    @Override
    public void combine() {
        courseDataInserter.insert();
        groupDataInserter.insert();
        studentDataInserter.insert();
    }
}
