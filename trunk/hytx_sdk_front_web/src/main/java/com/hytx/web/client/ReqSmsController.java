package com.hytx.web.client;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
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

import com.hytx.Json.JsonCommand;
import com.hytx.Json.JsonReqSms;
import com.hytx.Json.JsonReqSmsCheck;
import com.hytx.Json.JsonRespKeyword;
import com.hytx.Json.JsonRespSms;
import com.hytx.Json.JsonSyncSmsResult;
import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.DictKeyInfo;
import com.hytx.constance.ReqSmsCodeConstance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.client.SdkLoad;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.client.IBaseReqService;
import com.hytx.service.client.IReqSmsService;
import com.hytx.service.client.ISdkLoadService;
import com.hytx.util.CopyUtil;
import com.hytx.util.JsonMapper;
import com.hytx.web.base.IpUtil;

/*****
 * 此类用于sdk客户端请求短信指令及同步指令发送状态
 * 
 * @author houzz
 *
 */
@Controller
@RequestMapping("/client")
public class ReqSmsController extends BaseReqController {
	private static final Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	@Qualifier("reqSmsServiceImpl")
	private IReqSmsService reqSmsService;
	@Autowired
	@Qualifier("dictServiceImpl")
	private IDictService dictService;
	@Autowired
	private ISdkLoadService sdkLoadService;

