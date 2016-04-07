package com.hytx.web.count;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.count.DayLimitDto;
import com.hytx.service.count.IMessageService;

@Controller
@RequestMapping("/count/message")
public class MessageController {
	@Autowired
	@Qualifier("messageServiceImpl")
	private IMessageService messageService;

	@RequestMapping(value = "messageList")
	public String messege(Model model) {
		return "/count/message/messageList";
	}

	/****
	 * 功能描述：查询渠道包省份限量告警消息提醒列表
	 * 
	 * @param map
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年8月3日
	 */
	@RequestMapping(value = "channelAppMessageList", produces = "application/json")
	@ResponseBody
	public Map<String, Object> findChannelAppMessageList(
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DayLimitDto> messageList = messageService
				.selectChannelAppMessage();
		map.put("msChannelApp", messageList);
		return map;
	}

	/****
	 * 功能描述：查询应用省份限量告警消息提醒列表
	 * 
	 * @param map
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年8月3日
	 */
	@RequestMapping(value = "appMessageList", produces = "application/json")
	@ResponseBody
	public Map<String, Object> findAppMessageList(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DayLimitDto> messageList = messageService.selectAppMessage();
		map.put("msApp", messageList);
		return map;
	}

}
