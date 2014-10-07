package com.nelson.junit;

public class Largest {

    /**
     * Return the largest element in a list.
     *
     * @param list A list of integers
     * @return The largest number in the given list
     */
    public static int largest(int[] list) {

        int max = Integer.MIN_VALUE;

        if (list.length == 0) {
            throw new RuntimeException("largest: Empty list");
        } else {
            for (int number : list) {
                if (number > max) {
                    max = number;
                }
            }
        }
        return max;
    }

}
