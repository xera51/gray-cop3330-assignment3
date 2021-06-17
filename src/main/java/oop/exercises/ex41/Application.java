/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */
package oop.exercises.ex41;

import oop.exercises.util.FileLoader;
import oop.exercises.util.FileSorter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

import static java.lang.ClassLoader.getSystemClassLoader;

public class Application {


    //TODO dont use getSystemClassLoader, use getClass().getClassLoader()
    //TODO dont use getResources(), use getResourcesAsStream()

    private static final String INFILE_NAME = "exercise41_input.txt";
    private static final String OUTFILE_NAME = "exercise41_output.txt";

    public static void main(String[] args) {
        Application app = new Application();
        try {
            URL resource = getSystemClassLoader().getResource(System.getProperty("file.separator"));
            Path root = Paths.get(resource.toURI());

        } catch (URISyntaxException e) {
            System.out.println("the error");
            e.printStackTrace();
        }

        try {
            FileSorter.sortFileByLines(INFILE_NAME, OUTFILE_NAME);
            System.out.println("Operation Success");
        } catch (IOException | URISyntaxException e) {
            System.out.printf("Operation Failed%n%s%n", e.getMessage());
            e.printStackTrace();
        }
        // locate input file
        // open input file
        // get data from input file
        // close input file
        // sort lines of input file
        // open output file
        // print lines to output file
        // close output file
    }

    private ClassLoader loader() {
        return getClass().getClassLoader();
    }
}
