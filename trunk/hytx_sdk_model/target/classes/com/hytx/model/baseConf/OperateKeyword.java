package com.hytx.model.baseConf;

import java.io.Serializable;
import java.util.Date;

public class OperateKeyword  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer operateId;

    private String mtNum;

    private String mtContent;

    private Date updateDt;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public String getMtNum() {
        return mtNum;
    }

    public void setMtNum(String mtNum) {
        this.mtNum = mtNum;
    }

    public String getMtContent() {
        return mtContent;
    }

    public void setMtContent(String mtContent) {
        this.mtContent = mtContent;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
