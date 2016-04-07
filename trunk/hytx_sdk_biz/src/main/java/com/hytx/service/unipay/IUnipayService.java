package com.hytx.service.unipay;

import com.hytx.model.unipay.UnipayBill;
import com.hytx.model.unipay.UnipayState;
import com.hytx.model.xzf.XzfUnipayBill;

public interface IUnipayService {

	/****
	 * 保存用户下订单的记录
	 * 
	 * @param bill
	 * @return
	 * @author houzz
	 * @date 2015年9月29日
	 */
	int insertUnipayBill(UnipayBill bill);

	/****
	 * 保存银联同步的订单状态记录
	 * 
	 * @param unipayState
	 * @return
	 * @author houzz
	 * @date 2015年9月29日
	 */
	int insertUnipayState(UnipayState unipayState);

	/***
	 * 统计用户在银联成功购买的订单数
	 * 
	 * @param imsi
	 * @return
	 * @author houzz
	 * @date 2015年9月29日
	 */
	int countUserUnipayOrder(String imsi);

	/****
	 * 保存信支付用户下订单的记录
	 * 
	 * @param bill
	 * @return
	 * @author houzz
	 * @date 2015年9月29日
	 */
	int insertXzfUnipayBill(XzfUnipayBill bill);

	/****
	 * 根据订单号查询信支付银联订单记录
	 * 
	 * @param orderId
	 * @return
	 * @author houzz
	 * @date 2016年1月8日
	 */
	XzfUnipayBill selectXzfUnipayBillByOrderId(String orderId);

}
