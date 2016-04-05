package com.hytx.web.xzf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.Json.JsonXzfCheckState;
import com.hytx.Json.JsonXzfUserInfo;
import com.hytx.Json.JsonXzfVcode;
import com.hytx.Json.JsonXzfVcodeValid;
import com.hytx.Json.JsonXzfWechat;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.dto.client.ErrorCountDto;
import com.hytx.dto.xzf.XzfUserInfoDto;
import com.hytx.model.xzf.XzfCoupon;
import com.hytx.model.xzf.XzfFlowLog;
import com.hytx.model.xzf.XzfSelfBill;
import com.hytx.model.xzf.XzfUser;
import com.hytx.model.xzf.XzfVcode;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.sms.ISmsService;
import com.hytx.service.xzf.IXzfBillService;
import com.hytx.util.JsonMapper;
import com.hytx.web.base.BaseInfo;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/xzf")
public class XzfUserController extends BaseXzfController {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private ISmsService smsService;
	@Autowired
	private IXzfBillService xzfBillService;
	@Autowired
	private IDictService dictService;

	private Random random = new Random();

	/****
	 * 检查用户信息
	 * 
	 * @param reqCheckState
	 * @param bindingResult
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2016年1月4日
	 */
	@RequestMapping(value = "checkState", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, Object> checkState(
			@Valid @RequestBody JsonXzfCheckState reqCheckState,
			BindingResult bindingResult, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		reqCheckState.setIp(IpUtil.getRealIp(request));
		logger.info("信支付sdk用户信息查询为：{}", JsonMapper.toLogJson(reqCheckState));
		// 基本数据验证，如非空验证，长度验证等
		if (bindingResult.hasErrors()) {
			resultMap.put("resultCode", "101");
			printBindingErrors(bindingResult);
			logger.info("信支付sdk用户信息查询返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(reqCheckState);
		Integer validCode = validXzfReq(reqDto, reqCheckState);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("信支付sdk用户信息查询返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 如果用户不存在则添加用户信息
		XzfUser user = xzfUserService.selectByPrimaryKey(reqCheckState
				.getImei());
		if (user == null) {
			user = saveUser(reqDto);
		}
		List<XzfCoupon> couponList = xzfBillService
				.selectUserCoupons(reqCheckState.getImsi());
		XzfUserInfoDto userDto = new XzfUserInfoDto(user);
		resultMap.put("couponList", couponList);
		resultMap.put("user", userDto);
		resultMap.put("resultCode", "1000");
		logger.info("信支付sdk用户信息查询返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	/****
	 * 获取验证码接口,一段时间内只允许获取6次
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年11月24日
	 */
	@RequestMapping(value = "vcode", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getVcode(
			@Valid @RequestBody JsonXzfVcode jsonXzfVcode,
			BindingResult bindingResult) {
		logger.info("开始获取验证码信息,请求数据为:\n{}", jsonXzfVcode.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfVcode);
		Integer validCode = validXzfReq(reqDto, jsonXzfVcode);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("获取验证码返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		String mobile = jsonXzfVcode.getMobile();
		String keyTemp = mobile;
		int num = 1;
		ErrorCountDto errorCountDto = null;
		Cache cache = cacheManager.getCache(BaseInfo.COUNT_ERROR_CACHE_NAME);
		if (!dictService.isInXzfWhiteList(mobile) && cache != null) {
			ValueWrapper valueWrapper = cache.get(keyTemp);
			if (valueWrapper != null) {
				errorCountDto = (ErrorCountDto) valueWrapper.get();
				if (errorCountDto.expired()) {
					errorCountDto.reset();
				} else {
					num = errorCountDto.getCount() + 1;
					if (num > 5) {// 1小时内最多可以发送6次,否则锁定一小时
						errorCountDto.setCount(num);
						resultMap.put("resultCode", "400");
						logger.info("获取验证码返回数据为：{}",
								JsonMapper.toLogJson(resultMap));
						return resultMap;
					}
				}
			}
		}
		// 检查是否存在用户信息
		XzfUser user = xzfUserService
				.selectByPrimaryKey(jsonXzfVcode.getImei());
		if (user != null && user.getMobile() != null && user.getDebt() != null
				&& user.getDebt() > 0
				&& !user.getMobile().equals(jsonXzfVcode.getMobile())) {
			resultMap.put("resultCode", "600");
			logger.info("获取验证码返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 检查手机号是否允许
		XzfUser existsUser = xzfUserService.selectXzfUserByMobile(mobile);
		if (existsUser != null
				&& !jsonXzfVcode.getImei().equals(existsUser.getImei())) {
			resultMap.put("resultCode", "600");
			logger.info("获取验证码返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		String vcode = "";
		for (int i = 0; i < 6; i++) {// 6位数字验证码
			vcode = vcode + random.nextInt(9);
		}
		String message = "【信支付】验证码为：" + vcode + "，您正在使用信支付，需要进行校验，请勿转发。";// 不能改动,否则发送失败
		boolean result = smsService.sendSmsW(mobile, message);
		if (result) {
			if (errorCountDto == null) {
				cache.put(keyTemp, new ErrorCountDto(
						BaseInfo.GET_VCODE_LOCK_TIME));
			} else {
				errorCountDto.setCount(num);
			}
			Date effectiveDt = new Date();
			Date expireDt = DateUtils.addMinutes(effectiveDt, 1);
			XzfVcode vcodeEntity = new XzfVcode();
			vcodeEntity.setMobile(mobile);
			vcodeEntity.setVcode(vcode);
			vcodeEntity.setEffectiveDt(effectiveDt);
			vcodeEntity.setExpireDt(expireDt);
			xzfUserService.insertVcode(vcodeEntity);
			// 如果用户存在则添加用户信息
			if (user != null && user.getMobile() != null
					&& !mobile.equals(user.getMobile())) {
				user.setMobile(jsonXzfVcode.getMobile());
				xzfUserService.updateByPrimaryKeySelective(user);
			} else if (user != null && user.getMobile() == null) {
				user.setMobile(jsonXzfVcode.getMobile());
				xzfUserService.updateByPrimaryKeySelective(user);
			}
			// 添加日志
			XzfFlowLog record = new XzfFlowLog();
			record.setCreateDt(new Date());
			record.setImsi(jsonXzfVcode.getImsi());
			record.setImei(jsonXzfVcode.getImei());
			record.setName("获取验证码");
			record.setOrderId(jsonXzfVcode.getOrderId());
			record.setStep(BaseInfo.XZF_STEP.GETVCODE.getValue());
			record.setMemo("获取验证码成功,验证码为:" + vcode);
			record.setLogType(BaseInfo.LOG_TYPE_XZF);
			xzfUserService.insertFlowLog(record);
			XzfSelfBill bill = new XzfSelfBill();
			bill.setOrderId(jsonXzfVcode.getOrderId());
			bill.setStep(record.getStep());
			xzfBillService.updateXzfBillByOrderIdSelective(bill);
		}
		resultMap.put("resultCode", "1000");
		resultMap.put("result", result);
		logger.info("发送次数:" + (num));
		logger.info("获取验证码返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	/****
	 * 验证验证码接口
	 * 
	 * @param mobile
	 * @param vcode
	 * @return
	 * @author houzz
	 * @date 2016年1月4日
	 */
	@RequestMapping(value = "validVcode", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> validVcode(
			@Valid @RequestBody JsonXzfVcodeValid jsonXzfVcodeValid,
			BindingResult bindingResult) {
		logger.info("开始检查验证码信息,请求数据为:\n{}", jsonXzfVcodeValid.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfVcodeValid);
		Integer validCode = validXzfReq(reqDto, jsonXzfVcodeValid);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("检查验证码返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		String mobile = jsonXzfVcodeValid.getMobile();
		String vcode = jsonXzfVcodeValid.getVcode();
		boolean result = xzfUserService.validVcode(mobile, vcode);
		resultMap.put("validResult", result);
		Cache cache = cacheManager.getCache(BaseInfo.COUNT_ERROR_CACHE_NAME);
		if (cache != null) {
			cache.put("validVcode" + jsonXzfVcodeValid.getImei(), result);
		}
		// 添加日志
		XzfFlowLog record = new XzfFlowLog();
		record.setCreateDt(new Date());
		record.setImsi(jsonXzfVcodeValid.getImsi());
		record.setName("检查验证码");
		record.setOrderId(jsonXzfVcodeValid.getOrderId());
		record.setStep(BaseInfo.XZF_STEP.VALIDVCODE.getValue());
		record.setMemo("检查验证码结果为:" + result);
		record.setLogType(BaseInfo.LOG_TYPE_XZF);
		xzfUserService.insertFlowLog(record);
		XzfSelfBill bill = new XzfSelfBill();
		bill.setOrderId(jsonXzfVcodeValid.getOrderId());
		bill.setStep(record.getStep());
		xzfBillService.updateXzfBillByOrderIdSelective(bill);
		resultMap.put("resultCode", "1000");
		logger.info("校验验证码返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	/****
	 * 用户身份证及姓名验证
	 * 
	 * @param mobile
	 * @param vcode
	 * @return
	 * @author houzz
	 * @date 2016年1月4日
	 */
	@RequestMapping(value = "validUser", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> validUserInfo(
			@Valid @RequestBody JsonXzfUserInfo jsonXzfUserInfo,
			BindingResult bindingResult) {
		logger.info("开始检查用户身份信息,请求数据为:\n{}", jsonXzfUserInfo.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfUserInfo);
		Integer validCode = validXzfReq(reqDto, jsonXzfUserInfo);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("检查用户身份信息返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		boolean result = false;
		Cache cache = cacheManager.getCache(BaseInfo.COUNT_ERROR_CACHE_NAME);
		if (cache != null) {
			ValueWrapper validVcodeWrape = cache.get("validVcode"
					+ jsonXzfUserInfo.getImei());
			if (validVcodeWrape != null) {
				result = (boolean) validVcodeWrape.get();
				ValueWrapper validVcodeTimeWrape = cache.get("validVcodeTime"
						+ jsonXzfUserInfo.getImei());
				int times = 1;
				if (validVcodeTimeWrape != null) {
					times = times + (int) validVcodeTimeWrape.get();
				}
				if (times > 3) {
					cache.evict("validVcode" + jsonXzfUserInfo.getImei());
					cache.evict("validVcodeTime" + jsonXzfUserInfo.getImei());
				} else {
					cache.put("validVcodeTime" + jsonXzfUserInfo.getImei(),
							times);
				}
			}
		}
		// 验证通过增加用户积分
		if (!result) {
			resultMap.put("resultCode", "401");// 禁止访问
			logger.info("检查用户身份信息返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		boolean validResult = xzfUserService.validUserIdCard(
				jsonXzfUserInfo.getName(), jsonXzfUserInfo.getIdCard());
		if (!validResult) {
			resultMap.put("resultCode", "501");// 此用户不诚信,终止交易
			logger.info("检查用户身份信息返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 添加日志
		XzfFlowLog record = new XzfFlowLog();
		record.setCreateDt(new Date());
		record.setImsi(jsonXzfUserInfo.getImsi());
		record.setImei(jsonXzfUserInfo.getImei());
		record.setName("检查姓名及身份证");
		record.setOrderId(jsonXzfUserInfo.getOrderId());
		record.setStep(BaseInfo.XZF_STEP.VALIDNAME.getValue());
		record.setMemo("检查姓名及身份证信息为:\n" + jsonXzfUserInfo.getName() + "\n"
				+ jsonXzfUserInfo.getIdCard());
		record.setLogType(BaseInfo.LOG_TYPE_XZF);
		xzfUserService.insertFlowLog(record);
		XzfSelfBill bill = xzfBillService
				.selectXzfSelfBillByPrimaryKey(jsonXzfUserInfo.getOrderId());
		if (bill == null) {
			resultMap.put("resultCode", "402");// 禁止访问
			logger.info("检查用户身份信息返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 检查是否存在用户信息
		XzfUser user = xzfUserService.selectByPrimaryKey(jsonXzfUserInfo
				.getImei());
		// 如果用户存在则添加用户信息
		if (user != null) {
			Date nowDt = new Date();
			if (StringUtils.isBlank(user.getName())
					|| StringUtils.isBlank(user.getIdCard())) {
				user.setName(jsonXzfUserInfo.getName());
				user.setIdCard(jsonXzfUserInfo.getIdCard());
				// 增加用户积分
				Integer integral = user.getIntegral();
				Integer debt = user.getDebt();
				integral = integral == null ? 100 : integral + 100;
				debt = debt == null ? bill.getFeeValue() : bill.getFeeValue()
						+ debt;
				user.setIntegral(integral);
				user.setDebt(debt);
				user.setDebtDt(nowDt);
				user.setExpireDt(DateUtils.addDays(nowDt, 7));
				if (debt.equals(bill.getFeeValue())) {
					user.setShouldPayDt(DateUtils.addDays(new Date(), 7));
				}
				xzfUserService.updateByPrimaryKeySelective(user);
			} else {
				if (!user.getName().equals(jsonXzfUserInfo.getName())
						|| !user.getIdCard()
								.equals(jsonXzfUserInfo.getIdCard())) {
					resultMap.put("resultCode", "502");// 此用户不诚信,终止交易
					logger.info("检查用户身份信息返回数据为：{}",
							JsonMapper.toLogJson(resultMap));
					return resultMap;
				} else {
					// 增加用户积分
					Integer integral = user.getIntegral();
					Integer debt = user.getDebt();
					integral = integral == null ? 100 : integral + 100;
					debt = debt == null ? bill.getFeeValue() : bill
							.getFeeValue() + debt;
					user.setIntegral(integral);
					user.setDebt(debt);
					user.setDebtDt(nowDt);
					user.setExpireDt(DateUtils.addDays(nowDt, 7));
					if (debt.equals(bill.getFeeValue())) {
						user.setShouldPayDt(DateUtils.addDays(new Date(), 7));
					}
					xzfUserService.updateByPrimaryKeySelective(user);
				}
			}
			bill.setStep(record.getStep());
			bill.setStatus(BaseContance.ACTIVICE_STATUS);// 使订单状态生效
			bill.setEffectiveDt(nowDt);
			bill.setExpireDt(DateUtils.addDays(nowDt, 7));
			xzfBillService.updateXzfBillByOrderIdSelective(bill);

			XzfCoupon coupon = new XzfCoupon();
			coupon.setCouponCode(RandomStringUtils.randomNumeric(6));
			coupon.setCouponValue(100L);
			Date effectiveDt = new Date();
			coupon.setEffectiveDt(effectiveDt);
			coupon.setExpireDt(DateUtils.addHours(effectiveDt, 1));
			coupon.setImsi(jsonXzfUserInfo.getImsi());
			coupon.setImei(jsonXzfUserInfo.getImei());
			coupon.setMobile(user.getMobile());
			coupon.setOrderId(jsonXzfUserInfo.getOrderId());
			coupon.setStatus(BaseContance.ACTIVICE_STATUS);
			xzfBillService.insertCoupon(coupon);
			resultMap.put("coupon", coupon);
			resultMap.put("integral", user.getIntegral());
			resultMap.put("resultCode", "1000");
			cache.evict("validVcode" + jsonXzfUserInfo.getImei());
			cache.evict("validVcodeTime" + jsonXzfUserInfo.getImei());
		} else {
			resultMap.put("resultCode", "401");
		}
		logger.info("检查用户身份信息返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	/****
	 * 关注微信公众号
	 * 
	 * @param jsonXzfWechat
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月5日
	 */
	@RequestMapping(value = "wechatCare", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> wechatCare(
			@Valid @RequestBody JsonXzfWechat jsonXzfWechat,
			BindingResult bindingResult) {
		logger.info("开始接收用户微信关注状态,请求数据为:\n{}", jsonXzfWechat.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfWechat);
		Integer validCode = validXzfReq(reqDto, jsonXzfWechat);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("接收用户微信关注状态返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 添加日志
		XzfFlowLog record = new XzfFlowLog();
		record.setCreateDt(new Date());
		record.setImsi(jsonXzfWechat.getImsi());
		record.setImei(jsonXzfWechat.getImei());
		record.setName("关注微信公众号");
		record.setOrderId(jsonXzfWechat.getOrderId());
		record.setStep(BaseInfo.XZF_STEP.WECHATCARE.getValue());
		record.setMemo("已关注");
		record.setLogType(BaseInfo.LOG_TYPE_XZF);
		xzfUserService.insertFlowLog(record);
		// 检查是否正在用户信息
		XzfUser user = xzfUserService.selectByPrimaryKey(jsonXzfWechat
				.getImei());
		// 如果用户存在则添加用户信息
		if (user != null) {
			if (user.getHasCared() == null
					|| user.getHasCared() < BaseContance.ACTIVICE_STATUS) {
				user.setHasCared(BaseContance.ACTIVICE_STATUS);
				xzfUserService.updateByPrimaryKeySelective(user);
			}
		}
		resultMap.put("resultCode", "1000");
		logger.info("接收用户微信关注状态返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

}
