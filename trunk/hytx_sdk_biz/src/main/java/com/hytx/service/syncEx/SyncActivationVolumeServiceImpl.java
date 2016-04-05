package com.hytx.service.syncEx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.count.ex.SyncActivationVolumeMapperEx;
import com.hytx.dao.syncEx.ori.TActivationVolumeMapper;
import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.model.syncEx.TActivationVolume;
import com.hytx.util.Page;
@Service("SyncActivationVolumeServiceImpl")
public class SyncActivationVolumeServiceImpl implements
		ISyncActivationVolumeService {
	@Autowired
	private TActivationVolumeMapper tavMapper;
	@Autowired
	private SyncActivationVolumeMapperEx savMapper;

	@Override
	public int addActivationVolume(List<TActivationVolume> aclist) {
		// TODO Auto-generated method stub
		for(TActivationVolume ac :aclist){
			tavMapper.insertSelective(ac);
		}
		return 0;
	}

	@Override
	public List<TActivationVolume> selectTActivationVolumeList(
			TActivationVolume ta, Page<TActivationVolume> page) {
		 List<TActivationVolume> list = savMapper.selectSyncActivationVolumeListPage(ta, page);
			page.setResultList(list);
			page.setTotalCount(savMapper.countSyncActivationVolume(ta));
		return list;
	}
	

	
}
