package com.nelson.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author trnelson
 */
public class Linked_List {

    /**
     * A LinkedList solves the Array problem of inserting/removing in the middle of the List. It stores each
     * object in a separate link. Each link also stores a reference to the next link in the sequence. In java
     * all linked lists are actually doubly linked; that is, each link also stores a reference to its predecessor.
     *
     * @param args Command Line Parameters
     */
    public static void main(String[] args) {

        List<String> staff = new LinkedList<>();

        staff.add("Amy");
        staff.add("Bob");
        staff.add("Joe");
        staff.add("Helen");
        staff.add("Travis");

        System.out.println("Original List size " + staff.size());
        for (String name : staff) {
            System.out.println("Name: " + name);
        }

        Iterator<String> iterator = staff.iterator();
        iterator.next();
        iterator.next();
        String removedName = iterator.next();
        System.out.println();
        System.out.println("Removed item: " + removedName);
        // Removes last visited element which is the second element.
        iterator.remove();

        System.out.println();
        System.out.println("List after removal size " + staff.size());
        for (String name : staff) {
            System.out.println("Name: " + name);
        }

        System.out.println();
        ListIterator<String> iterator2 = staff.listIterator();
        iterator2.next();
        iterator2.next();
        iterator2.add("Henry");
        System.out.println("List after add size " + staff.size());
        for (String name : staff) {
            System.out.println("Name: " + name);
        }
    }

}
