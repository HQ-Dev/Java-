package 基础语法.XML.parseXML.hander;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Archy
 **/
public class SAXParserHandler extends DefaultHandler {

    private int bookId = 0;
    /**
     *  用来遍历 XML 文件的开始标签
     * @param uri
     * @param localName
     * @param qName 元素节点名
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        // 开始解析 book 元素的属性
        if (qName.equals("book")) {
            bookId++;
            System.out.println("==================下面开始遍历第 " + bookId + " 本书的内容==================");
//            // 已知 book 元素下的属性名称，根据属性名称获取属性值
//            String value = attributes.getValue("id");
//            System.out.println(value);
            // 不知道 book 元素下属性的名称以及个数，如何获取属性名以及属性值
            int num = attributes.getLength();
            for (int i = 0; i < num; i++) {
                System.out.print("book 元素的第 " + (i+1) + "个属性名是：" + attributes.getQName(i));
                System.out.println("---属性值是：" + attributes.getValue(i));
            }
        } else if (!qName.equals("book") && !qName.equals("bookstore")) {
            System.out.print("节点名：" + qName + ".    ");
        }
    }

    /**
     *  用来遍历 XML 文件的结束标签
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("book")) {
            System.out.println("==================结束遍历第 " + bookId + " 本书的内容==================");
        }
    }

    /**
     *
     * @param ch 表示整个解析文件的字符内容（可放开注释查看效果）
     * @param start startElement 方法会记录走到的那个元素标签显示内容的起点位置为 start
     * @param length endElement 方法会记录走完元素标签其中内容的长度为 length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
//        System.out.println(ch);
        String value = new String(ch,start,length);
        // 防止空格节点的输出
        if (!value.trim().equals("")) {
            System.out.println("节点值：" + value);
        }
    }

    /**
     * 用来标识解析开始
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX 解析开始！");
    }

    /**
     * 用来标志解析结束
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX 解析结束！");
    }
}
