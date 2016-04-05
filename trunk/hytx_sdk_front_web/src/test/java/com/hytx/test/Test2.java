package com.hytx.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.hytx.Json.JsonXzfUserInfo;
import com.hytx.util.JsonMapper;
import com.hytx.util.MD5;

public class Test2 {
	public static void main(String[] args) throws HttpException, IOException {
		String s = "1.0|tm0r75|460036000029095|99000643090245|张三|130182198212153590|145207147496799000643090245|c8acbba8-6a6f-4210-9b0c-5d59aa4c2241";
		System.out.println(MD5.getMD5(s));
		test();
	}

	public static void test() throws HttpException, IOException {
		JsonXzfUserInfo user = new JsonXzfUserInfo();
		user.setChannelAppKey("tm0r75");
		user.setIdCard("130182198212153590");
		user.setImei("99000643090245");
		user.setImsi("460036000029095");
		user.setSdkVersion("1.0");
		user.setName("张三");
		user.setOrderId("145207147496799000643090245");
		user.setSign(user
				.getColculateSign("c8acbba8-6a6f-4210-9b0c-5d59aa4c2241"));

		String url = "http://115.29.201.88/xzf/validUser";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		String jsonStr = JsonMapper.toNonEmptyJson(user);
		method.setRequestHeader("Content-Type",
				"application/json;charset=utf-8");
		System.out.println(jsonStr);
		RequestEntity requestEntity = new StringRequestEntity(jsonStr,
				"application/json;charset=utf-8", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);
		String content = method.getResponseBodyAsString();
		System.out.println("content:" + content);
	}

}
