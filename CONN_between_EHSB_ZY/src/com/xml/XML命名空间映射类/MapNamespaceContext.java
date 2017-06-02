package com.xml.XML命名空间映射类;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/**
 * 命名空间映射类主要用于定义XML命名空间及其前缀的映射关系，应用XPath时会使用到。
 *
 * @author Archy
 **/
public class MapNamespaceContext implements NamespaceContext
{
    private Map<String, String> pairs;

    public MapNamespaceContext()
    {
        pairs = new HashMap<String, String>();
        pairs.put(XMLConstants.XML_NS_PREFIX, XMLConstants.XML_NS_URI);
        // 为HL7V3消息的命名空间定义前缀s，应用XPath时会使用到
        pairs.put("s", "urn:hl7-org:v3");
    }

    @Override
    public String getNamespaceURI(String prefix)
    {
        return pairs.get(prefix);
    }

    @Override
    public String getPrefix(String namespaceURI)
    {
        throw new UnsupportedOperationException("getPrefix");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Iterator getPrefixes(String namespaceURI)
    {
        throw new UnsupportedOperationException("getPrefixs");
    }
}
