package com.phileagledev.parsexml; /**
 * Created by Phil on 24/06/2014.
 */

// Exemple d'utilisation XPath
// XPath permet de faire des requêtes sur le fichier XML

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.xpath.*;
import javax.xml.parsers.*;
import java.io.IOException;


public class XPathQuery {

    public static void main(String[] args) {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);

        DocumentBuilder builder;
        Document doc = null;

        try {
            builder = domFactory.newDocumentBuilder();
            doc = builder.parse("./xml_test/src/tvshows5.parsexml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xpath = XPathFactory.newInstance().newXPath();
        getNodeNameAndValue(doc, xpath);
    }

    private static void getNodeNameAndValue(Document doc, XPath xpath) {

        XPathExpression expression, expression2, expression3;
        Object result = null;
        Object result2 = null;
        Object result3 = null;

        try {

            expression = xpath.compile("//show/name//text()");
            result = expression.evaluate(doc, XPathConstants.NODESET);

            expression2 = xpath.compile("//show/name[@id_code='show_001']//text()");
            result2 = expression2.evaluate(doc, XPathConstants.NODESET);

            expression3 = xpath.compile("//show/actors/actor/*//text()");
            result3 = expression3.evaluate(doc, XPathConstants.NODESET);


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        NodeList nodes = (NodeList)result;
        for (int i = 0; i < nodes.getLength(); ++i) {
            System.out.println(nodes.item(i).getParentNode().getNodeName() + " " +
            nodes.item(i).getNodeValue());
        }

        System.out.println();

        nodes = (NodeList)result2;
        for (int i = 0; i < nodes.getLength(); ++i) {
            System.out.println(nodes.item(i).getParentNode().getNodeName() + " " +
                    nodes.item(i).getNodeValue());
        }

        System.out.println();

        nodes = (NodeList)result3;
        for (int i = 0; i < nodes.getLength(); ++i) {
            System.out.println(nodes.item(i).getParentNode().getNodeName() + " " +
                    nodes.item(i).getNodeValue());
        }

    }

}
