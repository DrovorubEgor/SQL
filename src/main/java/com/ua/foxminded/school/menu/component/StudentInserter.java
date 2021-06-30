package com.ua.foxminded.school.menu.component;

import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.impl.GroupDao;
import com.ua.foxminded.school.dao.impl.GroupDaoImpl;
import com.ua.foxminded.school.dao.impl.StudentDao;
import com.ua.foxminded.school.dao.impl.StudentDaoImpl;
import com.ua.foxminded.school.dao.mapper.GroupMapper;
import com.ua.foxminded.school.dao.mapper.StudentMapper;
import com.ua.foxminded.school.menu.Menu;
import com.ua.foxminded.school.model.Student;

import java.util.Scanner;

public class StudentInserter implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentDao studentDao = new StudentDaoImpl(new DataSource(), new StudentMapper());
    private final GroupDao groupDao = new GroupDaoImpl(new DataSource(), new GroupMapper());

    @Override
    public void execute() {
        String firstName;
        String lastName;
        String groupName;
        System.out.println("Enter student firstname: ");
        firstName = scanner.next();
        System.out.println("Enter student lastname: ");
        lastName = scanner.next();
        System.out.println("Enter student group: ");
        groupName = scanner.next();
        studentDao.insert(new Student(firstName, lastName, groupDao.getGroupByName(groupName)));
    }

    @Override
    public String getDescription() {
        return "Add new student";
    }
}
