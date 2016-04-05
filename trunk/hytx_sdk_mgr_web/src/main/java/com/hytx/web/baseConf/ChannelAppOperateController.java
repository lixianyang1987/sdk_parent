package com.hytx.web.baseConf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.baseConf.ChannelAppDto;
import com.hytx.model.baseConf.ChannelAppOperate;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IChannelAppOperateService;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/channelAppOperate")
public class ChannelAppOperateController {
	@Autowired
	@Qualifier("channelAppOperateServiceImpl")
	private IChannelAppOperateService channelAppOperateService;
	@Autowired
	@Qualifier("channelAppServiceImpl")
	private IChannelAppService channelAppService;

	/***
	 * 功能描述：查询指令列表
	 * 
	 * @param page
	 * @param operate
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 * 
	 */
	@RequestMapping(value = "channelAppOperateList")
	public String findChannelAppOperateList(Page page, ChannelAppOperate channelAppOperate,
			Map<String, Object> map, HttpServletRequest request
			) {
		if(channelAppOperate.getId()!=null){
			ChannelAppDto dto=channelAppService.selectChannelAppDtoById(channelAppOperate.getId());
			map.put("dto", dto);
			channelAppOperate.setChannelId(dto.getChannelId());
			channelAppOperate.setAppId(dto.getAppId());
			channelAppOperate.setChannelAppId(dto.getId());
			List<Operate> operateList = channelAppOperateService.selectOperatesByPage(
					channelAppOperate, page);
			map.put("list", operateList);
		}
		return "/baseConf/channelAppOperate/channelAppOperateList";
	}

	@RequestMapping(value="toChannelAppOperateAdd")
	public String toChannelAppOperateAdd(Page page,ChannelAppOperate channelAppOperate,Map<String, Object>map){
		List<Operate> operateList = channelAppOperateService.selectNotAddedOperatesByPage(
				channelAppOperate, page);
		map.put("list", operateList);
		return "/baseConf/channelAppOperate/addChannelAppOperate";
	}

	/**
	 * 功能描述:添加渠道包指令
	 * 
	 * @param channelAppOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/addChannelAppOperate", produces = "application/json")
	@ResponseBody
	public Map<String,Object>addChannelAppOperate(ChannelAppOperate channelAppOperate,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		  User userSession = RequestUtil.getUserSession(request);
		  channelAppOperate.setCreateBy(userSession.getUserName());
		  channelAppOperate.setCreateDt(new Date());
		  channelAppOperateService.addChannelAppOperate(channelAppOperate);
		  map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	
	/**
	 * 功能描述:根据指令ids删除渠道包指令
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "/delChannelAppOperate", produces = "application/json")
	@ResponseBody
	public Object delChannelAppOperate(String ids,Integer channelAppId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = channelAppOperateService.deleteChannelAppOperateByIds(idList,channelAppId);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
