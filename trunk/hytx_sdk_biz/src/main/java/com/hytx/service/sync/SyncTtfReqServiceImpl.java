package com.hytx.service.sync;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hytx.model.sync.SyncTtf;

@Service("syncTtfReqServiceImpl")
public class SyncTtfReqServiceImpl implements ISyncTtfReqService {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");

	@Override
	public String syncTtfreq(SyncTtf syncttf) {
		// TODO Auto-generated method stub
		String content = "";
		StringBuilder sb = new StringBuilder();
		sb.append("cpId=").append(syncttf.getCpid()).append("&opId=")
				.append(syncttf.getOpid()).append("&appId=")
				.append(syncttf.getAppid()).append("&imsi=")
				.append(syncttf.getImsi()).append("&fee=")
				.append(syncttf.getFee()).append("&channelId=")
				.append(syncttf.getChannelid()).append("&exData=")
				.append(syncttf.getExdata());
		try {
			String url = "http://sms.birdgame.cn/api/sms/single/charge?"
					+ sb.toString();
			logger.info("SyncTtfReqServiceImpl url:\n{}", url);
			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(url);
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			content = method.getResponseBodyAsString();
			logger.info("content:{}", content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	public static void main(String[] args) {
		SyncTtfReqServiceImpl s = new SyncTtfReqServiceImpl();
		s.syncTtfreq(new SyncTtf());
	}
}
