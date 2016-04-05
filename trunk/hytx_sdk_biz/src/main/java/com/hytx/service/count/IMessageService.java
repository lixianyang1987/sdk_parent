package com.hytx.service.count;

import java.util.List;

import com.hytx.dto.count.DayLimitDto;

public interface IMessageService {
	/***
	 * 功能描述：查询渠道包消息提醒列表
	 * 
	 * @return 返回消息提醒列表
	 * @author houzz
	 * @since 2015年07月31日
	 */
	public List<DayLimitDto> selectChannelAppMessage();

	/***
	 * 功能描述：查询渠道包消息提醒列表
	 * 
	 * @return 返回消息提醒列表
	 * @author houzz
	 * @since 2015年07月31日
	 */
	public List<DayLimitDto> selectAppMessage();
}
