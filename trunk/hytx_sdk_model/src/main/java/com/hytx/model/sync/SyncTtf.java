package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncTtf  implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cpid;
	
    public int getCpid() {
		return cpid;
	}

	public void setCpid(int cpid) {
		this.cpid = cpid;
	}

	private Long id;

    private Long orderno;

    private Short opid;

    private Long appid;

    private Long imsi;

    private Short fee;

    private String channelid;

    private String exdata;

    private String region;

    private String resultcode;

    private String resultdesc;

    private Date createtime;

    private String rpttime;

    private String syncAllId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderno() {
        return orderno;
    }

    public void setOrderno(Long orderno) {
        this.orderno = orderno;
    }

    public Short getOpid() {
        return opid;
    }

    public void setOpid(Short opid) {
        this.opid = opid;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public Long getImsi() {
        return imsi;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public Short getFee() {
        return fee;
    }

    public void setFee(Short fee) {
        this.fee = fee;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getExdata() {
        return exdata;
    }

    public void setExdata(String exdata) {
        this.exdata = exdata;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultdesc() {
        return resultdesc;
    }

    public void setResultdesc(String resultdesc) {
        this.resultdesc = resultdesc;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRpttime() {
        return rpttime;
    }

    public void setRpttime(String rpttime) {
        this.rpttime = rpttime;
    }

    public String getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(String syncAllId) {
        this.syncAllId = syncAllId;
    }
}
