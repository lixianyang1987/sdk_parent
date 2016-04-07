package com.hytx.service.unipay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.unipay.ex.UnipayStateMapperEx;
import com.hytx.dao.unipay.ori.UnipayBillMapper;
import com.hytx.dao.unipay.ori.UnipayStateMapper;
import com.hytx.dao.xzf.ori.XzfUnipayBillMapper;
import com.hytx.model.unipay.UnipayBill;
import com.hytx.model.unipay.UnipayState;
import com.hytx.model.xzf.XzfUnipayBill;
import com.hytx.service.xzf.IXzfUserService;

@Service("unipayServiceImpl")
public class UnipayServiceImpl implements IUnipayService {
	@Autowired
	private UnipayStateMapper unipayStateMapper;
	@Autowired
	private UnipayStateMapperEx unipayStateMapperEx;
	@Autowired
	private UnipayBillMapper unipayBillMapper;
	@Autowired
	private XzfUnipayBillMapper xzfUnipayBillMapper;
	@Autowired
	private IXzfUserService xzfUserService;

	@Override
	public int insertUnipayBill(UnipayBill bill) {
		return unipayBillMapper.insert(bill);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertXzfUnipayBill(XzfUnipayBill bill) {
		if (xzfUnipayBillMapper.selectByPrimaryKey(bill.getOrderId()) == null) {
			return xzfUnipayBillMapper.insert(bill);
		}
		return 1;
	}

	@Override
	public XzfUnipayBill selectXzfUnipayBillByOrderId(String orderId) {
		return xzfUnipayBillMapper.selectByPrimaryKey(orderId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertUnipayState(UnipayState unipayState) {
		unipayStateMapper.insert(unipayState);
		if ("00".equals(unipayState.getRespCode())) {
			XzfUnipayBill bill = xzfUnipayBillMapper
					.selectByPrimaryKey(unipayState.getOrderId());
			if (bill != null) {
				bill.setStep(2);
				bill.setStatus(BaseContance.ACTIVICE_STATUS);
				xzfUnipayBillMapper.updateByPrimaryKeySelective(bill);
				if (bill.getOpType() == 2) {
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

	/***
	 * 统计用户在银联成功购买的订单数
	 * 
	 * @param imsi
	 * @return
	 * @author houzz
	 * @date 2015年9月29日
	 */
	@Override
	public int countUserUnipayOrder(String imsi) {
		return unipayStateMapperEx.countUserUnipayOrder(imsi);
	}
}
