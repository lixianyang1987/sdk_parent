package com.hytx.service.client;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.hytx.constance.BaseContance;
import com.hytx.dao.sync.ori.SyncProvinceZjhyMapper;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.sync.ISyncSzqcReqService;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.StringUtil;

@Service("dynamicOperatedmjd")
public class DynamicOperateFkdsMM implements IDynamicOperate {
	
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
	 * 获取MM动态指令
	 * */
	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		//
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();

		StringBuilder sb = new StringBuilder(200);
		int num = reqSmsService.getNextSerialNum();
		String itemId = "";
		switch (feeValue) {
		case 10:
			itemId = "300007092001";
			break;
		case 300:
			itemId = "300007092002";
			break;
		case 500:
			itemId = "300007092003";
			break;
		case 600:
			itemId = "300007092004";
			break;
		case 800:
			itemId = "300007092005";
			break;
		case 1000:
			itemId = "300007092006";
			break;

		default:
			break;
		}

		sb.append("http://cartoon.yiqiao580.com:9800/crack/cartoon/paysms.do?")
				.append("imsi=").append(baseReqDto.getImsi())
				.append("&ptid=42001").append("&itemId=").append(itemId)
				.append("&cpparam=").append(baseReqDto.getExtraInfo())
				.append("&itemPrice=").append(feeValue)
				.append("&itemSafeLevel=2").append("&itemMethod=11")
				.append("&version=1.0.0").append("&itemExt=");
		String content;
		try {
			content = HttpClientUtil.simpleVisitUrl(sb.toString());
			if (content != null && content.equals("error")) {
				JSONObject jsons = JSONObject.fromObject(content);
				if (jsons.getInt("result") == 0) {
					ReqSmsCommand command = new ReqSmsCommand();
					// 获取指令
					command.setAppId(dynaOperate.getAppId());
					command.setFeeValue(feeValue);
					command.setOperateId(dynaOperate.getId());
					command.setOrderId(smsReq.getOrderId());
					command.setPayPointId(smsReq.getPayPointId());
					command.setMoContent("base64:" + jsons.getString("sms"));
					command.setUpdateDt(new Date());
					command.setSendStatus(BaseContance.INIT_STATUS);
					command.setMoNum(jsons.getString("port"));
					command.setSerialNum(-1);
					command.setProvinceId(baseReqDto.getProvinceId());
					return command;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}


}
