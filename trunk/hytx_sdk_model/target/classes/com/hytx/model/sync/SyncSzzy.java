package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncSzzy  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private String linkid;

    private String instruction;

    private String mob;

    private String destmob;

    private Date createtime;

    private String ip;

    private String cpparam;

    private String provinceName;

    private String rptStat;

    private String syncAllId;

    private String dt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getDestmob() {
        return destmob;
    }

    public void setDestmob(String destmob) {
        this.destmob = destmob;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCpparam() {
        return cpparam;
    }

    public void setCpparam(String cpparam) {
        this.cpparam = cpparam;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getRptStat() {
        return rptStat;
    }

    public void setRptStat(String rptStat) {
        this.rptStat = rptStat;
    }

    public String getSyncAllId() {
        return syncAllId;
    }

    public void setSyncAllId(String syncAllId) {
        this.syncAllId = syncAllId;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}
