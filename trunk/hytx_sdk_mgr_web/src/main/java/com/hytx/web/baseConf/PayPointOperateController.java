package com.hytx.web.baseConf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.BaseContance;
import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.baseConf.PayPointOperate;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IOperateService;
import com.hytx.service.baseConf.IPayPointOperateService;
import com.hytx.service.baseConf.IPayPointService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/payPointOperate")
public class PayPointOperateController {
	@Autowired
	@Qualifier("payPointOperateServiceImpl")
	private IPayPointOperateService payPointOperateService;
	@Autowired
	@Qualifier("payPointServiceImpl")
	private IPayPointService payPointService;
	@Autowired
	private IOperateService operateService;

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
	@RequestMapping(value = "payPointOperateList")
	public String findPayPointOperateList(Integer id,
			PayPointOperate payPointOperate, Map<String, Object> map,
			HttpServletRequest request) {
		if (payPointOperate.getPaypointId() != null) {
			PayPoint payPoint = payPointService
					.selectByPrimaryKey(payPointOperate.getPaypointId());
			map.put("payPoint", payPoint);
			List<OperateDto> operateList = payPointOperateService
					.selectPayPointOperates(payPointOperate);
			map.put("list", operateList);
		}
		return "/baseConf/payPointOperate/payPointOperateList";
	}

	@RequestMapping(value = "toPayPointOperateAdd")
	public String toPayPointOperateAdd(Page page,
			@ModelAttribute("findOperate") OperateDto findOperate,
			Map<String, Object> map) {
		findOperate.setStatus(BaseContance.ACTIVICE_STATUS);
		List<Operate> operateList = operateService.selectOperatesByPage(
				findOperate, page);
		map.put("list", operateList);
		return "/baseConf/payPointOperate/addPayPointOperate";
	}

	/**
	 * 功能描述:添加渠道包指令
	 * 
	 * @param payPointOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/addPayPointOperate", produces = "application/json")
	@ResponseBody
	public Map<String, Object> addPayPointOperate(
			PayPointOperate payPointOperate, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User userSession = RequestUtil.getUserSession(request);
			payPointOperate.setCreateBy(userSession.getUserName());
			payPointOperate.setCreateDt(new Date());
			payPointOperateService.insertPayPointOperate(payPointOperate);
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
	@RequestMapping(value = "/delPayPointOperate", produces = "application/json")
	@ResponseBody
	public Object delPayPointOperate(String ids, Integer payPointId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = payPointOperateService.deletePayPointOperateByIds(
						idList, payPointId);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
