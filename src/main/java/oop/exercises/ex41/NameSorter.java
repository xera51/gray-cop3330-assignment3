/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex41;

import oop.exercises.util.FileLoader;
import oop.exercises.util.FileSorter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameSorter {

    private final FileSorter sorter;

    public NameSorter() {
        this(System.getProperty("user.dir"));
    }

    public NameSorter(String dir) {
        this(new File(dir));
    }

    public NameSorter(File dir) {
        this(new FileLoader(dir));
    }

    public NameSorter(FileLoader loader) {
        this(new FileSorter(loader));
    }

    public NameSorter(FileSorter sorter) {
        this.sorter = sorter;
    }

    public FileSorter getSorter() {
        return sorter;
    }

    public FileLoader getLoader() {
        return sorter.getLoader();
    }

    public File getSearchDir() {
        return sorter.getLoader().getSearchDir();
    }

    public void sortNames(String fileName)
            throws IOException{
        sortNames(sorter.getLinesSorted(fileName), new File(fileName));
    }

    public void sortNames(File file)
            throws IOException {
        sortNames(sorter.getLinesSorted(file), file);
    }
    public void sortNames(String inFileName, String outFileName)
            throws IOException {
        sortNames(sorter.getLinesSorted(inFileName), new File(outFileName));
    }

    public void sortNames(File inFile, File outFile)
            throws IOException {
        sortNames(sorter.getLinesSorted(inFile), outFile);
    }

    private void sortNames(Stream<String> in, File outFile)
            throws IOException {
        String output = buildOutput(in);
        BufferedWriter out = getLoader().getBufferedWriter(outFile);
        out.write(output);
        out.close();
    }

    public String buildOutput(Stream<String> lines) {
        List<String> linesList = lines.collect(Collectors.toList());
        return buildOutputHeader(linesList.size()) + sorter.linesToString(linesList.stream());
    }

    private String buildOutputHeader(int numNames) {
        return String.format("Total of %d names%n-----------------%n", numNames);
    }
}
