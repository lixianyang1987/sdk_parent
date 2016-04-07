package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncYpplDx  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String action;

    private String spid;

    private String mobile;

    private String serviceid;

    private String mocontent;

    private String linkid;

    private String mtcontent;

    private String fee;

    private String status;

    private String dtime;

    private Date createtime;

    private String provinceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getMocontent() {
        return mocontent;
    }

    public void setMocontent(String mocontent) {
        this.mocontent = mocontent;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getMtcontent() {
        return mtcontent;
    }

    public void setMtcontent(String mtcontent) {
        this.mtcontent = mtcontent;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
