package com.hytx.web.client;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hytx.Json.JsonReqSms;
import com.hytx.Json.JsonSdkReqBase;
import com.hytx.constance.BaseContance;
import com.hytx.constance.ReqSmsCodeConstance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.IpInfo;
import com.hytx.service.baseConf.IAppService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;
import com.hytx.service.list.IUserFilterListService;
import com.hytx.util.IccidUtil;
import com.hytx.web.base.IpUtil;

public class BaseReqController {
	private static final Logger logger = LoggerFactory
			.getLogger(BaseReqController.class);
	@Autowired
	protected IBaseReqService baseReqService;
	@Autowired
	protected IAppService appService;
	@Autowired
	protected IProvinceService provinceService;
	@Autowired
	private IUserFilterListService userFilterListService;

	/***
	 * 将每次客户端请求的信息进一步封装成带应用、渠道包和省份等信息的对象
	 * 
	 * @param reqBase
	 * @return
	 */
	public BaseReqDto createBaseReqDto(JsonSdkReqBase reqBase) {
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
		dto.setServerType(checkServerType(reqBase.getImsi()));
		if (reqBase instanceof JsonReqSms) {
			JsonReqSms reqSms = (JsonReqSms) reqBase;
			dto.setImei(reqSms.getImei() == null ? "" : reqSms.getImei());
			dto.setLatitude(reqSms.getLatitude() == null ? "" : reqSms
					.getLatitude());
			dto.setLongitude(reqSms.getLongitude() == null ? "" : reqSms
					.getLongitude());
			dto.setBsccid(reqSms.getBsccid());
			dto.setBsclac(reqSms.getBsclac());
			String name = reqSms.getProvince();
			if (StringUtils.isBlank(name)) {
				name = IccidUtil.getProvinceNameByIccid(reqBase.getIccid());
				logger.info("根据iccid确认省份为{},省份id为:{}", (name != null ? name
						: "null"));
			}
			if (name != null) {
				Province p = provinceService.findProvinceByName(name);
				if (p != null) {
					dto.setProvinceId(p.getId());
				}
			}
			if (dto.getProvinceId() == null) {
				IpInfo ipInfo = baseReqService.selectIpInfoByIp(IpUtil
						.getIpLongValue(reqBase.getIp()));
				if (ipInfo != null) {
					dto.setProvinceId(ipInfo.getProvinceId());
					logger.info("根据ip确认省份id为:{}", ipInfo.getProvinceId());
				}
			}
		}
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
	 * 验证是否可以计费，返回状态码,返回0表示可以计费
	 * 
	 * @param dto
	 * @param smsReq
	 * @return
	 */
	public Integer validSmsReq(BaseReqDto dto, JsonReqSms smsReq) {
		// 判断渠道包是是否存在记录
		if (dto == null) {
			return ReqSmsCodeConstance.NO_CHANNEL_APP_ERROR;
		}
		ChannelApp channelApp = dto.getChannelApp();
		// 判断数字签名是否正确
		if (!smsReq.validSign(channelApp.getSignKey())) {
			return ReqSmsCodeConstance.SIGN_ERROR;
		}
		// 暂时将20元请求转为2元
		if (smsReq.getFeeValue() != null && smsReq.getFeeValue().equals(2000)) {
			if ("1.3.0".equals(smsReq.getSdkVersion())) {
				smsReq.setFeeValue(200);
			} else {
				smsReq.setFeeValue(1000);
			}
		}
		if (channelApp.getFeeStatus() != BaseContance.ACTIVICE_STATUS) {
			return ReqSmsCodeConstance.CHANNEL_APP_FEE_ERROR;
		}
		if (!baseReqService.validChannelApp(channelApp, dto.getProvinceId(),
				smsReq.getFeeValue())) {
			return ReqSmsCodeConstance.CHANNEL_APP_DAY_LIMIT_ERROR;
		}
		Integer listType = userFilterListService.checkUserFilterType(smsReq
				.getImsi());
		if (listType == null) {
			// 不在黑白名单内
			if (channelApp.getDayLimit() > 0) {
				// 用户日限验证
				if (baseReqService.selectDayConsumer(dto.getImsi())
						+ smsReq.getFeeValue() > channelApp.getDayLimit()) {
					return ReqSmsCodeConstance.USER_DAY_LIMIT_ERROR;
				}
			}
			if (channelApp.getMonthLimit() > 0) {
				// 用户月限验证
				if (baseReqService.selectMonthConsumer(dto.getImsi())
						+ smsReq.getFeeValue() > channelApp.getMonthLimit()) {
					return ReqSmsCodeConstance.USER_MONTH_LIMIT_ERROR;
				}
			}
		} else if (listType.equals(BaseContance.BLACK_LIST_TYPE)) {
			// 在黑名单内
			return ReqSmsCodeConstance.BLACK_ERROR;
		}
		return null;
	}

	/*****
	 * 验证是否可以计费，返回状态码,返回null表示可以计费
	 * 
	 * @param dto
	 * @param smsReq
	 * @return
	 */
	public Integer validXzfReq(BaseReqDto dto, JsonSdkReqBase reqBase) {
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

}
