package com.nelson.dpatterns.creational.prototype;

/**
 * Concrete Prototypes to clone *
 */
public class Book extends Product {
    private int numberOfPages;

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int i) {
        numberOfPages = i;
    }
}
