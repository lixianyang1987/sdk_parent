package com.hytx.service.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.BaseContance;
import com.hytx.dao.sync.ori.SyncProvinceZjhyMapper;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncProvinceZjhyExample;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.sync.ISyncSzqcReqService;

@Service("dynamicOperatemgsp")
public class DynamicOperatemgsp implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private ISyncSzqcReqService syncSzqcReqService;
	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private SyncProvinceZjhyMapper provincezjhy;

	/**
	 * 获取咪咕视频动态指令
	 * */
	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		//
		
		StringBuilder sb = new StringBuilder();
		sb.append("http://182.92.189.63/m.api?")
				.append("imsi=").append(baseReqDto.getImsi()).append("&imei=")
				.append(baseReqDto.getImei()).append("&fee=").append("1000")
				.append("&appid=").append("2be13a204ffe6332d4cdad3709b04e8c")
				.append("&cpid=YY444&fmt=json&ib=0&type=501&_mt=1003");
		String content = "";
		ReqSmsCommand command = new ReqSmsCommand();
		try {
			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(sb.toString());
			client.executeMethod(method);
			content = method.getResponseBodyAsString();
			logger.info("动态请求返回：");
			logger.info(content);
			if (!StringUtils.isBlank(content)) {
				JSONObject jsonObject = JSONObject.fromObject(content);
				int status = Integer.parseInt(jsonObject.getString("error"));
		
				if (status == 0) {		
					String num1 = jsonObject.getString("num1");
					String content1 = jsonObject.getString("content1");
					String num2 = jsonObject.getString("num2");
					String content2 = jsonObject.getString("content2");
					command.setAppId(dynaOperate.getAppId());
					command.setFeeValue(1000);
					command.setOperateId(dynaOperate.getId());
					command.setOrderId(smsReq.getOrderId());
					command.setPayPointId(smsReq.getPayPointId());
					command.setMoContent(content1+"_"+content2);
					command.setMoNum(num1+"_"+num2);
					command.setUpdateDt(new Date());
					command.setSendStatus(BaseContance.INIT_STATUS);
					command.setSerialNum(-1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

		return command;
	}

}
