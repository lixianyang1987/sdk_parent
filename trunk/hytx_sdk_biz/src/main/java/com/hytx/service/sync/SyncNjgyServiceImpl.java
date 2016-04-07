package com.hytx.service.sync;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.SyncHhaiMapper;
import com.hytx.dao.sync.ori.SyncNjgyMapper;
import com.hytx.model.sync.SyncHhai;
import com.hytx.model.sync.SyncNjgy;
@Service("syncNjgyServiceImpl")
public class SyncNjgyServiceImpl implements ISyncNjgyService {
	@Autowired
	private SyncNjgyMapper syncNjgyMapper;
	

	@Override
	public int insertSyncNjgy(SyncNjgy syncNjgy) {
		// TODO Auto-generated method stub
		syncNjgy.setCreatetime(new Date());
		return syncNjgyMapper.insert(syncNjgy);
	}

}
