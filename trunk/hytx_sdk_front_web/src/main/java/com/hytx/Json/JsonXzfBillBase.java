package com.hytx.Json;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.hytx.util.MD5;

public class JsonXzfBillBase extends XzfReqBase implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@Length(min = 15)
	private String orderId;
	@NotNull
	private Integer feeValue;
	@NotNull
	@Range(min = 1, max = 2)
	private Integer feeType;
	/*操作类型,1为购买,2为还款*/
	@NotNull
	@Range(min = 1, max = 2)
	private Integer opType;

	@Override
	public String getColculateSign(String encryKey) {
		StringBuilder builder = new StringBuilder();
		builder.append(this.sdkVersion);
		builder.append("|");
		builder.append(this.channelAppKey);
		builder.append("|");
		builder.append(this.imsi);
		builder.append("|");
		builder.append(this.imei);
		builder.append("|");
		builder.append(this.orderId);
		builder.append("|");
		builder.append(feeValue);
		builder.append("|");
		builder.append(feeType);
		builder.append("|");
		builder.append(opType);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(Integer feeValue) {
		this.feeValue = feeValue;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

	public Integer getOpType() {
		return opType;
	}

	public void setOpType(Integer opType) {
		this.opType = opType;
	}

}
