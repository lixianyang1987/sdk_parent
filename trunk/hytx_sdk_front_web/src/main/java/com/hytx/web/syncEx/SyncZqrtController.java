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
import com.hytx.service.sync.ISyncZqrdService;


@Controller
@RequestMapping("/sync")
public class SyncZqrtController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncZqrdService syncZqrdService;

	/****
	 * 
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日

	 * 	 * 
	 * 
	 */
	@RequestMapping(value = "zqrd")
	@ResponseBody
	public String zqrdSync(HttpServletRequest request) {
		String status = "failure";
		String moContent=request.getQueryString();
		logger.info("M3订单同步上行信息开始，订单信息为：\n{}",moContent );
		try {
			
			String spnumber = request.getParameter("spnumber")==null?"":request.getParameter("spnumber");
			String mobile = request.getParameter("mobile")==null?"":request.getParameter("mobile");
			String content = request.getParameter("content")==null?"":request.getParameter("content");
			String linkid = request.getParameter("linkid")==null?"":request.getParameter("linkid");	
			String state = request.getParameter("state")==null?"":request.getParameter("state");	
			
			if (spnumber != "" && mobile != ""&& content != ""&& linkid != "" && state != "") {
				SyncZqrd syncMs = new SyncZqrd();
				syncMs.setSpnumber(spnumber);
				syncMs.setMobile(mobile);
				syncMs.setContent(content);
				syncMs.setLinkid(linkid);
				syncMs.setState(state);
				syncMs.setReqContent(moContent);
				int i=syncZqrdService.insertSyncZqrd(syncMs);
				if(i==-2){
					logger.info("订单同步上行指令不匹配：{}", status);
					return status;
				}
				if(syncMs.getReduceStatus()==0){
					syncZqrdService.syncToZqrd(syncMs);
				}
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("订单同步上行状态为：{}", status);
		return status;
	}
	
	@RequestMapping(value = "syncalla")
	@ResponseBody
	public String zqrdSyncall(HttpServletRequest request) {
		syncZqrdService.syncallZqrd();
		return "ok";
	}
	


}
