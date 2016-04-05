package com.hytx.model.sync;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SyncWydF  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private Long phoneNum;

    private Integer payFee;

    private String orderTime;

    private Integer hret;

    private Date updateDt;

    private BigDecimal syncAllId;

    private String ip;

    private String appInfo;

    private String ext;

    private Integer serverType;

    private String status;

    private Integer channelAppId;

    private Integer reduceStatus;

    private Integer syncStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getPayFee() {
        return payFee;
    }

    public void setPayFee(Integer payFee) {
        this.payFee = payFee;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getHret() {
        return hret;
    }

    public void setHret(Integer hret) {
        this.hret = hret;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public BigDecimal getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(BigDecimal syncAllId) {
        this.syncAllId = syncAllId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(Integer channelAppId) {
        this.channelAppId = channelAppId;
    }

    public Integer getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(Integer reduceStatus) {
        this.reduceStatus = reduceStatus;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }
}
