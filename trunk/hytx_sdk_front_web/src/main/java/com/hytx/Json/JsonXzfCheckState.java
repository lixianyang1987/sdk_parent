package com.hytx.Json;

import java.io.Serializable;

import com.hytx.util.MD5;

public class JsonXzfCheckState extends XzfReqBase implements Serializable {
	private static final long serialVersionUID = 1L;

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
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

}
