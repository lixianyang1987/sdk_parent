package com.hytx.service.sync;



import com.hytx.model.sync.SyncHddxOr;
import com.hytx.model.sync.SyncHddxOrExample;


public interface ISyncHddxOrService {
	
	public int insertSyncHddxOr(SyncHddxOr syncHddxOr);
	
	public int updateSyncHddxOr(SyncHddxOr syncHddxOr,SyncHddxOrExample shdor);

	
}
