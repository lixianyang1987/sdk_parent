package com.hytx.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class TestCodePay {
	public static void main(String[] args) throws HttpException, IOException {
		testjsonSync();
	}



	public static void testjsonSync() throws HttpException, IOException {
		String url = "http://115.29.201.88/sync/yjspwosd";
		//String url = "http://localhost:8080/sdk_web/sync/zxjmbysms";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		String jsonStr = "{\"cpparam\":\"A000000000001\",\"cpfee\":\"cpfee1000\",\"status\":\"0\"}";
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
