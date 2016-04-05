package com.hytx.service.sms;

import org.apache.commons.httpclient.NameValuePair;
import org.springframework.stereotype.Service;

import com.hytx.dto.sms.SmsResponseWDto;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.JaxbUtil;

@Service("smsServiceImpl")
public class SmsServiceImpl implements ISmsService {
	private static final String SMSW_URL = "http://120.55.160.111:82/wgws/OrderServlet";

	@Override
	public boolean sendSmsW(String mobile, String content) {
		boolean result = false;
		NameValuePair[] nameValuePairs = new NameValuePair[] {
				new NameValuePair("apName", "bjdxxs"),
				new NameValuePair("apPassword", "ljy1228"),
				new NameValuePair("srcId", ""),
				new NameValuePair("ServiceId", ""),
				new NameValuePair("calledNumber", mobile),
				new NameValuePair("content", content),
				new NameValuePair("sendTime", "") };
		String smsContent = "";
		while (true) {
			if (content.length() > 70) {
				smsContent = content.substring(0, 70);
				content = content.substring(70);
			} else {
				smsContent = content;
			}
			try {
				String response = HttpClientUtil.postData(SMSW_URL,
						nameValuePairs);
				SmsResponseWDto dto = JaxbUtil.converyToJavaBean(response,
						SmsResponseWDto.class);
				if (dto.getError() == 0) {
					result = true;

				} else {
					result = false;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
				break;
			}
			if (smsContent == content) {
				break;
			}
		}
		return result;
	}

}
