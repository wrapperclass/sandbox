package com.nelson.string;

import java.io.File;

/**
 * User: tjnelson
 * Date: 4/20/12
 * Time: 3:23 PM
 */
public class SplitString {

    public static void main(String[] args) {

        String tempString = "C:\\data\\dept\\CHD\\assets\\Root Folder\\";

        int bazinga = tempString.lastIndexOf(File.separatorChar);
        String firstStr = tempString.substring(0, bazinga);

        int bazinga2 = firstStr.lastIndexOf(File.separatorChar);
        String secondStr = tempString.substring(0, bazinga2);

        String item = tempString.substring(bazinga2 + 1);
        String item2 = secondStr.substring(bazinga2 + 1);

        System.out.println("item : " + item);
        System.out.println("item2 : " + item2);
    }

}
