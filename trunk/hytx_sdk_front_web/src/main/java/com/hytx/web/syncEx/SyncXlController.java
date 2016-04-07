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
import com.hytx.model.syncEx.SyncXl;
import com.hytx.service.sync.ISyncZqrdService;
import com.hytx.service.syncEx.ISyncDxltService;
import com.hytx.service.syncEx.ISyncXlService;

@Controller
@RequestMapping("/sync")
public class SyncXlController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncXlService syncXlService;
	

	/**** 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 * 
	 *       *
	 * 
	 */
	@RequestMapping(value = "xl")
	@ResponseBody
	public String zqrdSync(HttpServletRequest request,SyncXl syncxl) {
		String status = "failure";
		
		logger.info("星罗订单同步上行信息开始，订单信息为：\n{}", syncxl.toString());
		try {				
				
			syncxl.setCreatetime(new Date());
			int i=syncXlService.addXl(syncxl);
			if(i==-1){
				return status;
			}
			if(syncxl.getReduceStatus()==0){
				syncXlService.syncToXl(syncxl);
			}
				status = "ok";
			
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("星罗订单同步上行状态为：{}", status);
		return status;
	}
	@RequestMapping(value = "syncallxl")
	@ResponseBody
	public String DxltSyncall(HttpServletRequest request) {
		syncXlService.xlAllSync();
		return "ok";
	}

}
