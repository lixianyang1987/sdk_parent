package com.hytx.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.hytx.util.JsonMapper;

public class JsonRespSms {
	private String resultCode;// 状态码
	private boolean controlFlag;// 是否弹窗二次确认
	private Set<JsonRespKeyword> keywords;// 屏蔽关键字
	private List<JsonCommand> commandList = new ArrayList<JsonCommand>();// 短串集

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Set<JsonRespKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<JsonRespKeyword> keywords) {
		this.keywords = keywords;
	}

	public List<JsonCommand> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<JsonCommand> commandList) {
		this.commandList = commandList;
	}

	public boolean isControlFlag() {
		return controlFlag;
	}

	public void setControlFlag(boolean controlFlag) {
		this.controlFlag = controlFlag;
	}

	@Override
	public String toString() {
		return JsonMapper.toLogJson(this).toString();
	}
}
