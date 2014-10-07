package com.nelson.dpatterns.creational.singleton;

/**
 * The Singleton pattern provides the possibility to control the number of instances (mostly one) that are allowed to be
 * made. We also receive a global point of access to it (them).
 * <p/>
 * Where to use:
 * <p/>
 * When only one instance or a specific number of instances of a class are allowed. Facade objects are often Singletons
 * because only one Facade object is required.
 * <p/>
 * Benefits:
 * <p/>
 * Controlled access to unique instance. Reduced name space. Allows refinement of operations and representations.
 * <p/>
 * Drawbacks:
 * <p/>
 * Singleton pattern is also considered an anti-pattern by some people, who feel that it is overused, introduction
 * unnecessary limitation in situations where a sole instance of a class is not actually required.
 * <p/>
 * Usage:
 *
 * @author trnelson
 */

public class TestSingleton {

    private static TestSingleton instance = null;

    protected TestSingleton() {
        // Exists only to defeat instantiation.
    }

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

}