	/*****
	 * 客户端请求指令接口
	 * 
	 * @param smsReq
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "reqSms", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public JsonRespSms findSmsContent(@Valid @RequestBody JsonReqSms smsReq,
			BindingResult bindingResult, HttpServletRequest request) {
		logger.info("user-agent：{}", request.getHeader("User-Agent"));
		long startTime = new Date().getTime();
		smsReq.setIp(IpUtil.getRealIp(request));
		logger.info("短串请求信息为：{}", smsReq.toString());
		JsonRespSms result = new JsonRespSms();
		// 基本数据验证，如非空验证，长度验证等
		if (bindingResult.hasErrors()) {
			result.setResultCode(ReqSmsCodeConstance.FORMAT_ERROR + "");
			logger.info(bindingResult.getAllErrors().toString());
			logger.info("短串请求返回数据为：{}", result.toString());
			return result;
		}
		// 根据请求信息加载相关基本信息存放在一个dto实体内
		BaseReqDto baseReqDto = createBaseReqDto(smsReq);
		// 验证
		Integer validResult = validSmsReq(baseReqDto, smsReq);
		// 如果验证有错，则保存记录，返回错误码
		if (validResult != null) {
			result.setResultCode(validResult.toString());
			saveFailResult(validResult, baseReqDto, smsReq, request);
			logger.info("短串请求返回数据为：{}", result.toString());
			// 保存验证错误记录
			return result;
		}
		// 将请求的json实体转换成pojo对象
		ReqSms record = new ReqSms();
		CopyUtil.copy(smsReq, record);
		record.setUa(request.getHeader("User-Agent"));
		if (baseReqDto != null) {
			record.setProvinceId(baseReqDto.getProvinceId());
			record.setServerType(baseReqDto.getServerType());
		}
		// 先根据道具编号及金额查询指令
		List<ReqSmsCommand> commandList = reqSmsService.findCommandList(record,
				baseReqDto);
		if (commandList.isEmpty()) {
			if (ThreadLocalCache.hasOrderdMark()) {
				result.setResultCode(ReqSmsCodeConstance.HAS_ORDERD + "");
			} else {
				result.setResultCode(ReqSmsCodeConstance.NO_COMMAND_ERROR + "");
			}
			logger.info("短串请求返回数据为：{}", result.toString());
			return result;
		}
		// 配置的指令屏蔽信息映射
		Map<Integer, List<OperateKeyword>> opIdAndOperateKeywordMap = baseReqService
				.selectAllOperateKeyword();
		// 动态指令通过接口取得的屏蔽信息映射
		Map<Integer, List<OperateKeyword>> cacheOperateKeywordMap = ThreadLocalCache.dynaOpKeyword
				.get();
		Set<JsonRespKeyword> keywordSet = new HashSet<JsonRespKeyword>();
		for (ReqSmsCommand cmd : commandList) {
			JsonCommand jcmd = new JsonCommand();
			jcmd.setCommandId(cmd.getId());
			jcmd.setMoContent(cmd.getMoContent());
			jcmd.setMoNum(cmd.getMoNum());
			jcmd.setEnsureContent(cmd.getTwoEnsure());
			jcmd.setEnsureNum(cmd.getEnsureNum() != null ? cmd.getEnsureNum()
					.toString() : "");
			Integer waitSeconds = cmd.getWaitSeconds();
			jcmd.setWaitSeconds(waitSeconds == null ? 0 : waitSeconds);
			if (cmd.getControlFlag() != null && cmd.getControlFlag() > 0) {
				result.setControlFlag(true);
			}
			result.getCommandList().add(jcmd);
			if (cmd.getAppId().equals(IBaseReqService.APP_ID_LGQB)) {
				result.getCommandList().add(jcmd);// 如果是灵光钱包指令，重复一次
			}
			List<OperateKeyword> okList = opIdAndOperateKeywordMap.get(cmd
					.getOperateId());
			if (okList != null && !okList.isEmpty()) {
				for (OperateKeyword ok : okList) {
					if (ok.getStatus().equals(2)) {// 2为正常屏蔽状态数据
						JsonRespKeyword jrk = new JsonRespKeyword(
								ok.getMtNum(), ok.getMtContent());
						keywordSet.add(jrk);
					}
				}
			}
			if (cacheOperateKeywordMap != null
					&& !cacheOperateKeywordMap.isEmpty()) {
				okList = cacheOperateKeywordMap.get(cmd.getOperateId());
				if (okList != null && !okList.isEmpty()) {
					for (OperateKeyword ok : okList) {
						JsonRespKeyword jrk = new JsonRespKeyword(
								ok.getMtNum(), ok.getMtContent());
						keywordSet.add(jrk);
					}
				}
			}
		}
		result.setKeywords(keywordSet);
		result.setResultCode(ReqSmsCodeConstance.SUCCESS.toString());
		long endTime = new Date().getTime();
		logger.debug("共用时间为：" + (endTime - startTime));
		logger.info("短串请求返回数据为：{}", result.toString());
		return result;
	}

	public void saveFailResult(Integer validResult, BaseReqDto baseReqDto,
			JsonReqSms smsReq, HttpServletRequest request) {
		ReqSms entity = reqSmsService.selectByPrimaryKey(smsReq.getOrderId());
		if (entity != null) {
			entity.setStatus(validResult);
			reqSmsService.updateByPrimaryKeySelective(entity);
		} else {
			ReqSms record = new ReqSms();
			CopyUtil.copy(smsReq, record);
			record.setUa(request.getHeader("User-Agent"));
			if (baseReqDto != null) {
				record.setProvinceId(baseReqDto.getProvinceId());
				record.setServerType(baseReqDto.getServerType());
				ChannelApp channelApp = baseReqDto.getChannelApp();
				if (channelApp != null) {
					record.setChannelId(channelApp.getChannelId());
					record.setAppId(channelApp.getAppId());
				}
			}
			record.setUpdateDt(new Date());
			record.setStatus(validResult);
			reqSmsService.insert(record);
		}
	}

	/****
	 * 客户端发送短信回执接口
	 * 
	 * @param reqSmsResult
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "syncSmsResult", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> syncSmsResult(
			@Valid @RequestBody JsonSyncSmsResult reqSmsResult,
			BindingResult bindingResult, HttpServletRequest request) {
		logger.info("user-agent：{}", request.getHeader("User-Agent"));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		reqSmsResult.setIp(IpUtil.getRealIp(request));
		logger.info("短串回执信息为：{}", JsonMapper.toLogJson(reqSmsResult));
		// 基本数据验证，如非空验证，长度验证等
		if (bindingResult.hasErrors()) {
			resultMap.put("resultCode", "101");
			logger.info(bindingResult.getAllErrors().toString());
			logger.info("短串回执返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		if (reqSmsResult.getCommandIdList().isEmpty()
				|| reqSmsResult.getCommandIdList().size() != reqSmsResult
						.getStatusList().size()) {
			resultMap.put("resultCode", "301");
			logger.info("短串回执返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		BaseReqDto baseReqDto = createBaseReqDto(reqSmsResult);
		// 判断渠道包是是否存在记录
		if (baseReqDto == null) {
			resultMap.put("resultCode", "201");
			logger.info("短串回执返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		ChannelApp channelApp = baseReqDto.getChannelApp();
		// 判断数字签名是否正确
		if (!reqSmsResult.validSign(channelApp.getSignKey())) {
			resultMap.put("resultCode", "202");
			logger.info("短串回执返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 处理请求
		reqSmsService.updateReqSmsResult(reqSmsResult.getCommandIdList(),
				reqSmsResult.getStatusList(), reqSmsResult.getOrderDt(),
				baseReqDto);
		resultMap.put("resultCode", "1000");
		logger.info("短串回执返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	/***
	 * 主动计费请求短串接口
	 * 
	 * @param reqSmsCheck
	 * @param bindingResult
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年7月13日
	 */
	@RequestMapping(value = "reqSmsCheck", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public JsonRespSms reqSmsCheck(
			@Valid @RequestBody JsonReqSmsCheck reqSmsCheck,
			BindingResult bindingResult, HttpServletRequest request) {
		logger.info("user-agent：{}", request.getHeader("User-Agent"));
		JsonRespSms result = new JsonRespSms();
		reqSmsCheck.setIp(IpUtil.getRealIp(request));
		logger.info("主动计费请求数据为：{}", JsonMapper.toLogJson(reqSmsCheck));
		// 基本数据验证，如非空验证，长度验证等
		if (bindingResult.hasErrors()) {
			result.setResultCode("101");
			logger.info(bindingResult.getAllErrors().toString());
			logger.info("主动计费返回数据为：{}", JsonMapper.toLogJson(result));
			return result;
		}
		BaseReqDto baseReqDto = createBaseReqDto(reqSmsCheck);
		// 判断渠道包是是否存在记录
		if (baseReqDto == null) {
			result.setResultCode("201");
			logger.info("主动计费返回数据为：{}", JsonMapper.toLogJson(result));
			return result;
		}
		ChannelApp channelApp = baseReqDto.getChannelApp();
		// 判断数字签名是否正确
		if (!reqSmsCheck.validSign(channelApp.getSignKey())) {
			result.setResultCode("202");
			logger.info("主动计费返回数据为：{}", JsonMapper.toLogJson(result));
			return result;
		}
		// 请主动计费的请求视为sdk启动数，记录sdk启动数
		SdkLoad sdkLoad = new SdkLoad();
		CopyUtil.copy(reqSmsCheck, sdkLoad);
		sdkLoad.setCreateDt(new Date());
		sdkLoad.setAppId(channelApp.getAppId());
		sdkLoad.setChannelId(channelApp.getChannelId());
		sdkLoad.setServerType(baseReqDto.getServerType());
		sdkLoad.setProvinceId(baseReqDto.getProvinceId());
		sdkLoad.setUa(request.getHeader("User-Agent"));
		sdkLoadService.insertSdkLoad(sdkLoad);
		Dict dict = dictService
				.selectActiviteDictByKey(DictKeyInfo.CHECK_AUTO_SMS);
		if (dict != null && "0".equals(dict.getVal())) {
			result.setResultCode("401");
			logger.info("主动计费返回数据为：{}", JsonMapper.toLogJson(result));
			return result;
		}
		Date date = DateUtils.addDays(new Date(), -5);// 五天内
		String startDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		logger.info("startDate is {}", startDate);
		List<ReqSmsCommand> commandList = reqSmsService
				.selectUserFailCommandList(reqSmsCheck.getImsi(), startDate,
						baseReqDto.getServerType());
		if (commandList == null || commandList.isEmpty()) {
			result.setResultCode("501");
			logger.info("主动计费返回数据为：{}", JsonMapper.toLogJson(result));
			return result;
		}
		// 配置的指令屏蔽信息映射
		Map<Integer, List<OperateKeyword>> opIdAndOperateKeywordMap = baseReqService
				.selectAllOperateKeyword();
		Set<JsonRespKeyword> keywordSet = new HashSet<JsonRespKeyword>();
		for (ReqSmsCommand cmd : commandList) {
			List<OperateKeyword> okList = opIdAndOperateKeywordMap.get(cmd
					.getOperateId());
			if (okList != null && !okList.isEmpty()) {
				for (OperateKeyword ok : okList) {
					JsonRespKeyword jrk = new JsonRespKeyword(ok.getMtNum(),
							ok.getMtContent());
					keywordSet.add(jrk);
				}
			}
			JsonCommand jcmd = new JsonCommand();
			jcmd.setCommandId(cmd.getId());
			jcmd.setMoContent(cmd.getMoContent());
			jcmd.setMoNum(cmd.getMoNum());
			jcmd.setEnsureContent(cmd.getTwoEnsure());
			jcmd.setEnsureNum(cmd.getEnsureNum() != null ? cmd.getEnsureNum()
					.toString() : "");
			Integer waitSeconds = cmd.getWaitSeconds();
			jcmd.setWaitSeconds(waitSeconds == null ? 0 : waitSeconds);
			result.getCommandList().add(jcmd);
			if (cmd.getAppId().equals(IBaseReqService.APP_ID_LGQB)) {
				result.getCommandList().add(jcmd);// 如果是灵光钱包指令，重复一次
			}
		}
		result.setControlFlag(true);
		result.setKeywords(keywordSet);
		// 处理请求
		result.setResultCode("1000");
		logger.info("主动计费返回数据为：{}", JsonMapper.toLogJson(result));
		return result;
	}

}
