package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class MobileSync implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String telno;

	private String mo;

	private String dest;

	private String stat;

	private String errorcode;

	private String linkid;

	private String province;

	private String mttime;

	private Date updateDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMo() {
		return mo;
	}

	public void setMo(String mo) {
		this.mo = mo;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getMttime() {
		return mttime;
	}

	public void setMttime(String mttime) {
		this.mttime = mttime;
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
		builder.append("telno:").append(this.telno).append("\n")
				.append("telno:").append(this.telno).append("\n").append("mo:")
				.append(this.mo).append("\n").append("dest:").append(this.dest)
				.append("\n").append("stat:").append(this.stat).append("\n")
				.append("errorcode:").append(this.errorcode).append("\n")
				.append("linkid:").append(this.linkid).append("\n")
				.append("province:").append(this.province).append("\n")
				.append("mttime:").append(this.mttime).append("\n");
		return builder.toString();
	}
}
