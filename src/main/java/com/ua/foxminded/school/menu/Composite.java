package com.ua.foxminded.school.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Composite implements Menu{

    private final List<Menu> components = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addComponent(Menu component) {
        components.add(component);
    }

    public void removeComponent(Menu component) {
        components.remove(component);
    }

    @Override
    public void execute() {
        String flag = "";
        while (!flag.equals("exit")) {
            for (Menu component : components) {
                System.out.printf("%d. %s%n", components.indexOf(component), component.getDescription());
            }
            System.out.println("Select an operation.");
            components.get(scanner.nextInt()).execute();
            System.out.println("Continue? y/n.");
            flag = scanner.next().equals("n") ? "exit" : "";
        }
    }

    @Override
    public String getDescription() {
        return "Main menu";
    }
}
