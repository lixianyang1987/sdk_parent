package com.hytx.service.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.dto.sync.SzxtyReqDto;
import com.hytx.dto.sync.SzxtyResDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.util.StringUtil;

@Service("dynamicOperateSzxty")
public class DynamicOperateSzxty implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");

	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;

	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		// TODO Auto-generated method stub
		SzxtyReqDto szxtydto = new SzxtyReqDto();
		szxtydto.setChannelId("8a68b489eb3943969ba0a75d913d56fb");
		szxtydto.setImsi(smsReq.getImsi());
		szxtydto.setImei("");
		SimpleDateFormat time1 = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat time2 = new SimpleDateFormat("yyyyMMddhhmmss");
		int serialNum = reqSmsService.getNextSerialNum();
		szxtydto.setOrder_id("0" + time1.format(new Date())
				+ StringUtil.format(serialNum + "", 7));
		szxtydto.setPhone("");
		szxtydto.setPrice(feeValue / 100);
		szxtydto.setProduct_id("p10004");
		szxtydto.setTimestamp(time2.format(new Date()));
		SzxtyResDto srd = SzxtyReq(szxtydto);
		if (srd != null && srd.getResult().equals("success")) {
			ReqSmsCommand command = new ReqSmsCommand();
			command.setAppId(dynaOperate.getAppId());
			command.setFeeValue(feeValue);
			command.setOperateId(dynaOperate.getId());
			command.setOrderId(smsReq.getOrderId());
			command.setPayPointId(smsReq.getPayPointId());
			command.setMoContent(srd.getSms_content());
			command.setUpdateDt(new Date());
			command.setSendStatus(BaseContance.INIT_STATUS);
			command.setMoNum(dynaOperate.getFeeCode());
			command.setSerialNum(serialNum);
			command.setProvinceId(baseReqDto.getProvinceId());
			return command;
		}
		return null;
	}

	public SzxtyResDto SzxtyReq(SzxtyReqDto srd) {
		String content = "";
		SzxtyResDto sresdto = new SzxtyResDto();
		StringBuilder sb = new StringBuilder();
		sb.append("order_id=").append(srd.getOrder_id()).append("&channelId=")
				.append(srd.getChannelId()).append("&product_id=")
				.append(srd.getProduct_id()).append("&price=")
				.append(srd.getPrice()).append("&imsi=").append(srd.getImsi())
				.append("&imei=").append(srd.getImei()).append("&phone=")
				.append(srd.getPhone()).append("&timestamp=")
				.append(srd.getTimestamp());
		try {
			String url = "http://182.92.3.11:8057/dmlm/yueRenPayment?"
					+ sb.toString();
			logger.info("DynamicOperateSzxty url:\n{}", url);
			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(url);
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			content = method.getResponseBodyAsString();
			logger.info("content:{}", content);
			if (!StringUtils.isBlank(content)) {
				JSONObject jsonObject = JSONObject.fromObject(content);
				sresdto.setResult(jsonObject.getString("result"));
				sresdto.setSms_content(jsonObject.getString("sms_content"));
				sresdto.setSms_number(jsonObject.getString("sms_number"));
				sresdto.setSms_type(jsonObject.getString("sms_type"));
			}

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

		return sresdto;

	}

	public static void main(String[] args) {
		SimpleDateFormat time1 = new SimpleDateFormat("yyMMdd");
		System.out.println(time1.format(new Date()));
	}
}
