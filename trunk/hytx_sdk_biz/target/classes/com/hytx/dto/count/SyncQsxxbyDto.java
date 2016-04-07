package com.hytx.dto.count;

import com.hytx.model.sync.SyncQsxxby;

public class SyncQsxxbyDto extends SyncQsxxby {
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;

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
