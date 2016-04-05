package com.hytx.service.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.sms.ex.SmsLtyyMapperEx;
import com.hytx.dao.sms.ori.SmsLtyyMapper;
import com.hytx.model.sms.SmsLtyy;
import com.hytx.model.sms.SmsLtyyExample;

@Service("smsLtyyServiceImpl")
public class SmsLtyyServiceImpl implements ISmsLtyyService {
	@Autowired
	private SmsLtyyMapper smsLtyyMapper;
	@Autowired
	private SmsLtyyMapperEx smsLtyyMapperEx;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertSmsLtyy(SmsLtyy smsLtyy) {
		return smsLtyyMapper.insert(smsLtyy);
	}

	@Override
	public SmsLtyy selectByPrimaryKey(Long orderId) {
		return smsLtyyMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public Long selectSeqId() {
		return smsLtyyMapperEx.selectSeqId();
	}

	@Override
	@Transactional(readOnly = true)
	public SmsLtyy selectByIpAndUpOrderId(String ip, String upOrderId) {
		SmsLtyyExample example = new SmsLtyyExample();
		example.createCriteria().andIpEqualTo(ip)
				.andUpOrderIdEqualTo(upOrderId);
		List<SmsLtyy> list = smsLtyyMapper.selectByExample(example);
		if (list == null || list.size() != 1) {
			return null;
		}
		return list.get(0);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateSmsLtyy(SmsLtyy smsLtyy) {
		return smsLtyyMapper.updateByPrimaryKeySelective(smsLtyy);
	}

}
