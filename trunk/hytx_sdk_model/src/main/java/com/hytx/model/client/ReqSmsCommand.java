package com.hytx.model.client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReqSmsCommand implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String orderId;

	private Integer operateId;

	private String moNum;

	private String moContent;

	private Integer sendStatus;

	private Integer sendTimes;

	private Date updateDt;

	private Integer feeValue;

	private Integer appId;

	private Integer payPointId;

	private Integer waitSeconds;

	private Integer controlFlag;

	private String twoEnsure;

	private Integer serverType;

	private Integer provinceId;

	private BigDecimal ensureNum;

	private Integer serialNum;

	private Integer ensureStatus;

	private Integer hasLayout;

	private String ext;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public String getMoNum() {
		return moNum;
	}

	public void setMoNum(String moNum) {
		this.moNum = moNum;
	}

	public String getMoContent() {
		return moContent;
	}

	public void setMoContent(String moContent) {
		this.moContent = moContent;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public Integer getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(Integer feeValue) {
		this.feeValue = feeValue;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getPayPointId() {
		return payPointId;
	}

	public void setPayPointId(Integer payPointId) {
		this.payPointId = payPointId;
	}

	public Integer getWaitSeconds() {
		return waitSeconds;
	}

	public void setWaitSeconds(Integer waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	public Integer getControlFlag() {
		return controlFlag;
	}

	public void setControlFlag(Integer controlFlag) {
		this.controlFlag = controlFlag;
	}

	public String getTwoEnsure() {
		return twoEnsure;
	}

	public void setTwoEnsure(String twoEnsure) {
		this.twoEnsure = twoEnsure;
	}

	public Integer getServerType() {
		return serverType;
	}

	public void setServerType(Integer serverType) {
		this.serverType = serverType;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public BigDecimal getEnsureNum() {
		return ensureNum;
	}

	public void setEnsureNum(BigDecimal ensureNum) {
		this.ensureNum = ensureNum;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	public Integer getEnsureStatus() {
		return ensureStatus;
	}

	public void setEnsureStatus(Integer ensureStatus) {
		this.ensureStatus = ensureStatus;
	}

	public Integer getHasLayout() {
		return hasLayout;
	}

	public void setHasLayout(Integer hasLayout) {
		this.hasLayout = hasLayout;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
}
