package com.hytx.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hytx.cache.ThreadLocalCache;

@Service
public class MyInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		ThreadLocalCache.cleanAllThreadLocal();
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		logger.debug("--postHandle--");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ThreadLocalCache.cleanAllThreadLocal();
		logger.debug("--afterCompletion--");
	}

}