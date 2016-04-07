package com.hytx.dto.count;

import java.io.Serializable;
public class PropOrderCountDto  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 查询条件
	 */
	private Integer appId;
	private Integer provinceId;
	private Integer channelId;
	private Integer reduceStatus;
	private String  startDate;
	private String  endDate;
	/**
	 * 展现数据
	 */
	private String date;
	private String provinceName;
	private String channelName;
	private String propName;
	private String appName;
	private int  price;
	private long upNums;
	private long upUsers;
	private long orderNums;
	private long orderSucNums;
	private long orderFailNums;
	private long countPrice;
	private String payCode;

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

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getUpNums() {
		return upNums;
	}

	public void setUpNums(long upNums) {
		this.upNums = upNums;
	}

	public long getUpUsers() {
		return upUsers;
	}

	public void setUpUsers(long upUsers) {
		this.upUsers = upUsers;
	}

	public long getOrderNums() {
		return orderNums;
	}

	public void setOrderNums(long orderNums) {
		this.orderNums = orderNums;
	}

	public long getOrderSucNums() {
		return orderSucNums;
	}

	public void setOrderSucNums(long orderSucNums) {
		this.orderSucNums = orderSucNums;
	}

	public long getOrderFailNums() {
		return orderFailNums;
	}

	public void setOrderFailNums(long orderFailNums) {
		this.orderFailNums = orderFailNums;
	}

	public long getCountPrice() {
		return countPrice;
	}

	public void setCountPrice(long countPrice) {
		this.countPrice = countPrice;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

	
}
