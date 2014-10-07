package com.nelson.flowcontrol;

/**
 * User: tjnelson
 * Date: 10/17/13
 * Time: 12:56 PM
 */
public class Switch {
    public static void main(String args[]) {
        int num = 120;
        switch (num) {
            default:
                System.out.println("default");
            case 0:
                System.out.println("case1");
            case 10 * 2 - 10:
                System.out.println("case2");
                break;
        }
    }
}
