//package com.xml;
//
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.ParserConfigurationException;
//
// import org.dom4j.Element;
// import org.xml.sax.InputSource;
// import org.w3c.dom.Document;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;
// import org.xml.sax.SAXException;
// import org.xml.sax.SAXParseException;
//
// import java.io.IOException;
// import java.io.StringReader;
//
///**
// * Created by Administrator on 2017/5/23 0023.
// */
//public class ParseXMLMsg {
//    // 部分需要导入的关键类：
//
//
//    // 取得由消息提供者得到的XML消息（字符串形式）
//    String xmlString = "";
//
//    // 创建一个InputSource读取XML数据
//    InputSource source = new InputSource(newBufferedReader(
//            new StringReader(xmlString)));
//
//// 需要设置字符编码为UTF-8
//    source.setEncoding("utf-8");
//
//    // 解析XML消息，在内存中创建表示其数据结构的DOM对象
//    Document document = null;
//try
//    {
//        DocumentBuilder parser = null;
//        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
//        domFactory.setNamespaceAware(true);
//        domFactory.setValidating(false);
//        try
//        {
//            parser = domFactory.newDocumentBuilder();
//        }
//        catch (ParserConfigurationException pce)
//        {
//// 记录错误日志
//        }
//        parser.reset();
//        document = parser.parse(source);
//    }
//catch (SAXParseException spe)
//    {
//        if (null != spe.getSystemId())
//        {
//// if (logger.isDebugEnabled())
//// {
//// logger.debug("xpath解析错误，出错的行数是：" + spe.getLineNumber()
//// + "，uri：" + spe.getSystemId());
//// logger.debug(spe.getMessage());
//// }
//        }
//        else
//        {
//// if (logger.isDebugEnabled())
//// {
//// logger.debug(spe.getMessage());
//// }
//        }
//    }
//catch (SAXException se)
//    {
//        document = null;
//// if (logger.isDebugEnabled())
//// {
//// logger.debug("解析XML错误，请确保存在格式正确的XML文档。");
//// }
//    }
//catch (IOException ioe)
//    {
//        document = null;
//// if (logger.isDebugEnabled())
//// {
//// logger.debug("不能加载文档，文档不可读取。");
//// }
//    }
//
//// 由document取得controlActProcess节点作为根节点，业务数据通常包含在此节点下（请参考XML消息示例）
//    NodeList nodeList = document.getElementsByTagName("controlActProcess");
//    Element root = (Element) nodeList.item(0);
//}
