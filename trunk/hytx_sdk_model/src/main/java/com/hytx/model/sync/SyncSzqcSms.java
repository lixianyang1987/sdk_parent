package com.hytx.model.sync;

import java.io.Serializable;

public class SyncSzqcSms implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tradeid;
	private int num;
	private String content;
	private int status;
	 
	public String getTradeid() {
		return tradeid;
	}
	public void setTradeid(String tradeid) {
		this.tradeid = tradeid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SyncZjhySms [num=");
		builder.append(num);
		builder.append(", content=");
		builder.append(content);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
