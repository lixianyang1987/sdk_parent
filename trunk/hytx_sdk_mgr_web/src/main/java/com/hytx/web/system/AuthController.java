package com.hytx.web.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.EnumStatus;
import com.hytx.model.system.Auth;
import com.hytx.model.system.User;
import com.hytx.service.system.IAuthService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/system/auth")
public class AuthController {
	@Autowired
	@Qualifier("authServiceImpl")
	private IAuthService authService;


	/***
	 * 功能描述：查询权限名列表
	 * 
	 * @param page
	 * @param auth
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 * 
	 */
	@RequestMapping(value = "authList")
	public String findAuthList(Page page, Auth auth, Map<String, Object> map,
			HttpServletRequest request) {
		List<Auth> authList = authService.selectAuthsByPage(auth, page);
		map.put("list", authList);
		map.put("command", auth);
		return "/system/auth/authList";
	}

	/***
	 * 功能描述：跳转到权限名添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	@RequestMapping(value = "toAuthInfo")
	public String toAuthInfo(Integer id, Model model) {
		Auth auth = new Auth();
		if (id != null) {
			auth = authService.selectByPrimaryKey(id);
		}
		model.addAttribute("auth", auth);
		
		return "/system/auth/addOrEditAuth";
	}

	/***
	 * 功能描述:添加或编辑权限名
	 * 
	 * @param auth
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	@RequestMapping(value = "addOrEditAuth")
	public String addOrEditAuth(@ModelAttribute("auth") Auth auth,
			HttpServletRequest request) {
		try {
			if (auth == null) {
				return "redirect:/system/auth/authList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			if (auth.getId() != null) {
				authService.updateByPrimaryKeySelective(auth);
			} else {
				auth.setCreateDt(new Date());
				auth.setCreateBy(userSession.getUserName());
				authService.insert(auth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/system/auth/authList";
	}

	/**
	 * 功能描述:根据权限名ids删除权限名
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	@RequestMapping(value = "/delAuth", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = authService.deleteAuthByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
