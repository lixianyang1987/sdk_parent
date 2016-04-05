package com.hytx.dto.client;

import com.hytx.model.client.ReqSms;

public class ReqSmsLogDto extends ReqSms {
	private String startDate;
	private String endDate;
	private String appName;
	private String channelName;
	private String provinceName;
	private String payPointName;
	private Long mobile;
	private String cnName;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getPayPointName() {
		return payPointName;
	}

	public void setPayPointName(String payPointName) {
		this.payPointName = payPointName;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

}
