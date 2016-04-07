package com.hytx.web.sync;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncYlel;
import com.hytx.model.sync.SyncYppl;
import com.hytx.model.sync.SyncYpplDx;
import com.hytx.model.sync.SyncYpplDxExample;
import com.hytx.model.sync.SyncYpplExample;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.service.sync.ISyncYlelService;
import com.hytx.service.sync.ISyncYpplDxService;
import com.hytx.service.sync.ISyncYpplService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncYpplDxController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncYpplDxService syncYpplDxService;

	/****
	 * 优朋普乐上行同步接口,包括电信
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月31日
	 */
	@RequestMapping(value = "yppldx")
	@ResponseBody
	public String ypploSync(HttpServletRequest request) {
		String status = "failure";
		String ip =IpUtil.getRealIp(request);
		if(!(ip.equals("218.241.154.95"))&&!(ip.equals("127.0.0.1"))){
			return status;
		}
		//mo_from=13800000000&mo_to=106688882&content=good&linkid=234234232&status=1
		logger.info("优朋普乐电信上行、同步接口开始，订单信息为：\n{}", request.getQueryString());
		try {
			String Action  = request.getParameter("Action");
			String MOContent ="";
			String MTContent ="";
			String Fee ="";
			String Status ="";
			String SPID = request.getParameter("SPID");
			String Mobile = request.getParameter("Mobile");
			String LinkID = request.getParameter("LinkID");
			String dTime = request.getParameter("dTime");
			SyncYpplDx syncYpplDx=new SyncYpplDx();
			syncYpplDx.setSpid(SPID);
			syncYpplDx.setMobile(Mobile);
			syncYpplDx.setLinkid(LinkID);
			syncYpplDx.setDtime(dTime);
			int i=0;
			
			if(Action.equals("3")){
				logger.info("优朋普乐电信上行接口开始，订单信息为：");
				MOContent=URLEncoder.encode (request.getParameter("MOContent"), "UTF-8" );
				syncYpplDx.setMocontent(MOContent);
				i=syncYpplDxService.insertSyncYpplDx(syncYpplDx);
				if(i==1){
					status="ok";
				}
				
			}else if(Action.equals("4")){
				logger.info("优朋普乐电信同步接口开始，订单信息为：");
				MTContent=URLEncoder.encode (request.getParameter("MTContent"), "UTF-8" );
				Fee=request.getParameter("Fee");
				Status=request.getParameter("Status");
				if(Status.equals("0")||Status.equals("OK")){
				Status ="DELIVRD";
				}
				syncYpplDx.setMtcontent(MTContent);
				syncYpplDx.setFee(Fee);
				syncYpplDx.setStatus(Status);
				SyncYpplDxExample syde = new SyncYpplDxExample();
				syde.createCriteria().andLinkidEqualTo(LinkID);
				i=syncYpplDxService.updateSyncYppl(syncYpplDx, syde);
				if(i==1){
					status="ok";
				}
			}				
				
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("优朋普乐电信上行、同步接口状态为：{}", status);
		return status;
	}
	
	
	
}
