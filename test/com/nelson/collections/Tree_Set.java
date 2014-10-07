package com.nelson.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * The TreeSet Class is similar to the hash set, with one added improvement. A tree set is a sorted collection.
 *
 * @author trnelson
 */
public class Tree_Set {

    /**
     * This method will try adding the same integer to a TreeSet.
     *
     * @param args Integer Values
     */
    public static void main(String[] args) {

        // create object of TreeSet
        Set<Integer> tSet = new TreeSet<>();

        /*
           * Add an Object to TreeSet using boolean add(Object obj) method of Java TreeSet class. This method adds an
           * element to TreeSet if it is not already present in TreeSet. It returns true if the element was added to
           * TreeSet, false otherwise.
           */

        try {
            tSet.add(new Integer("1"));
            tSet.add(new Integer("2"));
            tSet.add(new Integer("3"));
            tSet.add(new Integer("2"));
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: " + e.toString());
        }

        /*
           * Please note that add method accepts Objects. Java Primitive values CAN NOT be added directly to TreeSet. It
           * must be converted to corresponding wrapper class first.
           */

        System.out.println("TreeSet contains.. " + tSet);

    }

}
