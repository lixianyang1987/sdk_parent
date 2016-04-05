package com.hytx.service.sync;

import com.hytx.model.sync.SyncQsxx;
import com.hytx.model.sync.SyncQsxxExample;
import com.hytx.model.sync.SyncQsxxby;

public interface ISyncQsxxService {
	public int insertSyncQsxx(SyncQsxx syncqsxx);

	public int updateSyncQsxx(SyncQsxx syncqsxx,SyncQsxxExample e);
	
	public int insertSyncQsxxby(SyncQsxxby syncqsxxby);
	
	public SyncQsxx Getqsxx(String LinkId);

	/****
	 * 同步订单数据到下游渠道
	 * 
	 * @param syncqsxxby
	 * @param queryString
	 * @author houzz
	 * @date 2015年10月9日
	 */
	public void syncQsxxbyToOhers(SyncQsxxby syncqsxxby, String queryString);

	public void syncQsxxToOhers(SyncQsxx syncqsxx, String queryString);
}
