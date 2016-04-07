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

import com.hytx.Json.JsonXzfBillBase;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.xzf.XzfHuafeiBill;
import com.hytx.model.xzf.XzfUser;
import com.hytx.service.xzf.IXzfHuafeiService;
import com.hytx.util.JsonMapper;

@RequestMapping("/xzf/huafei")
@Controller
public class HuafeiPayController extends BaseXzfController {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	private IXzfHuafeiService huafeiService;

	/****
	 * 生成话费支付订单
	 * 
	 * @param jsonXzfWxPay
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	@RequestMapping(value = "pay", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> huafeiPay(
			@Valid @RequestBody JsonXzfBillBase jsonXzfBillBase,
			BindingResult bindingResult) {
		logger.info("开始话费支付下订单,请求信息为:\n{}", jsonXzfBillBase.toString());
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
			logger.info("话费支付返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
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
		logger.info("话费支付返回数据为:\n{}", JsonMapper.toLogJson(resultMap));
		return resultMap;
	}

	public void saveBill(JsonXzfBillBase jsonXzfBillBase, Integer channelAppId) {
		XzfHuafeiBill bill = new XzfHuafeiBill();
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
		huafeiService.insertHuafeiBill(bill);
	}

}
