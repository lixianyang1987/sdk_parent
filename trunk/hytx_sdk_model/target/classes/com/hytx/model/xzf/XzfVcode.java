package com.hytx.model.xzf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class XzfVcode  implements Serializable {
	private static final long serialVersionUID = 1L;

    private BigDecimal id;

    private String mobile;

    private String vcode;

    private Date effectiveDt;

    private Date expireDt;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Date getEffectiveDt() {
        return effectiveDt;
    }

    public void setEffectiveDt(Date effectiveDt) {
        this.effectiveDt = effectiveDt;
    }

    public Date getExpireDt() {
        return expireDt;
    }

    public void setExpireDt(Date expireDt) {
        this.expireDt = expireDt;
    }
}
