package com.hytx.web.count;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.count.KeyValueDto;
import com.hytx.dto.count.SyncExCountDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import com.hytx.model.baseConf.CpInfo;
import com.hytx.model.baseConf.SettlementMethod;
import com.hytx.model.syncEx.SyncByLog;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.service.baseConf.ICpInfoService;
import com.hytx.service.baseConf.ISettlementMethodService;
import com.hytx.service.count.ISyncExCountService;
import com.hytx.service.count.ISyncLogCountService;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.ISyncbyRetainedService;
import com.hytx.util.JsonMapper;
import com.hytx.util.Page;

/****
 * 接放代码统计功能
 * 
 * @author houzz
 *
 */
@Controller
@RequestMapping("/count/sync")
public class SyncExCountController {
	@Autowired
	private ISyncExCountService syncExCountService;
	@Autowired
	private IAppService appServer;
	@Autowired
	private IChannelService channelService;
	@Autowired
	private IChannelAppService channeapplService;
	@Autowired
	private ICpInfoService cpInfoService;
	@Autowired
	private ISettlementMethodService settlementMethodService;
	@Autowired
	private ISyncLogCountService syncLogCountService;

	/****
	 * 接放代码统计
	 * 
	 * @param findDto
	 * @param page
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2015年12月21日
	 */
	@RequestMapping(value = "countSyncExByDate")
	public String syncExCount(SyncExCountDto findDto,
			Page<SyncExCountDto> page, HttpServletRequest request, Model model) {
		// 初始化查询条件
		List<ChannelApp> channelAppList = syncExCountService
				.findSyncExChannelApp();
		List<App> appList = appServer.selectAppsByChannelAndCp(-1,
				findDto.getSpId());
		List<Channel> channelList = channelService.selectByAppId(findDto
				.getAppId());
		List<CpInfo> cpInfoList = cpInfoService.selectAllActiveCpInfos();
		List<SettlementMethod> smList = settlementMethodService
				.selectSettlementMethod();
		model.addAttribute("appList", appList);
		model.addAttribute("smList", smList);
		model.addAttribute("channelList", channelList);
		model.addAttribute("cpInfoList", cpInfoList);
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("channelAppList", channelAppList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncExCountDto> list = syncExCountService.countSyncEx(findDto,
				page);

		if (list != null && !list.isEmpty()) {
			SyncExCountDto dto = new SyncExCountDto();
			dto.setChannelAppName("汇总:");
			int totalUsers = 0;
			int upCount = 0;
			int downCount = 0;
			int sucCount = 0;
			int reduceCount = 0;
			int syncedCount = 0;
			int totalFeeValue = 0;
			for (SyncExCountDto tmpDto : list) {
				totalUsers = totalUsers + tmpDto.getTotalUsers();
				upCount = upCount + tmpDto.getUpCount();
				downCount = downCount + tmpDto.getDownCount();
				sucCount = sucCount + tmpDto.getSucCount();
				reduceCount = reduceCount + tmpDto.getReduceCount();
				syncedCount = syncedCount + tmpDto.getSyncedCount();
				totalFeeValue = totalFeeValue + tmpDto.getSucCount()
						* tmpDto.getFeeValue() / 100;
			}
			dto.setTotalFeeValue(totalFeeValue);
			dto.setTotalUsers(totalUsers);
			dto.setUpCount(upCount);
			dto.setDownCount(downCount);
			dto.setSucCount(sucCount);
			dto.setReduceCount(reduceCount);
			dto.setSyncedCount(syncedCount);
			list.add(dto);
		}

		model.addAttribute("list", list);
		return "/count/sync/countSyncExByDate";
	}

	/****
	 * 接放代码统计
	 * 
	 * @param findDto
	 * @param page
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2015年12月21日
	 */
	@RequestMapping(value = "countSyncExJsonByDate", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String syncExCountJson(SyncExCountDto findDto,
			Page<SyncExCountDto> page, HttpServletRequest request) {
		String callback = request.getParameter("callback");
		if (StringUtils.isBlank(callback)) {
			callback = "callback";
		}
		String backString = "";
		Map<String, Object> map = new HashMap<String, Object>();
		String ip = request.getRemoteAddr();
		if (!("182.18.37.141".equals(ip) || "114.243.216.9".equals(ip) || "127.0.0.1"
				.equals(ip))) {
			backString = "{\"success\":false}";
			return callback + "(" + backString + ")";
		}
		// 初始化查询条件
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncExCountDto> list = syncExCountService.countSyncEx(findDto,
				page);

		if (list != null && !list.isEmpty()) {
			SyncExCountDto dto = new SyncExCountDto();
			dto.setChannelAppName("汇总:");
			int totalUsers = 0;
			int upCount = 0;
			int downCount = 0;
			int sucCount = 0;
			int reduceCount = 0;
			int syncedCount = 0;
			int totalFeeValue = 0;
			for (SyncExCountDto tmpDto : list) {
				totalUsers = totalUsers + tmpDto.getTotalUsers();
				upCount = upCount + tmpDto.getUpCount();
				downCount = downCount + tmpDto.getDownCount();
				sucCount = sucCount + tmpDto.getSucCount();
				reduceCount = reduceCount + tmpDto.getReduceCount();
				syncedCount = syncedCount + tmpDto.getSyncedCount();
				totalFeeValue = totalFeeValue + tmpDto.getSucCount()
						* tmpDto.getFeeValue() / 100;
			}
			dto.setTotalFeeValue(totalFeeValue);
			dto.setTotalUsers(totalUsers);
			dto.setUpCount(upCount);
			dto.setDownCount(downCount);
			dto.setSucCount(sucCount);
			dto.setReduceCount(reduceCount);
			dto.setSyncedCount(syncedCount);
			map.put("total", dto);
		}
		map.put("list", list);
		map.put("success", true);
		backString = JsonMapper.toNonEmptyJson(map);
		return callback + "(" + backString + ")";
	}

	/****
	 * 接放代码统计
	 * 
	 * @param findDto
	 * @param page
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2015年12月21日
	 */
	@RequestMapping(value = "syncExMonthDayCountJson", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String syncExMonthDayCountJson(SyncExCountDto findDto,
			HttpServletRequest request,
			@RequestParam(value = "dataRange", required = false) int dataRange) {
		String callback = request.getParameter("callback");
		if (StringUtils.isBlank(callback)) {
			callback = "callback";
		}
		String backString = "";
		Map<String, Object> map = new HashMap<String, Object>();
		String ip = request.getRemoteAddr();
		if (!("182.18.37.141".equals(ip) || "114.243.216.9".equals(ip) || "127.0.0.1"
				.equals(ip))) {
			backString = "{\"success\":false}";
			return callback + "(" + backString + ")";
		}

		// 按查询条件查询数据
		List<KeyValueDto<Long>> list = null;
		if (dataRange == 2) {
			// 初始化查询条件
			findDto.setLeftDate(DateUtils.truncate(new Date(),
					Calendar.DAY_OF_MONTH));
			findDto.setRightDate(DateUtils.addDays(findDto.getLeftDate(), 1));
			list = syncExCountService.selectDayHourIncome(findDto);
		} else {
			// 初始化查询条件
			findDto.setLeftDate(DateUtils.truncate(new Date(), Calendar.MONTH));
			findDto.setRightDate(DateUtils.addMonths(findDto.getLeftDate(), 1));
			list = syncExCountService.selectMonthDayIncome(findDto);
		}
		map.put("list", list);
		map.put("success", true);
		backString = JsonMapper.toNonEmptyJson(map);
		return callback + "(" + backString + ")";
	}

	/****
	 * 接放代码详情统计
	 * 
	 * @param findDto
	 * @param page
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2015年12月21日
	 */
	@RequestMapping(value = "countSyncExDetailByDate")
	public String syncExDetailCount(SyncExCountDto findDto,
			Page<SyncExCountDto> page, Model model) {
		// 初始化查询条件
		List<ChannelApp> channelAppList = syncExCountService
				.findSyncExChannelApp();
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("channelAppList", channelAppList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncExCountDto> list = syncExCountService.countSyncExDetail(
				findDto, page);
		model.addAttribute("list", list);
		return "/count/sync/countSyncExDetailByDate";
	}

	// 单渠道详情统计
	@RequestMapping(value = "countSyncExDetailByDateC/{channelId:\\d+}")
	public String syncExDetailCountCh(SyncExCountDto findDto,
			Page<SyncExCountDto> page, Model model,
			@PathVariable("channelId") Integer channelId) {
		findDto.setChannelId(channelId);
		findDto.setReduceStatus(1);
		// 初始化查询条件
		ChannelAppExample example = new ChannelAppExample();
		example.createCriteria().andChannelIdEqualTo(channelId);
		List<ChannelApp> channelAppList = channeapplService
				.selectChannelAppIdlist(example);

		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("channelAppList", channelAppList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		// 按查询条件查询数据
		List<SyncExCountDto> list = syncExCountService.countSyncExDetail(
				findDto, page);
		model.addAttribute("list", list);
		return "/count/sync/countSyncExDetailByDateChannel";
	}

	/****
	 * 单渠道接放代码统计
	 * 
	 * @param findDto
	 * @param page
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2015年12月21日
	 */
	@RequestMapping(value = "countSyncExByDateC/{channelId:\\d+}")
	public String syncExCountC(SyncExCountDto findDto,
			Page<SyncExCountDto> page, HttpServletRequest request, Model model,
			@PathVariable("channelId") Integer channelId) {
		// 初始化查询条件
		ChannelAppExample example = new ChannelAppExample();
		example.createCriteria().andChannelIdEqualTo(channelId);
		List<ChannelApp> channelAppList = channeapplService
				.selectChannelAppIdlist(example);
		model.addAttribute("command", findDto);
		model.addAttribute("findDto", findDto);
		model.addAttribute("channelAppList", channelAppList);
		if (StringUtils.isBlank(findDto.getStartDate())) {
			findDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(findDto.getEndDate())) {
			findDto.setEndDate(findDto.getStartDate());
		}
		findDto.setChannelId(channelId);
		findDto.setReduceStatus(1);
		// 按查询条件查询数据
		List<SyncExCountDto> list = syncExCountService.countSyncEx(findDto,
				page);

		if (list != null && !list.isEmpty()) {
			SyncExCountDto dto = new SyncExCountDto();
			dto.setChannelAppName("汇总:");
			int totalUsers = 0;
			int upCount = 0;
			int downCount = 0;
			int sucCount = 0;
			int reduceCount = 0;
			int syncedCount = 0;
			int totalFeeValue = 0;
			for (SyncExCountDto tmpDto : list) {
				totalUsers = totalUsers + tmpDto.getTotalUsers();
				upCount = upCount + tmpDto.getUpCount();
				downCount = downCount + tmpDto.getDownCount();
				sucCount = sucCount + tmpDto.getSucCount();
				reduceCount = reduceCount + tmpDto.getReduceCount();
				syncedCount = syncedCount + tmpDto.getSyncedCount();
				totalFeeValue = totalFeeValue + tmpDto.getSucCount()
						* tmpDto.getFeeValue() / 100;
			}
			dto.setTotalFeeValue(totalFeeValue);
			dto.setTotalUsers(totalUsers);
			dto.setUpCount(upCount);
			dto.setDownCount(downCount);
			dto.setSucCount(sucCount);
			dto.setReduceCount(reduceCount);
			dto.setSyncedCount(syncedCount);
			list.add(dto);
		}

		model.addAttribute("list", list);
		return "/count/sync/countSyncExByDateC";
	}
	
	
	// 单渠道流水
		@RequestMapping(value = "countSyncExDetailByLogC/{channelId:\\d+}")
		public String syncExDetailLogCh(SyncByLog findDto,
				Page<SyncByLog> page, Model model,
				@PathVariable("channelId") Integer channelId) {
			findDto.setCoopid(channelId);
			findDto.setReduceStatus(1);
			// 初始化查询条件
			
			
		

			model.addAttribute("command", findDto);
			model.addAttribute("findDto", findDto);
			
			if (StringUtils.isBlank(findDto.getStartDate())) {
				findDto.setStartDate(DateFormatUtils.format(new Date(),
						"yyyy-MM-dd"));
			}
			if (StringUtils.isBlank(findDto.getEndDate())) {
				findDto.setEndDate(findDto.getStartDate());
			}
			// 按查询条件查询数据
			List<SyncByLog> list = syncLogCountService.syncByLogcount(
					findDto, page);
			model.addAttribute("list", list);
			return "/count/sync/countSyncExDetailByDateChannel";
		}

	public static void main(String[] args) {
		System.out.println(DateFormatUtils.format(
				DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH),
				"yyyy-MM-dd HH:mm:ss"));
	}
}
