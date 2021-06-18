/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.util;

/**
 * Factory for {@code FileLoader} for resources directory
 */
public class ResourceLoader {

    private static final String DIR = System.getProperty("user.dir") + "/src/main/resources";

    private ResourceLoader() {}

    public static FileLoader get() {
        return new FileLoader(DIR);
    }
}
