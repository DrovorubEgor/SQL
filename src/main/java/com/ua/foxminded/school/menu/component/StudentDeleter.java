package com.ua.foxminded.school.menu.component;

import com.ua.foxminded.school.dao.DataSource;
import com.ua.foxminded.school.dao.impl.StudentDao;
import com.ua.foxminded.school.dao.impl.StudentDaoImpl;
import com.ua.foxminded.school.dao.mapper.StudentMapper;
import com.ua.foxminded.school.menu.Menu;

import java.util.Scanner;

public class StudentDeleter implements Menu {

    private final StudentDao studentDao = new StudentDaoImpl(new DataSource(), new StudentMapper());
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Enter student id:");
        final int id = scanner.nextInt();
        studentDao.delete(studentDao.getById(id));
    }

    @Override
    public String getDescription() {
        return "Delete a student by id.";
    }
}
