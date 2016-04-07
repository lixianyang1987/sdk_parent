package com.hytx.web.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.BaseContance;
import com.hytx.dto.system.MenuAuthDto;
import com.hytx.model.system.Menu;
import com.hytx.model.system.User;
import com.hytx.service.system.IMenuService;
import com.hytx.service.system.IRoleMenuAuthService;
import com.hytx.web.base.RequestUtil;

@Controller
public class CommonController {
	@Autowired
	private IMenuService menuService;
	@Autowired
	@Qualifier("roleMenuAuthServiceImpl")
	private IRoleMenuAuthService roleMenuAuthService;
	
	private static Logger logger=LoggerFactory.getLogger(CommonController.class);

	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		User userSession = (User) RequestUtil.getUserSession(request);
		model.addAttribute("sessionUser", userSession);
		//初始化用户权限
		initUserAuth(userSession,request);
		return "/common/index";
	}

	/***
	 * 查询菜单
	 * 
	 * @param pid
	 * @return
	 */
	@RequestMapping(value = "ajaxLoadMenus", produces = "application/json")
	@ResponseBody
	public List<Menu> loadMenus(Integer pid,HttpServletRequest request) {
		if (pid == null) {
			pid = BaseContance.MENU_ROOT_ID;
		}
		User userSession = (User) RequestUtil.getUserSession(request);
		List<Menu> list = menuService.findUserChildMenus(pid,userSession);
		return list;
	}

	public void initUserAuth(User user,HttpServletRequest request){
		if(user.getUserName().equals("admin")){
			return;
		}
		Map<String,List<String>>urlAuthMap=new HashMap<String,List<String>>();
		RequestUtil.setUserAuthSession(request,urlAuthMap);
		List<MenuAuthDto> list = roleMenuAuthService.selectUserMenuAuthList(user);
		Map<String,Integer>urlMenuMap=new HashMap<String,Integer>(list.size()*2);
		Map<Integer,List<String>>menuAuthNameMap=new HashMap<Integer,List<String>>();
		for(MenuAuthDto dto:list){
			List<String> urls = dto.getUrls();
            if(urls==null){
				continue;
			}
			for(String url:urls){
				urlMenuMap.put(url.trim(), dto.getMenuId());
			}
			List<String>authNames=menuAuthNameMap.get(dto.getMenuId());
			if(authNames==null){
				authNames=new ArrayList<String>();
				authNames.add(dto.getAuthName());
				menuAuthNameMap.put(dto.getMenuId(), authNames);
			}else{
				authNames.add(dto.getAuthName());		
			}
		}
		Set<Entry<String, Integer>> entrySet = urlMenuMap.entrySet();
		for(Entry<String, Integer>entry:entrySet){
			urlAuthMap.put(entry.getKey(), menuAuthNameMap.get(entry.getValue()));
		}
	}
	
	
	
}
