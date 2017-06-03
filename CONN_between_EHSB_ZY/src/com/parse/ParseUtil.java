package com.parse;

import com.xml.XML命名空间映射类.MapNamespaceContext;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/25 0025.
 */
public class ParseUtil {

    public static Document doc;
    public static DocumentBuilder builder;
    public static XPath path;

    public static final String TYPE_STRING = "STRING";
    public static final String TYPE_NODE = "NODE";
    public static final String TYPE_NODESET = "NODESET";
    public static final String TYPE_NUMBER = "NUMBER";
    public static final String TYPE_BOOLEAN = "BOOLEAN";

    static {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        XPathFactory xpfactory = XPathFactory.newInstance();
        path = xpfactory.newXPath();
        path.setNamespaceContext(new MapNamespaceContext());
    }

    public static void parseXMLFile(String queryText, File xmlFile) {


        try {
            doc = builder.parse(xmlFile);
            String typeName = ParseUtil.TYPE_STRING;
            QName returnType = (QName) XPathConstants.class.getField(typeName).get(null);
            String queryString = queryText;

            Object evalResult = path.evaluate(queryString, doc, returnType);
            System.out.print("" + evalResult);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File xmlFile = new File("D:\\my_projects\\Java-\\CONN_between_EHSB_ZY\\src\\com\\xml\\exampleToParse.xml");
        ParseUtil.parseXMLFile("s:subject/s:observationRequest/s:subject/s:patient/s:patientPerson/s:name/s:item/s:part/@value", xmlFile);
    }

}
