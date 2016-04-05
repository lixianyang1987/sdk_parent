package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncTtf;
import com.hytx.service.sync.ISyncTtfReqService;


@Controller
@RequestMapping("/sync")
public class SyncTtfReqController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncTtfReqService syncTtfReqService;
	/****
	 * 通天富指令请求接口,包括电信天翼空间 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "ttfreq")
	@ResponseBody
	public String ttfSync(HttpServletRequest request) {
		String status = "failure";
		logger.info("通天富指令请求开始，订单信息为：\n{}", request.getQueryString());
		try{
		String cpId=request.getParameter("cpId")==null?"":request.getParameter("cpId");
		String opId=request.getParameter("opId")==null?"":request.getParameter("opId");
		String appId=request.getParameter("appId")==null?"":request.getParameter("appId");
		String imsi=request.getParameter("imsi")==null?"":request.getParameter("imsi");
		String fee=request.getParameter("fee")==null?"":request.getParameter("fee");
		String channelId=request.getParameter("channelId")==null?"":request.getParameter("channelId");
		String exData=request.getParameter("exData")==null?"":request.getParameter("exData");
		if(cpId!=""&&opId!=""&&appId!=""&&imsi!=""&&fee!=""){
			SyncTtf syncttf= new SyncTtf();
			syncttf.setCpid(Integer.parseInt(cpId));
			syncttf.setOpid(Short.parseShort(opId));
			syncttf.setAppid(Long.parseLong(appId));
			syncttf.setImsi(Long.parseLong(imsi));
			syncttf.setFee(Short.parseShort(fee));
			syncttf.setChannelid(channelId);
			syncttf.setExdata(exData);
			status=	syncTtfReqService.syncTtfreq(syncttf);
		}		
	
		}catch (Exception e){
			e.printStackTrace();
			status = "failure";
		}
		logger.info("通天富指令请求信息：{}", status);
		return status;
	}
}
