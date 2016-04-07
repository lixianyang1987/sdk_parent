package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class Tsyskmm  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String orderId;

    private Integer fee;

    private String ext;

    private String time;

    private String province;

    private Date createtime;

    private Integer coopid;

    private Integer channelAppId;

    private Integer reduceStatus;

    private Integer syncStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
