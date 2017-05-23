//package com.xml;
//
// import org.dom4j.Node;
//
// import javax.xml.xpath.XPath;
// import javax.xml.xpath.XPathConstants;
// import javax.xml.xpath.XPathExpression;
// import javax.xml.xpath.XPathExpressionException;
// import javax.xml.xpath.XPathFactory;
//
///**
// * Created by Administrator on 2017/5/23 0023.
// */
//public class UseXPathGetMsg {
//
//    // 部分需要导入的关键类：
//
//
//    // 创建XPath实例
//    XPathFactory factory = XPathFactory.newInstance();
//    XPath xpath = factory.newXPath();
//
//// 设置命名空间
//// 因为MapNamespaceContext在应用程序范围内是不会变化的，最好在适当位置创建一次，在程序中复用
//xpath.setNamespaceContext(newMapNamespaceContext());
//
//    // 取得XPath表达式，注意每个节点名字前使用了在MapNamespaceContext中定义的命名空间前缀s
//// 取得患者姓名的XPath表达式如下所示
//// 请注意，XPath路径相对于controlActProcess节点，从subject节点开始
//    String query =
//            "s:subject/s:observationRequest/s:subject/s:patient/s:patientPerson/s:name/s:item/s:part/@value"
//
//// 编译表达式
//    XPathExpression expr = xpath.compile(query);
//    Node result = null;
//try
//    {
//// 由root节点开始搜索目标结点，返回Node类型的数据
//        result = (Node)expr.evaluate(root, XPathConstants.NODE);
//        if (result == null)
//        {
//// 节点取得失败，请检查程序逻辑或XPath语法是否正确
//        }
//    }
//catch (XPathExpressionException e)
//    {
//        e.printStackTrace();
//    }
//
//    // 从目标节点中取得数据，本例中是取得患者的姓名：张三
//    String value = result.getTextContent();
//}
