package com.hytx.service.sync;

import com.hytx.model.sync.SyncYpplDx;
import com.hytx.model.sync.SyncYpplDxExample;


public interface ISyncYpplDxService {
	public int insertSyncYpplDx(SyncYpplDx syncYppl);
	
	public int updateSyncYppl(SyncYpplDx syncYppl,SyncYpplDxExample syde);
}
