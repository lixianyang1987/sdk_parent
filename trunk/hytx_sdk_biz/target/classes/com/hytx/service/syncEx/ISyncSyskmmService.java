package com.hytx.service.syncEx;

import com.hytx.model.sync.Tsyskmm;

public interface ISyncSyskmmService {
	public int addSyncSyskmm(Tsyskmm syskmm);

	public void syncToSysk(Tsyskmm tsyskmm);

	void mmSync();
}
