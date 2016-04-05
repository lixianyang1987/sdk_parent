package com.hytx.service.syncEx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.count.ex.SyncbyRetainedCountMapperEx;
import com.hytx.dao.syncEx.ori.SyncByRetainedMapper;
import com.hytx.dao.syncEx.ori.SyncTyAllMapper;
import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.util.Page;

@Service("SyncByRetainedServiceImpl")
public class SyncByRetainedServiceImpl implements ISyncbyRetainedService {
	@Autowired
	private SyncByRetainedMapper syncByRetainedMapper;
	@Autowired
	private SyncbyRetainedCountMapperEx syncbyRetainedCountMapperEx;
	@Autowired
	private SyncTyAllMapper  syncTyAllMapper;
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int AddSyncByRetained(List<SyncByRetained> syncByRetainedList) {
		// TODO Auto-generated method stub
		try {
			if (syncByRetainedList != null && syncByRetainedList.size() > 0) {
				for (SyncByRetained sbRetaines : syncByRetainedList) {
					sbRetaines.setReduceStatus(0);
					syncByRetainedMapper.insertSelective(sbRetaines);
				}
			}
			SyncTyAllExample synctyexample = new SyncTyAllExample();
			synctyexample.or().andAppIdEqualTo("840");
			synctyexample.or().andAppIdEqualTo("841");
			List<SyncTyAll> syncTyAllList = syncTyAllMapper
					.selectByExample(synctyexample);
			for (SyncTyAll syty : syncTyAllList) {
				SyncByRetained sbr = new SyncByRetained();
				sbr.setReduceStatus(syty.getReduceStatus());
				sbr.setLinkid(syty.getLinkid());
				sbr.setAppId(syty.getAppId());
				sbr.setChannelAppId(syty.getChannelAppId());
				syncByRetainedMapper.updateByPrimaryKeySelective(sbr);
			}

		} catch (Exception e) {
			return 1;
		}
		return 0;
	}


	
	

}
