package com.hytx.web.baseConf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.baseConf.ChannelAppDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import com.hytx.model.baseConf.SettlementApp;
import com.hytx.model.baseConf.SettlementChannelApp;
import com.hytx.model.baseConf.SettlementMethod;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.service.baseConf.ISettlementChannelAppService;
import com.hytx.service.baseConf.ISettlementMethodService;
import com.hytx.util.ChannelAppKeyUtil;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/channelApp")
public class ChannelAppController {
	@Autowired
	@Qualifier("channelAppServiceImpl")
	private IChannelAppService channelAppService;
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IAppService appService;
	@Autowired
	private ISettlementMethodService settlementMethodService;
	@Autowired
	private ISettlementChannelAppService settlementChannelAppService;

	/***
	 * 功能描述：查询渠道包列表
	 * 
	 * @param page
	 * @param channelApp
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 * 
	 */
	@RequestMapping(value = "channelAppList")
	public String findChannelAppList(Page page, ChannelApp channelApp,
			Map<String, Object> map, HttpServletRequest request) {
		List<ChannelAppDto> channelAppList = channelAppService
				.selectChannelAppsByPage(channelApp, page);
		map.put("list", channelAppList);
		map.put("command", channelApp);
		List<App> appList = appService.selectAllActiveApp();
		App app = new App();
		app.setId(-1);
		app.setAppName("=全部=");
		appList.add(0, app);
		List<Channel> channelList = channelService.selectAllActiveChannel();
		Channel channel = new Channel();
		channel.setId(-1);
		channel.setChannelName("=全部=");
		channelList.add(0, channel);
		List<SettlementMethod> smList = settlementMethodService
				.selectSettlementMethod();
		SettlementMethod s = new SettlementMethod();
		s.setSmId(-1);
		s.setSmName("=全部=");
		smList.add(0, s);
		map.put("smList", smList);
		map.put("appList", appList);
		map.put("channelList", channelList);
		return "/baseConf/channelApp/channelAppList";
	}

	/***
	 * 功能描述：跳转到渠道包添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "toChannelAppInfo")
	public String toChannelAppInfo(Integer id, Model model) {
		ChannelApp channelApp = new ChannelApp();
		if (id != null) {
			channelApp = channelAppService.selectByPrimaryKey(id);
			channelApp.setSmId(settlementChannelAppService.selctSmApp(id)
					.getSettlementId());
		}
		List<App> appList = appService.selectAllActiveApp();
		List<Channel> channelList = channelService.selectAllActiveChannel();
		List<SettlementMethod> smList = settlementMethodService
				.selectSettlementMethod();
		model.addAttribute("smList", smList);
		model.addAttribute("channelApp", channelApp);
		model.addAttribute("appList", appList);
		model.addAttribute("channelList", channelList);
		return "/baseConf/channelApp/addOrEditChannelApp";
	}

	/***
	 * 功能描述:添加或编辑渠道包
	 * 
	 * @param channelApp
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "addOrEditChannelApp")
	public String addOrEditChannelApp(
			@ModelAttribute("channelApp") ChannelApp channelApp,
			HttpServletRequest request) {
		try {
			if (channelApp == null) {
				return "redirect:/baseConf/channelApp/channelAppList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			channelApp.setUpdateDt(new Date());
			channelApp.setUpdateBy(userSession.getUserName());
			channelApp.setKey(ChannelAppKeyUtil.createChannelAppKey(
					channelApp.getAppId(), channelApp.getChannelId()));
			if (channelApp.getId() != null) {
				SettlementChannelApp sma = new SettlementChannelApp();
				sma.setSettlementId(channelApp.getSmId());
				sma.setChannelAppId(channelApp.getId());
				settlementChannelAppService.updateSmApp(sma);
				channelAppService.updateByPrimaryKey(channelApp);
			} else {
				channelApp.setCreateDt(new Date());
				channelApp.setCreateBy(userSession.getUserName());
				channelApp.setSignKey(UUID.randomUUID().toString());
				SettlementChannelApp sma = new SettlementChannelApp();
				sma.setSettlementId(channelApp.getSmId());
				channelAppService.insert(channelApp);
				ChannelAppExample example = new ChannelAppExample();
				example.createCriteria().andAppIdEqualTo(channelApp.getAppId())
						.andChannelIdEqualTo(channelApp.getChannelId()).andNameEqualTo(channelApp.getName());
				channelApp = channelAppService.selectChannelAppId(example);
				sma.setChannelAppId(channelApp.getId());
				
				settlementChannelAppService.addSmApp(sma);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/channelApp/channelAppList";
	}

	/**
	 * 功能描述:根据渠道包ids删除渠道包
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/delChannelApp", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = channelAppService.deleteChannelAppByIds(idList);
				settlementChannelAppService.delsSmApp(idList);
				map.put("success", true);

			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
