package com.hytx.service.sync;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.baseConf.ori.OperateMapper;
import com.hytx.dao.client.ex.ReqSmsCommandMapperEx;
import com.hytx.dao.client.ori.ReqSmsMapper;
import com.hytx.dao.sync.ex.SyncAllMapperEx;
import com.hytx.dao.sync.ori.SyncAllMapper;
import com.hytx.dao.sync.ori.SyncSzzbMapper;
import com.hytx.model.sync.SyncSzzb;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;

@Service("syncSzzbServiceImpl")
public class SyncSzzbServiceImpl implements ISyncSzzbService {
	@Autowired
	private SyncSzzbMapper syncSzzbMapper;
	@Autowired
	private SyncAllMapperEx syncAllMapperEx;
	@Autowired
	private SyncAllMapper syncAllMapper;
	@Autowired
	private OperateMapper operateMapper;
	@Autowired
	private ReqSmsMapper reqSmsMapper;
	@Autowired
	private ReqSmsCommandMapperEx reqSmsCommandMapperEx;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private IBaseReqService baseReqService;

	@Override
	public int insertSyncSzzb(SyncSzzb syncSzzb) {
		// TODO Auto-generated method stub		
		syncSzzb.setCreatetime(new Date());
		syncSzzbMapper.insert(syncSzzb);
		return 1;
	}

}
