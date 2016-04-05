package com.hytx.service.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.system.ex.MenuMapperEx;
import com.hytx.dao.system.ori.MenuAuthMapper;
import com.hytx.dao.system.ori.MenuMapper;
import com.hytx.dao.system.ori.RoleMenuAuthMapper;
import com.hytx.model.system.Menu;
import com.hytx.model.system.MenuAuth;
import com.hytx.model.system.MenuAuthExample;
import com.hytx.model.system.MenuExample;
import com.hytx.model.system.RoleMenuAuthExample;
import com.hytx.model.system.User;

@Service("menuServiceImpl")
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private MenuMapperEx menuMapperEx;
	@Autowired
	private MenuAuthMapper menuAuthMapper;
	@Autowired
	private RoleMenuAuthMapper roleMenuAuthMapper;

	@Override
	public Menu selectByPrimaryKey(Integer id) {
		return menuMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean delMenuById(Integer id) {
		menuMapperEx.deleteChildMenus(id.toString());
		// 删除设置的菜单权限
		MenuAuthExample menuAuthExample = new MenuAuthExample();
		menuAuthExample.createCriteria().andMenuIdEqualTo(id);
		List<MenuAuth> maList = menuAuthMapper.selectByExample(menuAuthExample);
		if (maList == null || maList.isEmpty()) {
			return true;
		}
		menuAuthMapper.deleteByExample(menuAuthExample);
		List<Integer> maIds = new ArrayList<Integer>();
		for (MenuAuth ma : maList) {
			maIds.add(ma.getId());
		}
		// 删除设置的角色菜单权限
		RoleMenuAuthExample rmaExample = new RoleMenuAuthExample();
		rmaExample.createCriteria().andMenuAuthIdIn(maIds);
		roleMenuAuthMapper.deleteByExample(rmaExample);
		return true;
	}

	@Override
	public int updateByPrimaryKey(Menu menu) {
		Menu persistMenu = selectByPrimaryKey(menu.getId());
		persistMenu.setMenuType(menu.getMenuType());
		persistMenu.setName(menu.getName());
		persistMenu.setUrl(menu.getUrl());
		persistMenu.setOrdernum(menu.getOrdernum());
		return menuMapper.updateByPrimaryKey(persistMenu);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertReturnId(Menu menu) {
		Integer pid = menu.getPid();
		if (pid == null) {
			menu.setPid(BaseContance.MENU_ROOT_ID);
		}
		menu.setIsLeaf(Menu.IS_LEAF);
		if (pid == BaseContance.MENU_ROOT_ID) {
			menu.setTier(1);
			menu.setParentIds(BaseContance.MENU_ROOT_ID + "");
			int id = menuMapperEx.selectMenuId();
			menu.setId(id);
			menuMapperEx.insertReturnId(menu);
			return id;
		} else {
			Menu pmenu = selectByPrimaryKey(pid);
			menu.setTier(pmenu.getTier() + 1);
			menu.setParentIds(pmenu.getParentIds() + "," + pid);
			int id = menuMapperEx.selectMenuId();
			menu.setId(id);
			menuMapperEx.insertReturnId(menu);
			if (pmenu.getIsLeaf() == Menu.IS_LEAF) {
				pmenu.setIsLeaf(Menu.NOT_LEAF);
				menuMapper.updateByPrimaryKey(pmenu);
			}
			return id;
		}
	}

	public List<Menu> findUserChildMenus(Integer pid, User userSession) {
		return menuMapperEx.selectUserChildrenMenus(pid, userSession);
	}

	public List<Menu> findChildMenus(Integer pid) {
		try {
			MenuExample example = new MenuExample();
			example.createCriteria().andPidEqualTo(pid);
			example.setOrderByClause(" ordernum asc");
			return menuMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Menu>();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateMenuAuth(Integer[] authIds, String urls[], Integer menuId,
			User user) {
		if (authIds == null) {
			authIds = new Integer[0];
		}
		if (urls == null) {
			urls = new String[0];
		}
		if (authIds.length != urls.length) {
			return 0;
		}
		List<Integer> authIdList = Arrays.asList(authIds);
		MenuAuthExample maExample = new MenuAuthExample();
		maExample.createCriteria().andMenuIdEqualTo(menuId);

		List<MenuAuth> existsMenuAuthList = menuAuthMapper
				.selectByExample(maExample);
		// 如果没有新设置权限且没有删除权限，则不做处理
		if (authIds.length == 0
				&& (existsMenuAuthList == null || existsMenuAuthList.isEmpty())) {
			return 0;
		}
		if (authIdList.size() == existsMenuAuthList.size()
				&& existsMenuAuthList.containsAll(authIdList)) {
			return 0;
		}
		// 存放新增的权限id
		List<Integer> newIdList = new ArrayList<Integer>();
		// 存放移除的权限id
		List<Integer> deleteIdList = new ArrayList<Integer>();
		// 存放前存在的权限id
		List<Integer> oldIdList = new ArrayList<Integer>(
				existsMenuAuthList.size());
		// 找出被删除的记录id，同时编辑修改的数据
		for (MenuAuth ma : existsMenuAuthList) {
			if (!authIdList.contains(ma.getAuthId())) {
				deleteIdList.add(ma.getAuthId());
			}
			oldIdList.add(ma.getAuthId());
			int index = authIdList.indexOf(ma.getAuthId());
			if (index > -1) {
				// if(index>-1&&(ma.getUrl()==null ||
				// !ma.getUrl().equals(urls[index]))){
				ma.setCreateBy(user.getUserName());
				ma.setCreateDt(new Date());
				ma.setUrl(urls[index]);
				menuAuthMapper.updateByPrimaryKey(ma);
			}
		}
		// 找出新添加的记录id
		for (Integer id : authIdList) {
			if (!oldIdList.contains(id)) {
				newIdList.add(id);
			}
		}
		// 删除数据
		if (!deleteIdList.isEmpty()) {
			MenuAuthExample delExample = new MenuAuthExample();
			delExample.createCriteria().andMenuIdEqualTo(menuId)
					.andAuthIdIn(deleteIdList);
			menuAuthMapper.deleteByExample(delExample);
		}
		// 添加新增省份记录
		for (int i = 0; i < authIds.length; i++) {
			if (newIdList.contains(authIds[i])) {
				MenuAuth ma = new MenuAuth();
				ma.setMenuId(menuId);
				ma.setAuthId(authIds[i]);
				ma.setUrl(urls[i]);
				ma.setCreateBy(user.getUserName());
				ma.setCreateDt(new Date());
				menuAuthMapper.insert(ma);
			}
		}
		return authIds.length;
	}

}
