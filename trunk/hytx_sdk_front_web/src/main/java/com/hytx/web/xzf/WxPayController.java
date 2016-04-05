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

import com.hytx.Json.JsonXzfWxPay;
import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.dto.xzf.WxPayAppPayDto;
import com.hytx.dto.xzf.WxPayReqDto;
import com.hytx.dto.xzf.WxPayResultDto;
import com.hytx.model.xzf.XzfUser;
import com.hytx.model.xzf.XzfWxBill;
import com.hytx.model.xzf.XzfWxBillResult;
import com.hytx.service.xzf.IWxPayService;
import com.hytx.util.CopyUtil;
import com.hytx.util.JaxbUtil;
import com.hytx.util.StringUtil;

@RequestMapping("/xzf/wxpay")
@Controller
public class WxPayController extends BaseXzfController {
	private static final Logger logger = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	private IWxPayService wxPayService;

	/****
	 * 生成微信支付订单,在服务器端请求微信接口统一下单,返回确认信息给客户端
	 * 
	 * @param jsonXzfWxPay
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	@RequestMapping(value = "pay", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> wxpay(
			@Valid @RequestBody JsonXzfWxPay jsonXzfWxPay,
			BindingResult bindingResult) {
		logger.info("开始微信下订单,订单号信息为:\n{}", jsonXzfWxPay.toString());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			printBindingErrors(bindingResult);
			resultMap.put("resultCode", "101");
			return resultMap;
		}
		BaseReqDto reqDto = createBaseReqDto(jsonXzfWxPay);
		Integer validCode = validXzfReq(reqDto, jsonXzfWxPay);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("微信下订单返回状态:{}", validCode);
			return resultMap;
		}
		XzfUser user = xzfUserService.selectByPrimaryKey(reqDto.getImei());
		if (user == null) {
			saveUser(reqDto);
		} else {
			if (user.getDebt() != null && user.getDebt() > 0) {
				jsonXzfWxPay.setOpType(2);
			}
		}
		// 保存订单
		saveBill(jsonXzfWxPay, reqDto.getChannelApp().getId());
		WxPayReqDto wxPayReqDto = new WxPayReqDto(jsonXzfWxPay.getFeeValue()
				.toString(), jsonXzfWxPay.getOrderId(),
				jsonXzfWxPay.getProInfo());
		WxPayAppPayDto appPayDto = wxPayService.unionPay(wxPayReqDto);
		if (appPayDto == null) {
			resultMap.put("result", false);
		} else {
			resultMap.put("result", true);
			resultMap.put("payInfo", appPayDto);
		}
		resultMap.put("resultCode", "1000");
		logger.info("微信下订单返回状态:{}", "1000");
		return resultMap;
	}

	public void saveBill(JsonXzfWxPay jsonXzfWxPay, Integer channelAppId) {
		XzfWxBill bill = new XzfWxBill();
		bill.setChannelAppId(channelAppId);
		bill.setCreateDt(new Date());
		bill.setFeeType(jsonXzfWxPay.getFeeType());
		bill.setFeeValue(jsonXzfWxPay.getFeeValue());
		bill.setImsi(jsonXzfWxPay.getImsi());
		bill.setImei(jsonXzfWxPay.getImei());
		bill.setOrderId(jsonXzfWxPay.getOrderId());
		bill.setStep(1);
		bill.setOpType(jsonXzfWxPay.getOpType());
		bill.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
		bill.setProductCode("dx_video_" + jsonXzfWxPay.getFeeValue());
		bill.setEffectiveDt(bill.getCreateDt());
		bill.setExpireDt(DateUtils.addDays(bill.getEffectiveDt(), 30));
		wxPayService.insertXzfWxBill(bill);
	}

	/****
	 * 支付结果通知接口
	 * 
	 * @param content
	 * @return
	 * @author houzz
	 * @date 2016年1月7日
	 */
	@RequestMapping(value = "payResult", produces = "application/xml;charset=utf-8")
	@ResponseBody
	public String payResult(@RequestBody String content) {
		logger.info("收到微信支付结果通知信息为:\n{}", content);
		String backInfo = "";
		WxPayResultDto resultDto = null;
		String returnInfoTamplate = "<xml><return_code><![CDATA[{0}]]></return_code><return_msg><![CDATA[{1}]]></return_msg></xml>";
		try {
			resultDto = JaxbUtil.converyToJavaBean(content,
					WxPayResultDto.class);
		} catch (Exception e) {
			logger.info("微信支付结果数据错误:{}", e.getMessage());
		}
		if (resultDto == null) {
			backInfo = StringUtil.formatContent(returnInfoTamplate, "FAIL",
					"参数格式校验错误");
			return backInfo;
		}
		if (!resultDto.valid()) {
			backInfo = StringUtil.formatContent(returnInfoTamplate, "FAIL",
					"签名失败");
			logger.info("收到微信支付结果通知信息验证签名失败");
			return backInfo;
		}
		XzfWxBillResult wxBillResult = new XzfWxBillResult();
		CopyUtil.copy(resultDto, wxBillResult);
		wxBillResult.setCreateDt(new Date());
		wxBillResult.setTradeState("SUCCESS");
		try {
			wxPayService.insertXzfWxBillResult(wxBillResult);
			backInfo = StringUtil.formatContent(returnInfoTamplate, "SUCCESS",
					"");
			return backInfo;
		} catch (Exception e) {
			logger.info("微信支付结果数据保存错误:{}", e.getMessage());
			backInfo = StringUtil.formatContent(returnInfoTamplate, "FAIL", "");
			return backInfo;
		}
	}

	/****
	 * 检查微信支付状态
	 * 
	 * @param jsonXzfWxPay
	 * @param bindingResult
	 * @return
	 * @author houzz
	 * @date 2016年1月7日
	 */
	@RequestMapping(value = "payState", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectPayState(
			@Valid @RequestBody JsonXzfWxPay jsonXzfWxPay,
			BindingResult bindingResult) {
		logger.info("开始检查微信支付状态,订单号为:{},imei号为:{}", jsonXzfWxPay.getOrderId(),
				jsonXzfWxPay.getImei());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		BaseReqDto reqDto = createBaseReqDto(jsonXzfWxPay);
		Integer validCode = validXzfReq(reqDto, jsonXzfWxPay);
		if (validCode != null) {
			resultMap.put("resultCode", validCode);
			logger.info("检查微信支付状态:{}", validCode);
			return resultMap;
		}
		XzfWxBillResult wxBillResult = wxPayService
				.selectWxBillResult(jsonXzfWxPay.getOrderId());
		if (wxBillResult != null) {
			resultMap.put("state", wxBillResult.getTradeState());
		} else {
			String tradeState = wxPayService.wxPayQuery(jsonXzfWxPay
					.getOrderId());
			if (tradeState == null) {
				tradeState = "ERROR";
			}
			resultMap.put("state", tradeState);
		}
		logger.info("检查微信支付状态,交易状态为:{}", resultMap.get("state"));
		resultMap.put("resultCode", "1000");
		logger.info("检查微信支付状态:{}", "1000");
		return resultMap;
	}

}
