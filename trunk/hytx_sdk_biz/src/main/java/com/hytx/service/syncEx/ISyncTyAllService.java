package com.hytx.service.syncEx;

import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.model.syncEx.SyncTyAllKey;


public interface ISyncTyAllService {
	public int addTyAll(SyncTyAll synctyall);
	
	public SyncTyAll SelectSyncTyAll (SyncTyAllExample sk);
	
	public int UpdateTyAll(SyncTyAll synctyall,SyncTyAllExample example);
	
	void syncToTyAll(SyncTyAll synctyall);
	
	public void SyncAll();

	
	
}	
