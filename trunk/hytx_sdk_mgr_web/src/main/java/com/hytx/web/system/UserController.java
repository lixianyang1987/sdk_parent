package com.hytx.web.system;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.system.UserRoleDto;
import com.hytx.model.system.User;
import com.hytx.service.system.IRoleService;
import com.hytx.service.system.IUserService;
import com.hytx.util.MD5;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/system")
public class UserController {
	@Autowired
	@Qualifier("userServiceImpl")
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	/****
	 * 查询用户列表， 根据用户类型转到不同的页面
	 * 
	 * @param page
	 * @param findUser
	 * @param model
	 * @return
	 */
	@RequestMapping("/{userTypeName:user}/userList")
	public String userList(@ModelAttribute("page") Page<User> page,
			@PathVariable("userTypeName") String userTypeName,
			@ModelAttribute("findUser") User findUser, Model model) {
		findUser.setUserType(getUserTypeByName(userTypeName));
		userService.selectUserListByPage(findUser, page);
		model.addAttribute("page", page);
		return "/system/" + userTypeName + "/" + userTypeName + "List";
	}

	/****
	 * 查询用户列表， 根据用户类型转到不同的页面,主要用于弹窗选择cp或渠道
	 * 
	 * @param page
	 * @param findUser
	 * @param model
	 * @return
	 */
	@RequestMapping("/{userTypeName:user}/selectUserList")
	public String selectUserList(@ModelAttribute("page") Page<User> page,
			@PathVariable("userTypeName") String userTypeName,
			@ModelAttribute("findUser") User findUser, Model model) {
		findUser.setUserType(getUserTypeByName(userTypeName));
		userService.selectUserListByPage(findUser, page);
		model.addAttribute("page", page);
		return "/system/" + userTypeName + "/select" + userTypeName + "List";
	}

	/**
	 * 根据路径中的关键名称返回用户类型
	 * 
	 * @param name
	 * @return
	 */
	private int getUserTypeByName(String name) {
		return User.USER_SYS_TYPE;
	}

	/***
	 * 转到添加或编辑用户页面, 根据用户类型转到不同的页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{userTypeName:user}/toUserInfo")
	public String toUserInfo(Integer id, Model model,
			@PathVariable("userTypeName") String userTypeName) {
		User user = new User();
		if (id != null) {
			user = userService.selectUserById(id);
			model.addAttribute("user", user);
			return "/system/" + userTypeName + "/" + userTypeName + "Edit";
		}
		return "/system/" + userTypeName + "/" + userTypeName + "Add";
	}

	/***
	 * 添加或编辑用户
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{userTypeName:user}/addOrEditUser")
	public String addUser(@Valid @ModelAttribute("user") User user,
			@PathVariable("userTypeName") String userTypeName,
			HttpServletRequest request, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allError", result.getAllErrors());
			return "/system/" + userTypeName + "/" + userTypeName + "AddOrEdit";
		}
		User userSession = (User) RequestUtil.getUserSession(request);
		user.setUpdateBy(userSession.getUserName());
		user.setUserType(getUserTypeByName(userTypeName));
		if (user.getId() != null) {
			userService.updateByPrimaryKeySelective(user);
		} else {
			user.setLoginPwd(MD5.getMD5(user.getLoginPwd()));
			user.setUpdateDt(new Date());
			user.setStatus(1);
			user.setCreateBy(userSession.getUserName());
			user.setCreateDt(new Date());
			userService.insertUser(user);
		}
		return "redirect:/system/" + userTypeName + "/userList";
	}

	/**
	 * 根据用户id删除用户
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/{userTypeName:user}/delUser", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids,
			@PathVariable("userTypeName") String userTypeName) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = userService.delUserByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/***
	 * 检查用户名是否已经存在
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/{userTypeName:user}/checkExistsUserName", produces = "application/json")
	@ResponseBody
	public Object checkExistsUserName(String userName,
			@PathVariable("userTypeName") String userTypeName) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(userName)) {
				map.put("exists", true);
			} else {
				List<User> list = userService.selectByUserName(userName);
				map.put("exists", !list.isEmpty());
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exists", false);
		}
		return map;
	}

	/***
	 * 跳转到修改密码页面
	 */
	@RequestMapping("/{userTypeName:user}/toModifyPwd")
	public String toModifyPwd(Integer id, Model model,
			@PathVariable("userTypeName") String userTypeName) {
		User user = new User();
		if (id != null) {
			user = userService.selectUserById(id);
			model.addAttribute("user", user);
		}
		return "/system/" + userTypeName + "/modifyPwd";
	}

	/***
	 * 修改用户密码
	 * 
	 * @param user
	 * @param userTypeName
	 * @return
	 */
	@RequestMapping(value = "/{userTypeName:user}/modifyPwd", produces = "application/json")
	@ResponseBody
	public Map<String, Object> modifyPwd(User user,
			@PathVariable("userTypeName") String userTypeName) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (user.getId() == null || StringUtils.isBlank(user.getLoginPwd())) {
			map.put("status", false);
			return map;// id参数为空
		}
		userService.modifyUserPwd(user);
		map.put("status", true);
		return map;
	}

	/***
	 * 检查登录名是否已经存在
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/user/checkExistsLoginName", produces = "application/json")
	@ResponseBody
	public Object checkExistsLoginName(String loginName) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(loginName)) {
				map.put("exists", true);
			} else {
				List<User> list = userService.selectByLoginName(loginName);
				map.put("exists", !list.isEmpty());
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exists", false);
		}
		return map;
	}

	@RequestMapping(value = "/user/userJsonList", produces = "application/json")
	@ResponseBody
	public Object getUserJsonListByType(Integer userType) {
		return userService.selectUserListByType(userType);
	}

	/***
	 * 转到设置用户角色页面
	 * 
	 * @param id
	 *            用户id
	 * @return
	 */
	@RequestMapping("/user/toModifyUserRoles")
	public String toModifyUserRoles(Integer id, Model model) {
		List<UserRoleDto> list = roleService.selectUserRoleDtoList(id);
		model.addAttribute("list", list);
		return "/system/user/modifyUserRoles";
	}

	/***
	 * 设置用户角色
	 * 
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/user/modifyUserRoles", produces = "application/json")
	@ResponseBody
	public Map<String, Object> modifyUserRoles(Integer userId,
			Integer[] roleIds, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User userSession = (User) RequestUtil.getUserSession(request);
			userService.updateUserRoles(userId, Arrays.asList(roleIds),
					userSession);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	public static void main(String[] args) {
		System.out.println(MD5.getMD5("admin"));
	}

}
