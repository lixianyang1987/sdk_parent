package com.hytx.web.baseConf;

import java.util.ArrayList;
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

import com.hytx.constance.EnumStatus;
import com.hytx.dto.baseConf.AppDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppExample;
import com.hytx.model.baseConf.CpInfo;
import com.hytx.model.baseConf.SettlementApp;
import com.hytx.model.baseConf.SettlementMethod;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.ICpInfoService;
import com.hytx.service.baseConf.ISettlementAppService;
import com.hytx.service.baseConf.ISettlementMethodService;
import com.hytx.service.baseConf.SettlementMethodServiceImpl;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/app")
public class AppController {
	@Autowired
	@Qualifier("appServiceImpl")
	private IAppService appService;
	@Autowired
	@Qualifier("cpInfoServiceImpl")
	private ICpInfoService cpInfoService;
	@Autowired
	private ISettlementMethodService settlementMethodService;
	@Autowired
	private ISettlementAppService settlementAppService;

	/***
	 * 功能描述：查询应用列表
	 * 
	 * @param page
	 * @param app
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 * 
	 */
	@RequestMapping(value = "appList")
	public String findAppList(Page page, App app, Map<String, Object> map,String sm,
			HttpServletRequest request) {
		List<Integer> smids= new ArrayList<Integer>();
		
		List<AppDto> appList = appService.selectAppsByPage(app, page);
		map.put("list", appList);
		List<CpInfo> cpList = cpInfoService.selectAllActiveCpInfos();
		CpInfo cp = new CpInfo();
		cp.setId(-1);
		cp.setCpName("=全部=");
		cpList.add(0, cp);
		List<SettlementMethod> smList = settlementMethodService.selectSettlementMethod();
		SettlementMethod s =new SettlementMethod();
		s.setSmId(-1);
		s.setSmName("=全部=");
		smList.add(0,s);
		map.put("smList", smList);
		map.put("cpList", cpList);
		map.put("command", app);
		return "/baseConf/app/appList";
	}

	/***
	 * 功能描述：跳转到应用添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "toAppInfo")
	public String toAppInfo(Integer id, Model model) {
		App app = new App();
		if (id != null) {
			app = appService.selectByPrimaryKey(id);
			app.setSmId(settlementAppService.selctSmApp(id).getSettlementId());
		}
		List cpList = cpInfoService.selectAllActiveCpInfos();
		List<SettlementMethod> smList = settlementMethodService.selectSettlementMethod();
		
		model.addAttribute("cpList", cpList);
		model.addAttribute("smList", smList);
		model.addAttribute("app", app);
		return "/baseConf/app/addOrEditApp";
	}

	/***
	 * 功能描述:添加或编辑应用
	 * 
	 * @param app
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "addOrEditApp")
	public String addOrEditApp(@ModelAttribute("app") App app,
			HttpServletRequest request) {
		try {
			if (app == null) {
				return "redirect:/baseConf/app/appList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			app.setUpdateDt(new Date());
			app.setUpdateBy(userSession.getUserName());
			app.setStatus(EnumStatus.ok.getValue());
			if (app.getId() != null) {
				appService.updateByPrimaryKeySelective(app);
				SettlementApp sma= new SettlementApp();
				sma.setSettlementId(app.getSmId());
				sma.setAppId(app.getId());
				settlementAppService.updateSmApp(sma);
			} else {
				app.setCreateDt(new Date());
				app.setCreateBy(userSession.getUserName());
				appService.insert(app);
				SettlementApp sma= new SettlementApp();
				sma.setSettlementId(app.getSmId());
				sma.setAppId(app.getId());
				settlementAppService.addSmApp(sma);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/app/appList";
	}

	/**
	 * 功能描述:根据应用ids删除应用
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/delApp", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = appService.deleteAppByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 功能描述:根据应用ids删除应用
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/selectApp", produces = "application/json")
	@ResponseBody
	public Object selectApp(Integer channelId, Integer cpId) {
		List<App> appList = new ArrayList<App>();
		try {
			appList = appService.selectAppsByChannelAndCp(channelId, cpId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appList;
	}
	/**
	 * 功能描述:根据sp筛选应用
	 * 
	 * @param spId
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "/selectAppBySp", produces = "application/json")
	@ResponseBody
	public Object selectChannelsByCp(Integer spId,Integer channelId) {
	    List<App>list=new ArrayList<App>();
		try {
			list=appService.selectAppsByChannelAndCp(channelId, spId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
