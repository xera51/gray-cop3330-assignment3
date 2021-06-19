/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex46;

import oop.exercises.util.ResourceLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyFinderTest {

    private static final String INFILE_NAME = "file_for_testing_in.txt";
    private static final String INPUT_STRING = String.format("badger badger badger %n" +
            "badger mushroom %n" +
            "mushroom snake badger badger %n" +
            "badger");
    private static final String OUTPUT_STRING = String.format("badger:   *******%n" +
            "mushroom: **%n" +
            "snake:    *%n");
    private static final String INPUT_STRING_MIXED = String.format("badger badger badger %n" +
            "badger snake mushroom %n" +
            "mushroom badger badger %n" +
            "badger");
    private static final String OUTPUT_STRING_MIXED = String.format("badger:   *******%n" +
            "snake:    *%n" +
            "mushroom: **%n");

    @Test
    @DisplayName("Gets FileLoader")
    void successfully_returns_file_loader() {
        WordFrequencyFinder replacer = new WordFrequencyFinder(ResourceLoader.get());

        String expected = ResourceLoader.get().toString();
        String actual = replacer.getLoader().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Gets search directory")
    void successfully_returns_search_directory() {
        WordFrequencyFinder replacer = new WordFrequencyFinder(ResourceLoader.get());

        String expected = ResourceLoader.get().getSearchDir().toString();
        String actual = replacer.getSearchDir().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Frequency using String")
    void successfully_creates_frequency_map_using_String()
            throws IOException{
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("badger", 7L);
        expected.put("mushroom", 2L);
        expected.put("snake", 1L);
        Map<String, Long> actual = new LinkedHashMap<>(freqFinder.getWordFrequency(INFILE_NAME));

        assertArrayEquals(expected.entrySet().toArray(), actual.entrySet().toArray());

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Frequency using File")
    void successfully_creates_frequency_map_using_File()
            throws IOException{
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("badger", 7L);
        expected.put("mushroom", 2L);
        expected.put("snake", 1L);
        Map<String, Long> actual = new LinkedHashMap(freqFinder.getWordFrequency(new File(INFILE_NAME)));

        assertArrayEquals(expected.entrySet().toArray(), actual.entrySet().toArray());

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Frequency Sorted using String")
    void successfully_creates_sorted_frequency_map_using_String()
            throws IOException{
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING_MIXED);
        writer.close();

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("badger", 7L);
        expected.put("mushroom", 2L);
        expected.put("snake", 1L);
        Map<String, Long> actual = freqFinder.getWordFrequencySorted(INFILE_NAME);

        assertArrayEquals(expected.entrySet().toArray(), actual.entrySet().toArray());

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Frequency using File")
    void successfully_creates_sorted_frequency_map_using_File()
            throws IOException{
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING_MIXED);
        writer.close();

        Map<String, Long> expected = new LinkedHashMap<>();
        expected.put("badger", 7L);
        expected.put("mushroom", 2L);
        expected.put("snake", 1L);
        Map<String, Long> actual = freqFinder.getWordFrequencySorted(new File(INFILE_NAME));

        assertArrayEquals(expected.entrySet().toArray(), actual.entrySet().toArray());

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Creates graph using String")
    void successfully_creates_graph_using_String()
            throws IOException {
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING_MIXED);
        writer.close();

        String expected = OUTPUT_STRING_MIXED;
        String actual = freqFinder.getWordFrequencyGraph(INFILE_NAME);

        assertEquals(expected, actual);

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Creates graph using File")
    void successfully_creates_graph_using_File()
            throws IOException {
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING_MIXED);
        writer.close();

        String expected = OUTPUT_STRING_MIXED;
        String actual = freqFinder.getWordFrequencyGraph(new File(INFILE_NAME));

        assertEquals(expected, actual);

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Creates sorted graph using String")
    void successfully_creates_sorted_graph_using_String()
            throws IOException {
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING_MIXED);
        writer.close();

        String expected = OUTPUT_STRING;
        String actual = freqFinder.getWordFrequencyGraphSorted(INFILE_NAME);

        assertEquals(expected, actual);

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Creates sorted graph using File")
    void successfully_creates_sorted_graph_using_File()
            throws IOException {
        WordFrequencyFinder freqFinder = new WordFrequencyFinder(ResourceLoader.get());
        BufferedWriter writer = freqFinder.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING_MIXED);
        writer.close();

        String expected = OUTPUT_STRING;
        String actual = freqFinder.getWordFrequencyGraphSorted(new File(INFILE_NAME));

        assertEquals(expected, actual);

        freqFinder.getLoader().getFile(INFILE_NAME).delete();
    }
}
