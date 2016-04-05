package com.hytx.service.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.CpOrderSyncMapper;
import com.hytx.dao.sync.ori.MobileSyncMapper;
import com.hytx.model.sync.CpOrderSync;
import com.hytx.model.sync.MobileSync;

@Service("mobileSyncServiceImpl")
public class MobileSyncServiceImpl implements IMobileSyncService {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private MobileSyncMapper mobileSyncMapper;
	@Autowired
	private CpOrderSyncMapper cpOrderSyncMapper;

	public int insertMobileSync(MobileSync mobileSync) {
		return mobileSyncMapper.insert(mobileSync);
	}

	public int insertCpOrderSync(CpOrderSync cpOrderSync) {
		return cpOrderSyncMapper.insert(cpOrderSync);
	}

}
