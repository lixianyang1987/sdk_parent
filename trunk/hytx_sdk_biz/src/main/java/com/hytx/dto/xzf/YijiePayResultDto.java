package com.hytx.dto.xzf;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.hytx.constance.BaseContance;
import com.hytx.model.xzf.XzfYijieResult;
import com.hytx.util.MD5;

public class YijiePayResultDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String app;
	private String cbi;
	private long ct;
	private int fee;
	private long pt;
	private String sdk;
	private String ssid;
	private String tcd;
	private String uid;
	private String ver;
	private int st;
	private String sign;

	public String caculateSign(String key) {
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("app", this.app);
		map.put("cbi", this.cbi);
		map.put("ct", this.ct);
		map.put("fee", this.fee);
		map.put("pt", this.pt);
		map.put("sdk", this.sdk);
		map.put("ssid", this.ssid);
		map.put("tcd", this.tcd);
		map.put("uid", this.uid);
		map.put("ver", this.ver);
		map.put("st", this.st);

		StringBuilder builder = new StringBuilder(500);
		Object value = null;
		for (Entry<String, Object> e : map.entrySet()) {
			value = e.getValue();
			if (builder.length() > 0) {
				builder.append("&");
			}
			if (value == null) {
				builder.append(e.getKey()).append("=");
			} else {
				builder.append(e.getKey()).append("=").append(value.toString());
			}
		}
		builder.append(key);
		return MD5.getMD5(builder.toString());
	}

	/***
	 * 参数校验
	 * 
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	public boolean valid() {
		if (this.sign == null) {
			return true;
		}
		String str = this.caculateSign(BaseContance.YIJIE_KEY);
		return sign.equals(str);
	}

	public String getApp() {
		return app;
	}

	/****
	 * 构建数据数实体对象
	 * 
	 * @return
	 * @author houzz
	 * @date 2016年1月13日
	 */
	public XzfYijieResult bulidXzfYijieResultEntity() {
		XzfYijieResult yijieResult = new XzfYijieResult();
		yijieResult.setApp(this.app);
		yijieResult.setCompleteTime(this.ct);
		yijieResult.setCreateDt(new Date());
		yijieResult.setFee(this.fee);
		yijieResult.setOrderId(this.cbi);
		yijieResult.setPayTime(this.pt);
		yijieResult.setSdk(this.sdk);
		yijieResult.setSsid(this.ssid);
		yijieResult.setStatus(this.st);
		yijieResult.setTcd(this.tcd);
		yijieResult.setUin(this.uid);
		yijieResult.setVersionNum(this.ver);
		return yijieResult;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getCbi() {
		return cbi;
	}

	public void setCbi(String cbi) {
		this.cbi = cbi;
	}

	public long getCt() {
		return ct;
	}

	public void setCt(long ct) {
		this.ct = ct;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public long getPt() {
		return pt;
	}

	public void setPt(long pt) {
		this.pt = pt;
	}

	public String getSdk() {
		return sdk;
	}

	public void setSdk(String sdk) {
		this.sdk = sdk;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getTcd() {
		return tcd;
	}

	public void setTcd(String tcd) {
		this.tcd = tcd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
