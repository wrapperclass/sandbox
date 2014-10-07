package com.nelson.dpatterns.creational.factory;

public class TestClientFactory {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        Product product;
        product = productFactory.createProduct("A");
        product.writeName("John Doe");
        product = productFactory.createProduct("B");
        product.writeName("John Doe");
    }

}
