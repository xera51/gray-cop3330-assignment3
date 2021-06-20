/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex44;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    @DisplayName("toString is formatted correctly")
    void product_toString_is_formatted_as_expected(){
        Product product = new Product("Thing", 15, 5);

        String expected = String.format("Name: Thing%n" +
                "Price: 15.00%n" +
                "Quantity: 5");
        String actual = product.toString();

        assertEquals(expected, actual);
    }

}