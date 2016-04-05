package com.hytx.test;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.hytx.Json.JsonReqCheckState;
import com.hytx.Json.JsonReqSms;
import com.hytx.Json.JsonReqSmsCheck;
import com.hytx.Json.JsonSyncSmsResult;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.JsonMapper;

public class Test {
	// private static String uuidStr = "b2b6df6f-23bd-4eb7-9ffb-5abf2d6b6ab2";
	private static String uuidStr = UUID.randomUUID().toString();

	public static void main(String[] args) throws HttpException, IOException {
		String uid = URLEncoder.encode("{4ff036a1-3254eafe}", "utf-8");
		String url = "http://sync.1sdk.cn/login/check.html?sdk=B101363CA00933D2&app=28BCD14771D67E2C&uin="
				+ uid + "&sess=selfServer1452680676882";
		String content = HttpClientUtil.simpleVisitUrl(url);
		if (content != null) {
			System.out.println(content);
		}
		// test();
	}

	public static void testSyncResult() throws HttpException, IOException {
		String url = "http://115.29.201.88/client/syncSmsResult.action";
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);

		JsonSyncSmsResult reqSmsResult = new JsonSyncSmsResult();
		reqSmsResult.getCommandIdList().add(292L);
		reqSmsResult.getStatusList().add(1);
		reqSmsResult.setOrderDt(new Date());
		reqSmsResult.setImsi("460036110430752");
		reqSmsResult.setSdkVersion("4.0.0");
		reqSmsResult.setChannelAppKey("t60d02");
		reqSmsResult.setExtraInfo("ex=abc");
		reqSmsResult.setSign(reqSmsResult
				.getColculateSign("d52dc1fe-9c11-4a47-930f-bcd48aba3e58"));
		String jsonStr = JsonMapper.toNonEmptyJson(reqSmsResult);
		System.out.println(jsonStr);
		RequestEntity requestEntity = new StringRequestEntity(jsonStr,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);
		String content = method.getResponseBodyAsString();
		System.out.println("content:" + content);
	}

	public static void test() throws HttpException, IOException {
		/*String channelAppKey = "e90uc2";
		String key = "1e32b514-a40b-4d1a-84e0-dd1f59bf31d2";
		String url = "http://115.29.201.88/client/reqSms.action";*/

		String channelAppKey = "050uk1";
		String key = "b2b6df6f-23bd-4eb7-9ffb-5abf2d6b689b";
		String url = "http://localhost:8080/sdk_web/client/reqSms.action";

		/*String channelAppKey = "vb0in2";
		String key = "550dc94e-c276-4a57-9677-56e8371dc6b7";
		String url = "http://115.29.201.88/client/reqSms.action";*/

		Integer feeValue = 200;
		String uuidStr = UUID.randomUUID().toString();
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("User-Agent", "GT-I8552,16,4.1.2,delos3gchn");
		JsonReqSms reqSms = new JsonReqSms();
		reqSms.setChannelAppKey(channelAppKey);
		reqSms.setFeeType(1);
		reqSms.setFeeValue(feeValue);
		reqSms.setImei("864855025689160");
		// reqSms.setImsi("460025011148160");// 移动
		// reqSms.setIccid("898602A00115F0011891");// 移动
		// reqSms.setImsi("460027930647199");// 电信
		// reqSms.setIccid("898602A00115F0011891");// 电信
		reqSms.setImsi("460011144909553");// 联通
		reqSms.setIccid("89860115851017411181");// 联通
		reqSms.setOrderId(uuidStr);
		reqSms.setPayCode("123");
		reqSms.setSdkVersion("1.1.0");
		reqSms.setProvince("北京");
		// reqSms.setOrderDt("2015-05-13 18:29:10");
		reqSms.setSign(reqSms.getColculateSign(key));

		String jsonStr = JsonMapper.toNonEmptyJson(reqSms);
		System.out.println(jsonStr);
		RequestEntity requestEntity = new StringRequestEntity(jsonStr,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		// client.executeMethod(method);

		// String content = method.getResponseBodyAsString();
		// System.out.println("charset:" + method.getResponseCharSet());
		// System.out.println("content:" + content);

	}

	public static void testAutoSms() throws HttpException, IOException {
		/*String channelAppKey = "t60d02";
		String key = "d52dc1fe-9c11-4a47-930f-bcd48aba3e58";
		String url = "http://115.29.201.88/client/reqSmsCheck.action";*/
		String channelAppKey = "050uk1";
		String key = "b2b6df6f-23bd-4eb7-9ffb-5abf2d6b689b";
		String url = "http://localhost:8080/sdk_web/client/reqSmsCheck.action";

		String uuidStr = UUID.randomUUID().toString();
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		JsonReqSmsCheck reqSmsCheck = new JsonReqSmsCheck();
		reqSmsCheck.setChannelAppKey(channelAppKey);
		reqSmsCheck.setImsi("460035011148840");// 电信
		reqSmsCheck.setIccid("898603A00115F0011890");// 电信
		reqSmsCheck.setSdkVersion("1.0.0");
		// reqSms.setOrderDt("2015-05-13 18:29:10");
		reqSmsCheck.setSign(reqSmsCheck.getColculateSign(key));

		String jsonStr = JsonMapper.toNonEmptyJson(reqSmsCheck);
		System.out.println(jsonStr);
		RequestEntity requestEntity = new StringRequestEntity(jsonStr,
				"application/json", "utf-8");
		method.setRequestEntity(requestEntity);
		client.executeMethod(method);

		String content = method.getResponseBodyAsString();
		System.out.println("charset:" + method.getResponseCharSet());
		System.out.println("content:" + content);

	}

	public static void testCheckState() throws HttpException, IOException {
		/*String channelAppKey = "t60d02";
		String key = "d52dc1fe-9c11-4a47-930f-bcd48aba3e58";
		String url = "http://115.29.201.88/client/checkState.action";
		*/
		String channelAppKey = "050uk1";
		String key = "b2b6df6f-23bd-4eb7-9ffb-5abf2d6b689b";
		String url = "http://localhost:8080/sdk_web/client/checkState.action";

		String uuidStr = UUID.randomUUID().toString();
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(url);
		JsonReqCheckState reqCheckState = new JsonReqCheckState();
		reqCheckState.setChannelAppKey(channelAppKey);
		reqCheckState.setImsi("460025011148842");
		reqCheckState.setIccid("898602A00115F0011892");
		reqCheckState.setSdkVersion("4.0.0");
		// reqSms.setOrderDt("2015-05-13 18:29:10");
		reqCheckState.setSign(reqCheckState.getColculateSign(key));

		String jsonStr = JsonMapper.toNonEmptyJson(reqCheckState);
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
