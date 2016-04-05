package com.hytx.web.base;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import com.hytx.constance.BaseContance;
import com.hytx.model.system.User;

public class RequestUtil {
	/***
	 * 获取session用户
	 * 
	 * @param request
	 * @return
	 */
	public static User getUserSession(HttpServletRequest request) {
		Object sessionObj=WebUtils.getSessionAttribute(request,
				BaseContance.USER_SESSION_NAME);
		if(sessionObj!=null){
			return (User)sessionObj;
		}
		//暂时没有强制登录，如果是未登录，将admin作为当前登录人
		User userSession = new User();
		userSession.setId(1);
		userSession.setUserName("admin");
		return userSession;
	}
	
	/***
	 * 设置用户权限session
	 * @param request
	 * @param value
	 */
	public static void setUserAuthSession(HttpServletRequest request, Map<String,List<String>>urlAuthMap){
		setSessionAttribute(request, BaseContance.USER_AUTH_SESSION_NAME, urlAuthMap);
	}
	/***
	 * 获取用户权限session
	 * @param request
	 * @param value
	 */
	public static Map<String,List<String>>getUserAuthSession(HttpServletRequest request){
		Object sessionObj=WebUtils.getSessionAttribute(request,
				BaseContance.USER_AUTH_SESSION_NAME);
		if(sessionObj!=null){
			return (Map<String,List<String>>)sessionObj;
		}else{
			return null;
		}
	}
	
	/***
	 * 获取用户权限
	 * @param request
	 * @param value
	 */
	public static List<String>getUrlUserAuthSession(HttpServletRequest request){
		Map<String, List<String>> urlAuthsMap = RequestUtil.getUserAuthSession(request);
		if(urlAuthsMap!=null){
			 String uri=request.getRequestURI();
			 String contentPath=request.getContextPath();
			 uri=uri.substring(contentPath.length());
			 if(!uri.endsWith(".action")){
				 uri=uri+".action";
			 }
			 return urlAuthsMap.get(uri);
		}else{
			return null;
		}
	}
	
	
	/***
	 * 设置session
	 * @param request
	 * @param name
	 * @param value
	 */
	private static void setSessionAttribute(HttpServletRequest request, String name, Object value){
		WebUtils.setSessionAttribute(request, name, value);
	}

}
