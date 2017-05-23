package 基础语法.XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author Archy
 **/
public class XML_Test {


    public static void main(String[] args) throws ParserConfigurationException {
        // To read an XML document, you need a DocumentBuilder object that you get from a DocumentBuilderFactory like this:
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();


    }
}
