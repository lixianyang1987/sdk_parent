package com.hytx.web.syncEx;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncZqrd;
import com.hytx.model.sync.Tdxlt;
import com.hytx.service.sync.ISyncZqrdService;
import com.hytx.service.syncEx.ISyncDxltService;

@Controller
@RequestMapping("/sync")
public class SyncDxltController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncDxltService syncDxltService;
	

	/**** 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 * 
	 *       *
	 * 
	 */
	@RequestMapping(value = "dxlt")
	@ResponseBody
	public String zqrdSync(HttpServletRequest request,Tdxlt tdxlt) {
		String status = "failure";
		String moContent = request.getQueryString();
		logger.info("短信绿通订单同步上行信息开始，订单信息为：\n{}", moContent);
		try {				
				
				syncDxltService.addDxlt(tdxlt);
				if(tdxlt.getReduceStatus()==0){
					syncDxltService.syncToDxlt(tdxlt);
				}
				status = "ok";
			
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("短信绿通订单同步上行状态为：{}", status);
		return status;
	}

	@RequestMapping(value = "syncalldxlt")
	@ResponseBody
	public String DxltSyncall(HttpServletRequest request) {
		syncDxltService.dxltSync();
		return "ok";
	}

}
