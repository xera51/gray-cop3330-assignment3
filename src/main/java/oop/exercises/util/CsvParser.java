/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser {

    /**
     * Files are loaded using the {@code FileLoader}
     */
    private final FileLoader loader;

    /**
     * Constructs a {@code CsvParser}
     *
     * <p>{@code loader.dir} defaults to {@code System.getProperty("user.dir")}
     *
     * @see #CsvParser(FileLoader)
     */
    public CsvParser() {
        this(System.getProperty("user.dir"));
    }

    /**
     * Constructs a {@code CsvParser}
     *
     * @param dir directory that the {@code FileLoader} will search from
     *
     * @see #CsvParser(FileLoader)
     */
    public CsvParser(String dir) {
        this(new File(dir));
    }

    /**
     * Constructs a {@code CsvParser}
     *
     * @param dir directory that the {@code FileLoader} will search from
     *
     * @see #CsvParser(FileLoader)
     */
    public CsvParser(File dir) {
        this(new FileLoader(dir));
    }

    /**
     * Constructs a {@code CsvParser}
     *
     * @param loader {@code FileLoader} that the {@code CsvParser} will use
     */
    public CsvParser(FileLoader loader) {
        this.loader = loader;
    }

    /**
     * Accessor for the {@code FileLoader}
     *
     * @return This {@code CsvLoader}'s {@code FileLoader}
     */
    public FileLoader getLoader() {
        return loader;
    }

    /**
     * Accessor for the {@code FileSorter}'s search directory
     *
     * @return This {@code CsvParser}'s search directory
     */
    public File getSearchDir() {
        return loader.getSearchDir();
    }

    /**
     * Reads in the data from a file of CSV.
     * <p>Each line is returned as its own {@code List}
     * <p>Each CSV is its own {@code String}
     *
     * @param fileName
     * @return {@code List} of {@code List} of CSV, each as its own {@code String}
     * @throws IOException if the file could not be found
     */
    public List<List<String>> parseFile(String fileName)
            throws IOException {
        return parseFile(new File(fileName));
    }

    /**
     * Reads in the data from a file of CSV.
     * <p>Each line is returned as its own {@code List}
     * <p>Each CSV is its own {@code String}
     *
     * @param file
     * @return {@code List} of {@code List} of CSV, each as its own {@code String}
     * @throws IOException if the file could not be found
     */
    public List<List<String>> parseFile(File file)
            throws IOException {
        return loader.getLines(file)
                     .map(s -> Arrays.stream(s.split(",")).toList())
                     .collect(Collectors.toList());
    }
}
