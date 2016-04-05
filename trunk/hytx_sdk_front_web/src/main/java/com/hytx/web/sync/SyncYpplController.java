package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncYlel;
import com.hytx.model.sync.SyncYppl;
import com.hytx.model.sync.SyncYpplExample;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.service.sync.ISyncYlelService;
import com.hytx.service.sync.ISyncYpplService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncYpplController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncYpplService syncYpplService;

	/****
	 * 优朋普乐上行接口,包括移动、联通 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月31日
	 */
	@RequestMapping(value = "ypplo")
	@ResponseBody
	public String ypploSync(HttpServletRequest request) {
		String status = "failure";
		String ip =IpUtil.getRealIp(request);
		if(!(ip.equals("219.239.94.248"))){
			return status;
		}
		//mo_from=13800000000&mo_to=106688882&content=good&linkid=234234232&status=1
		logger.info("优朋普乐上行接口开始，订单信息为：\n{}", request.getQueryString());
		try {
			String mobile  = request.getParameter("mobile");
			String moid = request.getParameter("moid");
			String msg = request.getParameter("msg");
			String sp = request.getParameter("sp");
			
			if (mobile != "" && mobile != null && moid != "" && moid != null
					&& msg != "" && msg != null && sp != ""
					&& sp != null) {
				
				SyncYppl syncYppl = new SyncYppl();
				syncYppl.setMobile(mobile);
				syncYppl.setMoid(moid);
				syncYppl.setMsg(msg);
				syncYppl.setSp(sp);
				syncYppl.setReportcode("-1");
				//syncZjhy.setCpparam(message.substring(message.length() - 7));
				int i=syncYpplService.insertSyncYppl(syncYppl);
				if(i==1){
					status = "ok";
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("优朋普乐上行接口状态为：{}", status);
		return status;
	}
	
	
	/****
	 * 优朋普乐状态同步接口,包括移动、联通 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月31日
	 */
	@RequestMapping(value = "ypplt")
	@ResponseBody
	public String yppltSync(HttpServletRequest request) {
		String status = "failure";
		String ip =IpUtil.getRealIp(request);
		if(!(ip.equals("219.239.94.248"))){
			return status;
		}
		//mo_from=13800000000&mo_to=106688882&content=good&linkid=234234232&status=1
		logger.info("优朋普乐状态同步开始，订单信息为：\n{}", request.getQueryString());
		try {
			String moid = request.getParameter("moid");
			String reportcode  = request.getParameter("reportcode");
			if (moid != "" && moid != null && reportcode != "" && reportcode != null
					) {
				SyncYppl syncYppl = new SyncYppl();
				SyncYpplExample sye= new SyncYpplExample();
				if(reportcode.equals("0")){
					syncYppl.setReportcode("DELIVRD");
					syncYppl.setServerType("2");
				}else if(reportcode.equals("DELIVRD")){
					syncYppl.setServerType("1");
					syncYppl.setReportcode("DELIVRD");
				}				
				sye.createCriteria().andMoidEqualTo(moid);
				//syncZjhy.setCpparam(message.substring(message.length() - 7));
			int i=	syncYpplService.updateSyncYppl(syncYppl, sye);
				if(i==1){
					status = "ok";
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("优朋普乐状态同步状态为：{}", status);
		return status;
	}
}
