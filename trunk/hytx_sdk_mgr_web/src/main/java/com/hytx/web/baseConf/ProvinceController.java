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

import com.hytx.dto.baseConf.ProvinceDto;
import com.hytx.model.baseConf.Province;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IProvinceCityService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/province")
public class ProvinceController {
	@Autowired
	@Qualifier("provinceServiceImpl")
	private IProvinceService provinceService;

	@Autowired
	@Qualifier("provinceCityServiceImpl")
	private IProvinceCityService provinceCityService;

	/***
	 * 功能描述：查询省份列表
	 * 
	 * @param page
	 * @param province
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 * 
	 */
	@RequestMapping(value = "provinceList")
	public String findProvinceList(Page page, Province province,
			Map<String, Object> map, HttpServletRequest request) {
		List<Province> provinceList = provinceService.selectProvincesByPage(
				province, page);
		map.put("list", provinceList);
		map.put("command", province);
		return "/baseConf/province/provinceList";
	}

	/***
	 * 功能描述：跳转到省份添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "toProvinceInfo")
	public String toProvinceInfo(Integer id, Model model) {
		Province province = new Province();
		if (id != null) {
			province = provinceService.selectByPrimaryKey(id);
		}
		model.addAttribute("province", province);

		return "/baseConf/province/addOrEditProvince";
	}

	/***
	 * 功能描述:添加或编辑省份
	 * 
	 * @param province
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "addOrEditProvince")
	public String addOrEditProvince(
			@ModelAttribute("province") Province province,
			HttpServletRequest request) {
		try {
			if (province == null) {
				return "redirect:/baseConf/province/provinceList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			province.setUpdateDt(new Date());
			province.setUpdateBy(userSession.getUserName());
			if (province.getId() != null) {
				provinceService.updateByPrimaryKeySelective(province);
			} else {
				province.setCreateDt(new Date());
				province.setCreateBy(userSession.getUserName());
				provinceService.insert(province);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/province/provinceList";
	}

	/**
	 * 功能描述:根据省份ids删除省份
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "/delProvince", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int countCity = provinceCityService.countCitys(idList);
				if (countCity > 0) {
					map.put("status", -1);
				} else {
					int rows = provinceService.deleteProvinceByIds(idList);
					map.put("status", 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 0);
		}
		return map;
	}

	/**
	 * 功能描述:转到渠道设置省份页面
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "/toAddChannelAppProvinceRef")
	public String toAddChannelAppProvinceRef(
			@ModelAttribute("recordId") Integer recordId, Model model) {
		List<ProvinceDto> list = provinceService
				.selectChannelAppProvinceDtoList(recordId);
		model.addAttribute("list", list);
		return "/baseConf/province/addChannelAppProvinceRef";
	}

	/**
	 * 功能描述:设置渠道省份
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "/addChannelAppProvinceRef", produces = "application/json")
	@ResponseBody
	public Map<String, Object> addChannelAppProvinceRef(Integer[] ids,
			Long limits[], Integer recordId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User userSession = RequestUtil.getUserSession(request);
			provinceService.insertChannelAppProvinceRefs(ids, limits, recordId,
					userSession);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 功能描述:转到应用设置省份页面
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "/toAddAppProvinceRef")
	public String toAddAppProvinceRef(
			@ModelAttribute("recordId") Integer recordId, Model model) {
		List<ProvinceDto> list = provinceService
				.selectAppProvinceDtoList(recordId);
		model.addAttribute("list", list);
		return "/baseConf/province/addAppProvinceRef";
	}

	/**
	 * 功能描述:设置应用省份
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月21日
	 */
	@RequestMapping(value = "/addAppProvinceRef", produces = "application/json")
	@ResponseBody
	public Map<String, Object> addAppProvinceRef(Integer[] ids, Long limits[],
			Integer recordId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User userSession = RequestUtil.getUserSession(request);
			provinceService.insertAppProvinceRefs(ids, limits, recordId,
					userSession);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
