package com.hytx.web.count;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hytx.dto.client.SdkLoadDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.baseConf.Province;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.ISdkLoadService;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/reqSms")
public class SdkLoadCountController {
	@Autowired
	private ISdkLoadService sdkLoadService;
	@Autowired
	private IAppService appService;
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IProvinceService provinceService;

	@RequestMapping("countSdkLoad")
	public String countReqSms(Page<SdkLoadDto> page, SdkLoadDto findDto,
			Map<String, Object> map) {
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		List<SdkLoadDto> list = sdkLoadService.selectAppsByPage(findDto, page);
		List<Channel> chList = channelService.selectAllActiveChannel();
		List<App> appList = appService.selectAppsOfChannel(findDto
				.getChannelId());
		List<Province> proList = provinceService.selectAllActiveProvince();
		map.put("proList", proList);
		map.put("list", list);
		map.put("chList", chList);
		map.put("appList", appList);
		map.put("command", findDto);
		return "/count/reqSms/countSdkLoad";
	}

}
