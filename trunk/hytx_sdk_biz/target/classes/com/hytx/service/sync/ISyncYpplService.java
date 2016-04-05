package com.hytx.service.sync;
import com.hytx.model.sync.SyncYppl;
import com.hytx.model.sync.SyncYpplExample;

public interface ISyncYpplService {
	public int insertSyncYppl(SyncYppl syncYppl);
	
	public int updateSyncYppl(SyncYppl syncYppl,SyncYpplExample sye);
}
