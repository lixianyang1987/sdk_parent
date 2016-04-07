package com.hytx.dto.count;

import java.io.Serializable;

public class CpOrderCountDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 查询条件
	 */
	private Integer appId;
	private Integer provinceId;
	private Integer channelId;
	private Integer cpId;
	private Integer reduceStatus;
	private String startDate;
	private String endDate;
	/**
	 * 展现数据
	 */
	private String date;
	private String provinceName;
	private String channelName;
	private String appName;
	private Integer serverType;
	private int feeValue;
	private int activates;
	private String cnName;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getReduceStatus() {
		return reduceStatus;
	}

	public void setReduceStatus(Integer reduceStatus) {
		this.reduceStatus = reduceStatus;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getServerType() {
		return serverType;
	}

	public void setServerType(Integer serverType) {
		this.serverType = serverType;
	}

	public int getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(int feeValue) {
		this.feeValue = feeValue;
	}

	public Integer getCpId() {
		return cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	public int getActivates() {
		return activates;
	}

	public void setActivates(int activates) {
		this.activates = activates;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

}
