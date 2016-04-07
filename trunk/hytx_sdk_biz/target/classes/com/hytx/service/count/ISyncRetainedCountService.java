package com.hytx.service.count;

import java.util.List;

import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.util.Page;

public interface ISyncRetainedCountService {
	public List<SyncByRetained> syncByRetainedcount(SyncByRetained sbr,Page<SyncByRetained> page);
}
