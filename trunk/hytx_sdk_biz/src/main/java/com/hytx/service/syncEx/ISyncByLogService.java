package com.hytx.service.syncEx;

import java.util.TimerTask;

import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByLogExample;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.model.syncEx.SyncTyAllKey;


public interface ISyncByLogService {
	public int addByLog(SyncByLog syncByLog,String zl);
	
	public SyncByLog SelectSyncByLog (SyncByLogExample  sk);
	
	
	void syncToByLog(SyncByLog syncByLog);
	void syncToByLogLS(SyncByLog syncByLog);
	
	public void SyncAll();
	
	void TimerSync();
	
}	
