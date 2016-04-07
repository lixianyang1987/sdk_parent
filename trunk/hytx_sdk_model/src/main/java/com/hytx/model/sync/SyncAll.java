package com.hytx.model.sync;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SyncAll  implements Serializable {
	private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private Integer channelId;

    private Integer cnAppId;

    private Integer opAppId;

    private Integer opId;

    private String mo;

    private Long mobile;

    private String spNumber;

    private Integer feeValue;

    private Integer serverType;

    private Integer status;

    private Date createDt;

    private Integer reduceStatus;

    private String provinceName;

    private String cityName;

    private String rptTime;

    private String orderId;

    private Integer serialNum;

    private String tName;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getCnAppId() {
        return cnAppId;
    }

    public void setCnAppId(Integer cnAppId) {
        this.cnAppId = cnAppId;
    }

    public Integer getOpAppId() {
        return opAppId;
    }

    public void setOpAppId(Integer opAppId) {
        this.opAppId = opAppId;
    }

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getSpNumber() {
        return spNumber;
    }

    public void setSpNumber(String spNumber) {
        this.spNumber = spNumber;
    }

    public Integer getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(Integer feeValue) {
        this.feeValue = feeValue;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(Integer reduceStatus) {
        this.reduceStatus = reduceStatus;
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

    public String getRptTime() {
        return rptTime;
    }

    public void setRptTime(String rptTime) {
        this.rptTime = rptTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
