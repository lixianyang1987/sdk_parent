package com.hytx.service.sync;

import com.hytx.model.sync.SyncMs;
import com.hytx.model.sync.SyncMsExample;
import com.hytx.model.sync.SyncZqrd;



public interface ISyncZqrdService {
	public int insertSyncZqrd(SyncZqrd syncZqrd);

	public int updateSyncZqrd(SyncZqrd syncZqrd);	
	
	public SyncZqrd GetSyncZqrd(String LinkId);

	/****
	 * 同步订单数据到下游渠道
	 * 
	 * @param syncqsxxby
	 * @param queryString
	 * @author houzz
	 * @date 2015年10月9日
	 */
	

	public void syncToZqrd(SyncZqrd syncMs);
	
	public void syncallZqrd();
}
