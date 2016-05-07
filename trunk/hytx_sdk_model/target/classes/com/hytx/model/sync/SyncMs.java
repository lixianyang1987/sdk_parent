package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncMs  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String linkid;

    private String spId;

    private String phone;

    private String moCode;

    private Date createtime;

    private String ip;

    private Integer syncStatus;

    private String status;

    private Integer reduceStatus;

    private Integer coopid;

    private String moContent;

    private String mrContent;

    private Integer channelAppId;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMoCode() {
        return moCode;
    }

    public void setMoCode(String moCode) {
        this.moCode = moCode;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(Integer reduceStatus) {
        this.reduceStatus = reduceStatus;
    }

    public Integer getCoopid() {
        return coopid;
    }

    public void setCoopid(Integer coopid) {
        this.coopid = coopid;
    }

    public String getMoContent() {
        return moContent;
    }

    public void setMoContent(String moContent) {
        this.moContent = moContent;
    }

    public String getMrContent() {
        return mrContent;
    }

    public void setMrContent(String mrContent) {
        this.mrContent = mrContent;
    }

    public Integer getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(Integer channelAppId) {
        this.channelAppId = channelAppId;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SyncMs [linkid=");
		builder.append(linkid);
		builder.append(", spId=");
		builder.append(spId);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", moCode=");
		builder.append(moCode);
		builder.append(", createtime=");
		builder.append(createtime);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", syncStatus=");
		builder.append(syncStatus);
		builder.append(", status=");
		builder.append(status);
		builder.append(", reduceStatus=");
		builder.append(reduceStatus);
		builder.append(", coopid=");
		builder.append(coopid);
		builder.append(", moContent=");
		builder.append(moContent);
		builder.append(", mrContent=");
		builder.append(mrContent);
		builder.append(", channelAppId=");
		builder.append(channelAppId);
		builder.append("]");
		return builder.toString();
	}
    
}
