package com.nelson.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tjnelson
 * Date: 12/11/12
 * Time: 12:48 PM
 */
public class CountXMLElements {

    public static void main(String argv[]) {

        try {
            String filePath;
            filePath = "C:\\Users\\tjnelson\\Dropbox\\java\\sandbox\\src\\com\\nelson\\xpath\\file.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filePath);

            NodeList list = doc.getElementsByTagName("staff");

            System.out.println("Total of elements : " + list.getLength());
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }

    }
}
