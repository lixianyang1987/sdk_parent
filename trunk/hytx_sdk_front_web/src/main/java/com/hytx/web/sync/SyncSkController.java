package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncSk;
import com.hytx.service.sync.ISyncSkService;

@Controller
@RequestMapping("/sync")
public class SyncSkController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSkService syncSkService;

	/****
	 * 刷卡订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "sk")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("刷卡订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String orderId = request.getParameter("orderId") == null ? ""
					: request.getParameter("orderId");
			String tradeId = request.getParameter("TradeID") == null ? ""
					: request.getParameter("TradeID");
			String price = request.getParameter("Price") == null ? "" : request
					.getParameter("Price");
			String feeMsisdn = request.getParameter("FeeMSISDN") == null ? ""
					: request.getParameter("FeeMSISDN");
			String appId = request.getParameter("AppID") == null ? "" : request
					.getParameter("AppID");
			String PayCode = request.getParameter("PayCode") == null ? ""
					: request.getParameter("PayCode");
			String exData = request.getParameter("ExData") == null ? ""
					: request.getParameter("ExData");
			String statu = request.getParameter("status") == null ? ""
					: request.getParameter("status");

			if (orderId != "" && orderId != null && appId != ""
					&& appId != null && PayCode != "" && PayCode != null
					&& statu != "" && statu != null) {

				SyncSk syncSk = new SyncSk();
				syncSk.setAppid(appId);
				syncSk.setExdata(exData);
				syncSk.setFeemsisdn(feeMsisdn);
				syncSk.setOrderid(orderId);
				syncSk.setPaycode(PayCode);
				syncSk.setPrice(price);
				syncSk.setStatus(statu);
				syncSk.setTradeid(tradeId);
				int i = syncSkService.insertSyncSk(syncSk);
				if (i == 1) {
					status = "ok";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("刷卡订单同步状态为：{}", status);
		return status;
	}
}
