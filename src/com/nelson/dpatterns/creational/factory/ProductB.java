package com.nelson.dpatterns.creational.factory;

public class ProductB extends Product {
    public void writeName(String name) {
        StringBuilder tempName = new StringBuilder().append(name);
        System.out.println("My reversed name is " + tempName.reverse());
    }
}
