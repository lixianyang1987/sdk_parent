package com.hytx.util;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {
	private static Logger log = LoggerFactory.getLogger(HttpClientUtil.class);

	public static String simpleVisitUrl(String url) throws HttpException,
			IOException {
		
		url = url.replace("#","%23");
		log.info("开始访问网络：{}", url);
		
		
		HttpClient client = new HttpClient();
		//client.getParams().setUriCharset("UTF-8");		
		client.getParams().setContentCharset("UTF-8");
		HttpConnectionManagerParams params = client.getHttpConnectionManager()
				.getParams();
		params.setConnectionTimeout(4000);
		params.setSoTimeout(12000);
		GetMethod method = new GetMethod(url);
		int status = client.executeMethod(method);
		log.info("访问网络状态为{}", status);

		if (status == 200) {
			String content = method.getResponseBodyAsString();
			log.info("访问网络返回数据为{}", content);
			return content;
		}
		return null;
	}

	/***
	 * 以post方式提交json数据,并返回json数据
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @author houzz
	 * @date 2015年10月26日
	 */
	public static String postJsonData(String url, String data)
			throws HttpException, IOException {
		log.info("开始访问网络：{}", url);
		log.info("请求参数：{}", data);
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		HttpConnectionManagerParams params = client.getHttpConnectionManager()
				.getParams();
		params.setConnectionTimeout(2000);
		params.setSoTimeout(10000);
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("Accept", "application/json;charset=UTF-8");
		method.addRequestHeader("Content-Type", "application/json");
		method.setRequestEntity(new StringRequestEntity(data,
				"application/json", "UTF-8"));
		int status = client.executeMethod(method);
		log.info("访问网络状态为{}", status);
		if (status == 200) {
			String content = method.getResponseBodyAsString();
			log.info("访问网络返回数据为{}", content);
			return content;
		}
		return null;
	}

	/***
	 * 
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @author houzz
	 * @date 2015年10月26日
	 */
	public static String postXmlData(String url, String data)
			throws HttpException, IOException {
		log.info("开始访问网络：{}", url);
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		HttpConnectionManagerParams params = client.getHttpConnectionManager()
				.getParams();
		params.setConnectionTimeout(2000);
		params.setSoTimeout(10000);
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("Content-Type", "application/xml");
		method.setRequestEntity(new StringRequestEntity(data,
				"application/xml", "UTF-8"));
		int status = client.executeMethod(method);
		log.info("访问网络状态为{}", status);
		if (status == 200) {
			String content = method.getResponseBodyAsString();
			log.info("访问网络返回数据为{}", content);
			return content;
		}
		return null;
	}

	/***
	 * 
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @author houzz
	 * @date 2015年10月26日
	 */
	public static String postData(String url, NameValuePair[] nameValuePairs)
			throws HttpException, IOException {
		log.info("开始访问网络：{}", url);
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		HttpConnectionManagerParams params = client.getHttpConnectionManager()
				.getParams();
		params.setConnectionTimeout(2000);
		params.setSoTimeout(10000);
		PostMethod method = new PostMethod(url);
		method.setRequestBody(nameValuePairs);
		int status = client.executeMethod(method);
		log.info("访问网络状态为{}", status);
		if (status == 200) {
			String content = method.getResponseBodyAsString();
			log.info("访问网络返回数据为{}", content);
			return content;
		}
		return null;
	}

}
