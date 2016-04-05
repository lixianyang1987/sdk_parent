package com.hytx.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLBeanUtil {

	public static Object  xml2Bean(String xml,Object obj) throws Exception{
	        JAXBContext context = JAXBContext.newInstance(obj.getClass());
	        Unmarshaller um =context.createUnmarshaller();
	        StringReader sr = new StringReader(xml);
	        return um.unmarshal(sr);

	}
	public static String bean2XML(Object obj) throws Exception {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller m = context.createMarshaller();
        StringWriter sw = new StringWriter();
        m.marshal(obj,sw);
        return sw.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
