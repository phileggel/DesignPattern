package com.phileagledev.parsexml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Created by Phil on 25/06/2014.
 */

public class CreateXML {

    public static void main(String[] args) {
        // writeXML();

        readXML();

    }

    private static void writeXML() {

        Document doc = new Document();

        Element theRoot = new Element("tvshows");

        doc.setRootElement(theRoot);

        Element show = new Element("show");
        Element name = new Element("name");
        name.setAttribute("show_id", "show_001");
        name.addContent(new Text("Life of Mars"));
        Element network = new Element("network");
        network.setAttribute("country", "US");
        network.addContent(new Text("ABC"));

        show.addContent(name);
        show.addContent(network);

        theRoot.addContent(show);

        Element show2 = new Element("show");
        Element name2 = new Element("name");
        name2.setAttribute("show_id", "show_002");
        name2.addContent(new Text("Life of Mars"));
        Element network2 = new Element("network");
        network2.setAttribute("country", "FR");
        network2.addContent(new Text("TF1"));

        show2.addContent(name2);
        show2.addContent(network2);

        theRoot.addContent(show2);

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlOutputter.output(doc, new FileOutputStream(new File("./xml_test/src/jdom_made.parsexml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("wrote to file");

    }

    private static void readXML() {

        SAXBuilder builder = new SAXBuilder();

        try {

            Document readDoc = builder.build(new File("./xml_test/src/jdom_made.parsexml"));

            System.out.println("Root : " + readDoc.getRootElement());
            System.out.println("Show : " + readDoc.getRootElement().getChild("show").getChildText("name"));
            System.out.println("Show : " + readDoc.getRootElement().getChild("show").getChild("name").getAttributeValue("show_id"));

            Element root = readDoc.getRootElement();
            for (Element curEle : root.getChildren("show")) {
                System.out.println("Show Name : " +
                    curEle.getChildText("name"));

                System.out.println("Show ID : " +
                        curEle.getChild("name").getAttributeValue("show_id"));

                System.out.print("On : " +
                        curEle.getChildText("network") + " in the ");

                System.out.println(curEle.getChild("network").getAttributeValue("country") + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }


    }

}

