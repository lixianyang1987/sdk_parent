package com.hytx.dto.sms;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class SmsResponseWDto {

	private int error;

	private int successCnt;
	private String message;
	private String msgId;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public int getSuccessCnt() {
		return successCnt;
	}

	public void setSuccessCnt(int successCnt) {
		this.successCnt = successCnt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
