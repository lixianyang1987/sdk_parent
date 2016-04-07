package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncSzzb  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String linkid;

    private String msg;

    private String mobile;

    private String spnumber;

    private Date createtime;

    private String ip;

    private String ext;

    private String provinceName;

    private String fee;

    private String status;

    private String syncAllId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(String syncAllId) {
        this.syncAllId = syncAllId;
    }
}
