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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.BaseContance;
import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.Province;
import com.hytx.model.system.User;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IOperateService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.util.ListUtil;
import com.hytx.util.Page;
import com.hytx.util.StringUtil;
import com.hytx.web.base.RequestUtil;

@Controller
@RequestMapping("/baseConf/{operate:operate|dynaOperate}")
public class OperateController {
	@Autowired
	@Qualifier("operateServiceImpl")
	private IOperateService operateService;
	@Autowired
	@Qualifier("appServiceImpl")
	private IAppService appService;
	@Autowired
	private IProvinceService provinceService;

	private Map<String, String> interfaceMap = new HashMap<String, String>() {
		{
			// put(BaseContance.INTERFACE_TELECOM, "电信动态指令接口 ");
			// put(BaseContance.INTERFACE_MOBILE_SYSJ, "手游世纪移动接口");
			put(BaseContance.INTERFACE_TTF_TYKJ, "通天富电信动态指令接口");
			put(BaseContance.INTERFACE_SZQC_MMQL, "上海力耀网动态指令接口");
			put(BaseContance.INTERFACE_SZXTY, "深圳星天元动态指令接口");
			put(BaseContance.INTERFACE_TYKJ, "康元国玉动态指令接口");
			put(BaseContance.INTERFACE_SK, "刷卡动态指令接口");
			put(BaseContance.INTERFACE_HHMM, "瀚海MM动态指令接口");
			put(BaseContance.INTERFACE_FKDS, "疯狂的士动态指令接口");
			put(BaseContance.INTERFACE_NJGY, "南京果园动态指令接口");
			put(BaseContance.INTERFACE_UNION_YOUJIA, "联通优嘉动态指令接口");
		}
	};

	/***
	 * 功能描述：查询指令列表
	 * 
	 * @param page
	 * @param operateDto
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 * 
	 */
	@RequestMapping(value = "operateList")
	public String findOperateList(Page<Operate> page, OperateDto operateDto,
			Map<String, Object> map, HttpServletRequest request,
			@PathVariable("operate") String operateType) {
		// PrintTrace.princeThreadTrace();
		if (operateType.equals("operate")) {
			operateDto.setOpType(BaseContance.OPERATE_TYPE_STATIC);
		} else {
			operateDto.setOpType(BaseContance.OPERATE_TYPE_DYNAMIC);
			map.put("interfaceMap", interfaceMap);
		}
		List<Operate> operateList = operateService.selectOperatesByPage(
				operateDto, page);
		List<App> appList = appService.selectAllActiveApp();
		App app = new App();
		app.setId(-1);
		app.setAppName("=全部=");
		appList.add(0, app);
		map.put("appList", appList);
		map.put("appMap", ListUtil.changeListToMap(appList, "id", "appName"));
		map.put("list", operateList);
		map.put("command", operateDto);
		List<Province> proList = provinceService.selectAllActiveProvince();
		map.put("proList", proList);
		return "/baseConf/" + operateType + "/operateList";
	}

	/***
	 * 功能描述：跳转到指令添加或编辑页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "toOperateInfo")
	public String toOperateInfo(Integer id, Model model,
			@PathVariable("operate") String operateType) {
		// PrintTrace.princeThreadTrace();
		List<App> appList = appService.selectAllActiveApp();
		model.addAttribute("appList", appList);
		Operate operate = new Operate();
		if (id != null) {
			operate = operateService.selectByPrimaryKey(id);
		}
		model.addAttribute("interfaceMap", interfaceMap);
		model.addAttribute("operate", operate);
		return "/baseConf/" + operateType + "/addOrEditOperate";
	}

	/***
	 * 功能描述:添加或编辑指令
	 * 
	 * @param operate
	 * @param request
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "addOrEditOperate")
	public String addOrEditOperate(@ModelAttribute("operate") Operate operate,
			HttpServletRequest request,
			@PathVariable("operate") String operateType) {
		try {
			if (operate == null) {
				return "redirect:/baseConf/" + operateType + "/operateList";
			}
			User userSession = (User) RequestUtil.getUserSession(request);
			operate.setUpdateDt(new Date());
			operate.setUpdateBy(userSession.getUserName());
			App app = appService.selectByPrimaryKey(operate.getAppId());
			if (app != null) {
				operate.setAppSn(app.getAppSn());
				operate.setChannelSn(app.getChannelSn());
			}
			if (operate.getId() != null) {
				operateService.updateByPrimaryKey(operate);
			} else {
				operate.setCreateDt(new Date());
				operate.setCreateBy(userSession.getUserName());
				operateService.insert(operate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/baseConf/" + operateType + "/operateList";
	}

	/**
	 * 功能描述:根据指令ids删除指令
	 * 
	 * @param ids
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	@RequestMapping(value = "/delOperate", produces = "application/json")
	@ResponseBody
	public Object delUser(String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Integer> idList = StringUtil.changeStringIdsToIntegerList(ids);
			if (!idList.isEmpty()) {
				operateService.deleteOperateByIds(idList);
				map.put("success", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}

}
