package com.nelson.flowcontrol;

/**
 * User: tjnelson
 * Date: 10/17/13
 * Time: 12:19 PM
 */
public class FlowControl {
    public static void main(String[] args) {
        int i = 10;
        do
            while (i++ < 15)
                i = i + 20;
        while (i < 2);
        System.out.println(i);
    }
}
