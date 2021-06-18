/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex41;

import oop.exercises.util.ResourceLoader;

import java.io.IOException;

public class Application {

    private static final String INFILE_NAME = "exercise41_input.txt";
    private static final String OUTFILE_NAME = "exercise41_output.txt";
    private NameSorter sorter;

    public static void main(String[] args) {
        Application app = new Application();
        app.sorter = new NameSorter(ResourceLoader.get());
        app.sort();
    }

    private void sort() {
        try {
            sorter.sortNames(INFILE_NAME, OUTFILE_NAME);
            System.out.println("Operation succeeded");
        } catch (IOException e) {
            System.out.println("Operation Failed");
        }
    }
}
