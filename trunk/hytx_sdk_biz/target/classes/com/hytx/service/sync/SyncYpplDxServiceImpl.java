package com.hytx.service.sync;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.SyncYpplDxMapper;
import com.hytx.dao.sync.ori.SyncYpplMapper;
import com.hytx.model.sync.SyncYpplDx;
import com.hytx.model.sync.SyncYpplDxExample;
@Service("syncYpplDxServiceImpl")
public class SyncYpplDxServiceImpl implements ISyncYpplDxService {
	@Autowired
	private SyncYpplDxMapper syncYpplDxMapper;
	
	@Override
	public int insertSyncYpplDx(SyncYpplDx syncYppl) {
		// TODO Auto-generated method stub
		syncYppl.setCreatetime(new Date());
		try{
			syncYpplDxMapper.insert(syncYppl);
		}catch (Exception e){
			return -1;
		}
		return 1;
	}

	@Override
	public int updateSyncYppl(SyncYpplDx syncYppl, SyncYpplDxExample syde) {
		// TODO Auto-generated method stub
		try{
			syncYpplDxMapper.updateByExampleSelective(syncYppl, syde);
		}catch (Exception e){
			return -1;
		}
		return 1;
	}

}
