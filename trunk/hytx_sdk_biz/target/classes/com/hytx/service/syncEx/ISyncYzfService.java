package com.hytx.service.syncEx;

import com.hytx.model.syncEx.SyncYzf;



public interface ISyncYzfService {
	public int addYzf(SyncYzf ddo);

	void syncToYzf(SyncYzf ddo);

	void yzfallSync();
	
	public int addMdo(SyncYzf yzf);

	void syncToMdo(SyncYzf yzf);
}
