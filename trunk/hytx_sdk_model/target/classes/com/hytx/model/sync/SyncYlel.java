package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncYlel  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String moFrom;

    private String moTo;

    private String content;

    private String linkid;

    private String status;

    private String ip;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoFrom() {
        return moFrom;
    }

    public void setMoFrom(String moFrom) {
        this.moFrom = moFrom;
    }

    public String getMoTo() {
        return moTo;
    }

    public void setMoTo(String moTo) {
        this.moTo = moTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
