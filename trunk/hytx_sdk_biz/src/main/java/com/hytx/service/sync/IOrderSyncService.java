package com.hytx.service.sync;

import com.hytx.model.sync.OrderSync;

public interface IOrderSyncService {
	/***
	 * 添加计费同步数据
	 * 
	 * @param orderSync
	 * @return
	 * @author houzz
	 * @date 2015年6月15日
	 */
	public int insert(OrderSync orderSync);
}
