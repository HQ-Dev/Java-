package 基础语法.XML.parseXML;

import org.xml.sax.SAXException;
import 基础语法.XML.entity.Book;
import 基础语法.XML.parseXML.hander.SAXParserHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by lenovo-pc on 2017/5/30.
 */
public class SAXParse {

    public void doParse() {
        // 获取一个 SAXParserFactory 的实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            // 通过 factory 获得 SAXParser 实例
            SAXParser saxParser = factory.newSAXParser();
            // 创建 SAXParserHandler 对象
            SAXParserHandler handler = new SAXParserHandler();
            saxParser.parse("./src/基础语法/XML/books.xml", handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SAXParse parser = new SAXParse();
        parser.doParse();

    }

}
