package com.xml.消息封装;

 import javax.xml.xpath.XPath;
 import javax.xml.xpath.XPathConstants;
 import javax.xml.xpath.XPathExpression;
 import javax.xml.xpath.XPathExpressionException;
 import javax.xml.xpath.XPathFactory;
 import org.w3c.dom.Document;
 import org.w3c.dom.Node;
 import org.w3c.dom.NodeList;
 import org.w3c.dom.Element;

/**
 *  1. 取得 DOM 对象未做
 *  取得DOM对象
 *  在将业务数据封装成XML格式数据前，需要取得表示XML结构的DOM对象，DOM对象是生成XML消息的依据，可以用来创建，更新XML消息中包含的业务数据。
 *  DOM对象有两种来源，一种是接收消息时解析完毕后创建的，另一种是应用程序主动创建的。主动创建DOM的方法有多种，可根据各应用系统本身需求进行处理，本文不再单独描述。
 *  // import org.w3c.dom.Document
 *  // 取得DOM对象，赋值给document变量
 *  Document document;
 *  2.基于XPath的方式更新DOM中包含的业务数据
 *  @author Archy
 **/
public class UpdateDom {

    // 取得DOM对象，赋值给document变量
    Document document;

    // 取得业务数据，例如患者姓名
    String patientName ="李四";

    // 由document取得controlActProcess节点作为根节点，业务数据通常包含在此节点下（请参考XML消息示例）
    NodeList nodeList = document.getElementsByTagName("controlActProcess");
    Element root = (Element) nodeList.item(0);

    // 创建XPath实例
    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();

    // 设置命名空间
    // 因为MapNamespaceContext在应用程序范围内是不会变化的，最好在适当位置创建一次，在程序中复用
    //xpath.setNamespaceContext(new MapNamespaceContext());

    // 取得XPath表达式，注意每个节点名字前使用了在MapNamespaceContext中定义的命名空间前缀s
    // 取得患者姓名的XPath表达式如下所示
    // 请注意，XPath路径相对于controlActProcess节点，从subject节点开始
    String query = "s:subject/s:observationRequest/s:subject/s:patient/s:patientPerson/s:name/s:item/s:part/@value";

    // 编译XPath表达式

    XPathExpression expr = xpath.compile(query);
    public UpdateDom() throws XPathExpressionException {
        try {
            // 由root节点开始搜索目标结点，返回Node类型的数据
            result = (Node)expr.evaluate(root, XPathConstants.NODE);
            if (result == null) {
                // 节点取得失败，请检查程序逻辑或XPath语法是否正确
            }
        }
        catch (XPathExpressionException e){
            e.printStackTrace();
        }
        // 设置患者姓名
        result.setTextContent(patientName);
    }

    Node result = null;

}
