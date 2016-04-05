package com.hytx.dto.sync;

public class DdoConfirmBillingDto extends DdoReqDto {
	
	public String orderId;
	public String cstmOrderNo;
	public String verifyCode;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCstmOrderNo() {
		return cstmOrderNo;
	}
	public void setCstmOrderNo(String cstmOrderNo) {
		this.cstmOrderNo = cstmOrderNo;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	

}
