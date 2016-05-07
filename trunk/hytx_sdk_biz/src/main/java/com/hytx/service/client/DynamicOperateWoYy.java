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
import com.hytx.model.client.SdkInfo;
import com.hytx.model.sync.SyncProvinceZjhyExample;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.sync.ISyncSzqcReqService;

@Service("dynamicOperateWoYy")
public class DynamicOperateWoYy implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private ISyncSzqcReqService syncSzqcReqService;
	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private SyncProvinceZjhyMapper provincezjhy;
	@Autowired
	private ISdkInfoService sdkInfoService;

	/**
	 * 获取WO音乐动态指令
	 * */
	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		//
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
			SdkInfo si=	sdkInfoService.selectByPrimaryKey(baseReqDto.getImsi())	;	
		StringBuilder sb = new StringBuilder();
		sb.append("http://198.96.93.89:8888/recharge/cumusic1?")
				.append("imsi=").append(baseReqDto.getImsi()).append("&imei=")
				.append(baseReqDto.getImei()).append("&fee=").append(feeValue)
				.append("&args=").append(smsReq.getChannelAppKey())
				.append("&ip=").append(smsReq.getIp())
				.append("&mobile=").append(si.getMobile()).append("&channelid=").append("7c905471");
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
				String sid =jsonObject.getString("sid");
				if (status == 0) {					
					command.setAppId(dynaOperate.getAppId());
					command.setFeeValue(feeValue);
					command.setOperateId(dynaOperate.getId());
					command.setOrderId(smsReq.getOrderId());
					command.setPayPointId(smsReq.getPayPointId());
					command.setMoContent("http://198.96.93.89:8888/recharge/cumusic2?sid="+sid+"&vcode=");
					command.setMoNum("http");
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
