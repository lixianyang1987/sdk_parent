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

import com.hytx.model.baseConf.Dict;
import com.hytx.model.sync.CpOrderSync;
import com.hytx.model.sync.MobileSync;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.sync.IMobileSyncService;
import com.hytx.service.syncEx.DdoreqService;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.ISyncTyAllService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/syncdm")
public class MobileSyncController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");

	@Autowired
	private DdoreqService ddoReqService;
	@Autowired
	private ISyncTyAllService syncTyAllService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private ISyncByLogService syncByLogService;

	// 移动动漫基地同步
	@RequestMapping(value = "yddmpj")
	@ResponseBody
	public String dxmomrSync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("移动动漫基地-订单同步上行信息开始，订单信息为：\n{}",
					request.getQueryString());
			SyncTyAll tyall = new SyncTyAll();
			String tranid = request.getParameter("orderno") != null ? request
					.getParameter("orderno") : ""; // 计费流水号
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String imsi = request.getParameter("imsi") != null ? request
					.getParameter("imsi") : "";
			String feecode = request.getParameter("amount") != null ? request
					.getParameter("amount").toLowerCase() : ""; // 业务代码
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String cpparam = request.getParameter("cpparam") != null ? request
					.getParameter("cpparam") : "";
			if (statu.equals("0")) {
				statu = "DELIVRD";
			}
			int channelappId = Integer.parseInt(cpparam);
			tyall.setChannelAppId(channelappId); // 下游渠道包编号
			tyall.setPayFee(Integer.parseInt(feecode));
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setStatus(statu);
			tyall.setReserveTwo(imsi);
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("移动动漫基地-订单同步-error：{}", e.getMessage());
			status = "1";
		}
		logger.info("移动动漫基地-订单同步状态为：{}", status);
		return status;
	}
}
