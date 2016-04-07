package com.hytx.Json;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.hytx.util.JsonMapper;
import com.hytx.util.MD5;

public class JsonReqSms extends JsonSdkReqBase {
	private String payCode;// 计费代码
	@NotBlank
	@Length(min = 1, max = 36)
	private String orderId; // 订单号
	@Range(min = 0, max = 100000)
	@NotNull
	private Integer feeValue;// 支付金额（分）
	@Range(min = 1, max = 2)
	@NotNull
	private Integer feeType;// 计费类型，1按次 2包月

	private String province;

	private String imei;

	private String longitude;

	private String latitude;

	private int bsclac;
	private int bsccid;

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(Integer feeValue) {
		this.feeValue = feeValue;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

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
		builder.append(this.extraInfo);
		builder.append("|");
		builder.append(this.iccid);
		builder.append("|");
		builder.append(this.payCode);
		builder.append("|");
		builder.append(this.orderId);
		builder.append("|");
		builder.append(this.feeValue);
		builder.append("|");
		builder.append(this.feeType);
		builder.append("|");
		builder.append(encryKey);
		return MD5.getMD5(builder.toString());
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return JsonMapper.toLogJson(this).toString();
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
