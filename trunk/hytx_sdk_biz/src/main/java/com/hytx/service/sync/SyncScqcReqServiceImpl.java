package com.hytx.service.sync;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.model.sync.SyncSzqcReq;
import com.hytx.model.sync.SyncSzqcSms;

@Service("syncScqcReqServiceImpl")
public class SyncScqcReqServiceImpl implements ISyncSzqcReqService {
	private Logger logger = LoggerFactory.getLogger("SZQC_LOG");

	// gpslng=36.6392380000&gpslat=91.9407440000&bsclac=37143&bsccid=40021

	@Override
	public SyncSzqcSms syncZjhyReq(SyncSzqcReq syncSzqcReq) {
		// TODO Auto-generated method stub
		String content = "";
		SyncSzqcSms syncszqSms = new SyncSzqcSms();
		StringBuilder sb = new StringBuilder();
		sb.append("cpid=")
				.append(syncSzqcReq.getCpid())
				.append("&imei=")
				.append(syncSzqcReq.getImei())
				.append("&fee=")
				.append(800)
				.append("&imsi=").append(syncSzqcReq.getImsi()).append("&ext=")
				.append(syncSzqcReq.getExt()).append("&ip=")
				.append(syncSzqcReq.getIp()).append("&province=")
				.append(syncSzqcReq.getProvince()).append("&gpslng=")
				.append(syncSzqcReq.getGpslng()).append("&gpslat=")
				.append(syncSzqcReq.getGpslat()).append("&bsclac=")
				.append(syncSzqcReq.getBsclac()).append("&bsccid=")
				.append(syncSzqcReq.getBsccid());
		try {
			String url = "http://14.17.74.121:9900/dorecharge10.do?"
					+ sb.toString();
			System.out.println("SyncScqcReqServiceImpl url:" + url);
			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(url);
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			content = method.getResponseBodyAsString();
			System.out.println("content:" + content);
			if (!StringUtils.isBlank(content)) {
				JSONObject jsonObject = JSONObject.fromObject(content);
				int status = Integer.parseInt(jsonObject.getString("status"));
				if (status == 1) {
					// 计费成功
					logger.info(content);
					Map<String, Object> map = ThreadLocalCache.metas.get();
					if (map == null) {
						map = new HashMap<String, Object>();
					}
					map.put("hasOrderd", true);
					ThreadLocalCache.metas.set(map);
					return null;
				} else if (status == 0) {
					// 获取指令
					syncszqSms.setContent(jsonObject.getString("content"));
				} else if (status == -1) {
					// 失败
					return null;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
		return syncszqSms;
	}
}
