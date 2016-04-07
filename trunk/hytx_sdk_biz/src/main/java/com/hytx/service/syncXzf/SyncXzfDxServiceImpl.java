package com.hytx.service.syncXzf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dao.syncXzf.ori.XzfSyncDxMapper;
import com.hytx.dao.xzf.ori.XzfHuafeiBillMapper;
import com.hytx.model.syncXzf.XzfSyncDx;
import com.hytx.model.xzf.XzfHuafeiBill;
import com.hytx.service.xzf.IXzfUserService;

@Service("syncXzfDxServiceImpl")
public class SyncXzfDxServiceImpl implements ISyncXzfDxService {
	@Autowired
	private XzfSyncDxMapper xzfSyncDxMapper;
	@Autowired
	private IXzfUserService xzfUserService;
	@Autowired
	private XzfHuafeiBillMapper xzfHuafeiBillMapper;

	@Override
	public int addSyncXzf(XzfSyncDx xzfSyncDx) {
		// TODO Auto-generated method stub
		xzfSyncDxMapper.insert(xzfSyncDx);
		if ("DELIVRD".equals(xzfSyncDx.getStatus())) {
			XzfHuafeiBill bill = xzfHuafeiBillMapper
					.selectByPrimaryKey(xzfSyncDx.getCpparam());
			if (bill != null
					&& BaseContance.ACTIVICE_STATUS != bill.getStatus()) {
				bill.setStatus(BaseContance.ACTIVICE_STATUS);
				xzfHuafeiBillMapper.updateByPrimaryKeySelective(bill);
				if (bill.getOpType().equals(1)) {
					xzfUserService
							.repayment(bill.getImei(), bill.getFeeValue());
				} else {
					xzfUserService.thirdPayCallBack(bill.getImei(),
							bill.getFeeValue());
				}
			}
		}
		return 1;
	}
}
