package com.hytx.model.xzf;

import java.io.Serializable;
import java.util.Date;

public class XzfUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imei;

	private String imsi;

	private String mobile;

	private String name;

	private String idCard;

	private Integer grade;

	private Integer integral;

	private Integer hasCared;

	private Integer debt;

	private Integer creditLevel;

	private Date createDt;

	private Integer channelAppId;

	private Date debtDt;

	private Date payDt;

	private Date shouldPayDt;

	private Integer maxAllowDebt;

	private Date expireDt;

	private boolean payOntime;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getHasCared() {
		return hasCared;
	}

	public void setHasCared(Integer hasCared) {
		this.hasCared = hasCared;
	}

	public Integer getDebt() {
		return debt;
	}

	public void setDebt(Integer debt) {
		this.debt = debt;
	}

	public Integer getCreditLevel() {
		return creditLevel;
	}

	public void setCreditLevel(Integer creditLevel) {
		this.creditLevel = creditLevel;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Integer getChannelAppId() {
		return channelAppId;
	}

	public void setChannelAppId(Integer channelAppId) {
		this.channelAppId = channelAppId;
	}

	public Date getDebtDt() {
		return debtDt;
	}

	public void setDebtDt(Date debtDt) {
		this.debtDt = debtDt;
	}

	public Date getPayDt() {
		return payDt;
	}

	public void setPayDt(Date payDt) {
		this.payDt = payDt;
	}

	public Date getShouldPayDt() {
		return shouldPayDt;
	}

	public void setShouldPayDt(Date shouldPayDt) {
		this.shouldPayDt = shouldPayDt;
	}

	public Integer getMaxAllowDebt() {
		return maxAllowDebt;
	}

	public void setMaxAllowDebt(Integer maxAllowDebt) {
		this.maxAllowDebt = maxAllowDebt;
	}

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public boolean isPayOntime() {
		if (this.expireDt != null) {
			payOntime = this.expireDt.getTime() > System.currentTimeMillis();
		}
		return payOntime;
	}

	public void setPayOntime(boolean payOntime) {
		this.payOntime = payOntime;
	}

}
