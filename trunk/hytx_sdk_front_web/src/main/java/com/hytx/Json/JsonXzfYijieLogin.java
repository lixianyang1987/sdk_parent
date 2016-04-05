package com.hytx.Json;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.hytx.util.MD5;

public class JsonXzfYijieLogin extends XzfReqBase implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String uin;
	@NotBlank
	private String sess;

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
		builder.append(this.uin);
		builder.append("|");
		builder.append(sess);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

	public String getUin() {
		return uin;
	}

	public void setUin(String uin) {
		this.uin = uin;
	}

	public String getSess() {
		return sess;
	}

	public void setSess(String sess) {
		this.sess = sess;
	}

}
