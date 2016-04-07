package com.hytx.dto.xzf;

import java.io.Serializable;
import java.util.Date;

public class XzfCountDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 查询条件
	 */
	private Integer channelAppId;
	private String startDate;
	private String endDate;
	private Date leftDate;
	private Date rightDate;
	/**
	 * 展现数据
	 */
	private String date;
	private String channelAppName;
	private int feeValue;
	private int dataType;
	private int opType;
	private String mobile;
	private long total;
	private long totalSuc;
	private long totalUsers;

	public Integer getChannelAppId() {
		return channelAppId;
	}

	public void setChannelAppId(Integer channelAppId) {
		this.channelAppId = channelAppId;
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

	public Date getLeftDate() {
		return leftDate;
	}

	public void setLeftDate(Date leftDate) {
		this.leftDate = leftDate;
	}

	public Date getRightDate() {
		return rightDate;
	}

	public void setRightDate(Date rightDate) {
		this.rightDate = rightDate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChannelAppName() {
		return channelAppName;
	}

	public void setChannelAppName(String channelAppName) {
		this.channelAppName = channelAppName;
	}

	public int getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(int feeValue) {
		this.feeValue = feeValue;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalSuc() {
		return totalSuc;
	}

	public void setTotalSuc(long totalSuc) {
		this.totalSuc = totalSuc;
	}

	public long getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

}
