package com.hytx.service.baseConf;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.baseConf.ori.SettlementAppMapper;
import com.hytx.model.baseConf.SettlementApp;
import com.hytx.model.baseConf.SettlementAppExample;

@Service
public class SettlementAppServiceImpl implements ISettlementAppService {
	@Autowired	
	private SettlementAppMapper settlementAppMapper;
	/**
	 * 添加app结算方式关联
	 * */
	@Override
	public int addSmApp(SettlementApp smApp) {
		// TODO Auto-generated method stub
		return settlementAppMapper.insertSelective(smApp);
}

	/**
	 * 更新app结算方式关联
	 * */
	@Override
	public int updateSmApp(SettlementApp smApp) {
		// TODO Auto-generated method stub
		return settlementAppMapper.updateByPrimaryKeySelective(smApp);
	}
	/**
	 * 删除app结算方式关联
	 * */
	@Override
	public int delSmApp(int appId) {
		// TODO Auto-generated method stub
		return settlementAppMapper.deleteByPrimaryKey(appId);
	}
	/**
	 * 查询结算方式关联
	 * */
	@Override
	public SettlementApp selctSmApp(int appId) {
		// TODO Auto-generated method stub
		return settlementAppMapper.selectByPrimaryKey(appId);
	}

	@Override
	public int delsSmApp(List<Integer> ids) {
		// TODO Auto-generated method stub
		SettlementAppExample s = new SettlementAppExample();
		s.createCriteria().andAppIdIn(ids);
		return settlementAppMapper.deleteByExample(s);
	}


}
