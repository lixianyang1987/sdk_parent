package com.hytx.web.baseConf;

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

import com.hytx.model.baseConf.Province;
import com.hytx.model.baseConf.ProvinceCity;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IProvinceCityService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/provinceCity")
public class ProvinceCityController {
	@Autowired
	@Qualifier("provinceCityServiceImpl")
	private IProvinceCityService provinceCityService;
    @Autowired
	private IProvinceService provinceService;

	/***
	 * 功能描述：查询城市列表
	 * 
	 * @param page
	 * @param provinceCity
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 * 
	 */
	@RequestMapping(value = "provinceCityList")
	public String findProvinceCityList(Page page, ProvinceCity provinceCity, Map<String, Object> map,
			HttpServletRequest request) {
		List<ProvinceCity> provinceCityList = provinceCityService.selectProvinceCitysByPage(provinceCity, page);
		map.put("list", provinceCityList);
		map.put("command", provinceCity);
		List<Province>proList=provinceService.selectAllActiveProvince();
		Province p=new Province();
		p.setId(-1);
		p.setProvinceName("=全部=");
		proList.add(0,p);
		map.put("proList", proList);
		return "/baseConf/provinceCity/provinceCityList";
	}

	/***
	 * 功能描述：跳转到城市添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	@RequestMapping(value = "toProvinceCityInfo")
	public String toProvinceCityInfo(Integer id, Model model) {
		ProvinceCity provinceCity = new ProvinceCity();
		if (id != null) {
			provinceCity = provinceCityService.selectByPrimaryKey(id);
		}
		model.addAttribute("provinceCity", provinceCity);
		List<Province>proList=provinceService.selectAllActiveProvince();
		model.addAttribute("proList", proList);
		return "/baseConf/provinceCity/addOrEditProvinceCity";
	}

	/***
	 * 功能描述:添加或编辑城市
	 * 
	 * @param provinceCity
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	@RequestMapping(value = "addOrEditProvinceCity")
	public String addOrEditProvinceCity(@ModelAttribute("provinceCity") ProvinceCity provinceCity,
			HttpServletRequest request) {
		try {
			if (provinceCity == null) {
				return "redirect:/baseConf/provinceCity/provinceCityList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			Province p=provinceService.selectByPrimaryKey(provinceCity.getProvinceId());
			provinceCity.setCityName(p.getProvinceName());
			if (provinceCity.getId() != null) {
				provinceCityService.updateByPrimaryKeySelective(provinceCity);
			} else {
				provinceCityService.insert(provinceCity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/provinceCity/provinceCityList";
	}

	/**
	 * 功能描述:根据城市ids删除城市
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	@RequestMapping(value = "/delProvinceCity", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				int rows = provinceCityService.deleteProvinceCityByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
