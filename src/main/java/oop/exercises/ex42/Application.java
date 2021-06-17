/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */
package oop.exercises.ex42;

import oop.exercises.util.FileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.Enumeration;

import static java.lang.ClassLoader.getSystemClassLoader;

public class Application {

    public static void main(String[] args) {
        try {
            String filename = "exercise41_output.txt";
            String output = "Test output.";
            Path thePath = Paths.get(getSystemClassLoader().getResource(filename).toURI());
            System.out.println(thePath);
            Writer writer = Files.newBufferedWriter(thePath, StandardOpenOption.CREATE);
            writer.write(output);
            writer.close();
        } catch (IOException | URISyntaxException e) {
            System.out.println("error");
        }

    }
}