package com.hytx.web.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.NativeWebRequest;

@ControllerAdvice
public class BaseController {
	private static Logger logger = LoggerFactory
			.getLogger(BaseController.class);

	@ModelAttribute
	public void addBasePath(HttpServletRequest request, Model model) {
		logger.debug("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
		model.addAttribute("basePath", request.getContextPath());
	}

	@ModelAttribute
	public void addUserAuthNames(HttpServletRequest request, Model model) {
		List<String> auths = RequestUtil.getUrlUserAuthSession(request);
		logger.debug("====当前uri:{}=====", request.getRequestURI());
		model.addAttribute("auths", auths);
		logger.debug("==放入权限:{}==", auths);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		logger.debug("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
	}

	@ExceptionHandler(Exception.class)
	public String processUnCatchException(NativeWebRequest request, Exception e) {
		e.printStackTrace();
		logger.debug("===========应用到所有@RequestMapping注解的方法，在其抛出Exception异常时执行"
				+ e.getStackTrace());
		if (e instanceof NoAuthException) {
			return "noAuth";
		}
		return "error"; // 返回一个逻辑视图名
	}

}
