package com.hytx.model.syncEx;

import java.io.Serializable;
import java.util.Date;

public class TsyncexSky  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String linkid;

    private Integer status;

    private String phonenum;

    private Integer price;

    private String ext;

    private Integer syncStatus;

    private Integer reduceStatus;

    private Long channelAppId;

    private Date createtime;

    private Integer coopId;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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

    public Long getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(Long channelAppId) {
        this.channelAppId = channelAppId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCoopId() {
        return coopId;
    }

    public void setCoopId(Integer coopId) {
        this.coopId = coopId;
    }
}
