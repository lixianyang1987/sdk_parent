package com.hytx.model.client;

import java.io.Serializable;
public class SdkInfo  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String imsi;

    private Long mobile;

    private String iccid;

    private String imei;

    private String dateTime;

    private String smsPort;

    private String ext1;

    private String ext2;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSmsPort() {
        return smsPort;
    }

    public void setSmsPort(String smsPort) {
        this.smsPort = smsPort;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }
}
