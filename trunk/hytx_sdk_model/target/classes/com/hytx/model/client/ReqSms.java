package com.hytx.model.client;

import java.io.Serializable;
import java.util.Date;

public class ReqSms  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String orderId;

    private String sdkVersion;

    private Integer channelId;

    private Integer appId;

    private String channelAppKey;

    private String payCode;

    private Integer feeValue;

    private Integer feeType;

    private String imsi;

    private String extraInfo;

    private Integer status;

    private Date updateDt;

    private Integer provinceId;

    private Integer payPointId;

    private String ip;

    private String iccid;

    private Integer serverType;

    private String ua;

    private Integer hasLayout;

    private String ext;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getChannelAppKey() {
        return channelAppKey;
    }

    public void setChannelAppKey(String channelAppKey) {
        this.channelAppKey = channelAppKey;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getPayPointId() {
        return payPointId;
    }

    public void setPayPointId(Integer payPointId) {
        this.payPointId = payPointId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public Integer getHasLayout() {
        return hasLayout;
    }

    public void setHasLayout(Integer hasLayout) {
        this.hasLayout = hasLayout;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
