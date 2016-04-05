package com.hytx.web.baseConf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.BaseContance;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IDictService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/dict")
public class DictController {
	@Autowired
	@Qualifier("dictServiceImpl")
	private IDictService dictService;

	/***
	 * 功能描述：查询字典列表
	 * 
	 * @param page
	 * @param dict
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 * 
	 */
	@RequestMapping(value = "dictList")
	public String findDictList(Page<Dict> page, Dict dict,
			Map<String, Object> map, HttpServletRequest request) {
		List<Dict> dictList = dictService.selectDictsByPage(dict, page);
		map.put("list", dictList);
		map.put("command", dict);
		return "/baseConf/dict/dictList";
	}

	/***
	 * 功能描述：跳转到字典添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	@RequestMapping(value = "toDictInfo")
	public String toDictInfo(Integer id, Model model) {
		Dict dict = new Dict();
		if (id != null) {
			dict = dictService.selectByPrimaryKey(id);
		}
		model.addAttribute("dict", dict);
		return "/baseConf/dict/addOrEditDict";
	}

	/***
	 * 功能描述:添加或编辑字典
	 * 
	 * @param dict
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	@RequestMapping(value = "addOrEditDict")
	public String addOrEditDict(@ModelAttribute("dict") Dict dict,
			HttpServletRequest request) {
		try {
			if (dict == null) {
				return "redirect:/baseConf/dict/dictList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			dict.setUpdateDt(new Date());
			dict.setUpdateBy(userSession.getUserName());
			if (dict.getStatus() == null) {
				dict.setStatus(BaseContance.ACTIVICE_STATUS);
			}
			if (dict.getId() != null) {
				dictService.updateByPrimaryKeySelective(dict);
			} else {
				dict.setCreateDt(new Date());
				dict.setCreateBy(userSession.getUserName());
				dictService.insert(dict);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/dict/dictList";
	}

	/**
	 * 功能描述:根据字典ids删除字典
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	@RequestMapping(value = "/delDict", produces = "application/json")
	@ResponseBody
	public Object delDict(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				dictService.deleteDictByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/***
	 * 检查key是否已经存在
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/checkKey", produces = "application/json")
	@ResponseBody
	public Object checkKeyExists(String key) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (StringUtils.isEmpty(key)) {
				map.put("exists", true);
			} else {
				Dict dict = dictService.selectDictByKey(key);
				map.put("exists", dict != null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("exists", false);
		}
		return map;
	}

}
