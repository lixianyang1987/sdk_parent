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

import com.hytx.constance.EnumStatus;
import com.hytx.model.baseConf.CpInfo;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.ICpInfoService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/cpInfo")
public class CpInfoController {
	@Autowired
	@Qualifier("cpInfoServiceImpl")
	private ICpInfoService cpInfoService;
	@Autowired
	private IAppService appService;

	/***
	 * 功能描述：查询CP列表
	 * 
	 * @param page
	 * @param cpInfo
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 * 
	 */
	@RequestMapping(value = "cpInfoList")
	public String findCpInfoList(Page page, CpInfo cpInfo,
			Map<String, Object> map, HttpServletRequest request) {
		List<CpInfo> cpInfoList = cpInfoService.selectCpInfosByPage(cpInfo,
				page);
		map.put("list", cpInfoList);
		map.put("command", cpInfo);
		return "/baseConf/cpInfo/cpInfoList";
	}

	/***
	 * 功能描述：跳转到CP添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "toCpInfoInfo")
	public String toCpInfoInfo(Integer id, Model model) {
		CpInfo cpInfo = new CpInfo();
		if (id != null) {
			cpInfo = cpInfoService.selectByPrimaryKey(id);
		}
		model.addAttribute("cpInfo", cpInfo);

		return "/baseConf/cpInfo/addOrEditCpInfo";
	}

	/***
	 * 功能描述:添加或编辑CP
	 * 
	 * @param cpInfo
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "addOrEditCpInfo")
	public String addOrEditCpInfo(@ModelAttribute("cpInfo") CpInfo cpInfo,
			HttpServletRequest request) {
		try {
			if (cpInfo == null) {
				return "redirect:/baseConf/cpInfo/cpInfoList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			cpInfo.setUpdateDt(new Date());
			cpInfo.setUpdateBy(userSession.getUserName());
			cpInfo.setStatus(EnumStatus.ok.getValue());
			if (cpInfo.getId() != null) {
				cpInfoService.updateByPrimaryKey(cpInfo);
			} else {
				cpInfo.setCreateDt(new Date());
				cpInfo.setCreateBy(userSession.getUserName());
				cpInfoService.insert(cpInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/cpInfo/cpInfoList";
	}

	/**
	 * 功能描述:根据CPids删除CP
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	@RequestMapping(value = "/delCpInfo", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int count = appService.countByCpIds(idList);
				if (count > 0) {
					map.put("status", -1);
				} else {
					int rows = cpInfoService.deleteCpInfoByIds(idList);
					map.put("status", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 0);
		}
		return map;
	}
}
