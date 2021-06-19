/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FileLoaderTest {

    private static final String ud = System.getProperty("user.dir");
    private static final String fs = System.getProperty("file.separator");

    @Test
    @DisplayName("Loads a file using String")
    void file_loader_successfully_loads_a_file_using_String() {
        FileLoader resourceLoader = ResourceLoader.get();

        File file = resourceLoader.getFile("exercise41_input.txt");
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Loads a file using File")
    void file_loader_successfully_loads_a_file_using_File() {
        FileLoader resourceLoader = ResourceLoader.get();

        File searchFile = new File("exercise41_input.txt");

        File file = resourceLoader.getFile(searchFile);
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Loads a file using String, with default FileLoader path")
    void file_loader_successfully_loads_a_file_using_default_constructor() {
        FileLoader loader = new FileLoader();

        File file = loader.getFile(String.
                format("src%smain%sresources%sexercise41_input.txt", fs, fs, fs));
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Gets Search Directory")
    void file_loader_successfully_returns_search_directory() {
        FileLoader resourceLoader = ResourceLoader.get();

        String expected = String.format("%s%ssrc%smain%sresources", ud, fs, fs, fs);
        String actual = resourceLoader.getSearchDir().toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Gets a BufferedReader using String")
    void file_loader_successfully_creates_a_buffered_reader_using_String() {
        FileLoader resourceLoader = ResourceLoader.get();

        assertDoesNotThrow(() -> resourceLoader.getBufferedReader("exercise41_input.txt"));
    }

    @Test
    @DisplayName("Gets a BufferedReader using File")
    void file_loader_successfully_creates_a_buffered_reader_using_File() {
        FileLoader resourceLoader = ResourceLoader.get();

        File searchFile = new File("exercise41_input.txt");

        assertDoesNotThrow(() -> resourceLoader.getBufferedReader(searchFile));
    }

    @Test
    @DisplayName("Throws IOException for non-existent file when creating a BufferedReader")
    void file_loader_throws_ioexception_for_file_that_does_not_exist_when_creating_new_buffered_reader() {
        FileLoader resourceLoader = ResourceLoader.get();

        assertThrows(IOException.class, () -> resourceLoader.getBufferedReader("nonsense.txt"));
    }

    @Test
    @DisplayName("Gets a BufferedWriter using String")
    void file_loader_successfully_creates_a_buffered_writer_using_String() {
        FileLoader resourceLoader = ResourceLoader.get();

        assertDoesNotThrow(() -> resourceLoader.getBufferedWriter("exercise41_output.txt"));
    }

    @Test
    @DisplayName("Gets a BufferedWriter using File")
    void file_loader_successfully_creates_a_buffered_writer_using_File() {
        FileLoader resourceLoader = ResourceLoader.get();

        File searchFile = new File("exercise41_output.txt");

        assertDoesNotThrow(() -> resourceLoader.getBufferedWriter(searchFile));
    }

    @Test
    @DisplayName("Gets a BufferedWriter using String and append")
    void file_loader_successfully_creates_a_buffered_writer_using_String_and_append() {
        FileLoader resourceLoader = ResourceLoader.get();

        assertDoesNotThrow(() -> resourceLoader.getBufferedWriter("exercise41_output.txt", true));
    }

    @Test
    @DisplayName("Gets a BufferedWriter using File and append")
    void file_loader_successfully_creates_a_buffered_writer_using_File_and_append() {
        FileLoader resourceLoader = ResourceLoader.get();

        File searchFile = new File("exercise41_output.txt");

        assertDoesNotThrow(() -> resourceLoader.getBufferedWriter(searchFile, true));
    }

    @Test
    @DisplayName("Gets the lines of a file using String")
    void file_loader_successfully_gets_the_lines_from_a_file_using_string()
            throws IOException{
        FileLoader loader = ResourceLoader.get();

        String expected = String.format("Ling, Mai%n" +
                "Johnson, Jim%n" +
                "Zarnecki, Sabrina%n" +
                "Jones, Chris%n" +
                "Jones, Aaron%n" +
                "Swift, Geoffrey%n" +
                "Xiong, Fong");
        String actual = loader.getLines("exercise41_input.txt")
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Gets the lines of a file using File")
    void file_loader_successfully_gets_the_lines_from_a_file_using_file()
            throws IOException{
        FileLoader loader = ResourceLoader.get();
        File searchFile = new File("exercise41_input.txt");

        String expected = String.format("Ling, Mai%n" +
                "Johnson, Jim%n" +
                "Zarnecki, Sabrina%n" +
                "Jones, Chris%n" +
                "Jones, Aaron%n" +
                "Swift, Geoffrey%n" +
                "Xiong, Fong");

        String actual = loader.getLines(searchFile)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);
    }
}