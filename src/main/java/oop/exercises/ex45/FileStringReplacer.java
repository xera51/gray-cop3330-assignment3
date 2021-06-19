/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex45;

import oop.exercises.util.FileLoader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStringReplacer {

    private final FileLoader loader;
    private static final FileLoader output_loader = new FileLoader();

    public FileStringReplacer() {
       this(System.getProperty("user.dir"));
    }

    public FileStringReplacer(String dir) {
        this(new File(dir));
    }

    public FileStringReplacer(File dir) {
        this(new FileLoader(dir));
    }

    public FileStringReplacer(FileLoader loader) {
        this.loader = loader;
    }

    public FileLoader getLoader() {
        return loader;
    }

    public File getSearchDir() {
        return loader.getSearchDir();
    }

    public void swapStringInFile(String fileName, String from, String to) 
            throws IOException {
        swapStringInFile(loader.getLines(fileName), new File(fileName), from, to);
    }

    public void swapStringInFile(File file, String from, String to)
            throws IOException {
        swapStringInFile(loader.getLines(file), file, from, to);
    }

    public void swapStringInFile(String inFileName, String outFileName,
                                 String from, String to)
            throws IOException {
        swapStringInFile(loader.getLines(inFileName), new File(outFileName), from, to);
    }

    public void swapStringInFile(File inFile, File outFile,
                                 String from, String to)
            throws IOException {
        swapStringInFile(loader.getLines(inFile), outFile, from, to);
    }

    private void swapStringInFile(Stream<String> in, File outFile, String from, String to)
            throws IOException {
        String output = linesToString(swapString(in, from, to));
        BufferedWriter out = output_loader.getBufferedWriter(outFile);
        out.write(output);
        out.close();
    }
    
    public Stream<String> swapString(Stream<String> in, String from, String to) {
        return in.map(s -> s.replaceAll(from, to));
    }

    private String linesToString(Stream<String> lines) {
        return lines.collect(Collectors.joining(System.lineSeparator()));
    }
}
