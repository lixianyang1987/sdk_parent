package com.hytx.model.sync;

import java.io.Serializable;
public class SyncProvinceZjhy  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer provinceid;

    private String provincename;

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }
}
