package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncSzxty  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private String linkid;

    private Date createtime;

    private String ip;

    private String cpparam;

    private String provinceName;

    private String syncAllId;

    private String dttime;

    private String mobile;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
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

    public String getCpparam() {
        return cpparam;
    }

    public void setCpparam(String cpparam) {
        this.cpparam = cpparam;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(String syncAllId) {
        this.syncAllId = syncAllId;
    }

    public String getDttime() {
        return dttime;
    }

    public void setDttime(String dttime) {
        this.dttime = dttime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
