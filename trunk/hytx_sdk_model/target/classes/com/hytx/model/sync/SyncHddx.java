package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncHddx  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String fromphone;

    private String tophone;

    private String msg;

    private String linkid;

    private String serviceid;

    private String backurl;

    private String msgtype;

    private Date createtime;

    private String syncAllId;

    private String provincename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromphone() {
        return fromphone;
    }

    public void setFromphone(String fromphone) {
        this.fromphone = fromphone;
    }

    public String getTophone() {
        return tophone;
    }

    public void setTophone(String tophone) {
        this.tophone = tophone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(String syncAllId) {
        this.syncAllId = syncAllId;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
}
