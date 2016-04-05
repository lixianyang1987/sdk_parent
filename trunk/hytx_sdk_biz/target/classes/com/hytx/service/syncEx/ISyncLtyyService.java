package com.hytx.service.syncEx;

import com.hytx.model.syncEx.SyncLtyy;

public interface ISyncLtyyService {

	/***
	 * 保存联通音乐上行订单数据
	 * 
	 * @param syncLtyy
	 * @return
	 * @author houzz
	 * @date 2015年10月22日
	 */
	int insertSyncLtyy(SyncLtyy syncLtyy);

	/***
	 * 更新上行订单记录
	 * 
	 * @param syncLtyy
	 * @return
	 * @author houzz
	 * @date 2015年10月22日
	 */
	int updateSyncLtyyStatus(SyncLtyy syncLtyy);

	/***
	 * 同步订单给下游渠道
	 * 
	 * @param url
	 * @param record
	 * @return
	 * @author houzz
	 * @date 2015年10月23日
	 */
	boolean syncLtyyToLowerChannel(String uri, SyncLtyy record);

	SyncLtyy selectByPrimaryKey(String linkId);

}
