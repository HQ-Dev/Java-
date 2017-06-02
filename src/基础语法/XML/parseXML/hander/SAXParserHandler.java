package 基础语法.XML.parseXML.hander;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by lenovo-pc on 2017/5/30.
 */
public class SAXParserHandler extends DefaultHandler {

    /**
     *  用来遍历 XML 文件的开始标签
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        // 开始解析 book 元素的属性
        if (qName.equals("book")) {
//            // 已知 book 元素下的属性名称，根据属性名称获取属性值
//            String value = attributes.getValue("id");
//            System.out.println(value);
            // 不知道 book 元素下属性的名称以及个数，如何获取属性名以及属性值
            int num = attributes.getLength();
            for (int i = 0; i < num; i++) {
                System.out.print("book 元素的第 " + (i+1) + "个属性名是：" + attributes.getQName(i));
                System.out.println("---属性值是：" + attributes.getValue(i));
            }
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
