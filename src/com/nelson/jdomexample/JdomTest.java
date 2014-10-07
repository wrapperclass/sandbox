package com.nelson.jdomexample;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * User: tjnelson
 * Date: 9/19/12
 * Time: 10:43 PM
 */
public class JdomTest {

    public static void main(String[] args) throws Exception {
        String xmlString = "<zs:searchRetrieveResponse xmlns:zs=\"http://www.loc.gov/zing/srw/\"><zs:version>1.1</zs:version><zs:numberOfRecords>1</zs:numberOfRecords><zs:records><zs:record><zs:recordSchema>info:srw/schema/1/marcxml-v1.1</zs:recordSchema><zs:recordPacking>xml</zs:recordPacking><zs:recordData><record xmlns=\"http://www.loc.gov/MARC21/slim\"><leader>03503npm a2200505 a 4500</leader><controlfield tag=\"001\">000134648</controlfield><controlfield tag=\"003\">org.ldschurch.hmms</controlfield><controlfield tag=\"005\">20110519152434.0</controlfield><controlfield tag=\"008\">860424i18361840xx            |     eng  </controlfield><datafield tag=\"035\" ind1=\"9\" ind2=\" \"><subfield code=\"a\">37113-ARCH</subfield><subfield code=\"b\">ARCHIVES</subfield></datafield><datafield tag=\"090\" ind1=\" \" ind2=\" \"><subfield code=\"a\">MS 3429</subfield></datafield><datafield tag=\"100\" ind1=\"1\" ind2=\" \"><subfield code=\"a\">Cowdery, Oliver</subfield><subfield code=\"d\">1806-1850</subfield></datafield><datafield tag=\"245\" ind1=\"0\" ind2=\"0\"><subfield code=\"a\">Oliver Cowdery diary</subfield><subfield code=\"f\">1836 January-March.</subfield></datafield><datafield tag=\"506\" ind1=\"0\" ind2=\" \"><subfield code=\"a\">Open for research.</subfield></datafield><datafield tag=\"520\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Account of Cowdery's trip to Columbus, Ohio, to attend a political convention and his activities in Kirtland, including writing endeavors, attendance at Hebrew school, and events connected with dedication of the Kirtland Temple.</subfield></datafield><datafield tag=\"520\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Includes references to activities of Joseph Smith, Sidney Rigdon, Thomas B. Marsh, and other Church leaders and to Hebrew instructor Josiah Seixas. There is also information about organization of priesthood quorums. Cowdery also records instances of the gift of tongues and other spiritual manifestations.</subfield></datafield><datafield tag=\"520\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Volume was afterwards used to record Nauvoo High Council minutes, October 1839-December 1840. Council handled Church financial and land matters and adjudicated difficulties between Church members. Clerks were Henry G. Sherwood and Hosea Stout.</subfield></datafield><datafield tag=\"520\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Typescript copy of Cowdery diary entries is cataloged separately as MS 2737 box 85 folder 1.</subfield></datafield><datafield tag=\"583\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Cataloged</subfield><subfield code=\"c\">13-FEB-1978</subfield><subfield code=\"k\">Christy Best</subfield></datafield><datafield tag=\"583\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Cataloging revised</subfield><subfield code=\"c\">09-MAR-1998</subfield><subfield code=\"k\">Christy Best</subfield></datafield><datafield tag=\"583\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Digital copies added</subfield><subfield code=\"c\">19-JUL-2001</subfield><subfield code=\"k\">Clinton D. Christensen</subfield></datafield><datafield tag=\"590\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Pages 1-22 contain Cowdery's diary; pages 22-88 contain Nauvoo High Council minutes; remainder of volume is blank except verso page containing notation about stucco whitewash. Typescript made in 1984 from Cowdery diary is filed with volume; the typescript has not been filmed (original was filmed in 1971).</subfield></datafield><datafield tag=\"590\" ind1=\" \" ind2=\" \"><subfield code=\"a\">Deleted today MS 3429 ANALYTIC, which served no purpose not already served by MS 3429 bib record. Copy is in case file. (GII, 3-AUG-2004)</subfield></datafield><datafield tag=\"509\" ind1=\" \" ind2=\" \"><subfield code=\"f\">2</subfield><subfield code=\"b\">Some of Cowdery's entries briefly refer to disciplinary actions against some brethren and to unwise conduct by others; Nauvoo High Council minutes contain summations of charges and disciplinary actions---in most, brethren are reconciled; three are expelled from Church (one for land fraud, two for slander). None pertain to cases of immorality. Recommend access level 2, as Cowdery's witness and testimony of power of God in Kirtland Temple should be accessible. (CLB) Copyright has expired, but R.E. Turley has directed that this material be assigned access level 2 so that there is staff input into decisions about whether to make copies for patrons. (GII, 14-DEC-2005)</subfield><subfield code=\"j\">Access level approved by Review Committee, December 2, 2005.</subfield></datafield><datafield tag=\"600\" ind1=\"1\" ind2=\"4\"><subfield code=\"a\">Smith, Joseph</subfield><subfield code=\"d\">1805-1844</subfield></datafield><datafield tag=\"600\" ind1=\"1\" ind2=\"4\"><subfield code=\"a\">Rigdon, Sidney</subfield><subfield code=\"d\">1793-1876</subfield></datafield><datafield tag=\"600\" ind1=\"1\" ind2=\"4\"><subfield code=\"a\">Marsh, Thomas Baldwin</subfield><subfield code=\"d\">1799-1866</subfield></datafield><datafield tag=\"600\" ind1=\"1\" ind2=\"4\"><subfield code=\"a\">Seixas, Joshua</subfield><subfield code=\"d\">1802-1874</subfield></datafield><datafield tag=\"610\" ind1=\"2\" ind2=\"4\"><subfield code=\"a\">Kirtland Temple</subfield></datafield><datafield tag=\"650\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Hebrew language</subfield></datafield><datafield tag=\"650\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Priesthood</subfield></datafield><datafield tag=\"650\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Gift of tongues</subfield></datafield><datafield tag=\"650\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Spiritual manifestations</subfield></datafield><datafield tag=\"650\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Temples</subfield><subfield code=\"x\">Dedication services</subfield></datafield><datafield tag=\"655\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Journals</subfield></datafield><datafield tag=\"655\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Minutes</subfield></datafield><datafield tag=\"655\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Electronic records</subfield></datafield><datafield tag=\"656\" ind1=\" \" ind2=\"7\"><subfield code=\"a\">General Authorities</subfield></datafield><datafield tag=\"691\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Ohio</subfield><subfield code=\"b\">Lake</subfield><subfield code=\"c\">Kirtland.</subfield></datafield><datafield tag=\"691\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Ohio</subfield><subfield code=\"b\">Franklin</subfield><subfield code=\"c\">Columbus.</subfield></datafield><datafield tag=\"691\" ind1=\" \" ind2=\"4\"><subfield code=\"a\">Illinois</subfield><subfield code=\"b\">Hancock</subfield><subfield code=\"c\">Nauvoo.</subfield></datafield><datafield tag=\"700\" ind1=\"1\" ind2=\" \"><subfield code=\"a\">Stout, Hosea</subfield><subfield code=\"d\">1810-1889</subfield></datafield><datafield tag=\"700\" ind1=\"1\" ind2=\" \"><subfield code=\"a\">Sherwood, Henry Garlic</subfield><subfield code=\"d\">1785-1867</subfield></datafield><datafield tag=\"710\" ind1=\"2\" ind2=\" \"><subfield code=\"a\">Nauvoo High Council</subfield></datafield><datafield tag=\"905\" ind1=\" \" ind2=\" \"><subfield code=\"a\">COM</subfield><subfield code=\"d\">13-FEB-1978</subfield><subfield code=\"k\">CLB</subfield></datafield></record></zs:recordData><zs:recordPosition>1</zs:recordPosition></zs:record></zs:records></zs:searchRetrieveResponse>";
        String data =
                "<root>" +
                        "<Companyname>" +
                        "<Employee name=\"Girish\" Age=\"25\">Developer</Employee>" +
                        "</Companyname>" +
                        "<Companyname>" +
                        "<Employee name=\"Komal\" Age=\"25\">Administrator</Employee>" +
                        "</Companyname>" +
                        "</root>";
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(new ByteArrayInputStream(data.getBytes()));
        Element root = document.getRootElement();
        List row = root.getChildren("Companyname");
        for (int i = 0; i < row.size(); i++) {
            Element Companyname = (Element) row.get(i);

            List column = Companyname.getChildren("Employee");
            for (int j = 0; j < column.size(); j++) {
                Element Employee = (Element) column.get(j);
                String name = Employee.getAttribute("name").getValue();
                String value = Employee.getText();
                int length = Employee.getAttribute("Age").getIntValue();

                System.out.println("Name = " + name);
                System.out.println("Profile = " + value);
                System.out.println("Age = " + length);
            }
        }
    }
}
