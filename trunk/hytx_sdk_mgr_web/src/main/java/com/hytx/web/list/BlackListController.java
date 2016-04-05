package com.hytx.web.list;

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
import com.hytx.model.list.UserFilterList;
import com.hytx.model.system.User;
import com.hytx.service.list.IUserFilterListService;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/list/blackList")
public class BlackListController {
	@Autowired
	@Qualifier("userFilterListServiceImpl")
	private IUserFilterListService userFilterListService;

	/***
	 * 功能描述：查询黑名单列表
	 * 
	 * @param page
	 * @param userFilterList
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 * 
	 */
	@RequestMapping(value = "userFilterListList")
	public String findUserFilterListList(Page<UserFilterList> page,
			UserFilterList userFilterList, Map<String, Object> map,
			HttpServletRequest request) {
		userFilterList.setListType(BaseContance.BLACK_LIST_TYPE);
		List<UserFilterList> userFilterListList = userFilterListService
				.selectUserFilterListsByPage(userFilterList, page);
		map.put("list", userFilterListList);
		map.put("command", userFilterList);
		return "/list/blackList/userFilterListList";
	}

	/***
	 * 功能描述：跳转到黑名单添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	@RequestMapping(value = "toUserFilterListInfo")
	public String toUserFilterListInfo(Integer id, Model model) {
		UserFilterList userFilterList = new UserFilterList();
		if (id != null) {
			userFilterList = userFilterListService.selectByPrimaryKey(id);
		}
		model.addAttribute("userFilterList", userFilterList);
		return "/list/blackList/addOrEditUserFilterList";
	}

	/***
	 * 功能描述:添加或编辑黑名单
	 * 
	 * @param userFilterList
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	@RequestMapping(value = "addOrEditUserFilterList")
	public String addOrEditUserFilterList(
			@ModelAttribute("userFilterList") UserFilterList userFilterList,
			HttpServletRequest request) {
		try {
			if (userFilterList == null) {
				return "redirect:/list/userFilterList/userFilterListList";
			}
			userFilterList.setListType(BaseContance.BLACK_LIST_TYPE);
			User userSession = (User) RequestUtil.getUserSession(request);
			if (userFilterList.getId() != null) {
				userFilterListService
						.updateByPrimaryKeySelective(userFilterList);
			} else {
				userFilterList.setCreateDt(new Date());
				userFilterList.setCreateBy(userSession.getUserName());
				userFilterListService.insert(userFilterList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/list/blackList/userFilterListList";
	}

	/**
	 * 功能描述:根据黑名单ids删除黑名单
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	@RequestMapping(value = "/delUserFilterList", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				userFilterListService.deleteUserFilterListByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
