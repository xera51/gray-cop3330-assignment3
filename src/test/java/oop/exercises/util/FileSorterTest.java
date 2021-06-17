package oop.exercises.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FileSorterTest {

    @Test
    @DisplayName("Lines are sorted Correctly")
    void lines_from_file_are_sorted() {

        List<String> lines = new LinkedList<>();
        try {
            lines = FileSorter.linesSorted("exercise41_input.txt").collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            System.out.printf("Error in lines_from_file_are_sorted%n%s%n", e.getMessage());
        }

        String[] expected = {"Johnson, Jim",
                "Jones, Aaron",
                "Jones, Chris",
                "Ling, Mai",
                "Swift, Geoffrey",
                "Xiong, Fong",
                "Zarnecki, Sabrina"};
        String[] actual = lines.toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }
}