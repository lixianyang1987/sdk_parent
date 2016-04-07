package com.hytx.service.baseConf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.baseConf.ori.SettlementMethodMapper;
import com.hytx.model.baseConf.SettlementMethod;
import com.hytx.model.baseConf.SettlementMethodExample;
@Service("settlementMethodServiceImpl")
public class SettlementMethodServiceImpl implements ISettlementMethodService {
	
	@Autowired
	private SettlementMethodMapper settlementMethodMapper;
	/**
	 * 获取所有结算方式
	 * */
	@Override
	public List<SettlementMethod> selectSettlementMethod() {
		// TODO Auto-generated method stub
		return settlementMethodMapper.selectByExample(new SettlementMethodExample());
	}

}
