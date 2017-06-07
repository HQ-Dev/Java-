package 基础语法.XML.parseXML;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.List;

/**
 * @author Archy
 **/
public class JDomParse {

    public static void main(String[] args) {

        // 对 xml 文件进行 JDom 解析
        // 1. 创建一个 SaxBuilder 对象
        SAXBuilder saxBuilder = new SAXBuilder();
        // 2. 创建一个输入流，将 xml 文件加载到输入流中
        try {
            InputStream in = new FileInputStream("./src/基础语法/XML/books.xml");
            // 将输入流的字符集设置为 UTF-8
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            // 3. 通过 SaxBuilder 的 builder 方法，将输入流加载到 saxBuilder 对象中
            Document document = saxBuilder.build(isr);
            // 4. 通过 document 对象获取 xml 文件的根节点
            Element rootElement = document.getRootElement();
            // 5. 获取根节点下的子节点的 List 结合
            List<Element> bookList = rootElement.getChildren();
            // 继续进行解析
            for (Element book : bookList) {
                System.out.println("==========开始解析第 " + (bookList.indexOf(book) + 1) + " 本书=========");
                // 解析 book 的属性
                List<Attribute> attributes = book.getAttributes();
                for (Attribute attribute : attributes) {
                    // 获取属性名
                    String attrName = attribute.getName();
                    // 获取属性值
                    String attrValue = attribute.getValue();
                    System.out.println("属性名: " + attrName + "----- 属性值：" + attrValue);
                }
                // 对 book 节点下的子节点的 name 和 value 进行遍历
                List<Element> bookChildren = book.getChildren();
                for (Element child : bookChildren) {
                    System.out.println("节点名： " + child.getName() + " ---- 节点值：" + child.getValue());
                }
                System.out.println("==========结束解析第 " + (bookList.indexOf(book) + 1) + " 本书=========");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
