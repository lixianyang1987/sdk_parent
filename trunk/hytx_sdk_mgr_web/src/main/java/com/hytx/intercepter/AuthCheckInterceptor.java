package com.hytx.intercepter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hytx.model.system.User;
import com.hytx.web.base.NoAuthException;
import com.hytx.web.base.RequestUtil;

@Service
public class AuthCheckInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory
			.getLogger(AuthCheckInterceptor.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		User userSession = RequestUtil.getUserSession(request);
		if (userSession != null && !"admin".equals(userSession.getUserName())
				&& !isOpenRequest(request)) {
			List<String> authList = RequestUtil.getUrlUserAuthSession(request);
			if (authList == null || authList.isEmpty()) {
				throw new NoAuthException("没有权限访问");
			}
		}
		// 判断用户是否有权限访问
		return true;
	}

	/***
	 * 判断请求是否是开放的，即不需要权限验证的请求
	 * 
	 * @param request
	 * @return
	 */
	public boolean isOpenRequest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String validUrl = uri.substring(contextPath.length());
		if (validUrl.startsWith("/common/")) {
			return true;
		}
		if (validUrl.equals("/index.action")) {
			return true;
		}
		if (validUrl.equals("/ajaxLoadMenus.action")) {
			return true;
		}
		if (validUrl.startsWith("/images/")) {
			return true;
		} else if (validUrl.startsWith("/files/")) {
			return true;
		} else if (validUrl.startsWith("/css/")) {
			return true;
		} else if (validUrl.startsWith("/js/")) {
			return true;
		} else if (validUrl.startsWith("/easyui/")) {
			return true;
		} else if (validUrl.startsWith("/count/sync/countSyncExJsonByDate")) {
			return true;
		} else if (validUrl.startsWith("/count/sync/syncExMonthDayCountJson")) {
			return true;
		}
		return false;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		logger.debug("--postHandle--");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("--afterCompletion--");
	}

}