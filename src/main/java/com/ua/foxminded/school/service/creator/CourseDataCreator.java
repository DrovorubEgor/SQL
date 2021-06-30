package com.ua.foxminded.school.service.creator;

import com.ua.foxminded.school.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDataCreator implements DataCreator<Course> {

    private final List<Course> courses = new ArrayList<>();

    @Override
    public List<Course> generateData() {
        courses.add(new Course("Algebra", "subject"));
        courses.add(new Course("Physics", "subject"));
        courses.add(new Course("English", "subject"));
        courses.add(new Course("Biology", "subject"));
        courses.add(new Course("Geometry", "subject"));
        courses.add(new Course("Chemistry", "subject"));
        courses.add(new Course("Psychology", "subject"));
        courses.add(new Course("History", "subject"));
        courses.add(new Course("PE", "subject"));
        courses.add(new Course("Philosophy", "subject"));
        return courses;
    }
}
