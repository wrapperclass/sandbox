package com.nelson.dpatterns.creational.factory;

public abstract class Product {
    public void writeName(String name) {
        System.out.println("My name is " + name);
    }
}
