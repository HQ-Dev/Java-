package com.xml;

 import java.io.StringWriter;
 import java.io.Writer;
 import javax.xml.transform.OutputKeys;
 import javax.xml.transform.Result;
 import javax.xml.transform.Transformer;
 import javax.xml.transform.TransformerFactory;
 import javax.xml.transform.dom.DOMSource;
 import javax.xml.transform.stream.StreamResult;

/**
 * 生成XML消息
 * @author Archy
 **/
public class GenerateXMLMsg {


    // 创建StringWriter
//    Writer writer = new StringWriter();
//
//    // 创建转换器
//    Transformer transformer = TransformerFactory.newInstance().newTransformer();
//    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//
//    // 转换DOM对象到XML消息（字符串形式）
//    DOMSource src = new DOMSource(document);
//    Result output = new StreamResult(writer);
//    transformer.transform(src, output);
//    String msgText = writer.toString();
}
