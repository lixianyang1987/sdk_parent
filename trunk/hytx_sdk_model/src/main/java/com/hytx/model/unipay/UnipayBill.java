package com.hytx.model.unipay;

import java.io.Serializable;
import java.util.Date;

public class UnipayBill implements Serializable {
	private static final long serialVersionUID = 1L;

	private String orderId;

	private String imsi;

	private String imei;

	private String ua;

	private String verSdk;

	private String feeValue;

	private String orderTime;

	private Date createDt;

	private String extraInfo;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getVerSdk() {
		return verSdk;
	}

	public void setVerSdk(String verSdk) {
		this.verSdk = verSdk;
	}

	public String getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(String feeValue) {
		this.feeValue = feeValue;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(200);
		builder.append("orderId:").append(this.orderId).append("\n")
				.append("imsi:").append(this.imsi).append("\n").append("imei:")
				.append(this.imei).append("\n").append("ua:").append(this.ua)
				.append("\n").append("verSdk:").append(this.verSdk)
				.append("\n").append("feeValue:").append(this.feeValue)
				.append("\n").append("orderTime:").append(this.orderTime)
				.append("\n").append("extraInfo:").append(this.extraInfo)
				.append("\n");
		return builder.toString();
	}

}
