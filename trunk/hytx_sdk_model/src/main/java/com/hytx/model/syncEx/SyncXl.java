package com.hytx.model.syncEx;

import java.io.Serializable;
import java.util.Date;

public class SyncXl  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String pdorderid;

    private String mchid;

    private String phone;

    private String fee;

    private String orderid;

    private String unit;

    private String status;

    private String channel;

    private String paychannel;

    private String sign;

    private Date createtime;

    private Integer channelAppId;

    private Integer syncStatus;

    private Integer reduceStatus;

    public String getPdorderid() {
        return pdorderid;
    }

    public void setPdorderid(String pdorderid) {
        this.pdorderid = pdorderid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPaychannel() {
        return paychannel;
    }

    public void setPaychannel(String paychannel) {
        this.paychannel = paychannel;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(Integer channelAppId) {
        this.channelAppId = channelAppId;
    }

    public Integer getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Integer syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Integer getReduceStatus() {
        return reduceStatus;
    }

    public void setReduceStatus(Integer reduceStatus) {
        this.reduceStatus = reduceStatus;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SyncXl [pdorderid=");
		builder.append(pdorderid);
		builder.append(", mchid=");
		builder.append(mchid);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", fee=");
		builder.append(fee);
		builder.append(", orderid=");
		builder.append(orderid);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", status=");
		builder.append(status);
		builder.append(", channel=");
		builder.append(channel);
		builder.append(", paychannel=");
		builder.append(paychannel);
		builder.append(", sign=");
		builder.append(sign);
		builder.append("]");
		return builder.toString();
	}
}
