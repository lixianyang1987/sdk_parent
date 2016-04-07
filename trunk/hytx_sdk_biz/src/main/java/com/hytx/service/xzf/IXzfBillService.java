package com.hytx.service.xzf;

import java.util.List;

import com.hytx.model.xzf.XzfCoupon;
import com.hytx.model.xzf.XzfSelfBill;

public interface IXzfBillService {

	int insertXzfBill(XzfSelfBill record);

	int updateXzfBillByOrderIdSelective(XzfSelfBill record);

	int insertCoupon(XzfCoupon xzfCoupon);

	List<XzfCoupon> selectUserCoupons(String imsi);

	XzfSelfBill selectXzfSelfBillByPrimaryKey(String orderId);

}
