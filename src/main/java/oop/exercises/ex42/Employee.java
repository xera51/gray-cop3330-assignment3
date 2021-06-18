/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex42;

import java.util.HashMap;

public class Employee {

    private final HashMap<String, String> data = new HashMap<>(3);

    public Employee(String firstName, String lastName, String salary) {
        this(firstName, lastName, Double.parseDouble(salary));
    }

    public Employee(String firstName, String lastName, double salary) {
        if(!validateName(firstName))
            throw new IllegalArgumentException("First name must not be blank");
        else if(!validateName(lastName))
            throw new IllegalArgumentException("Last name must not be blank");
        else if(!validateSalary(salary))
            throw new IllegalArgumentException("Salary must be positive");
        else {
            data.put("firstName", firstName);
            data.put("lastName", lastName);
            data.put("salary", Double.toString(salary));
        }
    }

    public String getFirst() {
        return data.get("firstName");
    }

    public String getLast() {
        return data.get("lastName");
    }

    public String getFull() {
        return data.get("firstName") + " " + data.get("lastName");
    }

    public String getSalary() {
        return data.get("salary");
    }

    private boolean validateName(String name) {
        return !name.isEmpty();
    }

    private boolean validateSalary(double salary) {
        return salary > 0;
    }
}
