/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex46;

import oop.exercises.util.ResourceLoader;

import java.io.IOException;

public class Application {

    private static final String INFILE_NAME = "exercise46_input.txt";
    private final WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());

    public static void main(String[] args) {
        Application app = new Application();
        try {
            String output = app.freqFinder.getWordFrequencyGraphSorted(INFILE_NAME);
            System.out.print(output);
        } catch (IOException e) {
            System.out.println("Operation Failed");
        }
    }
}