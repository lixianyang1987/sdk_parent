package com.hytx.model.system;

import java.io.Serializable;
import java.util.Date;

public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String authName;

	private Object createBy;

	private Date createDt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Object getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Object createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
}
