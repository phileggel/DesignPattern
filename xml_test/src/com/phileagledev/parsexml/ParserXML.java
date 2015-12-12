package com.phileagledev.parsexml; /**
 * Created by Phil on 24/06/2014.
 */

// Parser XML (SAX)

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ParserXML {

    public static void main(String[] args) {

        Document xmlDoc = getDocument("./xml_test/src/tvshows5.parsexml");
        System.out.println("Root: " + xmlDoc.getDocumentElement().getNodeName());

        NodeList listOfShows = xmlDoc.getElementsByTagName("show");
        System.out.println("Number of shows " + listOfShows.getLength());

        String elementName = "network";
        String attrName = "country";

        getElementAndAttrib(listOfShows, elementName, attrName);

    }

    private static Document getDocument(String docString) {

        try {

            // permet de récupérer le convertir le document sous forme de tree

            // 1. Création du ParserFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // 2. Paramétrage du ParserFactory
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            // factory.setValidating(true); --> génère des erreurs de lectures (problème DTD)

            //3. création du parser
            DocumentBuilder builder = factory.newDocumentBuilder();

            //4. parsing
            return builder.parse(new InputSource(docString));

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    private static void getElementAndAttrib(NodeList listOfShows, String elementName, String attrName) {

        try {

            for (int i = 0; i < listOfShows.getLength(); ++i) {

                Node showNode = listOfShows.item(i);
                Element showElement = (Element)showNode;

                NodeList networkList = showElement.getElementsByTagName(elementName);
                Element networkElement = (Element)networkList.item(0);

                NodeList elementList = networkElement.getChildNodes();

                if (networkElement.hasAttribute(attrName)) {
                    System.out.println(elementName + " : " + ((Node)elementList.item(0)).getNodeValue().trim() +
                    " has attribute " + networkElement.getAttribute(attrName));
                } else {
                    System.out.println(elementName + " : " + ((Node)elementList.item(0)).getNodeValue().trim());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
