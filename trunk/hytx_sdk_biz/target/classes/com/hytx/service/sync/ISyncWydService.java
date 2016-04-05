package com.hytx.service.sync;


import com.hytx.model.sync.SyncWydF;

public interface ISyncWydService {

	public int insertSyncWyd(SyncWydF syncWyd);

	void syncToWydf(SyncWydF syncWyd);

	void WydSync();
}
