package com.hytx.web.baseConf;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.EnumStatus;
import com.hytx.model.baseConf.Channel;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IChannelService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/channel")
public class ChannelController {
	@Autowired
	@Qualifier("channelServiceImpl")
	private IChannelService channelService;

	/***
	 * 功能描述：查询渠道列表
	 * 
	 * @param page
	 * @param channel
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 * 
	 */
	@RequestMapping(value = "channelList")
	public String findChannelList(Page page, Channel channel,
			Map<String, Object> map, HttpServletRequest request) {
		List<Channel> channelList = channelService.selectChannelsByPage(
				channel, page);
		map.put("list", channelList);
		map.put("command", channel);
		return "/baseConf/channel/channelList";
	}

	/***
	 * 功能描述：跳转到渠道添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "toChannelInfo")
	public String toChannelInfo(Integer id, Model model) {
		Channel channel = new Channel();
		if (id != null) {
			channel = channelService.selectByPrimaryKey(id);
		}
		model.addAttribute("channel", channel);

		return "/baseConf/channel/addOrEditChannel";
	}

	/***
	 * 功能描述:添加或编辑渠道
	 * 
	 * @param channel
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "addOrEditChannel")
	public String addOrEditChannel(@ModelAttribute("channel") Channel channel,
			HttpServletRequest request) {
		try {
			if (channel == null) {
				return "redirect:/baseConf/channel/channelList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			channel.setUpdateDt(new Date());
			channel.setUpdateBy(userSession.getUserName());
			channel.setStatus(EnumStatus.ok.getValue());
			if (channel.getId() != null) {
				channelService.updateByPrimaryKeySelective(channel);
			} else {
				channel.setCreateDt(new Date());
				channel.setCreateBy(userSession.getUserName());
				channelService.insert(channel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/channel/channelList";
	}

	/**
	 * 功能描述:根据渠道ids删除渠道
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "/delChannel", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = channelService.deleteChannelByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 功能描述:根据cp筛选渠道
	 * 
	 * @param cpId
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "/selectChannelsByCp", produces = "application/json")
	@ResponseBody
	public Object selectChannelsByCp(Integer cpId) {
		List<Channel> list = new ArrayList<Channel>();
		try {
			list = channelService.selectByCpId(cpId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 功能描述:根据app筛选渠道
	 * 
	 * @param cpId
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "/selectChannelsByApp", produces = "application/json")
	@ResponseBody
	public Object selectChannelsByApp(Integer appId) {
		List<Channel> list = new ArrayList<Channel>();
		try {
			list = channelService.selectByAppId(appId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
