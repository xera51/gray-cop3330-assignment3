/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex43;

import oop.exercises.util.FileLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {

    @Test
    @DisplayName("Get siteName")
    void gets_site_name() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator(
        "awesomeco", "Max Power", true, true);

        String expected = "awesomeco";
        String actual = websiteGenerator.getSiteName();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get authorName")
    void gets_author_name() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator(
                "awesomeco", "Max Power", true, true);

        String expected = "Max Power";
        String actual = websiteGenerator.getAuthorName();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get JS setting")
    void gets_js_setting() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator(
                "awesomeco", "Max Power", true, true);

        boolean actual = websiteGenerator.getJsSetting();

        assertTrue(actual);
    }

    @Test
    @DisplayName("Get CSS setting")
    void gets_css_setting() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator(
                "awesomeco", "Max Power", true, true);

        boolean actual = websiteGenerator.getCssSetting();

        assertTrue(actual);
    }

    @Test
    @DisplayName("Directories generated correctly")
    void directories_are_generated_correctly_set1() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator(
                "awesomeco", "Max Power", true, true);

        String expected = String.format("Created ./website/awesomeco%n" +
                "Created ./website/awesomeco/index.html%n" +
                "Created ./website/awesomeco/js/%n" +
                "Created ./website/awesomeco/css/%n");
        String actual = websiteGenerator.generate();

        assertEquals(expected, actual);

        FileLoader loader = new FileLoader();
        loader.getFile("website/awesomeco/index.html").delete();
        loader.getFile("website/awesomeco/css").delete();
        loader.getFile("website/awesomeco/js").delete();
        loader.getFile("website/awesomeco").delete();
        loader.getFile("website").delete();
    }

    @Test
    @DisplayName("Directories generated correctly, no js or css")
    void directories_are_generated_correctly_set2() {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator(
                "awesomeco", "Max Power", false, false);

        String expected = String.format("Created ./website/awesomeco%n" +
                "Created ./website/awesomeco/index.html%n");
        String actual = websiteGenerator.generate();

        assertEquals(expected, actual);

        FileLoader loader = new FileLoader();
        loader.getFile("website/awesomeco/index.html").delete();
        loader.getFile("website/awesomeco").delete();
        loader.getFile("website").delete();
    }

}