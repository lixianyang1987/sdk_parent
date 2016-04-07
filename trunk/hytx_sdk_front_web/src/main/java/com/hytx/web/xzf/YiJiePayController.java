package com.hytx.web.xzf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.Json.JsonXzfBillBase;
import com.hytx.Json.JsonXzfYijieLogin;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.dto.xzf.YijiePayResultDto;
import com.hytx.model.xzf.XzfUser;
import com.hytx.model.xzf.XzfYijieBill;
import com.hytx.model.xzf.XzfYijieResult;
import com.hytx.service.xzf.IYijiePayService;
import com.hytx.util.JsonMapper;

@RequestMapping("/xzf/yijie")
@Controller
public class YiJiePayController extends BaseXzfController {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	private static final String SYNC_URL = "http://115.29.201.88/xzf/yijie/result";

	@Autowired
	private IYijiePayService yijiePayService;

	@RequestMapping(value = "login", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> yiJieLogin(
			@Valid @RequestBody JsonXzfYijieLogin jsonXzfYijieLogin,
			BindingResult bindingResult) {
		logger.info("开始易接登录验证,请求信息为:\n{}", jsonXzfYijieLogin.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			resultMap.put("resultCode", "101");
			printBindingErrors(bindingResult);
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfYijieLogin);
		Integer validCode = validXzfReq(reqDto, jsonXzfYijieLogin);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("易接登录验证返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		String result = yijiePayService.login(jsonXzfYijieLogin.getUin(),
				jsonXzfYijieLogin.getSess());
		resultMap.put("result", "0".equals(result));
		resultMap.put("syncUrl", SYNC_URL);
		resultMap.put("resultCode", "1000");
		logger.info("易接登录验证返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	/****
	 * 生成易接支付订单
	 * 
	 * @param jsonXzfWxPay
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	@RequestMapping(value = "pay", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> yijiePay(
			@Valid @RequestBody JsonXzfBillBase jsonXzfBillBase,
			BindingResult bindingResult) {
		logger.info("开始易接支付下订单,请求信息为:\n{}", jsonXzfBillBase.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfBillBase);
		Integer validCode = validXzfReq(reqDto, jsonXzfBillBase);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("易接支付返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		XzfUser user = xzfUserService.selectByPrimaryKey(reqDto.getImei());
		if (user == null) {
			saveUser(reqDto);
		} else {
			if (user.getDebt() != null && user.getDebt() > 0) {
				jsonXzfBillBase.setOpType(2);
			}
		}
		// 保存订单
		saveBill(jsonXzfBillBase, reqDto.getChannelApp().getId());
		resultMap.put("result", true);
		resultMap.put("resultCode", "1000");
		logger.info("易接支付返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	public void saveBill(JsonXzfBillBase jsonXzfBillBase, Integer channelAppId) {
		XzfYijieBill bill = new XzfYijieBill();
		bill.setChannelAppId(channelAppId);
		bill.setCreateDt(new Date());
		bill.setFeeType(jsonXzfBillBase.getFeeType());
		bill.setFeeValue(jsonXzfBillBase.getFeeValue());
		bill.setImsi(jsonXzfBillBase.getImsi());
		bill.setImei(jsonXzfBillBase.getImei());
		bill.setOrderId(jsonXzfBillBase.getOrderId());
		bill.setStep(1);
		bill.setOpType(jsonXzfBillBase.getOpType());
		bill.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
		bill.setProductCode("dx_video_" + jsonXzfBillBase.getFeeValue());
		bill.setEffectiveDt(bill.getCreateDt());
		bill.setExpireDt(DateUtils.addDays(bill.getEffectiveDt(), 30));
		yijiePayService.insertYijieBill(bill);
	}

	/****
	 * 易接支付结果通知接口
	 * 
	 * @param content
	 * @return
	 * @author houzz
	 * @date 2016年1月7日
	 */
	@RequestMapping(value = "result", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String payResult(YijiePayResultDto yijiePayResultDto,
			HttpServletRequest request) {
		logger.info("收到易接支付结果通知信息为:\n{}", request.getQueryString());
		String backInfo = "";
		if (!yijiePayResultDto.valid()) {
			backInfo = "FAIL";
			logger.info("收到易接支付结果通知信息验证签名失败");
			return backInfo;
		}
		XzfYijieResult yijieResult = yijiePayResultDto
				.bulidXzfYijieResultEntity();
		try {
			yijiePayService.insertYijieResult(yijieResult);
			backInfo = "SUCCESS";
			return backInfo;
		} catch (Exception e) {
			logger.info("易接支付结果数据保存错误:{}", e.getMessage());
			backInfo = "ERROR";
			return backInfo;
		}
	}

	/****
	 * 检查易接支付状态
	 * 
	 * @param jsonXzfUniPay
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月7日
	 */
	@RequestMapping(value = "payState", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectPayState(
			@Valid @RequestBody JsonXzfBillBase jsonXzfBillBase,
			BindingResult bindingResult) {
		logger.info("开始检查易接订单状态,请求信息为:\n{}", jsonXzfBillBase.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			resultMap.put("resultCode", "101");
			printBindingErrors(bindingResult);
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfBillBase);
		Integer validCode = validXzfReq(reqDto, jsonXzfBillBase);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("检查易接订单状态返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		XzfYijieBill bill = yijiePayService
				.selectXzfYijieBillByOrderId(jsonXzfBillBase.getOrderId());
		if (bill != null && bill.getStatus() != null
				&& BaseContance.ACTIVICE_STATUS == bill.getStatus()) {
			resultMap.put("result", true);
		} else {
			resultMap.put("result", false);
		}
		resultMap.put("resultCode", "1000");
		logger.info("检查易接订单状态返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}
}
