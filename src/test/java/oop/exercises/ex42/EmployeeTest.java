/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex42;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    @DisplayName("Returns the first name")
    void successfully_returns_the_first_name() {
        Employee employee = new Employee("Difo", "Fido", "100000");

        String expected = "Difo";
        String actual = employee.getFirst();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Returns the last name")
    void successfully_returns_the_last_name() {
        Employee employee = new Employee("Difo", "Fido", "100000");

        String expected = "Fido";
        String actual = employee.getLast();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Returns the full name")
    void successfully_returns_the_full_name() {
        Employee employee = new Employee("Difo", "Fido", "100000");

        String expected = "Difo Fido";
        String actual = employee.getFull();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Returns the salary")
    void successfully_returns_the_salary() {
        Employee employee = new Employee("Difo", "Fido", "100000");

        String expected = "100000.0";
        String actual = employee.getSalary();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty first name is rejected")
    void empty_first_name_throws_illegal_argument_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Fido", "100000"));
    }

    @Test
    @DisplayName("Empty last name is rejected")
    void empty_last_name_throws_illegal_argument_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Difo", "", "100000"));
    }

    @Test
    @DisplayName("Negative salary is rejected")
    void negative_salary_throws_illegal_argument_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Difo", "Fido", -100000));
    }


}