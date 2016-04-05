package com.hytx.Json;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.hytx.util.MD5;

public class JsonXzfUserInfo extends XzfReqBase implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@Length(min = 15, max = 32)
	private String orderId;
	@NotBlank
	@Length(min = 1)
	private String name;
	@NotBlank
	@Length(min = 18, max = 19)
	private String idCard;

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
		builder.append(this.name);
		builder.append("|");
		builder.append(this.idCard);
		builder.append("|");
		builder.append(this.orderId);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
