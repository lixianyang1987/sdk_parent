package com.hytx.web.xzf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import com.hytx.Json.JsonXzfUniPay;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.xzf.XzfUnipayBill;
import com.hytx.model.xzf.XzfUser;
import com.hytx.service.unipay.IUnipayService;
import com.hytx.util.JsonMapper;

@RequestMapping("/xzf/unipay")
@Controller
public class UnionPayController extends BaseXzfController {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	private IUnipayService unipayService;

	/****
	 * 生成银联支付订单
	 * 
	 * @param jsonXzfWxPay
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	@RequestMapping(value = "pay", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> unionPay(
			@Valid @RequestBody JsonXzfUniPay jsonXzfUniPay,
			BindingResult bindingResult) {
		logger.info("开始银联支付下订单,请求信息为:\n{}", jsonXzfUniPay.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfUniPay);
		Integer validCode = validXzfReq(reqDto, jsonXzfUniPay);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("银联支付返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		XzfUser user = xzfUserService.selectByPrimaryKey(reqDto.getImei());
		if (user == null) {
			saveUser(reqDto);
		} else {
			if (user.getDebt() != null && user.getDebt() > 0) {
				jsonXzfUniPay.setOpType(2);
			}
		}
		// 保存订单
		saveBill(jsonXzfUniPay, reqDto.getChannelApp().getId());
		resultMap.put("result", true);
		resultMap.put("resultCode", "1000");
		logger.info("银联支付返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	public void saveBill(JsonXzfUniPay jsonXzfUniPay, Integer channelAppId) {
		XzfUnipayBill bill = new XzfUnipayBill();
		bill.setChannelAppId(channelAppId);
		bill.setCreateDt(new Date());
		bill.setFeeType(jsonXzfUniPay.getFeeType());
		bill.setFeeValue(jsonXzfUniPay.getFeeValue());
		bill.setImsi(jsonXzfUniPay.getImsi());
		bill.setImei(jsonXzfUniPay.getImei());
		bill.setOrderId(jsonXzfUniPay.getOrderId());
		bill.setStep(1);
		bill.setOpType(jsonXzfUniPay.getOpType());
		bill.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
		bill.setProductCode("dx_video_" + jsonXzfUniPay.getFeeValue());
		bill.setEffectiveDt(bill.getCreateDt());
		bill.setExpireDt(DateUtils.addDays(bill.getEffectiveDt(), 30));
		unipayService.insertXzfUnipayBill(bill);
	}

	/****
	 * 检查银联支付状态
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
			@Valid @RequestBody JsonXzfUniPay jsonXzfUniPay,
			BindingResult bindingResult) {
		logger.info("开始检查银联订单状态,请求信息为:\n{}", jsonXzfUniPay.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BaseReqDto reqDto = createBaseReqDto(jsonXzfUniPay);
		Integer validCode = validXzfReq(reqDto, jsonXzfUniPay);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("检查银联订单状态返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
			return resultMap;
		}
		XzfUnipayBill bill = unipayService
				.selectXzfUnipayBillByOrderId(jsonXzfUniPay.getOrderId());
		if (bill != null && bill.getStatus() != null
				&& BaseContance.ACTIVICE_STATUS == bill.getStatus()) {
			resultMap.put("result", true);
		} else {
			resultMap.put("result", false);
		}
		resultMap.put("resultCode", "1000");
		logger.info("检查银联订单状态返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

}
