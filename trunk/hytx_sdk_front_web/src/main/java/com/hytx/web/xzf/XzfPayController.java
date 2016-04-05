package com.hytx.web.xzf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.Json.JsonXzfSelfBill;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.xzf.XzfFlowLog;
import com.hytx.model.xzf.XzfSelfBill;
import com.hytx.model.xzf.XzfUser;
import com.hytx.service.xzf.IXzfBillService;
import com.hytx.util.JsonMapper;
import com.hytx.web.base.BaseInfo;

@Controller
@RequestMapping("/xzf")
public class XzfPayController extends BaseXzfController {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private IXzfBillService xzfBillService;

	/****
	 * 生成信支付订单
	 * 
	 * @param jsonXzfSelfBill
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月5日
	 */
	@RequestMapping(value = "xzfBill", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createSelfBill(
			@Valid @RequestBody JsonXzfSelfBill jsonXzfSelfBill,
			BindingResult bindingResult) {
		logger.info("开始使用信支付下订单,请求数据为：{}", jsonXzfSelfBill.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfSelfBill);
		Integer validCode = validXzfReq(reqDto, jsonXzfSelfBill);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("使用信支付下订单返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		// 如果用户不存在则添加用户信息
		XzfUser user = xzfUserService.selectByPrimaryKey(jsonXzfSelfBill
				.getImei());
		if (user == null) {
			user = saveUser(reqDto);
		}
		if (user.getDebt() != null && user.getDebt() > 0) {
			resultMap.put("resultCode", "1000");
			resultMap.put("result", false);
			resultMap.put("msg", "尊敬的用户，您的信支付借款尚未偿还，请还款后再使用！");
			logger.info("使用信支付下订单返回数据为：{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		resultMap.put("result", true);
		XzfSelfBill bill = new XzfSelfBill();
		bill.setChannelAppId(reqDto.getChannelApp().getId());
		bill.setCreateDt(new Date());
		bill.setFeeType(jsonXzfSelfBill.getFeeType());
		bill.setFeeValue(jsonXzfSelfBill.getFeeValue());
		bill.setImsi(jsonXzfSelfBill.getImsi());
		bill.setImei(jsonXzfSelfBill.getImei());
		bill.setOrderId(jsonXzfSelfBill.getOrderId());
		bill.setStep(BaseInfo.XZF_STEP.CREATEBILL.getValue());
		bill.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
		bill.setProductCode("dx_video_" + jsonXzfSelfBill.getFeeValue());
		bill.setEffectiveDt(bill.getCreateDt());
		bill.setExpireDt(DateUtils.addDays(bill.getEffectiveDt(), 7));
		xzfBillService.insertXzfBill(bill);
		// 添加日志
		XzfFlowLog record = new XzfFlowLog();
		record.setCreateDt(new Date());
		record.setImsi(jsonXzfSelfBill.getImsi());
		record.setImei(jsonXzfSelfBill.getImei());
		record.setName("信支付订单");
		record.setOrderId(jsonXzfSelfBill.getOrderId());
		record.setStep(BaseInfo.XZF_STEP.CREATEBILL.getValue());
		record.setMemo("信支付订单,金额为" + jsonXzfSelfBill.getFeeValue() + " 订单类型:"
				+ jsonXzfSelfBill.getFeeType());
		record.setLogType(BaseInfo.LOG_TYPE_XZF);
		xzfUserService.insertFlowLog(record);
		resultMap.put("resultCode", "1000");
		logger.info("使用信支付下订单返回数据为：{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

}
