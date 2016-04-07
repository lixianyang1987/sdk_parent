package com.hytx.dto.sync;

public class DdoGetVerificationCodeDto extends DdoReqDto {
	public String cstmOrderNo;
	public String phoneNo;
	public String callbackUrl;

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getCstmOrderNo() {
		return cstmOrderNo;
	}

	public void setCstmOrderNo(String cstmOrderNo) {
		this.cstmOrderNo = cstmOrderNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
