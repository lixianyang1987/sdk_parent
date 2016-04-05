package com.hytx.model.syncEx;

import java.io.Serializable;
import java.util.Date;

public class SyncYzf  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String orderId;

    private String fee;

    private String ext;

    private String time;

    private String mobile;

    private Integer channelAppId;

    private Integer syncStatus;

    private Integer reduceStatus;

    private Date createtime;

    private Integer coopid;

    private String province;

    private String spnumber;

    private String msg;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(Integer channelAppId) {
        this.channelAppId = channelAppId;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(Integer reduceStatus) {
        this.reduceStatus = reduceStatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCoopid() {
        return coopid;
    }

    public void setCoopid(Integer coopid) {
        this.coopid = coopid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSpnumber() {
        return spnumber;
    }

    public void setSpnumber(String spnumber) {
        this.spnumber = spnumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
