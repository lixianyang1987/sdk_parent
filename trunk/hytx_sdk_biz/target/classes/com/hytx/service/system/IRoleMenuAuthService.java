package com.hytx.service.system;

import java.util.List;

import com.hytx.dto.system.MenuAuthDto;
import com.hytx.dto.system.MenuNodeDto;
import com.hytx.model.system.RoleMenuAuth;
import com.hytx.model.system.User;
import com.hytx.util.Page;

public interface IRoleMenuAuthService {
	
	/***
	 * 功能描述：查询菜单及菜单权限,返回树型结构，菜单作为树干，菜单应对的权限作为叶子节点,
	 * 当前角色配置拥有的权限呈现选中状态
	 * 
	 * @param roleId
	 * @return  
	 * @author houzz
	 * @since 22015年05月5日
	 */
	public MenuNodeDto selectMenuNodeDtoList(Integer roleId);
	/***
	 * 功能描述：查询菜单权限
	 * 
	 * @param menuId
	 * @return  
	 * @author houzz
	 * @since 2015年05月5日
	 */
	public List<MenuAuthDto> selectMenuAuthList(Integer menuId);
	/***
	 * 功能描述：更新角色权限
	 * 
	 * @param roleId
	 * @param menuAuthIdList
	 * @param user
	 * @return  
	 * @author houzz
	 * @since 2015年05月5日
	 */
	public int updateRoleMenuAuths(Integer roleId,List<Integer>menuAuthIdList,User user);
	/***
	 * 功能描述：查询用户权限
	 * 
	 * @param user
	 * @return  
	 * @author houzz
	 * @since 2015年05月5日
	 */
	public  List<MenuAuthDto> selectUserMenuAuthList(User user);
}
