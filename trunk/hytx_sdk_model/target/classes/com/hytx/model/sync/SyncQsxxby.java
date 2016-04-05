package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncQsxxby  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String morid;

    private String gatewayId;

    private String productId;

    private Long phone;

    private Integer operateType;

    private String modatReceive;

    private String status;

    private Date createTime;

    private Integer reduceStatus;

    private Integer syncStatus;

    private Date beginTime;

    private Date endTime;

    public String getMorid() {
        return morid;
    }

    public void setMorid(String morid) {
        this.morid = morid;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getModatReceive() {
        return modatReceive;
    }

    public void setModatReceive(String modatReceive) {
        this.modatReceive = modatReceive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(Integer reduceStatus) {
        this.reduceStatus = reduceStatus;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
