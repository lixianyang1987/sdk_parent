package com.hytx.web.count;

import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hytx.dto.count.SyncAllCountDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.baseConf.CpInfo;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.service.baseConf.ICpInfoService;
import com.hytx.service.count.ISyncAllCountService;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/sync")
public class SyncAllCountController {
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IAppService appService;
	@Autowired
	@Qualifier("cpInfoServiceImpl")
	private ICpInfoService cpInfoService;
	@Autowired
	private ISyncAllCountService syncAllCountService;

	@RequestMapping(value = "countSyncAllByDate")
	public String syncAllCount(SyncAllCountDto findDto,
			Page<SyncAllCountDto> page, Model model) {
		// 初始化查询条件
		List<App> appList = appService.selectAppsByChannelAndCp(
				findDto.getChannelId(), findDto.getCpId());
		List<Channel> channelList = channelService.selectByCpId(findDto
				.getCpId());
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("appList", appList);
		model.addAttribute("channelList", channelList);
		List<CpInfo> cpList = cpInfoService.selectAllActiveCpInfos();
		model.addAttribute("cpList", cpList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncAllCountDto> list = syncAllCountService.countSyncAll(findDto,
				page);
		model.addAttribute("list", list);
		return "/count/sync/countSyncAllByDate";
	}

	@RequestMapping(value = "countSyncAppByDate")
	public String syncAppCount(SyncAllCountDto findDto,
			Page<SyncAllCountDto> page, Model model) {
		// 初始化查询条件
		List<App> appList = appService.selectAppsByChannelAndCp(
				findDto.getChannelId(), findDto.getCpId());
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("appList", appList);
		List<CpInfo> cpList = cpInfoService.selectAllActiveCpInfos();
		model.addAttribute("cpList", cpList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncAllCountDto> list = syncAllCountService.countSyncApp(findDto,
				page);
		model.addAttribute("list", list);
		return "/count/sync/countSyncAppByDate";
	}

	public static void main(String[] args) {
		System.out.println((18) / 28.0);
	}
}
