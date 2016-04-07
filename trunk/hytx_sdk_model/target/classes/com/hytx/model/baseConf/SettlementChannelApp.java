package com.hytx.model.baseConf;

import java.io.Serializable;
public class SettlementChannelApp  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer channelAppId;

    private Integer settlementId;

    public Integer getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(Integer channelAppId) {
        this.channelAppId = channelAppId;
    }

    public Integer getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Integer settlementId) {
        this.settlementId = settlementId;
    }
}
