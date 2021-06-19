/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.ex45;

import oop.exercises.util.FileLoader;
import oop.exercises.util.ResourceLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FileStringReplacerTest {

    private static final String INFILE_NAME = "file_for_testing_in";
    private static final String OUTFILE_NAME = "file_for_testing_out";
    private static final String INPUT_STRING =
            String.format("One should never utilize the word \"utilize\" in writing. " +
                    "Use \"use\" instead.%nFor example, \"She uses an IDE to write her " +
                    "Java programs\" instead of \"She%n" +
                    "utilizes an IDE to write her Java programs\".");
    private static final String OUTPUT_STRING =
            String.format("One should never use the word \"use\" in writing. " +
                    "Use \"use\" instead.%nFor example, \"She uses an IDE to write her " +
                    "Java programs\" instead of \"She%n" +
                    "uses an IDE to write her Java programs\".");
    private static final String FROM = "utilize";
    private static final String TO = "use";

    @Test
    @DisplayName("Gets FileLoader")
    void successfully_returns_file_loader() {
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());

        String expected = ResourceLoader.get().toString();
        String actual = replacer.getLoader().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Gets search directory")
    void successfully_returns_search_directory() {
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());

        String expected = ResourceLoader.get().getSearchDir().toString();
        String actual = replacer.getSearchDir().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Does Replacement with String")
    void successfully_replaces_word_with_String()
            throws IOException {
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());
        BufferedWriter writer = replacer.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        replacer.swapStringInFile(INFILE_NAME, FROM, TO);

        String expected = OUTPUT_STRING;
        String actual = new FileLoader()
                .getLines(INFILE_NAME)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);

        new FileLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Does Replacement with File")
    void successfully_replaces_word_with_File()
            throws IOException {
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());
        BufferedWriter writer = replacer.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        replacer.swapStringInFile(new File(INFILE_NAME), FROM, TO);

        String expected = OUTPUT_STRING;
        String actual = new FileLoader()
                .getLines(INFILE_NAME)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);

        new FileLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Does Replacement with String String")
    void successfully_replaces_word_with_String_String()
            throws IOException {
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());
        BufferedWriter writer = replacer.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        replacer.swapStringInFile(INFILE_NAME, OUTFILE_NAME, FROM, TO);

        String expected = OUTPUT_STRING;
        String actual = new FileLoader()
                .getLines(OUTFILE_NAME)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);

        replacer.getLoader().getFile(INFILE_NAME).delete();
        new FileLoader().getFile(OUTFILE_NAME).delete();
    }

    @Test
    @DisplayName("Does Replacement with File File")
    void successfully_replaces_word_with_File_File()
            throws IOException {
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());
        BufferedWriter writer = replacer.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        replacer.swapStringInFile(new File(INFILE_NAME),
                new File(OUTFILE_NAME), FROM, TO);

        String expected = OUTPUT_STRING;
        String actual = new FileLoader()
                .getLines(OUTFILE_NAME)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);

        replacer.getLoader().getFile(INFILE_NAME).delete();
        new FileLoader().getFile(OUTFILE_NAME).delete();
    }

    @Test
    @DisplayName("Properly swaps Strings")
    void successfully_swaps_from_String_to_to_String()
            throws IOException{
        FileStringReplacer replacer = new FileStringReplacer(ResourceLoader.get());
        BufferedWriter writer = replacer.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();

        String expected = OUTPUT_STRING;
        String actual = replacer.swapString(replacer
                .getLoader().getLines(INFILE_NAME), FROM, TO)
                .collect(Collectors.joining(System.lineSeparator()));

        assertEquals(expected, actual);

        replacer.getLoader().getFile(INFILE_NAME).delete();
    }
}