package com.hytx.model.baseConf;

import java.io.Serializable;
public class SettlementApp  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer appId;

    private Integer settlementId;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(Integer settlementId) {
        this.settlementId = settlementId;
    }
}
