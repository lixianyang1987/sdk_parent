package com.hytx.model.syncEx;

import java.io.Serializable;
import java.util.Date;

public class TActivationVolume implements Serializable {
	private static final long serialVersionUID = 1L;
	private String startDate;
	
	private String endDate;
	
	private Integer id;

	private Date daytime;

	private String channelName;

	private String appName;

	private String cooperationMode;

	private Integer theActivationNums;

	private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDaytime() {
		return daytime;
	}

	public void setDaytime(Date daytime) {
		this.daytime = daytime;
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

	public String getCooperationMode() {
		return cooperationMode;
	}

	public void setCooperationMode(String cooperationMode) {
		this.cooperationMode = cooperationMode;
	}

	public Integer getTheActivationNums() {
		return theActivationNums;
	}

	public void setTheActivationNums(Integer theActivationNums) {
		this.theActivationNums = theActivationNums;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
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
