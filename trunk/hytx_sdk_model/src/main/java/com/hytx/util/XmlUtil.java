package com.hytx.util;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {
	@SuppressWarnings("unchecked")
	public static Map<String,String> disXML_3(Element element) {
		Iterator iterator = element.elementIterator();
		List list = null;
		while (iterator.hasNext()) {
			Element node = (Element) iterator.next();
			list = node.elements();
			if (list != null && list.size() > 0) {
				System.out.print(node.getName());
				int count = node.attributeCount();
				for (int i = 0; i < count; i++) {
					Attribute attr = node.attribute(i);
					System.out.println("*****" + attr.getName() + "=" + attr.getText());
				}
				disXML_3(node);
			} else {
				System.out.println(node.getName() + " " + node.getText());
			}
		}
		return null;
	}
	

	public Document readXML() {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new File("D:/workspace4/resources/diagrams/leave/leave.bpmn"));
//			document = saxReader.read(new File("D:/workspace4/Test2/src/xml/test.xml"));
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}
	public static Map<String,String> getProcessInfo(InputStream inputStream) {
		Document document = null;
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(inputStream);
//			document = saxReader.read(new File("D:/workspace4/Test2/src/xml/test.xml"));
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		return disXML_3(root);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
