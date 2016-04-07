package com.hytx.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.hytx.dto.xzf.WxPayReqDto;
import com.hytx.util.JaxbUtil;

public class WecharPayTest {

	public static void main(String[] args) throws HttpException, IOException {
		test();
	}

	public static void test() throws HttpException, IOException {
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("User-Agent", "GT-I8552,16,4.1.2,delos3gchn");
		WxPayReqDto pay = new WxPayReqDto("10", "123", "测试");
		String xmlStr = JaxbUtil.convertToXml(pay);
		System.out.println(xmlStr);
		RequestEntity requestEntity = new StringRequestEntity(xmlStr,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);
		String content = method.getResponseBodyAsString();
		System.out.println("charset:" + method.getResponseCharSet());
		System.out.println("content:" + content);

	}

}
