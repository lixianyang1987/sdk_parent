package com.hytx.service.syncEx;

import com.hytx.model.sync.SyncDdo;
import com.hytx.model.sync.Tdxlt;


public interface DdoreqService {
	public int addDdoreq(SyncDdo ddo);

	void syncToDdoreq(SyncDdo ddo);
}
