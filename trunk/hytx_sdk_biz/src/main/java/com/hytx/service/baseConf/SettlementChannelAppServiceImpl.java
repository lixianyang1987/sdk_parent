package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.baseConf.ori.SettlementChannelAppMapper;
import com.hytx.model.baseConf.SettlementAppExample;
import com.hytx.model.baseConf.SettlementChannelApp;
import com.hytx.model.baseConf.SettlementChannelAppExample;
@Service
public class SettlementChannelAppServiceImpl implements
		ISettlementChannelAppService {
	
	@Autowired
	private SettlementChannelAppMapper settlementChannelAppMapper;

	@Override
	public int addSmApp(SettlementChannelApp smApp) {
		// TODO Auto-generated method stub
		return settlementChannelAppMapper.insertSelective(smApp);
	}

	@Override
	public int updateSmApp(SettlementChannelApp smApp) {
		// TODO Auto-generated method stub
		return settlementChannelAppMapper.updateByPrimaryKeySelective(smApp);
	}

	@Override
	public int delSmApp(int appId) {
		// TODO Auto-generated method stub
		return settlementChannelAppMapper.deleteByPrimaryKey(appId);
	}

	@Override
	public SettlementChannelApp selctSmApp(int appId) {
		// TODO Auto-generated method stub
		return settlementChannelAppMapper.selectByPrimaryKey(appId);
	}

	@Override
	public int delsSmApp(List<Integer> ids) {
		// TODO Auto-generated method stub
		SettlementChannelAppExample s = new SettlementChannelAppExample();
		s.createCriteria().andChannelAppIdIn(ids);
		return settlementChannelAppMapper.deleteByExample(s);
		
	}

}
