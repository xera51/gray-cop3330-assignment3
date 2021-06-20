/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Gray
 */

package oop.exercises.ex44;

import oop.exercises.util.ConsoleDataReader;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private static final ConsoleDataReader reader = new ConsoleDataReader();
    private List<Product> products;

    public ProductList() {
        products = new ArrayList<>();
    }

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(String productName) {
        return products.stream()
                .filter(p -> p.getName().equals(productName))
                .findAny().orElse(null);
    }

    public void addProduct(String name, double price, int quantity) {
        addProduct(new Product(name, price, quantity));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productName) {
        products.remove(getProduct(productName));
    }

    public Product searchForProduct() {
        return getProduct(reader.readString("What is the product name? "));
    }

    public Product searchForProductUntilFound() {
        while (true) {
            Product product = searchForProduct();
            if(product != null) return product;
            System.out.println("Sorry, that product was not found in our inventory.");
        }
    }


}
