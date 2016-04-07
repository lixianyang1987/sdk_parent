package com.hytx.service.syncEx;


import com.hytx.model.syncEx.SyncXl;

public interface ISyncXlService {
	public int addXl(SyncXl syncXl);

	void syncToXl(SyncXl syncXl);
	
	public void xlAllSync();
	
}	
