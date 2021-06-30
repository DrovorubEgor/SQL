package com.ua.foxminded.school.menu.component;

import com.ua.foxminded.school.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentComponent implements Menu {

    private final List<Menu> components = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addComponent(Menu component) {
        components.add(component);
    }

    @Override
    public void execute() {
        for (Menu component : components) {
            System.out.printf("%d. %s%n", components.indexOf(component), component.getDescription());
        }
        System.out.println("Choose a command.");
        components.get(scanner.nextInt()).execute();
    }

    @Override
    public String getDescription() {
        return "Student operations.";
    }
}
