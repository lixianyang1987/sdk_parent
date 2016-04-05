package com.hytx.Json;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.hytx.util.JsonMapper;
import com.hytx.util.MD5;

public class JsonReqXinPaySms extends JsonSdkReqBase {
private String	sign;
private String	sdkVersion;
private String	channelAppKey;
private String	imsi;
private String	imei;
private String	extraInfo;
private String	province;

	
	
	
	
	

	/****
	 * 根据加密密钥返回加密后的数字签名
	 */
	@Override
	public String getColculateSign(String encryKey) {
		StringBuilder builder = new StringBuilder();
		builder.append(this.sdkVersion);
		builder.append("|");
		builder.append(this.channelAppKey);
		builder.append("|");
		builder.append(this.imsi);		
		builder.append("|");
		builder.append(this.imei);
		builder.append("|");
		builder.append(this.extraInfo);	
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}
	@Override
	public String toString() {
		return JsonMapper.toLogJson(this).toString();
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSdkVersion() {
		return sdkVersion;
	}
	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}
	public String getChannelAppKey() {
		return channelAppKey;
	}
	public void setChannelAppKey(String channelAppKey) {
		this.channelAppKey = channelAppKey;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getImei() {
		return imei;
	}







	public void setImei(String imei) {
		this.imei = imei;
	}







	public String getExtraInfo() {
		return extraInfo;
	}







	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}







	public String getProvince() {
		return province;
	}







	public void setProvince(String province) {
		this.province = province;
	}

	

}
