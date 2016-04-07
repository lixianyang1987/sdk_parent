package com.hytx.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.client.ex.ReqSmsCommandMapperEx;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.ChannelApp;

@Service("validUserServiceImpl")
public class ValidUserServiceImpl implements IValidUserService {
	@Autowired
	private ReqSmsCommandMapperEx reqSmsCommandMapperEx;

	public boolean validUserOrderState(BaseReqDto baseReqDto) {
		ChannelApp channelApp = baseReqDto.getChannelApp();
		Integer count = reqSmsCommandMapperEx.countUserSendCmd(
				baseReqDto.getImsi(), channelApp.getAppId(),
				channelApp.getChannelId());
		return (count != null && count > 0);
	}
}
