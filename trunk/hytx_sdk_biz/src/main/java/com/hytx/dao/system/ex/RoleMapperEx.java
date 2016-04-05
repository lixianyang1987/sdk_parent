package com.hytx.dao.system.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.system.UserRoleDto;
import com.hytx.model.system.Role;
import com.hytx.util.Page;


public interface RoleMapperEx {
	
	public List<Role>selectRoleListByPage(@Param("findRole")Role findRole,@Param("page")Page<Role> page);
	
	public int countRole(@Param("findRole")Role findRole);
	
	public List<UserRoleDto>selectUserRoleDtoList(@Param("userId")Integer userId);
}