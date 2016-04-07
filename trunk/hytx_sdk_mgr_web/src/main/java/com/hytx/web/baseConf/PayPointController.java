package com.hytx.web.baseConf;

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

import com.hytx.constance.BaseContance;
import com.hytx.constance.EnumStatus;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IPayPointService;
import com.hytx.util.ListUtil;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/payPoint")
public class PayPointController {
	@Autowired
	@Qualifier("payPointServiceImpl")
	private IPayPointService payPointService;
	@Autowired
	private IAppService appService;

	/***
	 * 功能描述：查询计费点列表
	 * 
	 * @param page
	 * @param payPoint
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 * 
	 */
	@RequestMapping(value = "payPointList")
	public String findPayPointList(Page<PayPoint> page, PayPoint payPoint,
			Map<String, Object> map, HttpServletRequest request) {
		List<PayPoint> payPointList = payPointService.selectPayPointsByPage(
				payPoint, page);
		map.put("list", payPointList);
		map.put("command", payPoint);
		List<App> appList = appService.selectAllActiveApp();
		App app = new App();
		app.setId(-1);
		app.setAppName("=全部=");
		appList.add(0, app);
		map.put("appMap", ListUtil.changeListToMap(appList, "id", "appName"));
		map.put("appList", appList);
		return "/baseConf/payPoint/payPointList";
	}

	/***
	 * 功能描述：跳转到计费点添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	@RequestMapping(value = "toPayPointInfo")
	public String toPayPointInfo(Integer id, Model model) {
		PayPoint payPoint = new PayPoint();
		if (id != null) {
			payPoint = payPointService.selectByPrimaryKey(id);
		}
		model.addAttribute("payPoint", payPoint);
		List<App> appList = appService.selectAllActiveApp();
		model.addAttribute("appList", appList);
		return "/baseConf/payPoint/addOrEditPayPoint";
	}

	/***
	 * 功能描述:添加或编辑计费点
	 * 
	 * @param payPoint
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	@RequestMapping(value = "addOrEditPayPoint")
	public String addOrEditPayPoint(
			@ModelAttribute("payPoint") PayPoint payPoint,
			HttpServletRequest request) {
		try {
			if (payPoint == null) {
				return "redirect:/baseConf/payPoint/payPointList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			payPoint.setUpdateDt(new Date());
			payPoint.setUpdateBy(userSession.getUserName());
			if (payPoint.getId() != null) {
				payPointService.updateByPrimaryKeySelective(payPoint);
			} else {
				payPoint.setStatus(BaseContance.NOT_ACTIVICE_STATUS);// 新添加时为不可用状态
				payPoint.setCreateDt(new Date());
				payPoint.setCreateBy(userSession.getUserName());
				payPointService.insert(payPoint);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/payPoint/payPointList";
	}

	/**
	 * 功能描述:根据计费点ids删除计费点
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	@RequestMapping(value = "/delPayPoint", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				payPointService.deletePayPointByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/***
	 * 更改单个计费点状态
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "chPaypointState")
	@ResponseBody
	public Map<String, Object> updateRoleState(Integer id, Integer status) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (id == null || status == null || !EnumStatus.isEfficient(status)) {
			map.put("status", false);
			map.put("info", "参数不合法");
			return map;
		}
		if (status.equals(BaseContance.ACTIVICE_STATUS)) {
			String errorInfo = payPointService.checkOpenConditionError(id);
			if (errorInfo != null) {
				map.put("status", false);
				map.put("info", errorInfo);
				return map;
			}
		}
		PayPoint payPoint = new PayPoint();
		payPoint.setStatus(status);
		payPoint.setId(id);
		payPointService.updateByPrimaryKeySelective(payPoint);
		map.put("status", true);
		return map;
	}
}
