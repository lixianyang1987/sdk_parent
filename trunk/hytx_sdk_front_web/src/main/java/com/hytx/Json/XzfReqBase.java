package com.hytx.Json;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.hytx.util.JsonMapper;

public abstract class XzfReqBase {
	@NotBlank
	protected String channelAppKey; // 渠道包key
	@NotBlank
	protected String sdkVersion;// 版本号
	@NotBlank
	@Length(min = 32, max = 32)
	protected String sign;// 数据签名
	@NotBlank
	protected String imsi;// 用户imsi号
	@NotBlank
	protected String imei;// 用户imei号

	protected String extraInfo;// 扩展信息

	private String ip;

	protected Map<String, String> properties = new HashMap<String, String>();

	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	public String getChannelAppKey() {
		return channelAppKey;
	}

	public void setChannelAppKey(String channelAppKey) {
		this.channelAppKey = channelAppKey;
	}

	public String getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	/****
	 * 根据加密密钥返回加密后的数字签名
	 */
	public abstract String getColculateSign(String encryKey);

	public boolean validSign(String key) {
		String serverSign = getColculateSign(key);
		if (serverSign.equals(this.sign)) {
			return true;
		}
		return false;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	@Override
	public String toString() {
		return JsonMapper.toLogJson(this).toString();
	}

}
