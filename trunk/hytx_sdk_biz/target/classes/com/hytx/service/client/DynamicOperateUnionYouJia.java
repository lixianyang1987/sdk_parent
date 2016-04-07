package com.hytx.service.client;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.StringUtil;

/****
 * 优嘉-联通沃商店动态指令接口 Accept:application/json;charset=UTF-8
 * Content-Type:application/json { "cpparam":"text000000000002", "actionlist":[
 * { "action":"10655198000", "actiontype":"1", "actionparam":
 * "OgjJQ7znP/0BeM+GZm8OVC6v2wloxrvdYxxfXgKfQ+qioqyoBXzWX0Kr6Fewf+y+0ANnZYuimMOSozSH30XXV5Xp41/q1uiShj1yYrHIkUs="
 * , "sleep":"0" } ], "resultmsg":"Success", "resultcode":"0" }
 *
 * @author houzz
 *
 */
@Service("dynamicOperateUnionYouJia")
public class DynamicOperateUnionYouJia implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private IReqSmsService reqSmsService;
	private final String url = "http://qd.tg52.com/qdcs/cprequest";
	/****
	 * 资费与道具代码的映射
	 */
	private static final Map<Integer, String> FEE_CODE_MAP = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;

		{
			put(200, "COQ001001");
			put(400, "COQ001002");
			put(600, "COQ001003");
			put(800, "COQ001004");
			put(1000, "COQ001005");
			put(1500, "COQ001006");
		}
	};

	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		String cpFee = FEE_CODE_MAP.get(feeValue);
		if (cpFee == null) {
			return null;
		}
		Integer serialNum = reqSmsService.getNextSerialNum();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("cpfee", cpFee);
		jsonObj.put("cpparam", StringUtil.format(serialNum + "", 7));
		jsonObj.put("cpgoods", "");// 接入商的道具名称。若无，请提交“”字符
		jsonObj.put("userimei", baseReqDto.getImei());
		jsonObj.put("userimsi", baseReqDto.getImsi());
		jsonObj.put("usertype", dynaOperate.getServerType().toString());// 用户手机的归属运营商1：移动；2：联通；3：电信
		jsonObj.put("usertel", "00000000000");// 用户的手机号码，若无，请提交11个0
		jsonObj.put("exeno", "0");// 计费次数,默认为0
		try {
			String responseBody = HttpClientUtil.postJsonData(url,
					jsonObj.toString());
			if (StringUtils.isEmpty(responseBody)) {
				logger.debug("动态指令请求失败,没数据返回");
				return null;
			}
			logger.debug("动态指令请求返回数据为:{}", responseBody);
			JSONObject resultJson = JSONObject.fromObject(responseBody);
			String resultCode = resultJson.getString("resultcode");
			if (!"0".equals(resultCode)) {
				return null;
			}
			JSONArray actionArr = resultJson.getJSONArray("actionlist");
			Iterator listIt = actionArr.iterator();
			while (listIt.hasNext()) {
				JSONObject dataJson = (JSONObject) listIt.next();
				String actiontype = dataJson.getString("actiontype");
				// 1为发送短信方式,2为post请求方式
				if (actiontype.equals("1")) {
					ReqSmsCommand command = new ReqSmsCommand();
					command.setAppId(baseReqDto.getApp().getId());
					command.setFeeValue(feeValue);
					command.setOperateId(dynaOperate.getId());
					command.setOrderId(smsReq.getOrderId());
					command.setPayPointId(smsReq.getPayPointId());
					String moContent = dataJson.getString("actionparam");
					command.setMoContent("base64:" + moContent);// 与客户端的约定,如果指令以base64:开头,则做base64解码发送
					command.setUpdateDt(new Date());
					command.setSendStatus(BaseContance.NOT_ACTIVICE_STATUS);
					command.setSerialNum(serialNum);
					if (StringUtils.isBlank(dynaOperate.getFeeCode())) {
						command.setMoNum(dataJson.getString("action"));
					} else {
						command.setMoNum(dynaOperate.getFeeCode());
					}
					return command;
				}
			}
		} catch (HttpException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

}
