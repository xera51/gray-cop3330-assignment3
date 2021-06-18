/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex42;

import oop.exercises.util.CsvParser;
import oop.exercises.util.ResourceLoader;

import java.io.IOException;

public class Application {

    private static final String INFILE_NAME = "exercise42_input.txt";
    private CsvParser csvParser;
    private EmployeeList employeeList;

    public static void main(String[] args) {
        Application app = new Application();

        app.csvParser = new CsvParser(ResourceLoader.get());
        app.employeeList = new EmployeeList();
        try {
            app.employeeList.addEmployeeData(app.csvParser.parseFile(INFILE_NAME));
            System.out.println(app.employeeList.buildTable());
        } catch (IOException e) {
            System.out.println("Operation Failed");
        }
    }
}