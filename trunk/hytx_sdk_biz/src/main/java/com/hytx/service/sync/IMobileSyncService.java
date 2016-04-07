package com.hytx.service.sync;

import com.hytx.model.sync.CpOrderSync;
import com.hytx.model.sync.MobileSync;

public interface IMobileSyncService {
	/***
	 * 添加移动计费同步数据
	 * 
	 * @param mobileSync
	 * @return
	 * @author houzz
	 * @date 2015年6月15日
	 */
	public int insertMobileSync(MobileSync mobileSync);

	/****
	 * 添加cp计费同步数据
	 * 
	 * @param cpOrderSync
	 * @return
	 * @author houzz
	 * @date 2015年7月16日
	 */
	public int insertCpOrderSync(CpOrderSync cpOrderSync);

}
