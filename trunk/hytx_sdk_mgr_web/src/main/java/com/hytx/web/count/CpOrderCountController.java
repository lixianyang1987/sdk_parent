package com.hytx.web.count;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hytx.dto.count.CpOrderCountDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.Channel;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.service.baseConf.ICpInfoService;
import com.hytx.service.count.ISyncAllCountService;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/sync")
public class CpOrderCountController {
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IAppService appService;
	@Autowired
	@Qualifier("cpInfoServiceImpl")
	private ICpInfoService cpInfoService;
	@Autowired
	private ISyncAllCountService syncAllCountService;

	@RequestMapping(value = "countCpOrderByDate")
	public String countCpOrderByDate(CpOrderCountDto findDto,
			Page<CpOrderCountDto> page, Model model) {
		// 初始化查询条件
		List<App> appList = appService.selectAppsByChannelAndCp(
				findDto.getChannelId(), findDto.getCpId());
		List<Channel> channelList = channelService.selectByCpId(findDto
				.getCpId());
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("appList", appList);
		model.addAttribute("channelList", channelList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		List<CpOrderCountDto> list = syncAllCountService.countCpOrder(findDto);
		model.addAttribute("list", list);
		return "/count/sync/countCpOrderByDate";
	}

	@RequestMapping(value = "countChannelOrderByDate/{channelId:\\d+}")
	public String channelOrdersCount(CpOrderCountDto findDto,
			Page<CpOrderCountDto> page, Model model,
			@PathVariable("channelId") Integer channelId) {
		findDto.setChannelId(channelId);
		// 初始化查询条件
		List<App> appList = appService.selectAppsOfChannel(channelId);
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("appList", appList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		List<CpOrderCountDto> list = syncAllCountService.countCpOrder(findDto);
		model.addAttribute("list", list);
		return "/count/sync/countChannelOrderByDate";

	}

	/*@RequestMapping(value = "countCpOrderByServerType")
	public String countCpOrderByServerType(CpOrderCountDto findDto,
			Page<CpOrderCountDto> page, Model model) {
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		List<CpOrderCountDto> list = syncAllCountService.countCpOrder(findDto);
		model.addAttribute("list", list);
		return "/count/sync/countCpOrderByDate";
	}

	@RequestMapping(value = "countChannelOrderByServerType/{channelId:\\d+}")
	public String serverTypeOrdersCount(CpOrderCountDto findDto,
			Page<CpOrderCountDto> page, Model model,
			@PathVariable("channelId") Integer channelId) {
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		List<CpOrderCountDto> list = syncAllCountService.countCpOrder(findDto);
		model.addAttribute("list", list);
		return "/count/sync/countChannelOrderByDate";

	}*/

}
