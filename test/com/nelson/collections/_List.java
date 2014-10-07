package com.nelson.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _List {
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

        Iterator<String> iter = staff.iterator();
        iter.next();
        iter.next();
        String removedName = iter.next();
        System.out.println();
        System.out.println("Removed item: " + removedName);
        // Removes last visited element which is the second element.
        iter.remove();

        System.out.println();
        System.out.println("List after removal size " + staff.size());
        for (String name : staff) {
            System.out.println("Name: " + name);
        }

        System.out.println();
        ListIterator<String> iter2 = staff.listIterator();
        iter2.next();
        iter2.next();
        iter2.add("Henry");
        System.out.println("List after add size " + staff.size());
        for (String name : staff) {
            System.out.println("Name: " + name);
        }
    }
}
