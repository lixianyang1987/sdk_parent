package com.hytx.dto.baseConf;

import java.io.Serializable;

import com.hytx.model.baseConf.Operate;

public class OperateDto extends Operate implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer provinceId;

	private Integer refRecordId;

	public Integer getRefRecordId() {
		return refRecordId;
	}

	public void setRefRecordId(Integer refRecordId) {
		this.refRecordId = refRecordId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

}
