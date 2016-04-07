package com.hytx.model.sync;

import java.io.Serializable;
import java.util.Date;

public class SyncTykj  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    private String result;

    private String appid;

    private String exdata;

    private String price;

    private String paytime;

    private String operator;

    private String orderid;

    private Date createtime;

    private String syncAllId;

    private String provincename;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getExdata() {
        return exdata;
    }

    public void setExdata(String exdata) {
        this.exdata = exdata;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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
