package com.hytx.model.baseConf;

import java.io.Serializable;
import java.util.Date;

public class PayPointOperate  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer paypointId;

    private Integer operateId;

    private Date createDt;

    private String createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaypointId() {
        return paypointId;
    }

    public void setPaypointId(Integer paypointId) {
        this.paypointId = paypointId;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
