/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex41;

import oop.exercises.util.FileSorter;
import oop.exercises.util.ResourceLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

//TODO clean up, using @Before, maybe param testing

class NameSorterTest {

    private static final String test_filename_in = "file_for_testing_in.txt";
    private static final String test_filename_out = "file_for_testing_out.txt";
    private static final String test_input = String.format("Ling, Mai%n" +
            "Johnson, Jim%n" +
            "Zarnecki, Sabrina%n" +
            "Jones, Chris%n" +
            "Jones, Aaron%n" +
            "Swift, Geoffrey%n" +
            "Xiong, Fong");
    private static final String test_output = String.format("Total of 7 names%n" +
            "-----------------%n" +
            "Johnson, Jim%n" +
            "Jones, Aaron%n" +
            "Jones, Chris%n" +
            "Ling, Mai%n" +
            "Swift, Geoffrey%n" +
            "Xiong, Fong%n" +
            "Zarnecki, Sabrina");

    @Test
    @DisplayName("Gets FileSorter")
    void name_sorter_returns_reference_to_file_sorter() {
        NameSorter sorter = new NameSorter(ResourceLoader.get());

        String expected = new FileSorter(ResourceLoader.get()).toString();
        String actual = sorter.getSorter().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Gets FileLoader")
    void name_sorter_returns_reference_to_file_loader() {
        NameSorter sorter = new NameSorter(ResourceLoader.get());

        String expected = ResourceLoader.get().toString();
        String actual = sorter.getLoader().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Gets search directory")
    void name_sorter_returns_reference_to_search_directory() {
        NameSorter sorter = new NameSorter(ResourceLoader.get());

        String expected = ResourceLoader.get().getSearchDir().toString();
        String actual = sorter.getSearchDir().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sorts file using String")
    void sorts_a_file_of_name_using_String()
            throws IOException {
        NameSorter sorter = new NameSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortNames(test_filename_in);

        String expected = test_output;
        String actual = ResourceLoader.get()
                .getLines(test_filename_in)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);

        ResourceLoader.get().getFile(test_filename_in).delete();
    }

    @Test
    @DisplayName("Sorts file using File")
    void sorts_a_file_of_name_using_File()
            throws IOException {
        NameSorter sorter = new NameSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortNames(new File(test_filename_in));

        String expected = test_output;
        String actual = ResourceLoader.get()
                .getLines(test_filename_in)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);

        ResourceLoader.get().getFile(test_filename_in).delete();
    }

    @Test
    @DisplayName("Sorts file using String String")
    void sorts_a_file_of_name_using_String_String()
            throws IOException {
        NameSorter sorter = new NameSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortNames(test_filename_in, test_filename_out);

        String expected = test_output;
        String actual = ResourceLoader.get()
                .getLines(test_filename_out)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);

        ResourceLoader.get().getFile(test_filename_in).delete();
        ResourceLoader.get().getFile(test_filename_out).delete();
    }

    @Test
    @DisplayName("Sorts file using File File")
    void sorts_a_file_of_name_using_File_File()
            throws IOException {
        NameSorter sorter = new NameSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortNames(new File(test_filename_in), new File(test_filename_out));

        String expected = test_output;
        String actual = ResourceLoader.get()
                .getLines(test_filename_out)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);

        ResourceLoader.get().getFile(test_filename_in).delete();
        ResourceLoader.get().getFile(test_filename_out).delete();
    }

    @Test
    @DisplayName("Output built correctly")
    void output_is_built_correctly()
            throws IOException{
        NameSorter sorter = new NameSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        String expected = test_output;
        String actual = sorter.buildOutput(sorter.getSorter().getLinesSorted(test_filename_in));

        assertEquals(expected, actual);

        ResourceLoader.get().getFile(test_filename_in).delete();
    }
}