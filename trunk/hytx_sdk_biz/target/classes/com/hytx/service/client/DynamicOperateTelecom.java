package com.hytx.service.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;

/****
 * 电信应用动态指令请求短串处理类
 * 请求实例：http://115.29.170.66:8180/appstore/ctccapp/getsms?channelid
 * =1031&appid=103100001
 * &imsi=460036670877736&cpparam=1ayg1s&paymoney=600&coopid=771143
 * 
 * 响应： {"result":{"moContent":
 * "\"&, ^?Li3X4C8^\\<}|I`yn&=gW &ED!$3RUu&+|&()pO:Cf3&\"AnY{",
 * "moNum":"11803080"
 * ,"mtContent":"您的号码13320943073于10月27日11时41分完成购买，资费15.0元/次，详询4008689689",
 * "mtNum":"11803080","operName":"中国电信","operator":3},"resultCode":"000000",
 * "resultDesc":"请求成功"}
 * 
 * @author houzz
 *
 */
@Service("dynamicOperateTelecom")
public class DynamicOperateTelecom implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	private final String url = "http://115.29.170.66:8180/appstore/ctccapp/getsms?channelid=1031&appid=103100001&coopid=771143";

	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		StringBuffer buffer = new StringBuffer(url);
		buffer.append("&imsi=" + smsReq.getImsi());
		buffer.append("&cpparam=" + smsReq.getChannelAppKey());// 透传参数
		buffer.append("&paymoney=" + feeValue);
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(buffer.toString());
		logger.info("电信动态指令请求路径为:" + buffer.toString());
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				String content = method.getResponseBodyAsString();
				logger.info("请求动态指令返回数据为:" + content);
				if (!StringUtils.isBlank(content)) {
					JSONObject jsonObject = JSONObject.fromObject(content);
					String resultCode = jsonObject.getString("resultCode");
					if (resultCode.equals("000000")) {
						JSONObject resultJson = jsonObject
								.getJSONObject("result");
						String moContent = resultJson.getString("moContent");
						String moNum = resultJson.getString("moNum");
						String mtContent = resultJson.getString("mtContent");
						String mtNum = resultJson.getString("mtNum");
						ReqSmsCommand command = new ReqSmsCommand();
						command.setAppId(baseReqDto.getApp().getId());
						command.setFeeValue(feeValue);
						command.setOperateId(dynaOperate.getId());
						command.setOrderId(smsReq.getOrderId());
						command.setPayPointId(smsReq.getPayPointId());
						command.setMoContent(moContent);
						command.setUpdateDt(new Date());
						command.setSendStatus(BaseContance.INIT_STATUS);
						if (StringUtils.isBlank(dynaOperate.getFeeCode())) {
							command.setMoNum(moNum);
						} else {
							command.setMoNum(dynaOperate.getFeeCode());
						}
						OperateKeyword opKey = new OperateKeyword();
						opKey.setOperateId(dynaOperate.getId());
						opKey.setMtNum(mtNum);
						opKey.setMtContent(mtContent);
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
				}
				logger.info("dynamicOperate data exception;");
			} else {
				logger.info("dynamicOperate interface is not able to visit;");
			}
		} catch (HttpException e) {
			e.printStackTrace();
			logger.error("dynamicOperate  exception:{}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("dynamicOperate  exception:{}", e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) throws HttpException, IOException {
		String path = "http://115.29.170.66:8180/appstore/ctccapp/getsms?channelid=1031&appid=103100001&imsi=460036670877736&cpparam=1ayg1s&paymoney=600&coopid=771143";
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(path);
		client.executeMethod(method);
		client.getParams().setContentCharset("UTF-8");
		if (method.getStatusCode() == HttpStatus.SC_OK) {
			String content = method.getResponseBodyAsString();
			System.out.println(content);
			JSONObject jsonObject = JSONObject.fromObject(content);
			String resultCode = jsonObject.getString("resultCode");
			if (resultCode.equals("000000")) {
				JSONObject resultJson = jsonObject.getJSONObject("result");
				String moContent = resultJson.getString("moContent");
				String moNum = resultJson.getString("moNum");
				String mtContent = resultJson.getString("mtContent");
				String mtNum = resultJson.getString("mtNum");
				System.out.println(resultCode);
				System.out.println(method.getResponseCharSet());
				System.out.println(moContent);
				System.out.println(moNum);
				System.out.println(mtContent);
				System.out.println(mtNum);
			}

		}

	}
}
