package oop.exercises.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FileSorterTest {

    private static final String ud = System.getProperty("user.dir");
    private static final String fs = System.getProperty("file.separator");
    private static final String test_filename_in = "file_for_testing_in.txt";
    private static final String test_filename_out = "file_for_testing_out.txt";
    private static final String test_input = String.format("Ling, Mai%n" +
            "Johnson, Jim%n" +
            "Zarnecki, Sabrina%n" +
            "Jones, Chris%n" +
            "Jones, Aaron%n" +
            "Swift, Geoffrey%n" +
            "Xiong, Fong");
    private static final String test_output = String.format("Johnson, Jim%n" +
            "Jones, Aaron%n" +
            "Jones, Chris%n" +
            "Ling, Mai%n" +
            "Swift, Geoffrey%n" +
            "Xiong, Fong%n" +
            "Zarnecki, Sabrina");

    @Test
    @DisplayName("Returns FileLoader")
    void file_loader_is_successfully_returned() {
        FileSorter sorter = new FileSorter(ResourceLoader.get());

        assertEquals(ResourceLoader.get().toString(), sorter.getLoader().toString());
    }

    @Test
    @DisplayName("Returns search directory")
    void file_loader_search_dir_is_successfully_returned() {
        FileSorter sorter = new FileSorter(ResourceLoader.get());

        assertEquals(ResourceLoader.get().getSearchDir(), sorter.getSearchDir());
    }

    @Test
    @DisplayName("File is sorted by lines using String")
    void file_is_sorted_correctly_using_String() throws IOException {
        FileSorter sorter = new FileSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortByLines(test_filename_in);

        String expected = test_output;
        String actual = ResourceLoader.get().getLines(test_filename_in).collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("File is sorted by lines using File")
    void file_is_sorted_correctly_using_File() throws IOException{
        FileSorter sorter = new FileSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortByLines(new File(test_filename_in));

        String expected = test_output;
        String actual = ResourceLoader.get().getLines(test_filename_in).collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("File is sorted by lines using two Strings")
    void file_is_sorted_correctly_using_String_String() throws IOException {
        FileSorter sorter = new FileSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortByLines(test_filename_in, test_filename_out);

        String expected = test_output;
        String actual = ResourceLoader.get()
                .getLines(test_filename_out)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("File is sorted by lines using two Files")
    void file_is_sorted_correctly_using_File_File() throws IOException{
        FileSorter sorter = new FileSorter(ResourceLoader.get());
        BufferedWriter writer = ResourceLoader.get()
                .getBufferedWriter(test_filename_in);
        writer.write(test_input);
        writer.close();

        sorter.sortByLines(new File(test_filename_in), new File(test_filename_out));

        String expected = test_output;
        String actual = ResourceLoader.get()
                .getLines(test_filename_out)
                .collect(Collectors.joining(System.lineSeparator()));
        assertEquals(expected, actual);
    }
}