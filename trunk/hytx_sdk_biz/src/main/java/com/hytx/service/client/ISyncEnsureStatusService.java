package com.hytx.service.client;

import java.util.Map;

public interface ISyncEnsureStatusService {
	/***
	 * 同步二次确认的状态
	 * 
	 * @param idStatusMap
	 * @return
	 * @author houzz
	 * @date 2015年9月8日
	 */
	public int updateReqSmsCommandStatus(Map<Long, Integer> idStatusMap);

	/***
	 * 同步短信发送时弹窗的状态
	 * 
	 * @param orderId
	 * @return
	 * @author houzz
	 * @date 2015年9月9日
	 */
	public int updateReqSmsLayoutStatus(String orderId);

	public int updateReqSmsExTraInfo(String orderId, String extraInfo);
}
