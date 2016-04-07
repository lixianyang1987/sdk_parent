package com.hytx.service.sync;

import com.hytx.model.sync.SyncSjdy;

public interface ISyncSjdyService {
	/****
	 * 添加世纪电盈计费同步数据
	 * 
	 * @param syncSjdy
	 * @return
	 * @author houzz
	 * @date 2015年7月16日
	 */
	public int insertSyncSjdy(SyncSjdy syncSjdy);

	/****
	 * 添加世纪电盈MP计费同步数据
	 * 
	 * @param syncSjdyMp
	 * @return
	 * @author houzz
	 * @date 2015年7月16日
	 */
	public int insertSyncSjdyMp(SyncSjdy syncSjdyMp);
}
