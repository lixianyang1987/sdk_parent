package com.hytx.service.sms;

public interface ISmsService {

	/****
	 * 发送短信
	 * 
	 * @param mobile
	 * @param conent
	 * @return
	 * @author lxy
	 * @date 2015年12月29日
	 */
	public boolean sendSmsW(String mobile, String content);

}
