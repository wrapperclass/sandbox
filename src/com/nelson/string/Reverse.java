package com.nelson.string;

/**
 * Created by tjnelson on 11/5/15.
 * Reverse a string
 */
public class Reverse {

    public static void main(String... args) {

        String text = "String to Reverse";
        char[] array = text.toCharArray();
        System.out.println(text);

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }
}
