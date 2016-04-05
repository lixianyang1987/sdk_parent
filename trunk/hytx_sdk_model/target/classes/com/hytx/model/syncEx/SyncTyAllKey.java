package com.hytx.model.syncEx;

import java.io.Serializable;
public class SyncTyAllKey  implements Serializable {
	private static final long serialVersionUID = 1L;

    private String appId;

    private String linkid;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }
}
