package com.hytx.service.xzf;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.xzf.ori.XzfCouponMapper;
import com.hytx.dao.xzf.ori.XzfSelfBillMapper;
import com.hytx.model.xzf.XzfCoupon;
import com.hytx.model.xzf.XzfCouponExample;
import com.hytx.model.xzf.XzfSelfBill;

@Service("xzfBillServiceImpl")
public class XzfBillServiceImpl implements IXzfBillService {
	@Autowired
	private XzfSelfBillMapper xzfSelfBillMapper;
	@Autowired
	private XzfCouponMapper xzfCouponMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertXzfBill(XzfSelfBill record) {
		if (record.getOrderId() == null) {
			return 0;
		}
		XzfSelfBill entity = xzfSelfBillMapper.selectByPrimaryKey(record
				.getOrderId());
		if (entity == null) {
			xzfSelfBillMapper.insert(record);
		}
		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateXzfBillByOrderIdSelective(XzfSelfBill record) {
		return xzfSelfBillMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertCoupon(XzfCoupon xzfCoupon) {
		return xzfCouponMapper.insert(xzfCoupon);
	}

	@Override
	public XzfSelfBill selectXzfSelfBillByPrimaryKey(String orderId) {
		return xzfSelfBillMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public List<XzfCoupon> selectUserCoupons(String imsi) {
		Date nowDt = new Date();
		XzfCouponExample example = new XzfCouponExample();
		example.createCriteria().andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andEffectiveDtLessThan(nowDt).andExpireDtGreaterThan(nowDt);
		return xzfCouponMapper.selectByExample(example);
	}
}
