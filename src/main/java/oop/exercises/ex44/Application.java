/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex44;

import com.google.gson.Gson;
import oop.exercises.util.FileLoader;
import oop.exercises.util.ResourceLoader;

import java.io.IOException;

public class Application {

    private static final String INFILE_NAME = "exercise44_input.json";
    private static final FileLoader loader = ResourceLoader.get();
    private ProductList productList;

    public static void main(String[] args) {
        Application app = new Application();
        app.createProductListFromJson();
        System.out.println(app.productList.searchForProductUntilFound());
    }

    private void createProductListFromJson() {
        try {
            productList = new Gson().fromJson(
                    loader.getBufferedReader(INFILE_NAME),
                    ProductList.class);
        } catch(IOException e) {
            System.out.println("Failed to load file");
        }
    }
}