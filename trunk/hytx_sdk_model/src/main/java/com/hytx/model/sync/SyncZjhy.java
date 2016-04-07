package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncZjhy  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private String linkid;

    private String message;

    private String phone;

    private String spnumber;

    private Date createtime;

    private String ip;

    private String cpparam;

    private String provinceName;

    private String cityName;

    private String rptStat;

    private String syncAllId;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRptStat() {
        return rptStat;
    }

    public void setRptStat(String rptStat) {
        this.rptStat = rptStat;
    }

    public String getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(String syncAllId) {
        this.syncAllId = syncAllId;
    }
}
