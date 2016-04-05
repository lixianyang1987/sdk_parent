package com.hytx.dto.xzf;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.hytx.model.xzf.XzfUser;

public class XzfUserInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imei;

	private String name;

	private Integer grade;

	private Integer integral;

	private Integer hasCared;

	private Integer debt;

	private Integer creditLevel;
	@JsonIgnore
	private Date debtDt;
	@JsonIgnore
	private Date expireDt;

	private boolean payOntime;

	public XzfUserInfoDto() {
	}

	public XzfUserInfoDto(XzfUser user) {
		this.creditLevel = user.getCreditLevel();
		this.debt = user.getDebt();
		this.debtDt = user.getDebtDt();
		this.expireDt = user.getExpireDt();
		this.grade = user.getGrade();
		this.hasCared = user.getHasCared();
		this.imei = user.getImei();
		this.integral = user.getIntegral();
		this.name = user.getName();
	}

	public boolean isPayOntime() {
		if (this.expireDt != null) {
			payOntime = this.expireDt.getTime() > System.currentTimeMillis();
		}
		return payOntime;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDebtDt() {
		return debtDt;
	}

	public void setDebtDt(Date debtDt) {
		this.debtDt = debtDt;
	}

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public void setPayOntime(boolean payOntime) {
		this.payOntime = payOntime;
	}

}
