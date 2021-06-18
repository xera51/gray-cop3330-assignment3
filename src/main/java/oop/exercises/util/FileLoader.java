/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Used for loading various objects, such as {@code File}s, {@code Path}s,
 * {@code BufferedReader}s and {@code BufferedWriter}s from a given search directory
 */
public class FileLoader {

    /**
     * The directory that will be used to search for the files passed in to
     * the various methods in this class
     */
    private final File searchDir;

    /**
     * Constructs a FileLoader
     *
     * <p>{@code dir} defaults to {@code System.getProperty("user.dir")}
     * @see #FileLoader(File)
     * @see #FileLoader(String)
     */
    public FileLoader() {
        this(new File(System.getProperty("user.dir")));
    }

    /**
     * Constructs a FileLoader
     *
     * @param dir directory that the FileLoader will search from
     *
     * @throws IllegalArgumentException if {@code dir} is not a directory
     */
    public FileLoader(String dir) {
        this(new File(dir));
    }

    /**
     * Constructs a FileLoader
     *
     * @param dir directory that the FileLoader will search from
     *
     * @throws IllegalArgumentException if {@code dir} is not a directory
     */
    public FileLoader(File dir) {
        if(!dir.isDirectory()) throw new IllegalArgumentException("not a directory");
        this.searchDir = dir;
    }

    /**
     * Accessor for {@code searchDir}
     *
     * @return The search directory for the {@code FileLoader}
     */
    public File getSearchDir() {
        return searchDir;
    }

    /**
     * Creates a {@code File} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName name of the file
     * @return {@code File} that is in the {@code FileLoader}s search directory
     */
    public File getFile(String fileName) {
        return new File(searchDir, fileName);
    }

    /**
     * Creates a {@code File} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     * @param file path of the file
     * @return {@code File} that is in the {@code FileLoader}s search directory
     */
    public File getFile(File file) {
        return new File(searchDir, file.toString());
    }

    /**
     * Creates a {@code Path} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName the name of the file
     * @return the file as a {@code Path}
     */
    public Path getPath(String fileName) {
        return getFile(fileName).toPath();
    }

    /**
     * Creates a {@code Path} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     * @param file the path of the file
     * @return the file as a {@code Path}
     */
    public Path getPath(File file) {
        return getFile(file).toPath();
    }

    /**
     * Creates a {@code BufferedReader} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName name of the file
     * @return a {@code BufferedReader} with the file specified in {@code fileName}
     * @throws IOException if the file does not exist
     */
    public BufferedReader getBufferedReader(String fileName)
            throws IOException {
        return new BufferedReader(new FileReader(getFile(fileName)));
    }

    /**
     * Creates a {@code BufferedReader} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     *
     * @param file path of the file
     * @return a {@code BufferedReader} with the file specified in {@code file}
     * @throws IOException if the file does not exist
     */
    public BufferedReader getBufferedReader(File file)
            throws IOException {
        return new BufferedReader(new FileReader(getFile(file)));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName the name of the file
     * @return a {@code BufferedWriter} with the file specified in {@code fileName}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(String fileName)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(fileName)));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     *
     * @param file the path of the file
     * @return a {@code BufferedWriter} with the file specified in {@code file}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(File file)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(file)));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code String fileName} as the child
     *
     * @param fileName the name of the file
     * @param append if {@code true}, append to the file instead of overwrite
     * @return a {@code BufferedWriter} with the file specified in {@code fileName}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(String fileName, boolean append)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(fileName), append));
    }

    /**
     * Creates a {@code BufferedWriter} using {@code FileLoader}s {@code searchDir} as
     * the parent and {@code File file} as the child
     * @param file the path of the file
     * @param append if {@code true}, append to the file instead of overwrite
     * @return a {@code BufferedWriter} with the file specified in {@code file}
     * @throws IOException if the file can not be found or created
     */
    public BufferedWriter getBufferedWriter(File file, boolean append)
            throws IOException {
        return new BufferedWriter(new FileWriter(getFile(file), append));
    }

    /**
     * Creates a {@code Stream<String>} of lines of the file returned from {@code getPath}
     *
     * @param fileName the name of the file
     * @return {@code Stream<String>} containing the lines in the file
     * @throws IOException if the file does not exist
     * @see #getPath(String)
     */
    public Stream<String> getLines(String fileName)
            throws IOException{
        return Files.lines(getPath(fileName));
    }

    /**
     * Creates a {@code Stream<String>} of lines of the file returned from {@code getPath}
     *
     * @param file - the path of the file
     * @return {@code Stream<String>} containing the lines in the file
     * @throws IOException if the file does not exist
     * @see #getPath(File)
     */
    public Stream<String> getLines(File file)
            throws IOException{
        return Files.lines(getPath(file));
    }

    /**
     * Override for {@code Object toString()}
     *
     * @return A string representation of {@code FileLoader}
     */
    @Override
    public String toString() {
        return String.format("FileLoader searching from: %s", getSearchDir());
    }
}
