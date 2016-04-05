package com.hytx.model.baseConf;

import java.io.Serializable;
import java.util.Date;

public class ChannelAppPayPoint  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String channelAppId; 

    private String channelId; 

    private String payPointId;

    private String createBy;

    private Date createDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPayPointId() {
        return payPointId;
    }

    public void setPayPointId(String payPointId) {
        this.payPointId = payPointId;
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
}
