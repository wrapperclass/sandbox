package com.nelson.fileutil;

import java.io.Serializable;

/**
 * ItemFileInfo will represent the Item level information that we need for each
 * item to be processed.
 *
 * @author tjnelson
 */
public class ItemFileInfo implements Serializable {
    private static final long serialVersionUID = 3163065588152732711L;

    private String fileName;
    private String itemPath;
    private int numFiles;
    private int year;
    private int month;
    private int day;

    public ItemFileInfo() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getItemPath() {
        return itemPath;
    }

    public void setItemPath(String itemPath) {
        this.itemPath = itemPath;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "ItemFileInfo [itemPath=" + itemPath + ", numFiles =" + numFiles + ", year=" + year + ", month=" + month
                + ", day=" + day + "]";
    }

}
