package com.nelson.certification;

/**
 * User: tjnelson
 * Date: 10/31/13
 * Time: 3:06 PM
 */
public class Triangle {
    private static double ANGLE = 0.0;
    public int base;
    public int height;

    public static double getANGLE() {
        return 0;
    }

    public static void main(String args) {
        System.out.println(getANGLE());
    }
}


// A. It will not compile because it does not implement setAngle method.  
// B. It will not compile because ANGLE cannot be private.  
// * C. It will not compile because getAngle() has no body.  
// D. It will not compile because ANGLE field is not initialized.  
// E. It will not compile because of the name of the method Main instead of main.