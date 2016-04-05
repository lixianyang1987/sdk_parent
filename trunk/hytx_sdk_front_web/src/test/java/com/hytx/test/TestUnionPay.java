package com.hytx.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class TestUnionPay {

	public static void main(String[] args) throws HttpException, IOException {
		testjsonSync();
	}

	public static void test() throws HttpException, IOException {
		String url = "http://localhost:8080/sdk_web/unipay/unipayBill";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		method.addParameter(new NameValuePair("orderId", "1234567"));
		client.executeMethod(method);
		String content = method.getResponseBodyAsString();
		System.out.println("charset:" + method.getResponseCharSet());
		System.out.println("content:" + content);

	}

	public static void testSync() throws HttpException, IOException {
		// String url = "http://115.29.201.88/sync/unionPay";
		String url = "http://localhost:8080/sdk_web/sync/unionPay";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		String jsonStr = "{\"orderId\":\"0001sdfsdfsdfsdf\"}";
		System.out.println(jsonStr);
		RequestEntity requestEntity = new StringRequestEntity(jsonStr,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);

		String content = method.getResponseBodyAsString();
		System.out.println("charset:" + method.getResponseCharSet());
		System.out.println("content:" + content);

	}

	public static void testjsonSync() throws HttpException, IOException {
		String url = "http://115.29.201.88/sync/zxjmbysms";
		//String url = "http://localhost:8080/sdk_web/sync/zxjmbysms";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		String jsonStr = "{\"tranid\":\"1211\",\"cost\":0,\"provider\":3,\"province\":\"北京\",\"mobile\":\"13401188123\",\"feecode\":\"dy2\",\"lnum\":\"1066100164\",\"paytime\":\"20160215134211\"}";
		System.out.println(jsonStr);
		RequestEntity requestEntity = new StringRequestEntity(jsonStr,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);

		String content = method.getResponseBodyAsString();
		System.out.println("charset:" + method.getResponseCharSet());
		System.out.println("content:" + content);

	}
}
