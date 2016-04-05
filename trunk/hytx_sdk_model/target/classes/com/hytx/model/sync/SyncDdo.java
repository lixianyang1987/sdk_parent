package com.hytx.model.sync;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SyncDdo  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;
    private Map<String,String> paycoeds=new HashMap<String, String>();

    private String uuid;

    private String telno;

    private String mo;

    private String dest;

    private String stat;

    private String errorcode;

    private String linkid;

    private String motime;

    private Integer isreduce;

    private String coopid;

    private Date createtime;

    private String payCode;

    private String appid;

    private String channelAppId;

    private BigDecimal syncStatus;

    private BigDecimal reduceStatus;

    private String province;

    private String city;

    private String cpparam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getMotime() {
        return motime;
    }

    public void setMotime(String motime) {
        this.motime = motime;
    }

    public Integer getIsreduce() {
        return isreduce;
    }

    public void setIsreduce(Integer isreduce) {
        this.isreduce = isreduce;
    }

    public String getCoopid() {
        return coopid;
    }

    public void setCoopid(String coopid) {
        this.coopid = coopid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId;
    }

    public BigDecimal getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(BigDecimal syncStatus) {
        this.syncStatus = syncStatus;
    }

    public BigDecimal getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(BigDecimal reduceStatus) {
        this.reduceStatus = reduceStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCpparam() {
        return cpparam;
    }

    public void setCpparam(String cpparam) {
        this.cpparam = cpparam;
    }
    


	public Map<String, String> getPaycoeds() {
		paycoeds.put("10", "300007306001");
		paycoeds.put("20", "300007306002");
		paycoeds.put("50", "300007306003");
		paycoeds.put("100", "300007306004");
		paycoeds.put("150", "300007306005");
		paycoeds.put("200", "300007306006");
		paycoeds.put("250", "300007306007");
		paycoeds.put("300", "300007306008");
		paycoeds.put("350", "300007306009");
		paycoeds.put("400", "300007306010");		
		
		paycoeds.put("450", "300007306011");
		paycoeds.put("500", "300007306012");
		paycoeds.put("600", "300007306013");
		paycoeds.put("700", "300007306014");
		paycoeds.put("800", "300007306015");
		paycoeds.put("900", "300007306016");
		paycoeds.put("1000", "300007306017");
		paycoeds.put("1100", "300007306018");
		paycoeds.put("1200", "300007306019");
		paycoeds.put("1300", "300007306020");		
		
		paycoeds.put("1500", "300007306021");
		paycoeds.put("1600", "300007306022");
		paycoeds.put("1800", "300007306023");
		paycoeds.put("1900", "300007306024");
		paycoeds.put("2000", "300007306025");
		paycoeds.put("2400", "300007306026");
		paycoeds.put("2500", "300007306027");
		paycoeds.put("3000", "300007306028");
		paycoeds.put("3500", "300007306029");
		paycoeds.put("4000", "300007306030");		
		
		paycoeds.put("4500", "300007306031");
		paycoeds.put("5000", "300007306032");
		paycoeds.put("6000", "300007306033");
		paycoeds.put("7000", "300007306034");
		paycoeds.put("8000", "300007306035");
		paycoeds.put("9000", "300007306036");
		paycoeds.put("10000", "300007306037");		
		
		return paycoeds;
	}
    
}
