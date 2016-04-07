package com.hytx;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class Test {
	private long a = 1234567891234567L;

	public static void main(String[] args) throws HttpException, IOException {
		String url = "http://localhost:8080/hytx_sdk_front_web/sms/reqSms.action";
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		String uuidStr = UUID.randomUUID().toString();
		RequestEntity requestEntity = new StringRequestEntity(
				"{\"sign\":\""
						+ uuidStr
						+ "\",\"sdkVersion\":\"0.1.1\",\"imsi\":\"dfgdfg\",\"payCode\":\"5464342\",\"appId\":\"555555\",\"channelId\":\"7987946\",\"channelKey\":\"05sdfd\",\"appKey\":\"kkkkkkk\",\"orderId\":\""
						+ uuidStr
						+ "\",\"feeValue\":\"100\",\"feeType\":\"1\"}",
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);
		String content = method.getResponseBodyAsString();
		System.out.println("content:" + content);
	}
}
