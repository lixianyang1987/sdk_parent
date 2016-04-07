package com.hytx.service.sync;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.SyncYpplMapper;
import com.hytx.model.sync.SyncYppl;
import com.hytx.model.sync.SyncYpplExample;

@Service("syncYpplServiceImpl")
public class SyncYpplServiceImpl implements ISyncYpplService {
	@Autowired
	private SyncYpplMapper syncYpplMapper;
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Override
	public int insertSyncYppl(SyncYppl syncYppl) {
		syncYppl.setCreatetime(new Date());
		// TODO Auto-generated method stub
		try{
			syncYpplMapper.insert(syncYppl);
		}catch (Exception e){
			return -1;
		}
		return 1;
	}

	@Override
	public int updateSyncYppl(SyncYppl syncYppl, SyncYpplExample sye) {
		// TODO Auto-generated method stub
		try{
			syncYpplMapper.updateByExampleSelective(syncYppl, sye);
		}catch (Exception e){
			
			return -1;
		}
		return  1;
	}

}
