package com.nelson.flowcontrol;

/**
 * User: tjnelson
 * Date: 10/17/13
 * Time: 1:00 PM
 */
public class SwitchByte {
    public static void main(String args[]) {
        byte foo = 120;
        //byte foo = 119;
        switch (foo) {
            default:
                System.out.println("ejavaguru");
                break;
            case 2:
                System.out.println("e");
                break;
            case 120:
                System.out.println("ejava");
            case 121:
                System.out.println("enum");
            case 127:
                System.out.println("guru");
                break;
        }
    }
}
