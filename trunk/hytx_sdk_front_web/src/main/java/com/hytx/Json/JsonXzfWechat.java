package com.hytx.Json;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.hytx.util.MD5;

public class JsonXzfWechat extends XzfReqBase implements Serializable {
	private static final long serialVersionUID = 1L;
	private int hasCared;
	@NotBlank
	@Length(min = 15, max = 32)
	private String orderId;

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
		builder.append(this.hasCared);
		builder.append("|");
		builder.append(this.orderId);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

	public int getHasCared() {
		return hasCared;
	}

	public void setHasCared(int hasCared) {
		this.hasCared = hasCared;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
