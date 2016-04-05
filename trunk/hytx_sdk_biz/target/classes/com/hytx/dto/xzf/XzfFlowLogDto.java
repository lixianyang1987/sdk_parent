package com.hytx.dto.xzf;

import com.hytx.model.xzf.XzfFlowLog;

public class XzfFlowLogDto extends XzfFlowLog {
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;

	private String mobile;
	private String userName;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
