package com.hytx.dao.sync.ex;

import com.hytx.model.sync.SyncQsxxby;

public interface SyncQsxxbyMapperEx {
	/***
	 * 查询用户最后一次订购记录
	 * 
	 * @param mobile
	 * @return
	 * @author houzz
	 * @date 2015年10月9日
	 */
	public SyncQsxxby selectLastOrderRecord(Long mobile);

}