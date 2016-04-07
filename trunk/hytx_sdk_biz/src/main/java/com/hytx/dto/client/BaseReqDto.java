package com.hytx.dto.client;

import java.io.Serializable;

import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.ChannelApp;

public class BaseReqDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private App app;
	private ChannelApp channelApp;
	private Integer serverType;// 运营商
	private String imsi;// 用户imsi号
	private String extraInfo;// 扩展信息
	private String sdkVersion;// 版本号
	private Integer provinceId;

	private String imei;

	private String longitude;

	private String latitude;

	private int bsclac;// 位置区域码
	private int bsccid;// 基站编号；

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public ChannelApp getChannelApp() {
		return channelApp;
	}

	public void setChannelApp(ChannelApp channelApp) {
		this.channelApp = channelApp;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public Integer getServerType() {
		return serverType;
	}

	public void setServerType(Integer serverType) {
		this.serverType = serverType;
	}

	public static void main(String[] args) {
		System.out.println((1 << 30) / (1024 * 1024));
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getBsclac() {
		return bsclac;
	}

	public void setBsclac(int bsclac) {
		this.bsclac = bsclac;
	}

	public int getBsccid() {
		return bsccid;
	}

	public void setBsccid(int bsccid) {
		this.bsccid = bsccid;
	}

}
