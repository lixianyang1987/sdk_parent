package com.hytx.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SyncAppOrderResp")
public class SyncAppOrderResp implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement
	private String TransactionID;
	@XmlElement
	private String hRet;

	public String getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}

	public String gethRet() {
		return hRet;
	}

	public void sethRet(String hRet) {
		this.hRet = hRet;
	}
}
