package com.hytx.service.client;

import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;

public interface IDynamicOperateService {
	/****
	 * 通过动态指令获取短信串及上行号码
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @param operate
	 * @return
	 */
	public ReqSmsCommand changeOperateToCommand(ReqSms smsReq,
			BaseReqDto baseReqDto, Operate operate);
}
