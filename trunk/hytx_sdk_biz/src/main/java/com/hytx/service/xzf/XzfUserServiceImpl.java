package com.hytx.service.xzf;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.xzf.ori.XzfFlowLogMapper;
import com.hytx.dao.xzf.ori.XzfUserMapper;
import com.hytx.dao.xzf.ori.XzfVcodeMapper;
import com.hytx.model.xzf.XzfFlowLog;
import com.hytx.model.xzf.XzfUser;
import com.hytx.model.xzf.XzfUserExample;
import com.hytx.model.xzf.XzfVcode;
import com.hytx.model.xzf.XzfVcodeExample;
import com.hytx.util.HttpClientUtil;

@Service("xzfUserServiceImpl")
public class XzfUserServiceImpl implements IXzfUserService {
	@Autowired
	private XzfVcodeMapper vcodeMapper;
	@Autowired
	private XzfUserMapper xzfUserMapper;
	@Autowired
	private XzfFlowLogMapper xzfFlowLogMapper;

	@Override
	public int insertVcode(XzfVcode record) {
		return vcodeMapper.insert(record);
	}

	@Override
	public boolean validVcode(String mobile, String vcode) {
		Date nowDate = new Date();
		XzfVcodeExample example = new XzfVcodeExample();
		example.createCriteria().andMobileEqualTo(mobile)
				.andEffectiveDtLessThan(nowDate)
				.andExpireDtGreaterThan(nowDate).andVcodeEqualTo(vcode);
		return vcodeMapper.countByExample(example) > 0;
	}

	@Override
	@Transactional(readOnly = true)
	public XzfUser selectByPrimaryKey(String imei) {
		return xzfUserMapper.selectByPrimaryKey(imei);
	}

	@Override
	@Transactional(readOnly = true)
	public XzfUser selectXzfUserByMobile(String mobile) {
		XzfUserExample example = new XzfUserExample();
		example.createCriteria().andMobileEqualTo(mobile);
		List<XzfUser> list = xzfUserMapper.selectByExample(example);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insert(XzfUser record) {
		return xzfUserMapper.insert(record);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(XzfUser record) {
		return xzfUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertFlowLog(XzfFlowLog record) {
		return xzfFlowLogMapper.insert(record);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void repayment(String imei, Integer feeValue) {
		XzfUser xzfUser = selectByPrimaryKey(imei);
		if (xzfUser == null || feeValue < 0) {
			return;
		}
		Integer debt = xzfUser.getDebt();
		if (debt == null) {
			debt = 0;
		} else {
			debt = debt - feeValue;
		}
		if (debt < 0) {
			debt = 0;
		}
		Date debtDt = xzfUser.getDebtDt();
		if (debtDt == null) {
			debtDt = new Date();
		}
		xzfUser.setDebt(debt);
		xzfUser.setPayDt(new Date());
		if (debt == 0) {
			xzfUser.setShouldPayDt(null);
		}
		xzfUser.setExpireDt(DateUtils.addDays(debtDt, 30));// 还款清了用户可以看30天.
		updateByPrimaryKeySelective(xzfUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void thirdPayCallBack(String imei, Integer feeValue) {
		XzfUser xzfUser = selectByPrimaryKey(imei);
		if (xzfUser == null || feeValue < 0) {
			return;
		}
		Integer debt = xzfUser.getDebt();
		if (debt == null || debt == 0) {
			xzfUser.setShouldPayDt(null);
		}
		Date date = DateUtils.addDays(new Date(), 30);
		if (xzfUser.getExpireDt() == null
				|| xzfUser.getExpireDt().getTime() < date.getTime()) {
			xzfUser.setExpireDt(date);// 还款清了用户可以看30天.
			updateByPrimaryKeySelective(xzfUser);
		}
	}

	@Override
	public boolean validUserIdCard(String name, String idCard) {
		String url = "http://apicloud.mob.com/idcard/query?key=e3caf21db4a7&cardno="
				+ idCard;
		try {
			String content = HttpClientUtil.simpleVisitUrl(url);
			JSONObject jsObj = JSONObject.fromObject(content);
			if ("success".equals(jsObj.getString("msg"))) {
				return true;
			} else {
				return false;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

}
