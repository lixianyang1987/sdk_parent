package com.hytx.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.system.MenuNodeDto;
import com.hytx.model.system.User;
import com.hytx.service.system.IRoleMenuAuthService;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/system/roleMenuAuth")
public class RoleMenuAuthController {
	@Autowired
	@Qualifier("roleMenuAuthServiceImpl")
	private IRoleMenuAuthService roleMenuAuthService;


	/***
	 * 功能描述：跳转到角色菜单权限添加或编辑页面
	 * 
	 * @param roleId
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	@RequestMapping(value = "toRoleMenuAuthInfo")
	public String toRoleMenuAuthInfo(Integer roleId, Model model) {
		MenuNodeDto menuTree = roleMenuAuthService.selectMenuNodeDtoList(roleId);
		String json=net.sf.json.JSONArray.fromObject(menuTree).toString();
		model.addAttribute("rootNode",json);
		return "/system/roleMenuAuth/roleMenuAuthList";
	}

	
	/**
	 * 功能描述:为角色设置菜单权限
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年5月4日
	 */
	@RequestMapping(value = "/addRoleMenuAuth", produces = "application/json")
	@ResponseBody
	public Map<String,Object>addRoleMenuAuth(Integer roleId,String menuAuthIds,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User userSession = RequestUtil.getUserSession(request);
			List<Integer>menuAuthIdList=StringUtil.changeStringIdsToIntegerList(menuAuthIds);
			roleMenuAuthService.updateRoleMenuAuths(roleId, menuAuthIdList, userSession);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	
}
