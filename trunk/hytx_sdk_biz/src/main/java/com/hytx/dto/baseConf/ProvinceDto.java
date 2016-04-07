package com.hytx.dto.baseConf;

import java.io.Serializable;
import com.hytx.model.baseConf.Province;

public class ProvinceDto extends Province  implements Serializable {
	private static final long serialVersionUID = 1L;

	private int refId;

	private long dayLimit;
	
	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public long getDayLimit() {
		return dayLimit;
	}

	public void setDayLimit(long dayLimit) {
		this.dayLimit = dayLimit;
	}
	
}
