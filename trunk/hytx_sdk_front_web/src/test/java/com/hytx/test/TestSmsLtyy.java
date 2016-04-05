package com.hytx.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.hytx.util.HttpClientUtil;

/****
 * http://s.smilegames.cn:88/Sms/GetVerifyCode?order_id=20151022162310&
 * channel_id=c100032&product_id=p10103&price=800
 * &imsi=460026012242669&imei=99000522803663
 * &phone=18201045684&timestamp=20151022153810&version=200
 * 
 * 
 * 460019834098880 864783023234905 13049814583
 * 
 * @author houzz
 *
 */
public class TestSmsLtyy {

	public static void main(String[] args) throws HttpException, IOException {
		//testGet();
		testGetVerifyCode();
		//testSendVerifyCode("704715");
	}

	public static void testGet() throws HttpException,IOException  {
		String timestamp = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
		//String urlPre = "http://115.29.201.88/sync/lad";
		String urlPre="http://localhost:8080/sdk_web/sync/ldddwojfee";
		
		String url = urlPre
				+ "?linkid=xxxxxxx1&mobile=13800138000&port=1065553610007&msg=ZQXX_200&status=DELIVRD&cpparam=0247123456789012";

		
		try {
			System.out.println(HttpClientUtil.simpleVisitUrl(url));
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetVerifyCode() {
		String timestamp = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
		//String url = "http://115.29.201.88/sms/ltyy/getVerifyCode?order_id=11000000000033&price=800&imsi=460019834098880&imei=864783023234905&phone=13049814583&timestamp="+ timestamp;
		//String url = "http://localhost:8080/sdk_web/sync/ldddwojreq?money=2&imsi=460026015049346&cpparam=0247123456001";
		String url = "http://115.29.201.88/sync/ldddwojreq?money=4&tel=13261378407&imsi=460010112262540&cpparam=0247123456002";


		try {
			System.out.println(HttpClientUtil.simpleVisitUrl(url));
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testSendVerifyCode(String code) {
		String timestamp = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
		String urlPre = "http://115.29.201.88";
		// String urlPre="http://localhost:8080/sdk_web";

/*		String url = urlPre
				+ "/sms/ltyy/sendVerifyCode?order_id=11000000000033&price=800"
				+ "&imsi=460019834098880&imei=864783023234905&phone=13049814583&timestamp="
				+ timestamp + "&verify_code=" + code;*/
		String url = urlPre
				+ "/sync/ldddwojconfirm?orderid=SHAG_201603111526111171"
				+ "&verifycode=" + code;

		try {
			System.out.println(HttpClientUtil.simpleVisitUrl(url));
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
