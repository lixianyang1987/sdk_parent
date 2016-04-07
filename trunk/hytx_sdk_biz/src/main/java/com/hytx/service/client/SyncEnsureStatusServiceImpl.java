package com.hytx.service.client;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.client.ori.ReqSmsCommandMapper;
import com.hytx.dao.client.ori.ReqSmsMapper;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.client.ReqSmsCommandExample;

@Service("syncEnsureStatusServiceImpl")
public class SyncEnsureStatusServiceImpl implements ISyncEnsureStatusService {
	@Autowired
	private ReqSmsCommandMapper reqSmsCommandMapper;
	@Autowired
	private ReqSmsMapper reqSmsMapper;

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateReqSmsCommandStatus(Map<Long, Integer> idStatusMap) {
		ReqSmsCommand cmd = new ReqSmsCommand();
		for (Entry<Long, Integer> entry : idStatusMap.entrySet()) {
			cmd.setId(entry.getKey());
			if (cmd.getEnsureStatus() == null
					|| !cmd.getEnsureStatus().equals(1)) {
				cmd.setEnsureStatus(entry.getValue());
				reqSmsCommandMapper.updateByPrimaryKeySelective(cmd);
			}
		}
		return 0;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateReqSmsLayoutStatus(String orderId) {
		ReqSmsCommand cmd = new ReqSmsCommand();
		cmd.setHasLayout(BaseContance.ACTIVICE_STATUS);
		ReqSmsCommandExample example = new ReqSmsCommandExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		reqSmsCommandMapper.updateByExampleSelective(cmd, example);

		ReqSms reqSms = new ReqSms();
		reqSms.setOrderId(orderId);
		reqSms.setHasLayout(BaseContance.ACTIVICE_STATUS);
		reqSmsMapper.updateByPrimaryKeySelective(reqSms);
		return 1;
	}

	public int updateReqSmsExTraInfo(String orderId, String extraInfo) {
		ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(orderId);
		if (reqSms != null && !StringUtils.isBlank(extraInfo)) {
			reqSms.setExtraInfo(extraInfo);
			reqSmsMapper.updateByPrimaryKey(reqSms);
			return 1;
		}
		return 0;
	}

}
