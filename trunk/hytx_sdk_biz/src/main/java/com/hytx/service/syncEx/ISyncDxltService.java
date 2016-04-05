package com.hytx.service.syncEx;

import com.hytx.model.sync.Tdxlt;

public interface ISyncDxltService {
	public int addDxlt(Tdxlt dxlt);

	void syncToDxlt(Tdxlt dxlt);
	
	public void dxltSync();
	
}	
