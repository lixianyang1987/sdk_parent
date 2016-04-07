package com.hytx.service.client;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;
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
import com.hytx.service.sync.ISyncSzqcReqService;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.StringUtil;

@Service("dynamicOperateFkdsmm")
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
		sb.append("http://14.17.74.124:10011/xcMMBilling.aspx?")
				.append("imsi=").append(baseReqDto.getImsi())
				.append("&chargeId=10931").append("&imei=")
				.append(baseReqDto.getImei()).append("&exdata=42")
				.append(StringUtil.format(num + "", 6)).append("&bsccid=")
				.append(baseReqDto.getBsccid()).append("&bsclac=")
				.append(baseReqDto.getBsclac()).append("&ip=")
				.append(smsReq.getIp());

		String content;
		try {
			content = HttpClientUtil.simpleVisitUrl(sb.toString());
			if (content != null && content.equals("error")) {
				String url = "http://14.17.74.124:10011/xcMMBilling.aspx?exdata=42111111&bsccid=42852&bsclac=4219&ip=182.18.37.141&chargeId=10931&imsi=460026012242669&imei=99000522803663";
				content = HttpClientUtil.simpleVisitUrl(url);
			}
			if (!StringUtils.isBlank(content)) {
				if (!content.equals("error")) {
					String[] s = content.split("<:>");
					ReqSmsCommand command = new ReqSmsCommand();
					// 获取指令
					command.setAppId(dynaOperate.getAppId());
					command.setFeeValue(feeValue);
					command.setOperateId(dynaOperate.getId());
					command.setOrderId(smsReq.getOrderId());
					command.setPayPointId(smsReq.getPayPointId());
					command.setMoContent("base64:" + s[1]);
					command.setUpdateDt(new Date());
					command.setSendStatus(BaseContance.INIT_STATUS);
					command.setMoNum(s[0]);
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

	public static void main(String[] args) throws Exception {
		String str = "";
		System.out.println(new String(Base64.decodeBase64(str), "utf-8"));
	}
}
