package com.hytx.test;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.hytx.model.sync.OrderSync;
import com.hytx.util.JaxbUtil;

public class OrderSyncTest {

	public static void main(String[] args) throws HttpException, IOException,
			JAXBException {
		testSync();
		/*StringBuilder xmlStr = new StringBuilder();
		xmlStr.append(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
				.append("<SyncAppOrderReq>")
				.append("<TransactionID> b3d290936090407b914a9c8bf5093061</TransactionID>")
				.append("<Result>DELIVRD</Result>")
				.append("<ResultDesc></ResultDesc>")
				.append("<ActionTime>20130619144435</ActionTime>")
				.append("<UserID>11130619144434998192</UserID>")
				.append("<Mo></Mo>").append("<Dest></Dest>")
				.append("<Province></Province>").append("<AppID></AppID>")
				.append("<PayCode>1231231</PayCode>")
				.append("<Price>100</Price>")
				.append("<OrderID>23123123123545</OrderID>")
				.append("<CPParam>efefefsfsdf</CPParam>")
				.append("<Operator>3</Operator>").append("</SyncAppOrderReq>");
		OrderSync order = JaxbUtil.converyToJavaBean(xmlStr.toString(),
				OrderSync.class);
		System.out.println(order.getActionTime());*/
	}

	public static void test2() throws HttpException, IOException, JAXBException {
		StringBuilder xmlStr = new StringBuilder();
		xmlStr.append(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
				.append("<SyncAppOrderReq>")
				.append("<ID>12345</ID>")
				.append("<TransactionID>b3d290936090407b914a9c8bf5093061</TransactionID>")
				.append("<Result>DELIVRD</Result>")
				.append("<ResultDesc></ResultDesc>")
				.append("<ActionTime>20130619144435</ActionTime>")
				.append("<UserID>11130619144434998192</UserID>")
				.append("<Mo></Mo>").append("<Dest></Dest>")
				.append("<Province></Province>").append("<AppID></AppID>")
				.append("<PayCode>1231231</PayCode>")
				.append("<Price>100</Price>")
				.append("<OrderID>23123123123545</OrderID>")
				.append("<CPParam>efefefsfsdf</CPParam>")
				.append("<Operator>3</Operator>").append("</SyncAppOrderReq>");
		OrderSync orderSync = JaxbUtil.converyToJavaBean(xmlStr.toString(),
				OrderSync.class);
	}

	public static void testSync() throws HttpException, IOException {
		String url = "http://115.29.201.88/sync/orderSync.action";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		StringBuilder xmlStr = new StringBuilder();
		xmlStr.append(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
				.append("<SyncAppOrderReq>")
				.append("<TransactionID>b3d290936090407b914a9c8bf5093061</TransactionID>")
				.append("<Result>DELIVRD</Result>")
				.append("<ResultDesc>成功</ResultDesc>")
				.append("<ActionTime>20130619144435</ActionTime>")
				.append("<UserID>11130619144434998192</UserID>")
				.append("<Mo>106558110</Mo>").append("<Dest>10086</Dest>")
				.append("<Province>北京</Province>")
				.append("<AppID>111111</AppID>")
				.append("<PayCode>1231231</PayCode>")
				.append("<Price>100</Price>")
				.append("<OrderID>23123123123545</OrderID>")
				.append("<CPParam>efefefsfsdf</CPParam>")
				.append("<Operator>3</Operator>").append("<hRet>OK</hRet>")
				.append("</SyncAppOrderReq>");

		RequestEntity requestEntity = new StringRequestEntity(
				xmlStr.toString(), "application/xml", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);
		String content = method.getResponseBodyAsString();
		System.out.println("content:" + content);
	}

	/**
	 * xml转换成JavaBean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T converyToJavaBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
