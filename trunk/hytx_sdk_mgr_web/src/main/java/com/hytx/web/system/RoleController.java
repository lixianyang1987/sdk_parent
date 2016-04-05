package com.hytx.web.system;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.EnumStatus;
import com.hytx.model.system.Role;
import com.hytx.model.system.User;
import com.hytx.service.system.IRoleService;
import com.hytx.util.Page;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/system/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;

	/***
	 * 查询角色列表
	 * 
	 * @param page
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "roleList")
	public String findRoleList(@ModelAttribute("page") Page page,
			@ModelAttribute("role") Role role, Model model) {
		List<Role> roles = roleService.selectRolesByPage(role, page);
		model.addAttribute("list", roles);
		return "/system/role/roleList";
	}

	/***
	 * 跳转到角色添加或编辑页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toRoleInfo")
	public String toRoleInfo(Integer id, Model model) {
		Role role = new Role();
		if (id != null) {
			role = roleService.selectByPrimaryKey(id);
		}
		model.addAttribute("role", role);
		return "/system/role/addOrEditRole";
	}

	/***
	 * 添加或编辑角色
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "addOrEditRole")
	public String addOrEditRole(@ModelAttribute("role") Role role,
			HttpServletRequest request) {
		try {
			if (role == null) {
				return "redirect:/system/role/roleList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			role.setUpdateDt(new Date());
			role.setUpdateBy(userSession.getUserName());
			if (role.getId() != null) {
				roleService.updateByPrimaryKeySelective(role);
			} else {
				role.setCreateDt(new Date());
				role.setCreateBy(userSession.getUserName());
				roleService.insertSelective(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/system/role/roleList";
	}

	/***
	 * 更改单个角色状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "chRoleState")
	@ResponseBody
	public boolean updateRoleState(Integer id, Integer status) {
		if (id == null || status == null || !EnumStatus.isEfficient(status)) {
			return false;
		}
		Role role = new Role();
		role.setId(id);
		role.setStatus(status);
		roleService.updateByPrimaryKeySelective(role);
		return true;
	}

	/****
	 * 单个删除角色
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteRole")
	public boolean deleteRole(Role role) {
		if (role.getId() == null) {
			return false;
		}
		role.setStatus(EnumStatus.del.getValue());
		roleService.updateByPrimaryKeySelective(role);
		return true;
	}

}
