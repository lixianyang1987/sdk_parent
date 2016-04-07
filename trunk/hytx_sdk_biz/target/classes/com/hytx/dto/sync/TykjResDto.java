package com.hytx.dto.sync;

import java.io.Serializable;

public class TykjResDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resultCode;
	
	private String resultDesc;
	
	private String moNum;
	
	private String mtNum;
	
	private String moContent;
	
	private String mtContent;
	
	private String operator;
	
	private String operName;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getMoNum() {
		return moNum;
	}

	public void setMoNum(String moNum) {
		this.moNum = moNum;
	}

	public String getMtNum() {
		return mtNum;
	}

	public void setMtNum(String mtNum) {
		this.mtNum = mtNum;
	}

	public String getMoContent() {
		return moContent;
	}

	public void setMoContent(String moContent) {
		this.moContent = moContent;
	}

	public String getMtContent() {
		return mtContent;
	}

	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}
	
	

}
