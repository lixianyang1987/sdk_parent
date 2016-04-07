package com.hytx.web.syncEx;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hytx.model.sync.Tsyskmm;

import com.hytx.service.syncEx.ISyncSyskmmService;

@Controller
@RequestMapping("/sync")
public class SyncTsyskController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSyskmmService syncSyskmmService;
	

	/****
	 * 
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 * 
	 *       *
	 * 
	 */
	@RequestMapping(value = "sysk")
	@ResponseBody
	public String syskmmSync(HttpServletRequest request,Tsyskmm tsyskmm,String order_id) {
		String status = "failure";
		String moContent = request.getQueryString();
		logger.info("首游时空订单同步上行信息开始，订单信息为：\n{}", moContent);
		try {				
			tsyskmm.setOrderId(order_id);
			syncSyskmmService.addSyncSyskmm(tsyskmm);
				if(tsyskmm.getReduceStatus()==0){
					syncSyskmmService.syncToSysk(tsyskmm);
				}
				status = "ok";
			
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("首游时空订单同步上行状态为：{}", status);
		return status;
	}
	@RequestMapping(value = "syncallmm")
	@ResponseBody
	public String mmSyncall(HttpServletRequest request) {
		syncSyskmmService.mmSync();
		return "ok";
	}


}
