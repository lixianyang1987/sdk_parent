package com.hytx.dto.sync;

public class Keadm {
	
	private String channelId;
	private int fee;
	private String ip;
	private String extra;
	private String imsi;
	private String gameName;
	private String chargeName;
	private String iccid;
	private String mac;
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getChargeName() {
		return chargeName;
	}
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Keadm [channelId=");
		builder.append(channelId);
		builder.append(", fee=");
		builder.append(fee);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", extra=");
		builder.append(extra);
		builder.append(", imsi=");
		builder.append(imsi);
		builder.append(", gameName=");
		builder.append(gameName);
		builder.append(", chargeName=");
		builder.append(chargeName);
		builder.append(", iccid=");
		builder.append(iccid);
		builder.append(", mac=");
		builder.append(mac);
		builder.append("]");
		return builder.toString();
	}
	public Keadm() {
		super();
	}
	public Keadm(String channelId, int fee, String ip, String extra,
			String imsi, String gameName, String chargeName, String iccid,
			String mac) {
		super();
		this.channelId = channelId;
		this.fee = fee;
		this.ip = ip;
		this.extra = extra;
		this.imsi = imsi;
		this.gameName = gameName;
		this.chargeName = chargeName;
		this.iccid = iccid;
		this.mac = mac;
	}
	
	

}
