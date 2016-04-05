package com.hytx.service.system;

import java.util.List;

import com.hytx.dto.system.UserRoleDto;
import com.hytx.model.system.Role;
import com.hytx.util.Page;

public interface IRoleService {
	/***
	 * 查询角色列表
	 * @param findRole
	 * @param page
	 * @return
	 */
	public List<Role>selectRolesByPage(Role findRole,Page<Role>page);
	
	/***
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int insertSelective(Role role);
	/**
	 * 查询角色的总数
	 * @return
	 */
	public int getTotalCount();

	/***
	 * 更新角色
	 * @param role
	 * @return
	 */
	public int updateByPrimaryKeySelective(Role role);
	/***
	 * 根据id获取角色实体
	 * @param id
	 * @return
	 */
	public Role selectByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(Role role);
	
	public List<UserRoleDto>selectUserRoleDtoList(Integer userId);

}
