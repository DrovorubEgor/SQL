package com.ua.foxminded.school.service.creator;

import com.github.javafaker.Faker;
import com.ua.foxminded.school.model.Group;
import com.ua.foxminded.school.model.Student;

import java.util.*;

public class StudentDataCreator implements DataCreator<Student> {

    private final Faker fakeValuesService = new Faker();
    private final List<String> firstNames = new ArrayList<>();
    private final List<String> lastNames = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Group> groups;
    private final int namesAmount;

    public StudentDataCreator(final int namesAmount, final List<Group> groups) {
        this.namesAmount = namesAmount;
        this.groups = groups;
    }

    @Override
    public List<Student> generateData() {
        for (int counter = 0; counter <= namesAmount; ++counter) {
            firstNames.add(fakeValuesService.name().firstName());
            lastNames.add(fakeValuesService.name().lastName());
        }

        for (String firstName : firstNames) {
            for (int counter = 0; counter < lastNames.size(); ++counter) {
                students.add(new Student(firstName,
                        lastNames.get((int) (Math.random() * (lastNames.size()))),
                        groups.get((int) (Math.random() * (groups.size()))))
                );
            }
        }
        return students;
    }
}
