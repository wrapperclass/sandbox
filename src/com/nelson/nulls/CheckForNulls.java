package com.nelson.nulls;

public class CheckForNulls {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Test using String
        String testString = null;
        String results = checkForNulls(testString);
        System.out.println("Results: " + results);
    }

    private static String checkForNulls(String testString) {

        String str = null;

        if (testString == null) {
            str = "Got into a null check";
        } else {
            str = "Skipped null check";
        }
        return str;
    }

    private Boolean checkForNullObject(Object obj) {

        return null;
    }

    private class NullTest {

        String str;
    }
}
