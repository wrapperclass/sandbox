package com.nelson.fileutil;

import org.apache.commons.vfs2.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tjnelson
 * Date: 1/4/13
 * Time: 11:02 PM
 */
public class InMemoryFile {

    FileObject myFile;

    public static void main(String args[]) {

        InMemoryFile inMemoryFile = new InMemoryFile();
        StringBuffer stringBuffer = new StringBuffer("This is a test for the inMemoryFile system");
        inMemoryFile.open("test.txt");
        inMemoryFile.write(stringBuffer);
        StringBuffer fileContent = inMemoryFile.read();
        System.out.println(fileContent.toString());
    }

    public void open(String fileName) {
        try {
            FileSystemManager fsManager = VFS.getManager();
            String fileString = "ram://" + fileName;
            myFile = fsManager.resolveFile(fileString);
        } catch (org.apache.commons.vfs2.FileSystemException fse) {
            System.out.println("ERROR: " + fse.toString());
        }
    }

    public StringBuffer read() {
        StringBuffer fileContents = new StringBuffer();

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            FileUtil.writeContent(myFile, outputStream);
            fileContents.append(outputStream);
        } catch (IOException fse) {
            System.out.println("ERROR: " + fse);
        }

        return fileContents;
    }

    public boolean write(StringBuffer sbf) {
        try {
            myFile.createFile();
            FileContent fc = myFile.getContent();
            OutputStream outputStream = fc.getOutputStream();
            PrintWriter bw = new PrintWriter(outputStream);
            bw.write(sbf.toString());
            bw.close();
            outputStream.close();
        } catch (IOException fse) {
            System.out.println("ERROR: " + fse);
        }

        return true;
    }

    public void close() {
        try {
            myFile.close();
        } catch (org.apache.commons.vfs2.FileSystemException fse) {
            System.out.println("ERROR: " + fse);
        }

    }
}
