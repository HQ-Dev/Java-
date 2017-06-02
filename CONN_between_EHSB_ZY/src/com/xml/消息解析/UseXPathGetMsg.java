package com.xml.消息解析;

 import com.xml.XML命名空间映射类.MapNamespaceContext;
 import org.dom4j.Node;
 import org.w3c.dom.Document;
 import org.xml.sax.InputSource;
 import org.xml.sax.SAXException;

 import javax.xml.parsers.DocumentBuilder;
 import javax.xml.parsers.DocumentBuilderFactory;
 import javax.xml.parsers.ParserConfigurationException;
 import javax.xml.xpath.XPath;
 import javax.xml.xpath.XPathConstants;
 import javax.xml.xpath.XPathExpression;
 import javax.xml.xpath.XPathExpressionException;
 import javax.xml.xpath.XPathFactory;
 import java.io.BufferedReader;
 import java.io.File;
 import java.io.IOException;
 import java.io.StringReader;

/**
 * 使用 XPath 取得业务数据
 * Created by Administrator on 2017/5/23 0023.
 */
public class UseXPathGetMsg {




    public static void main(String[] args) {
        // 创建XPath实例
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        // 设置命名空间
        // 因为MapNamespaceContext在应用程序范围内是不会变化的，最好在适当位置创建一次，在程序中复用
        xpath.setNamespaceContext(new MapNamespaceContext());
        // 取得XPath表达式，注意每个节点名字前使用了在MapNamespaceContext中定义的命名空间前缀s
        // 取得患者姓名的XPath表达式如下所示
        // 请注意，XPath路径相对于controlActProcess节点，从subject节点开始
        String query =
                "s:subject/s:observationRequest/s:subject/s:patient/s:patientPerson/s:name/s:item/s:part/@value";

        InputSource source = new InputSource(new BufferedReader(
                new StringReader(MyConstants.xmlString)));

        source.setEncoding("utf-8");

        File xmlFile = new File("D:\\my_projects\\Java-\\CONN_between_EHSB_ZY\\src\\com\\xml\\exampleToParse.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        // 解析 XML 消息，在内存中创建表示其数据结构的 DOM 对象
        Document doc = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            doc = builder.parse(xmlFile);
//            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getElementsByTagName("controlActProcess");

        // 编译表达式
        XPathExpression expr = null;
        try {
            expr = xpath.compile(query);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        Node result = null;
        try
        {
            // 由root节点开始搜索目标结点，返回Node类型的数据
            result = (Node)expr.evaluate(doc.getElementsByTagName("controlActProcess"), XPathConstants.NODE);
            System.out.print("");
            if (result == null)
            {
                // 节点取得失败，请检查程序逻辑或XPath语法是否正确
            }
        }
        catch (XPathExpressionException e)
        {
            e.printStackTrace();
        }

        // 从目标节点中取得数据，本例中是取得患者的姓名：张三
//        String value = result.getTextContent();
    }

}
