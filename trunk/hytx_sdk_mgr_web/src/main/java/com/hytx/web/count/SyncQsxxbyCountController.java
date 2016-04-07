package com.hytx.web.count;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hytx.dto.count.SyncQsxxbyDto;
import com.hytx.service.count.ISyncQsxxbyCountService;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/sync")
public class SyncQsxxbyCountController {
	@Autowired
	private ISyncQsxxbyCountService syncQsxxbyCountService;

	@RequestMapping(value = "countSyncQsxxbyByDate")
	public String syncAllCount(SyncQsxxbyDto findDto, Page<SyncQsxxbyDto> page,
			Model model) {
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncQsxxbyDto> list = syncQsxxbyCountService.countSyncQsxxby(
				findDto, page);
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("list", list);
		return "/count/sync/countSyncQsxxbyByDate";
	}

}
