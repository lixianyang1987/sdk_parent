package com.hytx.service.system;

import java.util.List;

import com.hytx.model.system.Menu;
import com.hytx.model.system.User;

public interface IMenuService {
	/**
	 * 根据id查询菜单
	 * 
	 * @param id
	 * @return
	 */
	public Menu selectByPrimaryKey(Integer id);

	/***
	 * 根据id删除菜单
	 * 
	 * @param id
	 * @return
	 */
	public boolean delMenuById(Integer id);

	/***
	 * 编辑菜单
	 * 
	 * @param menu
	 * @return
	 */
	public int updateByPrimaryKey(Menu menu);

	/***
	 * 添加菜单
	 * 
	 * @param menu
	 * @return
	 */
	public int insertReturnId(Menu menu);

	/****
	 * 根据父菜单id查询用户菜单
	 * 
	 * @param parentId
	 * @param user
	 * @return
	 */
	public List<Menu> findUserChildMenus(Integer pid, User userSession);

	/****
	 * 根据父菜单id查询菜单
	 * 
	 * @param parentId
	 * @param user
	 * @return
	 */
	public List<Menu> findChildMenus(Integer pid);

	/***
	 * 更新菜单权限
	 * 
	 * @param authIds
	 * @param urls
	 * @param menuId
	 * @param user
	 * @return
	 */
	public int updateMenuAuth(Integer[] authIds, String urls[], Integer menuId,
			User user);
}
