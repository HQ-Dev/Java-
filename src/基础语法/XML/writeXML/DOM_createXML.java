package 基础语法.XML.writeXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by lenovo-pc on 2017/5/30.
 */
public class DOM_createXML {

    public static DocumentBuilder getDocumentBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * 生成 XML
     */
    public void createXML() {
        DocumentBuilder builder = getDocumentBuilder();
        Document document = builder.newDocument();
        Element bookstore = document.createElement("bookstore");
        // 将 book 节点添加到 root 节点中
        Element book = document.createElement("book");
        Element name = document.createElement("name");
        name.setTextContent("冰与火之歌");
        Element author = document.createElement("author");
        author.setTextContent("乔治马丁");
        Element year = document.createElement("year");
        year.setTextContent("2014");
        Element price = document.createElement("price");
        price.setTextContent("89");
        book.appendChild(name);
        book.appendChild(author);
        book.appendChild(year);
        book.appendChild(price);
        // 为 book 节点添加属性
        book.setAttribute("id", "1");
        bookstore.appendChild(book);
        document.appendChild(bookstore);

        //  将 DOM 文件转换为 XML 文件
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");// 这段代码可以让输出的 XML 换行
            transformer.transform(new DOMSource(document), new StreamResult(new File("./src/基础语法/XML/books1.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DOM_createXML createXML = new DOM_createXML();
        createXML.createXML();
    }
}
