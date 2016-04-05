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
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.ChannelAppOperate;
import com.hytx.model.baseConf.ChannelAppPayPoint;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IChannelAppOperateService;
import com.hytx.service.baseConf.IChannelAppPayPointService;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.ListUtil;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/channelAppPayPoint")
public class ChannelAppPayPointController {
	@Autowired
	@Qualifier("channelAppPayPointServiceImpl")
	private IChannelAppPayPointService channelAppPayPointService;
	@Autowired
	@Qualifier("channelAppServiceImpl")
	private IChannelAppService channelAppService;
	@Autowired
	private IAppService appService;

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
	@RequestMapping(value = "channelAppPayPointList")
	public String findChannelAppOperateList(Page page, ChannelAppPayPoint channelAppPayPoint,
			Map<String, Object> map, HttpServletRequest request
			) {
		if(channelAppPayPoint.getId()!=null){
			ChannelAppDto dto=channelAppService.selectChannelAppDtoById(Integer.parseInt(channelAppPayPoint.getId()+""));
			map.put("dto", dto);
			List<App> appList = appService.selectAllActiveApp();
			map.put("appMap", ListUtil.changeListToMap(appList, "id", "appName"));
			channelAppPayPoint.setChannelAppId(dto.getId()+"");
			List<PayPoint> payPointList = channelAppPayPointService.selectPayPointesByPage(channelAppPayPoint, page);
			map.put("list", payPointList);
			}
		return "/baseConf/channelAppPayPoint/channelAppPayPointList";
	}

	@RequestMapping(value="toChannelAppPayPointAdd")
	public String toChannelAppOperateAdd(Page page,ChannelAppPayPoint channelAppPayPoint,Map<String, Object>map){
		List<PayPoint> payPointList = channelAppPayPointService.selectNotAddedPayPointesByPage(channelAppPayPoint, page);
		
		map.put("list", payPointList);
		return "/baseConf/channelAppPayPoint/addChannelAppPayPoint";
	}

	/**
	 * 功能描述:添加渠道包指令
	 * 
	 * @param channelAppOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/addChannelAppPayPoint", produces = "application/json")
	@ResponseBody
	public Map<String,Object>addChannelAppOperate(ChannelAppPayPoint channelAppPayPint,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		  User userSession = RequestUtil.getUserSession(request);
		  channelAppPayPint.setCreateBy(userSession.getUserName());
		  channelAppPayPint.setCreateDt(new Date());
		  channelAppPayPointService.addChannelAppPayPoint(channelAppPayPint);
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
	@RequestMapping(value = "/delChannelAppPayPoint", produces = "application/json")
	@ResponseBody
	public Object delChannelAppOperate(String ids,Integer channelAppId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = channelAppPayPointService.deleteChannelAppPayPointByIds(idList, channelAppId);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
