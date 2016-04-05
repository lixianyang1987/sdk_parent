package com.hytx.dao.system.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.system.MenuAuthDto;
import com.hytx.model.system.RoleMenuAuth;
import com.hytx.util.Page;

public interface RoleMenuAuthMapperEx {
	/***
	 * 功能描述：查询角色菜单权限
	 * 
	 * @param roleId
	 * @return  
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public List<MenuAuthDto> selectRoleMenuAuthList(@Param("roleId")Integer roleId);
	
	/***
	 * 功能描述：查询菜单权限
	 * 
	 * @param menuId
	 * @return  
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public List<MenuAuthDto> selectMenuAuthList(@Param("menuId")Integer menuId);
	
	/***
	 * 功能描述：查询用户权限
	 * 
	 * @param userId
	 * @return  
	 * @author houzz
	 * @since 2015年05月5日
	 */
	public List<MenuAuthDto> selectUserMenuAuthList(@Param("userId")Integer userId);
	
}