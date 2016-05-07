package com.hytx.service.count;

import java.util.List;

import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.util.Page;

public interface ISyncLogCountService {
	public List<SyncByLog> syncByLogcount(SyncByLog sbr,Page<SyncByLog> page);
}
