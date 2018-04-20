package com.sree;
/*
Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure and returns all folder names that start with startingLetter. The XML format is given in the example below.

For example, for the letter 'u' and an XML file:

<?xml version="1.0" encoding="UTF-8"?>
<folder name="c">
    <folder name="program files">
        <folder name="uninstall information" />
    </folder>
    <folder name="users" />
</folder>

the function should return a collection with items "uninstall information" and "users" (in any order).

 */
import java.util.Collection;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
import java.util.regex.*;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        List folderNames = new ArrayList<String>();
        InputSource inputSource = new InputSource(new StringReader(xml));
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource);
        NodeList nodeList = doc.getElementsByTagName("folder");
        String pattern = "^" + startingLetter + ".*";

        for (int i=0; i<nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            String folderName = element.getAttribute("name");
            if (folderName.matches(pattern)) {
                folderNames.add(folderName);
            }
        }
        return folderNames;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}