package com.nelson.corejava.initializers;

public class Initializers {

    // Should see this fifth.
    public Initializers() {
        System.out.println("Constructor moo!");
    }
    // Should see this fourth.
    {
        System.out.println("Initializer moo 2!");
    }
    // Should see this first.
    static {
        System.out.println("Static moo!");
    }

    public static void main(String[] args) throws Exception {
        // Should see this second.
        System.out.println("Main moo!");
        new Initializers();
    }
    // Should see this third.
    {
        System.out.println("Initializer moo 1!");
    }

}
