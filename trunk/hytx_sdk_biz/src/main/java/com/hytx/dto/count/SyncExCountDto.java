package com.hytx.dto.count;

import java.io.Serializable;
import java.util.Date;

public class SyncExCountDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 查询条件
	 */
	private Integer channelAppId;
	private Integer reduceStatus;
	private String startDate;
	private String endDate;
	private Date leftDate;
	private Date rightDate;
	private Integer dsjs;
	private Integer dxjs;
	private Integer spId;
	private Integer appId;
	private Integer channelId;	
	
	/**
	 * 展现数据
	 */
	
	private String dsjsName;
	private String dxjsName;
	
	private String spName;
	private String channelName;
	private String appName;
	private String date;
	private String channelAppName;
	private int feeValue;
	private String mobile;
	private Date createTime;
	private int downStatus;
	private int feeStatus;
	private int totalUsers;
	private int syncStatus;
	private int upCount;
	private int downCount;
	private int sucCount;
	private int syncedCount;
	private int reduceCount;
	private int totalFeeValue;
	private int reducePercent;
	private String province;
	

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getDsjs() {
		return dsjs;
	}

	public void setDsjs(Integer dsjs) {
		if(dsjs==1){
			this.dsjsName="周结算";
			
		}else{
			this.dsjsName="月结算";
		}
		this.dsjs = dsjs;
	}

	public String getDsjsName() {
		
		
		return dsjsName;
	}

	public void setDsjsName(String dsjsName) {
		this.dsjsName = dsjsName;
	}

	public String getDxjsName() {
		
		
		return dxjsName;
	}

	public void setDxjsName(String dxjsName) {
		this.dxjsName = dxjsName;
	}

	public Integer getDxjs() {
		return dxjs;
	}

	public void setDxjs(Integer dxjs) {
		if(dxjs==1){
			this.dxjsName="周结算";
			
		}else{
			this.dxjsName="月结算";
		}
		this.dxjs = dxjs;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
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

	public Integer getChannelAppId() {
		return channelAppId;
	}

	public void setChannelAppId(Integer channelAppId) {
		this.channelAppId = channelAppId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getDownStatus() {
		return downStatus;
	}

	public void setDownStatus(int downStatus) {
		this.downStatus = downStatus;
	}

	public int getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(int feeStatus) {
		this.feeStatus = feeStatus;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public int getSucCount() {
		return sucCount;
	}

	public void setSucCount(int sucCount) {
		this.sucCount = sucCount;
	}

	public int getReduceCount() {
		return reduceCount;
	}

	public void setReduceCount(int reduceCount) {
		this.reduceCount = reduceCount;
	}

	public int getTotalFeeValue() {
		if (totalFeeValue < 1) {
			totalFeeValue = sucCount * feeValue / 100;
		}
		return totalFeeValue;
	}

	public void setTotalFeeValue(int totalFeeValue) {
		this.totalFeeValue = totalFeeValue;
	}

	public int getReducePercent() {
		return reducePercent;
	}

	public void setReducePercent(int reducePercent) {
		this.reducePercent = reducePercent;
	}

	public int getSyncedCount() {
		return syncedCount;
	}

	public void setSyncedCount(int syncedCount) {
		this.syncedCount = syncedCount;
	}

	public int getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(int syncStatus) {
		this.syncStatus = syncStatus;
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

	public Integer getSpId() {
		return spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	

}
