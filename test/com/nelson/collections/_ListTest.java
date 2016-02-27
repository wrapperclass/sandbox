package com.nelson.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by tjnelson on 2/4/14.
 */
public class _ListTest {

    @Test
    public void myTest() {
        System.out.println("How are you?");
    }

    @Test
    private void ListTest() {

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
        assert (staff.size() == 4);

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
