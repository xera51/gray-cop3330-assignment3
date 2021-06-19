/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex46;

import oop.exercises.util.FileLoader;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyFinder {

    private static final Function<String, Stream<String>> linesToWords = l -> Stream.of(l.split("\\s+"));

    private final FileLoader loader;

    public WordFrequencyFinder() {
        this(System.getProperty("user.dir"));
    }

    public WordFrequencyFinder(String dir) {
        this(new File(dir));
    }

    public WordFrequencyFinder(File dir) {
        this(new FileLoader(dir));
    }

    public WordFrequencyFinder(FileLoader loader) {
        this.loader = loader;
    }

    public FileLoader getLoader() {
        return loader;
    }

    public File getSearchDir() {
        return loader.getSearchDir();
    }

    public Map<String, Long> getWordFrequency(String fileName)
            throws IOException {
        return getWordFrequency(new File(fileName));
    }

    public Map<String, Long> getWordFrequency(File file)
            throws IOException{
        return loader.getLines(file)
                     .flatMap(linesToWords)
                     .collect(Collectors
                     .groupingBy(String::toString, LinkedHashMap::new,Collectors.counting()));
    }

    public Map<String, Long> getWordFrequencySorted(String fileName)
            throws IOException{
        return getWordFrequencySorted(new File(fileName));
    }

    public Map<String, Long> getWordFrequencySorted(File file)
            throws IOException{
        return getWordFrequency(file)
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
    }

    public String getWordFrequencyGraph(String fileName)
            throws IOException{
        return getWordFrequencyGraph(new File(fileName));
    }

    public String getWordFrequencyGraph(File file)
            throws IOException{
        return buildWordFrequencyGraph(getWordFrequency(file), getWidth(file));
    }

    public String getWordFrequencyGraphSorted(String fileName)
            throws IOException{
        return getWordFrequencyGraphSorted(new File(fileName));
    }

    public String getWordFrequencyGraphSorted(File file)
            throws IOException{
        return buildWordFrequencyGraph(getWordFrequencySorted(file), getWidth(file));
    }

    private String buildWordFrequencyGraph(Map<String, Long> words, int width) {
        StringBuilder output = new StringBuilder();

        for(Map.Entry<String, Long> e : words.entrySet()) {
            output.append(
                    String.format("%" + width + "s", e.getKey() + ":") +
                            "*".repeat(e.getValue().intValue()) +
                            System.lineSeparator());
        }
        return output.toString();
    }

    private int longestWordLength(File file)
            throws IOException{
        return loader.getLines(file)
                .flatMap(linesToWords)
                .mapToInt(s -> s.length())
                .max().getAsInt();
    }

    private int getWidth(File file)
            throws IOException{
        return -(longestWordLength(file) + 2);
    }
}
