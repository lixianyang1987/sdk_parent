package com.hytx.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class root {
// 
	private String ENV_CgiName;
	private String ENV_ClientAgent;
	private String ENV_ClientIp;
	private String ENV_QueryString;
	private String ENV_RequestMethod;
	private String ENV_referer;
	private String chgmobile;
	private String city;
	private String province;
	private String retcode;
	private String retmsg;
	private String supplier;
	private String tid;
	public String getENV_CgiName() {
		return ENV_CgiName;
	}
	public void setENV_CgiName(String eNV_CgiName) {
		ENV_CgiName = eNV_CgiName;
	}
	public String getENV_ClientAgent() {
		return ENV_ClientAgent;
	}
	public void setENV_ClientAgent(String eNV_ClientAgent) {
		ENV_ClientAgent = eNV_ClientAgent;
	}
	public String getENV_ClientIp() {
		return ENV_ClientIp;
	}
	public void setENV_ClientIp(String eNV_ClientIp) {
		ENV_ClientIp = eNV_ClientIp;
	}
	public String getENV_QueryString() {
		return ENV_QueryString;
	}
	public void setENV_QueryString(String eNV_QueryString) {
		ENV_QueryString = eNV_QueryString;
	}
	public String getENV_RequestMethod() {
		return ENV_RequestMethod;
	}
	public void setENV_RequestMethod(String eNV_RequestMethod) {
		ENV_RequestMethod = eNV_RequestMethod;
	}
	public String getENV_referer() {
		return ENV_referer;
	}
	public void setENV_referer(String eNV_referer) {
		ENV_referer = eNV_referer;
	}
	public String getChgmobile() {
		return chgmobile;
	}
	public void setChgmobile(String chgmobile) {
		this.chgmobile = chgmobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public root() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("root [ENV_CgiName=");
		builder.append(ENV_CgiName);
		builder.append(", ENV_ClientAgent=");
		builder.append(ENV_ClientAgent);
		builder.append(", ENV_ClientIp=");
		builder.append(ENV_ClientIp);
		builder.append(", ENV_QueryString=");
		builder.append(ENV_QueryString);
		builder.append(", ENV_RequestMethod=");
		builder.append(ENV_RequestMethod);
		builder.append(", ENV_referer=");
		builder.append(ENV_referer);
		builder.append(", chgmobile=");
		builder.append(chgmobile);
		builder.append(", city=");
		builder.append(city);
		builder.append(", province=");
		builder.append(province);
		builder.append(", retcode=");
		builder.append(retcode);
		builder.append(", retmsg=");
		builder.append(retmsg);
		builder.append(", supplier=");
		builder.append(supplier);
		builder.append(", tid=");
		builder.append(tid);
		builder.append("]");
		return builder.toString();
	}
	
}
