package coreJava.XML.StreamingParsers;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * <p>类似一个网络爬虫程序.The program prints all hyperlinks of an XHTML web page.</p>
 * Created by lenovo-pc on 2017/5/30.
 */
public class SAXTest {
    public static void main(String[] args) {
        String url;
        if (args.length == 0) {
            url = "http://www.w3c.org";
//            url = "https://www.baidu.com";
            System.out.println("Using " + url);
        }
        else url = args[0];

        /**
         *  defines a handler that overrides the startElement method of the ContentHandler interface
         *  to watch out for a elements with an href attributes.
         */
        DefaultHandler handler = new DefaultHandler()
        {
            public void startElement(String namespaceURI, String lname, String qname, Attributes attrs) {
                if (lname.equals("a") && attrs != null) {
                    for (int i = 0; i < attrs.getLength(); i++) {
                        String aname = attrs.getLocalName(i);
                        if (aname.equals("href")) System.out.println(attrs.getValue(i));
                    }
                }
            }
        };

        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            // if you don't need to validate the document
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            SAXParser saxParser = factory.newSAXParser();
            InputStream in = new URL(url).openStream();
            saxParser.parse(in, handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
