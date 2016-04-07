package com.hytx.dto.sync;

public class HzdsDdoDto {
	private String mobile;
	private String chargeCode;
	private String callbackUrl;
	private String transmissionData;
	public String getTransmissionData() {
		return transmissionData;
	}
	public void setTransmissionData(String transmissionData) {
		this.transmissionData = transmissionData;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HzdsDdoDto [mobile=");
		builder.append(mobile);
		builder.append(", chargeCode=");
		builder.append(chargeCode);
		builder.append(", callbackUrl=");
		builder.append(callbackUrl);
		builder.append("]");
		return builder.toString();
	}
	
}
