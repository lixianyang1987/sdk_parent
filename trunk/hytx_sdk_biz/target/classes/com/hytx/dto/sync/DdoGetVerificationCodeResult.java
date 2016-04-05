package com.hytx.dto.sync;

public class DdoGetVerificationCodeResult {
	private String code;
	private String msg;
	private data data;
	
	public data getData() {
		return data;
	}
	public void setData(data data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DdoGetVerificationCodeResult [code=");
		builder.append(code);
		builder.append(", msg=");
		builder.append(msg);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	
	
}
