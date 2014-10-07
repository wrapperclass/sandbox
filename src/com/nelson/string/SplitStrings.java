package com.nelson.string;

public class SplitStrings {

    /**
     * This method will split a String by the | pipe char.
     *
     * @param args Command Line Values
     */
    public static void main(final String[] args) {
        String delimiter = "\\|";
        String str = "2=44 2920-618178|1=44 7711-950689";
        String[] tokens = str.split(delimiter);

        for (String token : tokens) {
            System.out.println(token);
        }
    }

}
