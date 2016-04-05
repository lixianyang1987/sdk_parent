package com.hytx.service.client;

import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dao.sync.ori.SyncProvinceZjhyMapper;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.service.baseConf.IProvinceService;

@Service("dynamicOperateSk")
public class DynamicOperateSk implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");

	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private SyncProvinceZjhyMapper provincezjhy;

	/**
	 *
	 * 获取刷卡动态指令
	 * 
	 * */
	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		int serialNum = reqSmsService.getNextSerialNum();
		StringBuilder sb = new StringBuilder();
		// cp=1031&r=12&appid=103100001&amp;imsi=460036670351048&p=500
		sb.append("app_id=300009125747&imsi=").append(smsReq.getImsi());
		ReqSmsCommand command = new ReqSmsCommand();
		getRequsetSK(sb.toString(), command);
		command.setAppId(dynaOperate.getAppId());
		command.setFeeValue(feeValue);
		command.setOperateId(dynaOperate.getId());
		command.setOrderId(smsReq.getOrderId());
		command.setPayPointId(smsReq.getPayPointId());
		command.setUpdateDt(new Date());
		command.setSendStatus(BaseContance.INIT_STATUS);
		if (StringUtils.isBlank(dynaOperate.getFeeCode())) {
			//
		} else {
			command.setMoNum(dynaOperate.getFeeCode());
		}

		return command;
	}

	public void getRequsetSK(String req, ReqSmsCommand command) {

		String content = "";
		try {
			String url = "http://114.113.159.171:8088/statsynd/interface/mmpay.jsp?"
					+ req;

			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(url);
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			content = method.getResponseBodyAsString();
			System.out.println("content:" + content);
			if (!StringUtils.isBlank(content)) {
				String[] str = content.split("#@#");
				command.setMoContent(str[1]);
				command.setMoNum(str[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
