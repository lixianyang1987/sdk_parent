package com.hytx.service.sync;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hytx.dao.sync.ori.SyncYlelMapper;
import com.hytx.model.sync.SyncYlel;

@Service("syncYlelServiceImpl")
public class SyncYlelServiceImpl implements ISyncYlelService {
	@Autowired
	private SyncYlelMapper syncYlelMapper;
	@Override
	public int insertSyncYlel(SyncYlel syncYlel) {
		// TODO Auto-generated method stub
		syncYlel.setCreatetime(new Date());
		syncYlelMapper.insert(syncYlel);
		return 1;
	}

}
