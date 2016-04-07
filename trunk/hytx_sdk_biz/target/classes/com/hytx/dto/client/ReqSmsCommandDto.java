package com.hytx.dto.client;

import com.hytx.model.client.ReqSmsCommand;

public class ReqSmsCommandDto extends ReqSmsCommand {
	private static final long serialVersionUID = 1L;
	private String appName;
	private String operateName;
	private String payPointName;
	private String provinceName;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getPayPointName() {
		return payPointName;
	}

	public void setPayPointName(String payPointName) {
		this.payPointName = payPointName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
