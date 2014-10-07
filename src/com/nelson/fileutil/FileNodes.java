package com.nelson.fileutil;

import java.io.File;

/**
 * User: tjnelson
 * Date: 4/28/12
 * Time: 3:54 PM
 */
public class FileNodes {

    public static void main(String args[]) {

        // Overall goal is to return only directories that have files in them but no other directories.
        String directoryName = "/home/tjnelson/Dropbox/ebooks/";

        // Get all the files under the given path.
        File directoryListing = new File(directoryName);
        String[] children = directoryListing.list();

        if (children != null) {
            for (String child : children) {
                System.out.println("child: " + child);
            }
        } else {
            System.out.println("children was empty");
        }
    }

}
