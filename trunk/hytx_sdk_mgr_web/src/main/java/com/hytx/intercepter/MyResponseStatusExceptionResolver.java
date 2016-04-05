package com.hytx.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import com.hytx.web.base.NoAuthException;
@Service
public class MyResponseStatusExceptionResolver extends ResponseStatusExceptionResolver{	
	private static Logger logger=LoggerFactory.getLogger(MyResponseStatusExceptionResolver.class);
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		logger.debug("===== MyResponseStatusExceptionResolver =======");
		if(ex instanceof NoAuthException){
			ModelAndView mv=new ModelAndView();
			mv.setViewName("noAuth");
			return mv;
		}
		ResponseStatus responseStatus = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
		if (responseStatus != null) {
			try {
				return resolveResponseStatus(responseStatus, request, response, handler, ex);
			}
			catch (Exception resolveEx) {
				logger.warn("Handling of @ResponseStatus resulted in Exception", resolveEx);
			}
		}
		return null;
	}
	
	


}
