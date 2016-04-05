package com.hytx.web.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hytx.model.baseConf.App;

import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;

import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelAppService;

import com.hytx.service.baseConf.ICpInfoService;
import com.hytx.service.count.ISyncAllCountService;
import com.hytx.service.count.ISyncRetainedCountService;
import com.hytx.service.syncEx.ISyncbyRetainedService;
import com.hytx.util.ExcelUtil;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/sync")
public class SyncByRetainedController {
	@Autowired
	private IChannelAppService channelappService;
	@Autowired
	private IAppService appService;
	@Autowired
	@Qualifier("cpInfoServiceImpl")
	private ICpInfoService cpInfoService;
	@Autowired
	private ISyncAllCountService syncAllCountService;

	@Autowired
	private ISyncbyRetainedService syncByRetainedService;
	@Autowired
	private ISyncRetainedCountService syncByRetainedCountService;

	@RequestMapping(value = "addSyncByRetained", method = RequestMethod.POST)
	public Map<String, Object> addSyncByRetained(String uri,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SyncByRetained> sbrList = new ArrayList<SyncByRetained>();

		try {
			sbrList = ExcelUtil.readByRetained(uri);
			if (sbrList != null) {
				int i = syncByRetainedService.AddSyncByRetained(sbrList);
				if (i == 0) {
					map.put("success", true);
				} else {
					map.put("success", false);
				}
			}
		} catch (Exception e) {
			map.put("success", false);
		}
		return map;
	}

	@RequestMapping(value = "toAddXls")
	public String toAddXls() {

		return "/count/sync/addXls";
	}

	@RequestMapping(value = "countSyncRetainedByDate")
	public String syncRetainedByCount(SyncByRetained findDto,
			Page<SyncByRetained> page, Model model) {
		// 初始化查询条件
		List<App> appList = createlistApp();
		ChannelAppExample example = new ChannelAppExample();
		for (App app : appList) {
			example.or().andAppIdEqualTo(app.getId());
		}
		List<ChannelApp> channelAppList = channelappService
				.selectChannelAppIdlist(example);
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("appList", appList);
		model.addAttribute("channelappList", channelAppList);

		// 按查询条件查询数据
		List<SyncByRetained> list = syncByRetainedCountService
				.syncByRetainedcount(findDto, page);
		model.addAttribute("list", list);
		return "/count/sync/countSyncByRetained";
	}

	public List<App> createlistApp() {
		List<App> listapp = new ArrayList<App>();

		listapp.add(new App(840, "电信d1包月-10元"));
		listapp.add(new App(841, "电信dy2包月-15元"));

		return listapp;
	}
}
