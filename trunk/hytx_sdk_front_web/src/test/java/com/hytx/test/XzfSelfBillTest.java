package com.hytx.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.hytx.Json.JsonXzfYijieLogin;
import com.hytx.util.JsonMapper;

public class XzfSelfBillTest {

	public static void main(String[] args) throws HttpException, IOException {
		test();
	}

	public static void test() throws HttpException, IOException {
		JsonXzfYijieLogin model = new JsonXzfYijieLogin();
		model.setChannelAppKey("tm0r75");
		model.setImei("123456789abcdfe");
		model.setImsi("123456789abcdfe");
		model.setSdkVersion("1.0");
		model.setUin("0001");
		model.setSess("123456");
		model.setSign(model
				.getColculateSign("c8acbba8-6a6f-4210-9b0c-5d59aa4c2241"));
		String content = JsonMapper.toNormalJson(model);
		String url = "http://115.29.201.88/xzf/yijie/login";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("User-Agent", "GT-I8552,16,4.1.2,delos3gchn");
		System.out.println(content);
		RequestEntity requestEntity = new StringRequestEntity(content,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);
		String responseBody = method.getResponseBodyAsString();
		System.out.println("charset:" + method.getResponseCharSet());
		System.out.println("responseBody:" + responseBody);

	}

}
