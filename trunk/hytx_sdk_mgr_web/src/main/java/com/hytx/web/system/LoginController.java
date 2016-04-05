package com.hytx.web.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.BaseContance;
import com.hytx.model.system.User;
import com.hytx.service.system.IUserService;
import com.hytx.util.MD5;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/common")
public class LoginController {
	private static Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	@Autowired
	private IUserService userService;

	/***
	 * 转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toLogin")
	public String toLogin() {
		return "/common/login";
	}

	/***
	 * 用户登录
	 * 
	 * @param loginName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login")
	public String login(@ModelAttribute("loginName") String loginName,
			HttpServletRequest request, Model model) {
		String vcode = request.getParameter("vcode");
		String password = request.getParameter("password");
		Object sessionVcode = request.getSession().getAttribute("vcode");
		request.getSession().removeAttribute("vcode");
		logger.debug("======newsessionid:{}==========", request.getSession()
				.getId());
		if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
			model.addAttribute("msg", "请填写登录信息");
			return "/common/login";
		}
		if (sessionVcode == null || vcode == null
				|| !vcode.equals(sessionVcode.toString())) {
			model.addAttribute("msg", "请输入正确的验证码");
			return "/common/login";
		}
		try {
			User user = userService.selectByLoginNameAndPassword(loginName,
					MD5.getMD5(password));
			if (user != null) {
				request.getSession().setAttribute(
						BaseContance.USER_SESSION_NAME, user);

				return "redirect:/index.action";
			} else {
				model.addAttribute("msg", "用户名密码不正确");
				return "/common/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/common/login";
	}

	@RequestMapping(value = "logout")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(BaseContance.USER_AUTH_SESSION_NAME);
		session.removeAttribute(BaseContance.USER_SESSION_NAME);
		logger.debug("======oldsessionid:{}==========", session.getId());
		session.invalidate();
		return "redirect:/index";
	}

	/***
	 * 跳转到修改密码页面
	 */
	@RequestMapping("toModifySelfPwd")
	public String toModifySelfPwd(Model model, HttpServletRequest request) {
		User user = RequestUtil.getUserSession(request);
		model.addAttribute("user", user);
		return "/common/modifySelfPwd";
	}

	/***
	 * 修改用户密码
	 * 
	 * @param user
	 * @param userTypeName
	 * @return
	 */
	@RequestMapping(value = "modifySelfPwd", produces = "application/json")
	@ResponseBody
	public Map<String, Object> modifySelfPwd(User user,
			HttpServletRequest request) {
		User userSession = RequestUtil.getUserSession(request);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user.getId() == null || !user.getId().equals(userSession.getId())
				|| StringUtils.isBlank(user.getLoginPwd())) {
			map.put("status", false);
			return map;// id参数为空
		}
		userService.modifyUserPwd(user);
		map.put("status", true);
		return map;
	}

}
