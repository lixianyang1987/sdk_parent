package com.hytx.service.client;

import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;

/****
 * 移动应用动态指令请求短串处理类
 * 
 * @author houzz
 *
 */
public class DynamicOperateMobile implements IDynamicOperate {
	private String url = "http://sdk.birdgame.cn/cmcc/mm/sms/charge?appId=xxx&imei=xxx&imsi=xxx&chargeCode=xxx&exData=xxx&channelId=xxx";

	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		url = url + "";
		return null;
	}

}
