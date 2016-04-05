package com.hytx.model.baseConf;

import java.io.Serializable;
import java.util.Date;

public class App  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer smZj;
	
	private Integer smYj;
	
	private Integer smId;  

	private Integer id;

    private String appName;

    private Integer cpId;

    private String appDescribe;

    private String createBy;

    private Date createDt;

    private String updateBy;

    private Date updateDt;

    private Integer status;

    private String appSn;

    private String appKey;

    private Integer serverType;

    private String channelSn;

    private Integer controlFlag;

    private Integer dayLimit;

    private Integer monthLimit;

    private Integer waitSeconds;

    private Integer reducePercent;

    private Integer feePercent;

    private Integer cpaPrice;
    
    
    
    public Integer getSmZj() {
		return smZj;
	}

	public void setSmZj(Integer smZj) {
		this.smZj = smZj;
	}

	public Integer getSmYj() {
		return smYj;
	}

	public void setSmYj(Integer smYj) {
		this.smYj = smYj;
	}

	public Integer getSmId() {
  		return smId;
  	}

  	public void setSmId(Integer smId) {
  		this.smId = smId;
  	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getAppDescribe() {
        return appDescribe;
    }

    public void setAppDescribe(String appDescribe) {
        this.appDescribe = appDescribe;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAppSn() {
        return appSn;
    }

    public void setAppSn(String appSn) {
        this.appSn = appSn;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getChannelSn() {
        return channelSn;
    }

    public void setChannelSn(String channelSn) {
        this.channelSn = channelSn;
    }

    public Integer getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(Integer controlFlag) {
        this.controlFlag = controlFlag;
    }

    public Integer getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(Integer dayLimit) {
        this.dayLimit = dayLimit;
    }

    public Integer getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(Integer monthLimit) {
        this.monthLimit = monthLimit;
    }

    public Integer getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(Integer waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public Integer getReducePercent() {
        return reducePercent;
    }

    public void setReducePercent(Integer reducePercent) {
        this.reducePercent = reducePercent;
    }

    public Integer getFeePercent() {
        return feePercent;
    }

    public void setFeePercent(Integer feePercent) {
        this.feePercent = feePercent;
    }

    public Integer getCpaPrice() {
        return cpaPrice;
    }

    public void setCpaPrice(Integer cpaPrice) {
        this.cpaPrice = cpaPrice;
    }

	public App(Integer id, String appName) {
		super();
		this.id = id;
		this.appName = appName;
	}

	public App() {
		super();
	}
    
}
