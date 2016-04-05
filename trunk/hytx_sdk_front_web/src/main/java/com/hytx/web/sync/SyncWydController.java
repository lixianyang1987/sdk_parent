package com.hytx.web.sync;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncWyd;
import com.hytx.model.sync.SyncWydF;
import com.hytx.service.sync.ISyncWydService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncWydController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncWydService syncWydService;

	@RequestMapping(value = "wyd")
	@ResponseBody
	public String sjdySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("沃阅读订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			SyncWydF syncWyd = new SyncWydF();
			String m = request.getParameter("phonenum");
			if (m != null) {
				if (m.length() > 11) {
					m = m.substring(m.length() - 11);
				}
				syncWyd.setPhoneNum(Long.parseLong(m));
			}
			syncWyd.setPayFee(Integer.parseInt(request.getParameter("payfee")));
			syncWyd.setHret(Integer.parseInt(request.getParameter("hRet")));
			syncWyd.setOrderTime(request.getParameter("ordertime"));
			syncWyd.setAppInfo(request.getParameter("appid"));
			syncWyd.setStatus(request.getParameter("status"));
			if (m != null && syncWyd.getAppInfo() != null
					&& syncWyd.getHret() != null && syncWyd.getPayFee() != null) {
				syncWyd.setUpdateDt(new Date());
				syncWyd.setIp(IpUtil.getRealIp(request));
				syncWydService.insertSyncWyd(syncWyd);
				status = "ok";
				if(syncWyd.getReduceStatus()==0){
					
					syncWydService.syncToWydf(syncWyd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("沃阅读订单同步状态为：{}", status);
		return status;
	}
	@RequestMapping(value = "syncallwyd")
	@ResponseBody
	public String DxltSyncall(HttpServletRequest request) {
		syncWydService.WydSync();
		return "ok";
	}
}
