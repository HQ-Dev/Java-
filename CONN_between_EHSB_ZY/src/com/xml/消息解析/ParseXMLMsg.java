package com.xml.消息解析;

 import javax.xml.parsers.DocumentBuilder;
 import javax.xml.parsers.DocumentBuilderFactory;
 import javax.xml.parsers.ParserConfigurationException;
 import javax.xml.transform.Source;
 import javax.xml.transform.TransformerConfigurationException;
 import javax.xml.transform.TransformerFactory;
 import javax.xml.transform.dom.DOMSource;
 import javax.xml.transform.stream.StreamResult;

 import com.ibm.disthub2.impl.matching.selector.Transformer;
 import org.dom4j.Element;
 import org.xml.sax.InputSource;
 import org.w3c.dom.Document;
 import org.w3c.dom.Node;
 import org.w3c.dom.NodeList;
 import org.xml.sax.SAXException;
 import org.xml.sax.SAXParseException;

 import java.io.*;

/**
 *  1. 由 XML 消息创建 DOM 对象
 * Created by Administrator on 2017/5/23 0023.
 */
public class ParseXMLMsg {

    private InputSource source;

    public static void main(String[] args) {

        // 文件路径
        File xmlFile = new File("D:\\my_projects\\Java-\\CONN_between_EHSB_ZY\\src\\com\\xml\\exampleToParse.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;

        // 解析 XML 消息，在内存中创建表示其数据结构的 DOM 对象
        Document doc = null;
        try {
            builder = builderFactory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Root element: "+doc.getDocumentElement().getNodeName());

        System.out.print(doc.getElementsByTagName("acceptAckCode").item(0).getAttributes().item(2));
//        System.out.print(nodeList);


//        try {
//            DocumentBuilder parser = null;
//            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
//            domFactory.setNamespaceAware(true);
//            domFactory.setValidating(false);
//            try {
//                parser = domFactory.newDocumentBuilder();
//            }
//            catch (ParserConfigurationException pce)
//            {
//                // 记录错误日志
//            }
//            parser.reset();
//            document = parser.parse(source);
//        }
//        catch (SAXParseException spe)
//        {
//            if (null != spe.getSystemId())
//            {
//                // if (logger.isDebugEnabled())
//                // {
//                // logger.debug("xpath解析错误，出错的行数是：" + spe.getLineNumber()
//                // + "，uri：" + spe.getSystemId());
//                // logger.debug(spe.getMessage());
//                // }
//            }
//            else
//            {
//                // if (logger.isDebugEnabled())
//                // {
//                // logger.debug(spe.getMessage());
//                // }
//            }
//        }
//        catch (SAXException se)
//        {
//            document = null;
//            // if (logger.isDebugEnabled())
//            // {
//            // logger.debug("解析XML错误，请确保存在格式正确的XML文档。");
//            // }
//        }
//        catch (IOException ioe)
//        {
//            document = null;
//            // if (logger.isDebugEnabled())
//            // {
//            // logger.debug("不能加载文档，文档不可读取。");
//            // }
//        }
//
//        // 由document取得controlActProcess节点作为根节点，业务数据通常包含在此节点下（请参考XML消息示例）
//        NodeList nodeList = document.getElementsByTagName("controlActProcess");
//        Element root = (Element) nodeList.item(0);
    }

}
