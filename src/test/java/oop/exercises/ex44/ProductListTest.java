/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex44;

import com.google.gson.Gson;
import oop.exercises.util.FileLoader;
import oop.exercises.util.ResourceLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductListTest {

    private static final String INFILE_NAME = "exercise44_input.json";

    @Test
    @DisplayName("Json deserialized via Gson properly")
    void product_list_created_properly_via_gson() {
        FileLoader loader = ResourceLoader.get();
        ProductList productList = null;
        try {
            productList = new Gson().fromJson(
                    loader.getBufferedReader(INFILE_NAME),
                    ProductList.class);
        } catch (IOException e) {
            fail("IOException");
        }

        List<Product> expected = new ArrayList<>() {
            {
                add(new Product("Widget", 25, 5));
                add(new Product("Thing", 15, 5));
                add(new Product("Doodad", 5, 10));
            }};
        List<Product> actual = productList.getProducts();

        if(expected.size() != actual.size()) {
            fail("different length lists");
        }

        for(int i = 0; i < expected.size(); i++) {
            Product expectedProduct = expected.get(i);
            Product actualProduct = actual.get(i);
            assertEquals(expectedProduct.toString(), actualProduct.toString());
        }
    }

    @Test
    @DisplayName("Finds Product")
    void finds_product() {
        FileLoader loader = ResourceLoader.get();
        ProductList productList = null;
        try {
            productList = new Gson().fromJson(
                    loader.getBufferedReader(INFILE_NAME),
                    ProductList.class);
        } catch (IOException e) {
            fail("IOException");
        }

        assertNotNull(productList.getProduct("Thing"));
    }

    @Test
    @DisplayName("Fails to find non-existent product")
    void does_not_find_product() {
        FileLoader loader = ResourceLoader.get();
        ProductList productList = null;
        try {
            productList = new Gson().fromJson(
                    loader.getBufferedReader(INFILE_NAME),
                    ProductList.class);
        } catch (IOException e) {
            fail("IOException");
        }

        assertNull(productList.getProduct("iPad"));
    }
}