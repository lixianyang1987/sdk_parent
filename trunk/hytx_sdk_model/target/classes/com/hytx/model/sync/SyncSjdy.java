package com.hytx.model.sync;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SyncSjdy implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long mobile;

	private String spNumber;

	private String moContent;

	private String linkId;

	private String rptStat;

	private String ip;

	private String spParam;

	private Date updateDt;

	private BigDecimal syncAllId;

	private String provinceName;

	private String cityName;

	private Integer telType;

	private Integer feeCode;

	private String rptTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getSpNumber() {
		return spNumber;
	}

	public void setSpNumber(String spNumber) {
		this.spNumber = spNumber;
	}

	public String getMoContent() {
		return moContent;
	}

	public void setMoContent(String moContent) {
		this.moContent = moContent;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getRptStat() {
		return rptStat;
	}

	public void setRptStat(String rptStat) {
		this.rptStat = rptStat;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSpParam() {
		return spParam;
	}

	public void setSpParam(String spParam) {
		this.spParam = spParam;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public BigDecimal getSyncAllId() {
		return syncAllId;
	}

	public void setSyncAllId(BigDecimal syncAllId) {
		this.syncAllId = syncAllId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getTelType() {
		return telType;
	}

	public void setTelType(Integer telType) {
		this.telType = telType;
	}

	public Integer getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(Integer feeCode) {
		this.feeCode = feeCode;
	}

	public String getRptTime() {
		return rptTime;
	}

	public void setRptTime(String rptTime) {
		this.rptTime = rptTime;
	}
}
