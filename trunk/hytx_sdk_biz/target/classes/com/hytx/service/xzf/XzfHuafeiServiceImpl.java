package com.hytx.service.xzf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.xzf.ori.XzfHuafeiBillMapper;
import com.hytx.model.xzf.XzfHuafeiBill;

@Service("xzfHuafeiServiceImpl")
public class XzfHuafeiServiceImpl implements IXzfHuafeiService {
	@Autowired
	private XzfHuafeiBillMapper xzfHuafeiBillMapper;

	@Override
	@Transactional
	public int insertHuafeiBill(XzfHuafeiBill huafeiBill) {
		XzfHuafeiBill record = xzfHuafeiBillMapper
				.selectByPrimaryKey(huafeiBill.getOrderId());
		if (record != null) {
			return 1;
		}
		return xzfHuafeiBillMapper.insert(huafeiBill);
	}
}
