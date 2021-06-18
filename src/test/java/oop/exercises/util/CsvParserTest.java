/*
 * UCF COP3330 Summer 2021 Assignment 3 Solution
 * Copyright 2021 Christopher Gray
 */

package oop.exercises.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvParserTest {

    private static final String INFILE_NAME = "file_for_testing_in.txt";
    private static final String INPUT_STRING = String.format("Ling,Mai,55900%n" +
            "Johnson,Jim,56500%n" +
            "Jones,Aaron,46000%n" +
            "Jones,Chris,34500%n" +
            "Swift,Geoffrey,14200%n" +
            "Xiong,Fong,65000%n" +
            "Zarnecki,Sabrina,51500");

    @Test
    @DisplayName("Returns FileLoader")
    void successfully_returns_file_loader() {
        CsvParser parser = new CsvParser(ResourceLoader.get());

        String expected = ResourceLoader.get().toString();
        String actual = parser.getLoader().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Returns search directory")
    void successfully_returns_search_directory() {
        CsvParser parser = new CsvParser(ResourceLoader.get());

        String expected = ResourceLoader.get().getSearchDir().toString();
        String actual = parser.getLoader().getSearchDir().toString();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Parses a CSV using String")
    void successfully_parses_a_CSV_file_using_fileName()
            throws IOException {
        CsvParser parser = new CsvParser(ResourceLoader.get());
        BufferedWriter writer = parser.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();


        List<List<String>> expected = new ArrayList<>(){{
            add(new ArrayList<>(){{add("Ling"); add("Mai"); add("55900");}});
            add(new ArrayList<>(){{add("Johnson"); add("Jim"); add("56500");}});
            add(new ArrayList<>(){{add("Jones"); add("Aaron"); add("46000");}});
            add(new ArrayList<>(){{add("Jones"); add("Chris"); add("34500");}});
            add(new ArrayList<>(){{add("Swift"); add("Geoffrey"); add("14200");}});
            add(new ArrayList<>(){{add("Xiong"); add("Fong"); add("65000");}});
            add(new ArrayList<>(){{add("Zarnecki"); add("Sabrina"); add("51500");}});
        }};
        List<List<String>> actual = parser.parseFile(INFILE_NAME);

        assertArrayEquals(expected.toArray(), actual.toArray());

        parser.getLoader().getFile(INFILE_NAME).delete();
    }

    @Test
    @DisplayName("Parses a CSV using File")
    void successfully_parses_a_CSV_file_using_file()
            throws IOException {
        CsvParser parser = new CsvParser(ResourceLoader.get());
        BufferedWriter writer = parser.getLoader().getBufferedWriter(INFILE_NAME);
        writer.write(INPUT_STRING);
        writer.close();


        List<List<String>> expected = new ArrayList<>(){{
            add(new ArrayList<>(){{add("Ling"); add("Mai"); add("55900");}});
            add(new ArrayList<>(){{add("Johnson"); add("Jim"); add("56500");}});
            add(new ArrayList<>(){{add("Jones"); add("Aaron"); add("46000");}});
            add(new ArrayList<>(){{add("Jones"); add("Chris"); add("34500");}});
            add(new ArrayList<>(){{add("Swift"); add("Geoffrey"); add("14200");}});
            add(new ArrayList<>(){{add("Xiong"); add("Fong"); add("65000");}});
            add(new ArrayList<>(){{add("Zarnecki"); add("Sabrina"); add("51500");}});
        }};
        List<List<String>> actual = parser.parseFile(new File(INFILE_NAME));

        assertArrayEquals(expected.toArray(), actual.toArray());

        parser.getLoader().getFile(INFILE_NAME).delete();
    }
}