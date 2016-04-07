package com.hytx.web.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.BaseContance;
import com.hytx.dto.system.MenuAuthDto;
import com.hytx.model.system.Auth;
import com.hytx.model.system.Menu;
import com.hytx.model.system.User;
import com.hytx.service.system.IAuthService;
import com.hytx.service.system.IMenuService;
import com.hytx.service.system.IRoleMenuAuthService;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/system/menu")
public class MenuController {
	@Autowired
	private IMenuService menuService;
	@Autowired
	@Qualifier("authServiceImpl")
	private IAuthService authService;
	@Autowired
	@Qualifier("roleMenuAuthServiceImpl")
	private IRoleMenuAuthService roleMenuAuthService;

	/**
	 * 转到菜单管理页面
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return "/system/menu/menuList";
	}

	/***
	 * 查询菜单
	 * 
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "findChildMenus", produces = "application/json")
	@ResponseBody
	public List<Menu> findChildMenus(Integer pid) {
		if (pid == null) {
			pid = BaseContance.MENU_ROOT_ID;
		}
		List<Menu> list = menuService.findChildMenus(pid);
		return list;
	}

	/****
	 * 转到菜单添加页面
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "toMenuInfo")
	public String toMenuInfo(Integer pid, Integer id, Model model) {
		if (id != null) {
			Menu menu = menuService.selectByPrimaryKey(id);
			model.addAttribute("menu", menu);
		} else {
			if (pid != null) {
				Menu menu = menuService.selectByPrimaryKey(pid);
				model.addAttribute("pmenu", menu);
			}
			model.addAttribute("pid", pid);
		}
		return "/system/menu/addOrEditMenu";
	}

	/***
	 * 添加或编辑菜单
	 * 
	 * @param menu
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addOrEditMenu", produces = "application/json")
	@ResponseBody
	public Map<String, Object> addOrEditMenu(Menu menu,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (menu.getPid() == null) {
			menu.setPid(BaseContance.MENU_ROOT_ID);
		}
		try {
			User userSession = (User) RequestUtil.getUserSession(request);
			menu.setUpdateBy(userSession.getUserName());
			menu.setUpdateDt(new Date());
			if (menu.getId() != null) {
				menuService.updateByPrimaryKey(menu);
				map.put("id", menu.getId());
			} else {
				int id = menuService.insertReturnId(menu);
				map.put("id", id);
			}
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/****
	 * 删除菜单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delMenu", produces = "application/json")
	@ResponseBody
	public Map<String, Object> delMenu(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (id == null) {
			map.put("status", 1);
			return map;// id参数为空
		}
		Menu m = menuService.selectByPrimaryKey(id);
		if (m == null) {
			map.put("status", 2);
			return map;
		}
		if (menuService.delMenuById(id)) {
			map.put("status", 0);
			return map;
		} else {
			map.put("status", 4);
			return map;
		}
	}

	@RequestMapping("toAddMenuAuth")
	public String toAddMenuAuth(@ModelAttribute("menuId")Integer menuId,Model model){
		List<MenuAuthDto> authList = roleMenuAuthService.selectMenuAuthList(menuId);
		model.addAttribute("authList",authList);
		return "/system/menu/addMenuAuth";
	}
	
	/**
	 * 功能描述:设置菜单权限
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年5月4日
	 */
	@RequestMapping(value = "/addMenuAuth", produces = "application/json")
	@ResponseBody
	public Map<String,Object>addMenuAuth(Integer []authIds,String urls[],Integer menuId,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User userSession = RequestUtil.getUserSession(request);
			menuService.updateMenuAuth(authIds, urls, menuId, userSession);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	
}
