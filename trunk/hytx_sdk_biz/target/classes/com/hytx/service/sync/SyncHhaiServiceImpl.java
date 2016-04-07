package com.hytx.service.sync;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.SyncHhaiMapper;
import com.hytx.model.sync.SyncHhai;
@Service("syncHhaiServiceImpl")
public class SyncHhaiServiceImpl implements ISyncHhaiService {
	@Autowired
	private SyncHhaiMapper syncHhaiMapper;
	@Override
	public int insertSyncHhai(SyncHhai syncHhai) {
		// TODO Auto-generated method stub
		syncHhai.setCreatetime(new Date());
		return syncHhaiMapper.insert(syncHhai);
	}

}
