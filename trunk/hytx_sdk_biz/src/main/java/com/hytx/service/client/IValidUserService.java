package com.hytx.service.client;

import com.hytx.dto.client.BaseReqDto;

public interface IValidUserService {
	/****
	 * 验证用户包月是否处于有效状态，目前没有退订，只要订购就认为一直有效，判断依据为曾经成功状态sdk指令即为订购状态
	 * 
	 * @param baseReqDto
	 * @return
	 * @author houzz
	 * @date 2015年7月24日
	 */
	public boolean validUserOrderState(BaseReqDto baseReqDto);
}
