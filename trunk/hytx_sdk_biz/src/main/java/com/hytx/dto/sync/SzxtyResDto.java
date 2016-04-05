package com.hytx.dto.sync;

import java.io.Serializable;

public class SzxtyResDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String	result;
	private String		sms_content;
	private String		sms_type;
	private String		sms_number;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSms_content() {
		return sms_content;
	}
	public void setSms_content(String sms_content) {
		this.sms_content = sms_content;
	}
	public String getSms_type() {
		return sms_type;
	}
	public void setSms_type(String sms_type) {
		this.sms_type = sms_type;
	}
	public String getSms_number() {
		return sms_number;
	}
	public void setSms_number(String sms_number) {
		this.sms_number = sms_number;
	}
	
}
