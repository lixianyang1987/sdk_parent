package com.hytx.web.xzf;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.xzf.XzfCountDto;
import com.hytx.dto.xzf.XzfFlowLogDto;
import com.hytx.service.xzf.IXzfCountService;
import com.hytx.util.JsonMapper;
import com.hytx.util.Page;

@Controller
@RequestMapping("/count/xzf")
public class XzfCountController {
	@Autowired
	private IXzfCountService xzfCountService;

	/****
	 * 信支付订单概要统计
	 * 
	 * @param findDto
	 * @param page
	 * @param request
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2016年1月11日
	 */
	@RequestMapping(value = "countXzfByDate")
	public String countXzfByDate(XzfCountDto findDto, Page<XzfCountDto> page,
			HttpServletRequest request, Model model) {
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
		List<XzfCountDto> list = xzfCountService.countXzfOrders(findDto, page);

		model.addAttribute("list", list);
		return "/count/xzf/countXzfByDate";
	}

	/****
	 * 信支付订单概要统计
	 * 
	 * @param findDto
	 * @param page
	 * @param model
	 * @return
	 * @author houzz
	 * @date 2015年12月21日
	 */
	@RequestMapping(value = "countXzfJsonByDate", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String countXzfJsonByDate(XzfCountDto findDto,
			Page<XzfCountDto> page, HttpServletRequest request) {
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
		List<XzfCountDto> list = xzfCountService.countXzfOrders(findDto, page);
		map.put("list", list);
		map.put("success", true);
		backString = JsonMapper.toNonEmptyJson(map);
		return callback + "(" + backString + ")";
	}

	/****
	 * 信支付日志查询
	 * 
	 * @param page
	 * @param xzfFlowLog
	 * @param map
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2016年1月13日
	 */
	@RequestMapping(value = "xzfLogList")
	public String findXzfLogList(Page page, XzfFlowLogDto xzfFlowLogDto,
			Map<String, Object> map, HttpServletRequest request) {
		// 初始化查询条件
		if (StringUtils.isBlank(xzfFlowLogDto.getStartDate())) {
			xzfFlowLogDto.setStartDate(DateFormatUtils.format(new Date(),
					"yyyy-MM-dd"));
		}
		if (StringUtils.isBlank(xzfFlowLogDto.getEndDate())) {
			xzfFlowLogDto.setEndDate(xzfFlowLogDto.getStartDate());
		}
		List<XzfFlowLogDto> logList = xzfCountService.selectXzfLogsByPage(
				xzfFlowLogDto, page);
		TreeMap<String, List<XzfFlowLogDto>> dataMap = new TreeMap<String, List<XzfFlowLogDto>>();
		String tempOrderId = null;
		List<XzfFlowLogDto> tempList = null;
		if (logList != null && !logList.isEmpty()) {
			for (XzfFlowLogDto dto : logList) {
				tempOrderId = dto.getOrderId();
				tempList = dataMap.get(tempOrderId);
				if (tempList == null) {
					tempList = new ArrayList<XzfFlowLogDto>();
					tempList.add(dto);
					dataMap.put(tempOrderId, tempList);
				} else {
					tempList.add(dto);
				}
			}
		}
		map.put("dataMap", dataMap);
		map.put("command", xzfFlowLogDto);
		return "/count/xzf/xzfLogList";
	}

}
