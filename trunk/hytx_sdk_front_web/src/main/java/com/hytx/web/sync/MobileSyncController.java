package com.hytx.web.sync;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.CpOrderSync;
import com.hytx.model.sync.MobileSync;
import com.hytx.service.sync.IMobileSyncService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class MobileSyncController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private IMobileSyncService mobileSyncService;

	/***
	 * MDO移动订单同步接口
	 * 
	 * @param mobileSync
	 * @return
	 * @author houzz
	 * @date 2015年6月16日
	 */
	@RequestMapping(value = "mobileSync")
	@ResponseBody
	public String orderSync(MobileSync mobileSync, HttpServletRequest request) {
		logger.info("移动订单同步信息开始，订单信息为：\n{}", mobileSync.toString());
		String status = "failure";
		try {
			if (!StringUtils.isBlank(mobileSync.getTelno())) {
				mobileSync.setUpdateDt(new Date());
				mobileSyncService.insertMobileSync(mobileSync);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("移动订单同步状态为：{}", status);
		return status;
	}

	/****
	 * cp订单同步接口
	 * 
	 * @param cpOrderSync
	 * @return
	 * @author houzz
	 * @date 2015年7月16日
	 */
	@RequestMapping(value = "cpSync")
	@ResponseBody
	public String cpOrderSync(CpOrderSync cpOrderSync,
			HttpServletRequest request) {
		logger.info("cp订单同步信息开始，订单信息为：\n{}", cpOrderSync.toString());
		String status = "failure";
		try {
			if (!StringUtils.isBlank(cpOrderSync.getKey())) {
				cpOrderSync.setUpdateDt(new Date());
				cpOrderSync.setIp(IpUtil.getRealIp(request));
				mobileSyncService.insertCpOrderSync(cpOrderSync);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("cp订单同步状态为：{}", status);
		return status;
	}

}
