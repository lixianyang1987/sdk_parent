package com.hytx.service.sync;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.SyncSkMapper;
import com.hytx.model.sync.SyncSk;
@Service("syncSkServiceImpl")
public class SyncSkServiceImpl implements ISyncSkService {
	@Autowired
	private SyncSkMapper syncSkMapper;
	@Override
	public int insertSyncSk(SyncSk syncSk) {
		// TODO Auto-generated method stub
		syncSk.setCreatetime(new Date());
		try{
			syncSkMapper.insert(syncSk);
		}catch (Exception e){
			return -1;
		}
		return 1;
	}

}
