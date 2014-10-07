package com.nelson.dpatterns.creational.prototype;

/**
 * Concrete Prototypes to clone *
 */
public class DVD extends Product {
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int i) {
        duration = i;
    }
}
