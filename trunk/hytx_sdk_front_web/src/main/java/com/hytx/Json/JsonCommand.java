package com.hytx.Json;

public class JsonCommand {
	private Long commandId;
	private int waitSeconds = 0;// 指令发送间隔时间

	private String ensureNum;
	private String ensureContent;
	private String moNum;
	private String moContent;

	public Long getCommandId() {
		return commandId;
	}

	public void setCommandId(Long commandId) {
		this.commandId = commandId;
	}

	public String getMoNum() {
		return moNum;
	}

	public void setMoNum(String moNum) {
		this.moNum = moNum;
	}

	public String getMoContent() {
		return moContent;
	}

	public void setMoContent(String moContent) {
		this.moContent = moContent;
	}

	public int getWaitSeconds() {
		return waitSeconds;
	}

	public void setWaitSeconds(int waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	public String getEnsureContent() {
		return ensureContent;
	}

	public void setEnsureContent(String ensureContent) {
		this.ensureContent = ensureContent;
	}

	public String getEnsureNum() {
		return ensureNum;
	}

	public void setEnsureNum(String ensureNum) {
		this.ensureNum = ensureNum;
	}

}
