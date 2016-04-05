package com.hytx.web.xinPayClient;

import java.util.Date;
import java.util.Random;

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

import com.hytx.Json.JsonReqXinPaySms;
import com.hytx.Json.JsonRespXinPaySms;
import com.hytx.constance.ReqSmsCodeConstance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.client.IReqSmsService;
import com.hytx.service.client.ISdkLoadService;
import com.hytx.web.base.IpUtil;
import com.hytx.web.client.BaseReqController;

/*****
 * 此类用于sdk客户端请求短信指令及同步指令发送状态
 * 
 * @author houzz
 *
 */
@Controller
@RequestMapping("/xinPayClient")
public class XinPayReqSmsController extends BaseReqController {
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
	@RequestMapping(value = "reqUserInfo", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public JsonRespXinPaySms xinPayFindSmsContent(
			@Valid @RequestBody JsonReqXinPaySms smsReq,
			BindingResult bindingResult, HttpServletRequest request) {
		logger.info("user-agent：{}", request.getHeader("User-Agent"));
		long startTime = new Date().getTime();
		smsReq.setIp(IpUtil.getRealIp(request));
		logger.info("客户请求信息为：{}", smsReq.toString());
		JsonRespXinPaySms result = new JsonRespXinPaySms();
		// 根据请求信息加载相关基本信息存放在一个dto实体内
		BaseReqDto baseReqDto = createBaseReqDto(smsReq);
		// 验证
		Integer validResult = validXzfReq(baseReqDto, smsReq);
		Random random = new Random();
		int x = random.nextInt(899999);
		x = x + 100000;
		int presentCode = x;
		result.setResultCode(ReqSmsCodeConstance.SUCCESS.toString());
		result.setPersentCode(presentCode + "");
		long endTime = new Date().getTime();
		logger.debug("共用时间为：" + (endTime - startTime));
		logger.info("短串请求返回数据为：{}", result.toString());
		return result;
	}

}
