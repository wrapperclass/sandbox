package com.nelson.string;

import com.nelson.certification.comparator.NumberAwareStringComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextSort {
    public static void main(String[] args) throws Exception {

        List<String> values = new ArrayList<>();
        values.add("CR 298 59_2013_Ward_f0001_1074_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_1139_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_1155_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_116_8x11.pdf");
        values.add("CR 298 59_2013_Ward_f0001_124_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_1325_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_1406_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_221_8x11.pdf");
        values.add("CR 298 59_2013_Ward_f0001_27_36x36.pdf");
        values.add("CR 298 59_2013_Ward_f0001_27_8x11.pdf");
        values.add("CR 298 59_2013_Ward_f0001_418_36x36.pdf");

        Collections.sort(values, new NumberAwareStringComparator());

        values.forEach(System.out::println);
    }
}
