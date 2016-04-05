package com.hytx.service.sync;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hytx.model.sync.SyncSzqcSms;
@Service("syncSzqcResServiceImpl")
public class SyncSzqcResServiceImpl implements ISyncSzqcResService {

	@Override
	public String syncSzqcRes(SyncSzqcSms s) {
		// TODO Auto-generated method stub
		String content="";
		try{
		
		StringBuilder sb = new StringBuilder();
		sb.append("tradeid=").append(s.getTradeid())
		.append("&status=").append(s.getStatus());
		String url = "http://14.17.74.121:9900/dorecharge10.do?"
				+ sb.toString();

		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		GetMethod method = new GetMethod(url);
		client.executeMethod(method);
		System.out.println(method.getStatusCode());
		content = method.getResponseBodyAsString();
		if (!StringUtils.isBlank(content)) {
			JSONObject jsonObject = JSONObject.fromObject(content);				
			content=jsonObject.getString("error");
		}
		}catch (Exception e){
			e.printStackTrace();
		}
		return content;
	}

}
