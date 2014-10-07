package com.nelson.npe;

/**
 * User: tjnelson
 * Date: 9/20/12
 * Time: 9:31 PM
 */
public class NPETest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String stuff = null;
        String nonstuff = "see";
        //if (stuff.equalsIgnoreCase(nonstuff)) {
        if (nonstuff.equalsIgnoreCase(stuff)) {
            System.out.println("EQUAL");
        } else {
            System.out.println("different");
        }


        String stuff1 = null;
        String nonstuff1 = "";
        //if (stuff1.equals(stuff1)) {
        if ("".equals(stuff1)) {
            System.out.println("EQUAL1");
        } else {
            System.out.println("different1");
        }
    }

}
