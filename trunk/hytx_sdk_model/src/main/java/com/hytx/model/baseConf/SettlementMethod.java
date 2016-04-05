package com.hytx.model.baseConf;

import java.io.Serializable;
public class SettlementMethod  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer smId;

    private String smName;

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName;
    }
}
