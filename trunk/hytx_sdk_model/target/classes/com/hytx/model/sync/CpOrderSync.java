package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class CpOrderSync implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long mobile;

	private Integer sendtype;

	private String gageid;

	private String mo;

	private String key;

	private String spnumber;

	private Integer feecode;

	private Integer spcode;

	private String ip;

	private Date updateDt;

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

	public Integer getSendtype() {
		return sendtype;
	}

	public void setSendtype(Integer sendtype) {
		this.sendtype = sendtype;
	}

	public String getGageid() {
		return gageid;
	}

	public void setGageid(String gageid) {
		this.gageid = gageid;
	}

	public String getMo() {
		return mo;
	}

	public void setMo(String mo) {
		this.mo = mo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSpnumber() {
		return spnumber;
	}

	public void setSpnumber(String spnumber) {
		this.spnumber = spnumber;
	}

	public Integer getFeecode() {
		return feecode;
	}

	public void setFeecode(Integer feecode) {
		this.feecode = feecode;
	}

	public Integer getSpcode() {
		return spcode;
	}

	public void setSpcode(Integer spcode) {
		this.spcode = spcode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("mobile:").append(this.mobile).append("\n")
				.append("sendtype:").append(this.sendtype).append("\n")
				.append("mo:").append(this.mo).append("\n").append("gageid:")
				.append(this.gageid).append("\n").append("key:")
				.append(this.key).append("\n").append("spnumber:")
				.append(this.spnumber).append("\n").append("feecode:")
				.append(this.feecode).append("\n").append("spcode:")
				.append(this.spcode).append("\n");
		return builder.toString();
	}
}
