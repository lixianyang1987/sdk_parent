package com.hytx.model.sync;

import java.io.Serializable;
public class SyncSzqcReq  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String cpid;

    private String imsi;

    private String imei;

    private String fee;

    private String ext;

    private String ip;

    private String province;

    private String gpslng;

    private String gpslat;

    private String bsclac;

    private String bsccid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGpslng() {
        return gpslng;
    }

    public void setGpslng(String gpslng) {
        this.gpslng = gpslng;
    }

    public String getGpslat() {
        return gpslat;
    }

    public void setGpslat(String gpslat) {
        this.gpslat = gpslat;
    }

    public String getBsclac() {
        return bsclac;
    }

    public void setBsclac(String bsclac) {
        this.bsclac = bsclac;
    }

    public String getBsccid() {
        return bsccid;
    }

    public void setBsccid(String bsccid) {
        this.bsccid = bsccid;
    }
}
