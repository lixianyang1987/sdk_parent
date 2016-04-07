package com.hytx.web.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.Json.JsonReqCheckState;
import com.hytx.constance.DictKeyInfo;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.client.IValidUserService;
import com.hytx.util.JsonMapper;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/client")
public class ValidUserController extends BaseReqController {
	private static final Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private IValidUserService validUserService;
	@Autowired
	@Qualifier("dictServiceImpl")
	private IDictService dictService;

	/****
	 * 验证用户包月是否处于有效状态，目前没有退订，只要订购就认为一直有效，判断依据为曾经成功状态sdk指令即为订购状态
	 * 
	 * @param reqCheckState
	 * @param bindingResult
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年7月24日
	 */
	@RequestMapping(value = "checkState", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> checkState(
			@Valid @RequestBody JsonReqCheckState reqCheckState,
			BindingResult bindingResult, HttpServletRequest request) {
		logger.info("user-agent：{}", request.getHeader("User-Agent"));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		reqCheckState.setIp(IpUtil.getRealIp(request));
		logger.info("验证包月信息为：{}", JsonMapper.toLogJson(reqCheckState));
		// 基本数据验证，如非空验证，长度验证等
		if (bindingResult.hasErrors()) {
			resultMap.put("resultCode", "101");
			logger.info(bindingResult.getAllErrors().toString());
			logger.info("验证包月返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		BaseReqDto baseReqDto = createBaseReqDto(reqCheckState);
		// 判断渠道包是是否存在记录
		if (baseReqDto == null) {
			resultMap.put("resultCode", "201");
			logger.info("验证包月返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}

		// 让用户每次都计费,临时改动
		if (true) {
			resultMap.put("resultCode", "500");
			return resultMap;
		}

		ChannelApp channelApp = baseReqDto.getChannelApp();
		// 判断数字签名是否正确
		if (!reqCheckState.validSign(channelApp.getSignKey())) {
			resultMap.put("resultCode", "202");
			logger.info("验证包月返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}

		boolean isOrdered = validUserService.validUserOrderState(baseReqDto);
		if (isOrdered) {
			resultMap.put("resultCode", "400");
		} else {
			resultMap.put("resultCode", "300");
			Dict dictNotCheck = dictService
					.selectActiviteDictByKey(DictKeyInfo.NOT_CHECK_STATE_KEY);
			if (dictNotCheck == null
					|| dictNotCheck.getVal() == null
					|| dictNotCheck.getVal().indexOf(
							reqCheckState.getChannelAppKey()) < 0) {
				Dict dict = dictService
						.selectActiviteDictByKey(DictKeyInfo.CHECK_STATE_KEY);
				if (dict != null) {
					resultMap.put("resultCode", dict.getVal());
				}
			}
		}
		logger.info("验证包月返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

}
