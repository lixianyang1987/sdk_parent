package com.hytx.model.baseConf;

import java.io.Serializable;
import java.util.Date;

public class PayPoint  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer serverType;

    private Integer feeValue;

    private Integer appId;

    private String payCode;

    private Integer status;

    private Date createDt;

    private String createBy;

    private Date updateDt;

    private String updateBy;

    private String memo;

    private Integer opType;

    private Integer opRange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public Integer getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(Integer feeValue) {
        this.feeValue = feeValue;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getOpRange() {
        return opRange;
    }

    public void setOpRange(Integer opRange) {
        this.opRange = opRange;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PayPoint [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", serverType=");
		builder.append(serverType);
		builder.append(", feeValue=");
		builder.append(feeValue);
		builder.append(", appId=");
		builder.append(appId);
		builder.append(", payCode=");
		builder.append(payCode);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createDt=");
		builder.append(createDt);
		builder.append(", createBy=");
		builder.append(createBy);
		builder.append(", updateDt=");
		builder.append(updateDt);
		builder.append(", updateBy=");
		builder.append(updateBy);
		builder.append(", memo=");
		builder.append(memo);
		builder.append(", opType=");
		builder.append(opType);
		builder.append(", opRange=");
		builder.append(opRange);
		builder.append("]");
		return builder.toString();
	}
    
}
