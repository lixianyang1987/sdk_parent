package com.hytx.dto.system;

import java.io.Serializable;
import com.hytx.model.system.Role;



public class UserRoleDto extends Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userId;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
