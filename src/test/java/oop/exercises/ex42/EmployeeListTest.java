/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex42;

import oop.exercises.util.CsvParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeListTest {

    @Test
    @DisplayName("Correctly builds output")
    void buildTable() {
        EmployeeList employeeList = new EmployeeList();

        List<List<String>> employeeData = new ArrayList<>(){{
            add(new ArrayList<>(){{add("Ling"); add("Mai"); add("55900");}});
            add(new ArrayList<>(){{add("Johnson"); add("Jim"); add("56500");}});
            add(new ArrayList<>(){{add("Jones"); add("Aaron"); add("46000");}});
            add(new ArrayList<>(){{add("Jones"); add("Chris"); add("34500");}});
            add(new ArrayList<>(){{add("Swift"); add("Geoffrey"); add("14200");}});
            add(new ArrayList<>(){{add("Xiong"); add("Fong"); add("65000");}});
            add(new ArrayList<>(){{add("Zarnecki"); add("Sabrina"); add("51500");}});
        }};

        employeeList.addEmployeeData(employeeData);

        String expected = String.format("Last      First     Salary%n" +
                "--------------------------%n" +
                "Ling      Mai       55900%n" +
                "Johnson   Jim       56500%n" +
                "Jones     Aaron     46000%n" +
                "Jones     Chris     34500%n" +
                "Swift     Geoffrey  14200%n" +
                "Xiong     Fong      65000%n" +
                "Zarnecki  Sabrina   51500%n");
        String actual = employeeList.buildTable();

        assertEquals(expected, actual);
    }
}