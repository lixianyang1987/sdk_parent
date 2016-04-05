package com.hytx.Json;

public class JsonRespKeyword {
	private String mtNum;
	private String mtContent;

	public JsonRespKeyword(String mtNum, String mtContent) {
		this.mtContent = mtContent;
		this.mtNum = mtNum;
	}

	public String getMtNum() {
		return mtNum;
	}

	public void setMtNum(String mtNum) {
		this.mtNum = mtNum;
	}

	public String getMtContent() {
		return mtContent;
	}

	public void setMtContent(String mtContent) {
		this.mtContent = mtContent;
	}

	@Override
	public boolean equals(Object obj) {
		JsonRespKeyword jrk = (JsonRespKeyword) obj;
		if (this.mtNum == null && jrk.getMtNum() != null) {
			return false;
		}
		if (this.mtContent == null && jrk.getMtContent() != null) {
			return false;
		}
		if (this.mtNum != null && this.mtContent != null) {
			return this.mtNum.equals(jrk.getMtNum())
					&& this.mtContent.equals(jrk.getMtContent());
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		if (this.mtNum == null || this.mtContent == null) {
			return super.hashCode();
		}
		return this.mtNum.hashCode() + this.mtContent.hashCode();
	}

}
