package com.hytx.service.xzf;

import com.hytx.dto.xzf.WxPayAppPayDto;
import com.hytx.dto.xzf.WxPayReqDto;
import com.hytx.model.xzf.XzfWxBill;
import com.hytx.model.xzf.XzfWxBillResult;

public interface IWxPayService {

	int insertXzfWxBill(XzfWxBill record);

	int updateXzfWxBillByOrderIdSelective(XzfWxBill record);

	WxPayAppPayDto unionPay(WxPayReqDto reqDto);

	int insertXzfWxBillResult(XzfWxBillResult record);

	String wxPayQuery(String orderId);

	XzfWxBillResult selectWxBillResult(String orderId);

}
