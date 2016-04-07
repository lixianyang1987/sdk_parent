package com.hytx.service.client;

import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;

public interface IDynamicOperate {
	/****
	 * 获取短信串及上行号码实例
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @param operate
	 * @return
	 */
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate);
}
