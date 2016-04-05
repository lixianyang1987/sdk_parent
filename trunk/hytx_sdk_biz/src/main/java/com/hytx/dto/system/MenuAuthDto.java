package com.hytx.dto.system;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.hytx.model.system.MenuAuth;

public class MenuAuthDto extends MenuAuth  implements Serializable {
	private static final long serialVersionUID = 1L;

	private String authName;
	private Integer roleId;

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public List<String> getUrls(){
		if(getUrl()==null){
			return null;
		}
		return Arrays.asList(getUrl().split(","));
	}

}
