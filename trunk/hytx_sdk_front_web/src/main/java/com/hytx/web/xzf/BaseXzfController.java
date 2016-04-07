package com.hytx.web.xzf;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.hytx.Json.XzfReqBase;
import com.hytx.constance.BaseContance;
import com.hytx.constance.ReqSmsCodeConstance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.xzf.XzfUser;
import com.hytx.service.client.IBaseReqService;
import com.hytx.service.xzf.IXzfUserService;

public class BaseXzfController {
	public static final Logger XZF_LOG = LoggerFactory.getLogger("XZF_LOG");
	@Autowired
	protected IBaseReqService baseReqService;
	@Autowired
	protected IXzfUserService xzfUserService;

	/***
	 * 将每次客户端请求的信息进一步封装成带应用、渠道包和省份等信息的对象
	 * 
	 * @param reqBase
	 * @return
	 */
	public BaseReqDto createBaseReqDto(XzfReqBase reqBase) {
		ChannelApp channelApp = baseReqService.selectChannelAppByKey(reqBase
				.getChannelAppKey());
		if (channelApp == null) {
			return null;
		}
		App app = baseReqService.selectAppById(channelApp.getAppId());
		if (app == null) {
			return null;
		}
		BaseReqDto dto = new BaseReqDto();
		dto.setApp(app);
		dto.setChannelApp(channelApp);
		dto.setSdkVersion(reqBase.getSdkVersion());
		dto.setExtraInfo(reqBase.getExtraInfo());
		dto.setImsi(reqBase.getImsi());
		dto.setImei(reqBase.getImei());
		dto.setServerType(checkServerType(reqBase.getImsi()));
		return dto;
	}

	/***
	 * 根据imsi确定运营商类型
	 * 
	 * @param imsi
	 * @return
	 * @author houzz
	 * @date 2015年6月8日
	 */
	public Integer checkServerType(String imsi) {
		if (imsi.startsWith("46001") || imsi.startsWith("46006")) {
			/*联通类型*/
			return BaseContance.SERVER_TYPE_UNICOM;
		} else if (imsi.startsWith("46003") || imsi.startsWith("46005")
				|| imsi.startsWith("46011")) {
			/*电信类型*/
			return BaseContance.SERVER_TYPE_TELECOM;
		} else {
			/* 移动类型,默认设置成移动类型,imsi以46000或46002或46007开头 */
			return BaseContance.SERVER_TYPE_MOBILE;
		}
	}

	/*****
	 * 验证是否可以计费，返回状态码,返回null表示可以计费
	 * 
	 * @param dto
	 * @param smsReq
	 * @return
	 */
	public Integer validXzfReq(BaseReqDto dto, XzfReqBase reqBase) {
		// 判断渠道包是是否存在记录
		if (dto == null) {
			return ReqSmsCodeConstance.NO_CHANNEL_APP_ERROR;
		}
		ChannelApp channelApp = dto.getChannelApp();
		// 判断数字签名是否正确
		if (!reqBase.validSign(channelApp.getSignKey())) {
			return ReqSmsCodeConstance.SIGN_ERROR;
		}
		return null;
	}

	public void checkAndSaveUser(BaseReqDto dto) {
		// 如果用户不存在则添加用户信息
		XzfUser user = xzfUserService.selectByPrimaryKey(dto.getImei());
		if (user == null) {
			saveUser(dto);
		}
	}

	public XzfUser saveUser(BaseReqDto dto) {
		XzfUser user = new XzfUser();
		user.setChannelAppId(dto.getChannelApp().getId());
		user.setCreateDt(new Date());
		user.setImsi(dto.getImsi());
		user.setImei(dto.getImei());
		user.setMaxAllowDebt(1000);
		xzfUserService.insert(user);
		return user;
	}

	/*****
	 * 打印参数绑定错误信息
	 * 
	 * @param bindingResult
	 * @author houzz
	 * @date 2016年2月1日
	 */
	public void printBindingErrors(BindingResult bindingResult) {
		XZF_LOG.info("请求参数格式不符合规范\n");
		List<FieldError> errors = bindingResult.getFieldErrors();
		if (errors == null || errors.isEmpty()) {
			return;
		}
		for (FieldError e : errors) {
			XZF_LOG.info(e.getObjectName() + "对象的" + e.getField() + "属性"
					+ e.getDefaultMessage());
		}
	}
}
