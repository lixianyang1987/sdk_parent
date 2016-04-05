package com.hytx.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SyncAppOrderReq")
@XmlType(name = "SyncAppOrderReq")
public class AppOrderReq {
	private Long id;
	@XmlElement(name = "TransactionID")
	private String transactionId;
	@XmlElement(name = "Result")
	private String result;
	@XmlElement(name = "ResultDesc")
	private String resultDesc;
	@XmlElement(name = "ActionTime")
	private String actionTime;
	@XmlElement(name = "UserID")
	private String userId;
	@XmlElement(name = "Mo")
	private String mo;
	@XmlElement(name = "Dest")
	private String dest;
	@XmlElement(name = "Province")
	private String province;
	@XmlElement(name = "AppID")
	private String appId;
	@XmlElement(name = "PayCode")
	private String payCode;
	@XmlElement(name = "Price")
	private Long price;
	@XmlElement(name = "OrderId")
	private String orderId;
	@XmlElement(name = "CPParam")
	private String cpParam;
	@XmlElement(name = "Operate")
	private Integer operate;
	@XmlElement(name = "hRet")
	private String hret;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCpParam() {
		return cpParam;
	}

	public void setCpParam(String cpParam) {
		this.cpParam = cpParam;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public String getHret() {
		return hret;
	}

	public void setHret(String hret) {
		this.hret = hret;
	}

}
