package com.hytx.model.system;

import java.io.Serializable;
import java.util.Date;

public class RoleMenuAuth  implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer roleId;

    private Integer menuAuthId;

    private String createBy;

    private Date createDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuAuthId() {
        return menuAuthId;
    }

    public void setMenuAuthId(Integer menuAuthId) {
        this.menuAuthId = menuAuthId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
