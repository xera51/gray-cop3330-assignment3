/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex45;

import oop.exercises.util.ConsoleDataReader;
import oop.exercises.util.ResourceLoader;

import java.io.IOException;

public class Application {

    private static final String INFILE_NAME = "exercise45_input.txt";
    private static final String FROM = "utilize";
    private static final String TO = "use";
    private static final ConsoleDataReader reader = new ConsoleDataReader();
    private final FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());

    public static void main(String[] args) {
        Application app = new Application();

        String outFileName = app.readFileName();

        try {
            app.replacer.swapStringInFile(INFILE_NAME, outFileName, FROM, TO);
            System.out.println("Operation Succeeded");
        } catch (IOException e) {
            System.out.println("Operation Failed");
        }
    }

    private String readFileName() {
        return reader.readString("Name of the output file " +
                "(include file extension): ");
    }
}