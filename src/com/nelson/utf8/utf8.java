package com.nelson.utf8;

import java.io.UnsupportedEncodingException;

/**
 * User: tjnelson
 * Date: 11/1/12
 * Time: 11:17 AM
 */
public class utf8 {

    public static void main(String[] args) {

        String original = "ü";
        //String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");
        byte[] utf8Bytes = new byte[0];
        try {
            utf8Bytes = original.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] defaultBytes = original.getBytes();

        String roundTrip = null;
        try {
            roundTrip = new String(utf8Bytes, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("roundTrip = " + roundTrip);
        System.out.println();
        printBytes(utf8Bytes, "utf8Bytes");
        System.out.println();
        printBytes(defaultBytes, "defaultBytes");
    }

    public static void printBytes(byte[] array, String name) {
        for (int k = 0; k < array.length; k++) {
            System.out.println(name + "[" + k + "] = " + "0x" +
                    UnicodeFormatter.byteToHex(array[k]));
        }
    }
}
