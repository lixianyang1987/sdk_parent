package com.hytx.web.count;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hytx.dto.client.ReqSmsCommandDto;
import com.hytx.dto.client.ReqSmsLogDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.baseConf.Province;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.count.IReqSmsCountService;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/reqSms")
public class ReqSmsLogCountController {
	@Autowired
	private IReqSmsCountService reqSmsCountService;
	@Autowired
	private IAppService appService;
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IProvinceService provinceService;

	@RequestMapping("countReqSms")
	public String countReqSms(Page<ReqSmsLogDto> page, ReqSmsLogDto findReqSms,
			Map<String, Object> map) {
		if (StringUtils.isBlank(findReqSms.getStartDate())) {
			findReqSms.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findReqSms.getEndDate())) {
			findReqSms.setEndDate(findReqSms.getStartDate());
		}
		List<ReqSmsLogDto> list = reqSmsCountService.selectReqSmssByPage(
				findReqSms, page);
		List<Channel> chList = channelService.selectAllActiveChannel();
		List<App> appList = appService.selectAppsOfChannel(findReqSms
				.getChannelId());
		List<Province> proList = provinceService.selectAllActiveProvince();
		map.put("proList", proList);
		map.put("list", list);
		map.put("chList", chList);
		map.put("appList", appList);
		map.put("command", findReqSms);
		return "/count/reqSms/countReqSms";
	}

	@RequestMapping(value = "findReqSmsCommands")
	public String findReqSmsCommands(@RequestParam("orderId") String orderId,
			Map<String, Object> map) {
		List<ReqSmsCommandDto> list = reqSmsCountService
				.findReqSmsCommands(orderId);
		map.put("list", list);
		return "/count/reqSms/reqSmsCommand";
	}

}
