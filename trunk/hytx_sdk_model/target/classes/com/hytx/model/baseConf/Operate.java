package com.hytx.model.baseConf;

import java.io.Serializable;
import java.util.Date;
public class Operate implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String opName;

    private Integer price;

    private String feeCode;

    private String opCode;

    private Integer suffixNum;

    private Integer serverType;

    private Integer status;

    private Integer weight;

    private Integer opType;

    private String createBy;

    private Date createDt;

    private String updateBy;

    private Date updateDt;

    private Integer appId;

    private String appSn;

    private String channelSn;

    private Integer ensureType;

    private String ensureContent;

    private String ensureNum;

    private String cpparam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public Integer getSuffixNum() {
        return suffixNum;
    }

    public void setSuffixNum(Integer suffixNum) {
        this.suffixNum = suffixNum;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppSn() {
        return appSn;
    }

    public void setAppSn(String appSn) {
        this.appSn = appSn;
    }

    public String getChannelSn() {
        return channelSn;
    }

    public void setChannelSn(String channelSn) {
        this.channelSn = channelSn;
    }

    public Integer getEnsureType() {
        return ensureType;
    }

    public void setEnsureType(Integer ensureType) {
        this.ensureType = ensureType;
    }

    public String getEnsureContent() {
        return ensureContent;
    }

    public void setEnsureContent(String ensureContent) {
        this.ensureContent = ensureContent;
    }

    public String getEnsureNum() {
        return ensureNum;
    }

    public void setEnsureNum(String ensureNum) {
        this.ensureNum = ensureNum;
    }

    public String getCpparam() {
        return cpparam;
    }

    public void setCpparam(String cpparam) {
        this.cpparam = cpparam;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operate [id=");
		builder.append(id);
		builder.append(", opName=");
		builder.append(opName);
		builder.append(", price=");
		builder.append(price);
		builder.append(", feeCode=");
		builder.append(feeCode);
		builder.append(", opCode=");
		builder.append(opCode);
		builder.append(", suffixNum=");
		builder.append(suffixNum);
		builder.append(", serverType=");
		builder.append(serverType);
		builder.append(", status=");
		builder.append(status);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", opType=");
		builder.append(opType);
		builder.append(", createBy=");
		builder.append(createBy);
		builder.append(", createDt=");
		builder.append(createDt);
		builder.append(", updateBy=");
		builder.append(updateBy);
		builder.append(", updateDt=");
		builder.append(updateDt);
		builder.append(", appId=");
		builder.append(appId);
		builder.append(", appSn=");
		builder.append(appSn);
		builder.append(", channelSn=");
		builder.append(channelSn);
		builder.append(", ensureType=");
		builder.append(ensureType);
		builder.append(", ensureContent=");
		builder.append(ensureContent);
		builder.append(", ensureNum=");
		builder.append(ensureNum);
		builder.append(", cpparam=");
		builder.append(cpparam);
		builder.append("]");
		return builder.toString();
	}
    
}