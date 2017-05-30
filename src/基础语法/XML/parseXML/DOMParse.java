package 基础语法.XML.parseXML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by lenovo-pc on 2017/5/30.
 */
public class DOMParse {

    public void main(String[] args) {
        // 创建一个 DocumentBuilderFactory 对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            // 创建一个 DocumentBuilder 对象
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 通过 builder 中的 parse(String fileName) 方法解析 xml 文件
            // 在解析 XML 或者 xsl 时使用绝对路径需要在文件前加上 file:\\
            Document document = builder.parse("./src/基础语法/XML/books.xml");  // 这次使用的是相对路径

            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有 " + bookList.getLength() + " 本书.");
            // 遍历每一个 book 节点
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("==================下面开始遍历第 " + (i + 1) + " 本书的内容==================");
                // 通过 item(i) 方法获取一个 book 节点
                Node book = bookList.item(i);
                // 获取 book 节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                System.out.println("第 " + (i+1) + " 本书共有 " + attrs.getLength() + " 个属性.");
                // 遍历 book 的属性
                for (int j = 0; j < attrs.getLength(); j++) {
                    // 通过 item(j) 方法获取 book 中的属性(要知道，其实属性也是一种节点)
                    Node attribute = attrs.item(j);
                    // 获取属性名
                    System.out.print("属性名：" + attribute.getNodeName());
                    // 获取属性值
                    System.out.println("--属性值：" + attribute.getNodeValue() );
                }
//                // 前提：已经知道 book 节点有且只有 1 个 id 属性
//                // 将 book 节点进行强制类型转换，转换为 Element 类型
//                Element bookElement = (Element) bookList.item(i);
//                String attrValue = bookElement.getAttribute("id");
//                System.out.println("id 属性值为 " + attrValue);

                // 解析 book 节点的子节点
                NodeList bookChildNodes = book.getChildNodes();
                System.out.println("第 " + (i + 1) + " 本书共有 " + bookChildNodes.getLength() + " 个子节点");
                for (int k = 0; k < bookChildNodes.getLength(); k++) {
//                    System.out.println(bookChildNodes.item(k).getNodeName());
                    // 区分 text 类型的 node 以及 element 类型的 node
                    if (bookChildNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        // 获取 element 类型节点的节点名
                        System.out.print("第 " + k + " 个节点是 " + bookChildNodes.item(k).getNodeName() + "；节点值为：");
                        // 获取 element 类型节点的节点值
//                        System.out.println(bookChildNodes.item(k).getFirstChild().getNodeValue()); // 其中一种方法
                        System.out.println(bookChildNodes.item(k).getTextContent());  // 其中一种方法
                    }
                }

                System.out.println("==================结束遍历第 " + (i + 1) + " 本书的内容==================");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
