package com.hytx.web.baseConf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.service.baseConf.IOperateKeywordService;
import com.hytx.service.baseConf.IOperateService;
import com.hytx.util.StringUtil;

@Controller
@RequestMapping("/baseConf/operateKeyword")
public class OperateKeywordController {
	@Autowired
	private IOperateKeywordService operateKeywordService;
	@Autowired
	private IOperateService operateService;

	/***
	 * 功能描述：查询指令屏蔽信息列表
	 * 
	 * @param operateId
	 * @param map
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年6月4日
	 * 
	 */
	@RequestMapping(value = "operateKeywordList")
	public String findOperateKeywordList(Integer operateId,
			Map<String, Object> map, HttpServletRequest request) {
		if (operateId != null) {
			Operate operate = operateService.selectByPrimaryKey(operateId);
			map.put("operate", operate);
			List<OperateKeyword> operateKeywordList = operateKeywordService
					.selectOperateKeywordList(operateId);
			map.put("list", operateKeywordList);
		}
		return "/baseConf/operateKeyword/operateKeywordList";
	}

	@RequestMapping(value = "toOperateKeywordAdd")
	public String toOperateKeywordAdd(Integer operateId, Integer id, Model model) {
		OperateKeyword operateKeyword = new OperateKeyword();
		if (id != null) {
			operateKeyword = operateKeywordService.selectByPrimaryKey(id);
			if (operateKeyword != null) {
				operateId = operateKeyword.getOperateId();
			}
		}
		model.addAttribute("operateId", operateId);
		model.addAttribute("operateKeyword", operateKeyword);
		return "/baseConf/operateKeyword/addOperateKeyword";
	}

	/**
	 * 功能描述:添加屏蔽信息
	 * 
	 * @param operateKeyword
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年6月4日
	 */
	@RequestMapping(value = "/addOperateKeyword", produces = "application/json")
	@ResponseBody
	public Map<String, Object> addOperateKeyword(OperateKeyword operateKeyword,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			operateKeyword.setUpdateDt(new Date());
			if (operateKeyword.getId() == null) {
				operateKeywordService.insertOperateKeyword(operateKeyword);
			} else {
				operateKeywordService.updateOperateKeyword(operateKeyword);
			}
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

	/**
	 * 功能描述:根据指令ids删除屏蔽信息
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年6月4日
	 */
	@RequestMapping(value = "/delOperateKeyword", produces = "application/json")
	@ResponseBody
	public Object delOperateKeyword(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				operateKeywordService.deleteOperateKeywordByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
}
