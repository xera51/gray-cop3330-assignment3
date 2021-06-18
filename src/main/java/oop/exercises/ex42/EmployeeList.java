/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex42;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    private List<Employee> employees;

    public EmployeeList() {
        this(new ArrayList<>());
    }

    public EmployeeList(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getList() {
        return employees;
    }

    public void setList(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
    }

    // Data in each list must be ordered as lastName, firstName, salary
    public void addEmployeeData(List<List<String>> employeesData) {
        List<Employee> temp = new ArrayList<>();
        for(List<String> e : employeesData) {
            if(e.size() != 3) {
                throw new IllegalArgumentException(
                        "Incorrect amount of arguments for an employee");
            }
            temp.add(new Employee(e.get(1), e.get(0), e.get(2)));
        }
        employees.addAll(temp);
    }

    public String buildTable() {
        StringBuilder output = new StringBuilder();
        output.append(buildTableHeader());
        for(Employee employee : employees) {
            output.append(String.format("%-10s%-10s%.0f%n",
                    employee.getLast(),
                    employee.getFirst(),
                    Double.parseDouble(employee.getSalary())));
        }
        return output.toString();
    }

    private String buildTableHeader() {
        return String.format("%-10s%-10s%s%n" +
                "--------------------------%n",
                "Last", "First", "Salary");
    }
}
