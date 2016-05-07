package com.hytx.service.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.count.ex.SyncbyLogCountMapperEx;
import com.hytx.dao.count.ex.SyncbyRetainedCountMapperEx;
import com.hytx.dto.count.SyncAllCountDto;
import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.service.syncEx.ISyncbyRetainedService;
import com.hytx.util.Page;
@Service
public class SyncByLogCountServiceImpl implements ISyncLogCountService {
	@Autowired
	private SyncbyLogCountMapperEx sbrcm; 
	@Override
	public List<SyncByLog> syncByLogcount(SyncByLog sbr,
			Page<SyncByLog> page) {
		 List<SyncByLog> list = sbrcm.selectSyncLogListByPage(sbr, page);
			page.setResultList(list);
			page.setTotalCount(sbrcm.countSyncbyLog(sbr));
			return list;	
	}



}
