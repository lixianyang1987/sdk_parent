package com.hytx.Json;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.hytx.util.MD5;

public class JsonXzfVcode extends XzfReqBase implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@Length(min = 11, max = 11)
	private String mobile;
	@NotBlank
	@Length(min = 15)
	private String orderId;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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
		builder.append(this.mobile);
		builder.append("|");
		builder.append(this.orderId);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

}
