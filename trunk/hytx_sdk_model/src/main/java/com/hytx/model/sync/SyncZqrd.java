package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncZqrd  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String linkid;

    private String mobile;

    private String spnumber;

    private String content;

    private String state;

    private Date createtime;

    private Integer coopid;

    private Integer syncStatus;

    private Integer reduceStatus;

    private String reqContent;

    private Integer channelappid;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpnumber() {
        return spnumber;
    }

    public void setSpnumber(String spnumber) {
        this.spnumber = spnumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent;
    }

    public Integer getChannelappid() {
        return channelappid;
    }

    public void setChannelappid(Integer channelappid) {
        this.channelappid = channelappid;
    }
}
