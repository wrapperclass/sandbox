package com.nelson.flowcontrol;

/**
 * User: tjnelson
 * Date: 10/17/13
 * Time: 1:05 PM
 */
public class VariableAssignmentInIf {
    public static void main(String args[]) {
        boolean myVal = false;
        if (myVal = true) {
			for (int i = 0; i < 2; i++) {
				System.out.println(i);
			}
		} else {
			System.out.println("else");
		}
    }
}
