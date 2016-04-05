package com.hytx.web.baseConf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hytx.constance.EnumStatus;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppServerService;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IPayPointService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/appServer")
public class AppServerController {
	@Autowired
	@Qualifier("appServerServiceImpl")
	private IAppServerService appServerService;
	@Autowired
	private IAppService appService;
	@Autowired
	private IPayPointService payPointService;

	/***
	 * 功能描述：查询应用运营商配置列表
	 * 
	 * @param page
	 * @param appServer
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 * 
	 */
	@RequestMapping(value = "appServerList")
	public String findAppServerList(Page<AppServer> page, AppServer appServer,
			Map<String, Object> map, HttpServletRequest request) {
		List<AppServer> appServerList = appServerService
				.selectAppServersByPage(appServer, page);
		map.put("list", appServerList);
		if (appServer.getAppId() != null) {
			App app = appService.selectByPrimaryKey(appServer.getAppId());
			map.put("app", app);
		}
		map.put("command", appServer);
		return "/baseConf/appServer/appServerList";
	}

	/***
	 * 功能描述：跳转到应用运营商配置添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	@RequestMapping(value = "toAppServerInfo")
	public String toAppServerInfo(Integer id, Model model) {
		AppServer appServer = new AppServer();
		if (id != null) {
			appServer = appServerService.selectByPrimaryKey(id);
		}
		model.addAttribute("appServer", appServer);
		return "/baseConf/appServer/addOrEditAppServer";
	}

	/***
	 * 功能描述:添加或编辑应用运营商配置
	 * 
	 * @param appServer
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	@RequestMapping(value = "addOrEditAppServer")
	public String addOrEditAppServer(
			@ModelAttribute("appServer") AppServer appServer,
			HttpServletRequest request, RedirectAttributes rat) {
		rat.addAttribute("appId", appServer.getAppId());
		try {
			if (appServer == null) {
				return "redirect:/baseConf/appServer/appServerList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			appServer.setUpdateDt(new Date());
			appServer.setUpdateBy(userSession.getUserName());
			appServer.setStatus(EnumStatus.ok.getValue());
			if (appServer.getId() != null) {
				appServerService.updateByPrimaryKeySelective(appServer);
			} else {
				appServer.setCreateDt(new Date());
				appServer.setCreateBy(userSession.getUserName());
				appServerService.insert(appServer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/appServer/appServerList";
	}

	/**
	 * 功能描述:根据应用运营商配置ids删除应用运营商配置
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	@RequestMapping(value = "/delAppServer", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				appServerService.deleteAppServerByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/***
	 * 检查含有私有指令的不正常计费点
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/checkPrivateOp", produces = "application/json")
	@ResponseBody
	public Object checkPrivateOp(Integer appId, Integer serverType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (appId == null || serverType == null) {
				map.put("exists", true);
			} else {
				List<PayPoint> list = payPointService.selectIllegePayPoints(
						appId, serverType);
				map.put("exists", list != null && !list.isEmpty());
				map.put("list", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exists", false);
		}
		return map;
	}
}
