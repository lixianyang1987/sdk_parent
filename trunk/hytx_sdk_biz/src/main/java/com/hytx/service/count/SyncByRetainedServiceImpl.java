package com.hytx.service.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.count.ex.SyncbyRetainedCountMapperEx;
import com.hytx.dto.count.SyncAllCountDto;
import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.service.syncEx.ISyncbyRetainedService;
import com.hytx.util.Page;
@Service
public class SyncByRetainedServiceImpl implements ISyncRetainedCountService {
	@Autowired
	private SyncbyRetainedCountMapperEx sbrcm; 
	@Override
	public List<SyncByRetained> syncByRetainedcount(SyncByRetained sbr,
			Page<SyncByRetained> page) {
		// TODO Auto-generated method stub
		 List<SyncByRetained> list = sbrcm.selectSyncRetainedListByPage(sbr, page);
		page.setResultList(list);
		page.setTotalCount(sbrcm.countSyncbyRetained(sbr));
		return list;	
		
	}



}
