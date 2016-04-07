package com.hytx.service.sync;

import com.hytx.model.sync.SyncMs;

public interface ISyncMsService {
	public int insertSyncMs(SyncMs syncMs);

	public int updateSyncMs(SyncMs syncMs);

	public SyncMs GetMs(String LinkId);

	/****
	 * 同步订单数据到下游渠道
	 * 
	 * @param syncqsxxby
	 * @param queryString
	 * @author houzz
	 * @date 2015年10月9日
	 */

	public void syncQsxxToMs(SyncMs syncMs);

}
