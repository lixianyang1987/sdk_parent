package com.hytx.dto.count;

import java.io.Serializable;

public class SyncAllCountDto implements Serializable {
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
	private long sucFee;
	private long failFee;
	private long cnSucFee;
	private long cnFailFee;
	private long allFee;
	private long countPrice;
	private long ensureCount;
	private long ensureSucCount;
	private long ensureFailCount;

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

	public long getSucFee() {
		return sucFee;
	}

	public void setSucFee(long sucFee) {
		this.sucFee = sucFee;
	}

	public long getFailFee() {
		return failFee;
	}

	public void setFailFee(long failFee) {
		this.failFee = failFee;
	}

	public long getCnSucFee() {
		return cnSucFee;
	}

	public void setCnSucFee(long cnSucFee) {
		this.cnSucFee = cnSucFee;
	}

	public long getCnFailFee() {
		return cnFailFee;
	}

	public void setCnFailFee(long cnFailFee) {
		this.cnFailFee = cnFailFee;
	}

	public long getAllFee() {
		return allFee;
	}

	public void setAllFee(long allFee) {
		this.allFee = allFee;
	}

	public long getCountPrice() {
		return countPrice;
	}

	public void setCountPrice(long countPrice) {
		this.countPrice = countPrice;
	}

	public Integer getCpId() {
		return cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	public long getEnsureCount() {
		return ensureCount;
	}

	public void setEnsureCount(long ensureCount) {
		this.ensureCount = ensureCount;
	}

	public long getEnsureSucCount() {
		return ensureSucCount;
	}

	public void setEnsureSucCount(long ensureSucCount) {
		this.ensureSucCount = ensureSucCount;
	}

	public long getEnsureFailCount() {
		return ensureFailCount;
	}

	public void setEnsureFailCount(long ensureFailCount) {
		this.ensureFailCount = ensureFailCount;
	}

}
