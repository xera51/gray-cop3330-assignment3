/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex43;

public class Application {

    private final WebsiteGenerator websiteGenerator = new WebsiteGenerator();

    public static void main(String[] args) {
        Application app = new Application();

        try {
            app.websiteGenerator.setSettingsThroughConsole();
            System.out.println(app.websiteGenerator.generate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}