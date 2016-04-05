package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncTtf;
import com.hytx.service.sync.ISyncTtfService;


@Controller
@RequestMapping("/sync")
public class SyncTtfController {
	
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncTtfService syncTtfService;

	/****
	 * 通天富订单同步接口,包括电信天翼空间 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "ttf")
	@ResponseBody
	public String ttfSync(HttpServletRequest request) {
		String status = "failure";
		logger.info("通天富订单同步信息开始，订单信息为：\n{}", request.getQueryString());	
		try{
		String orderNo =request.getParameter("orderNo");
		String opId =request.getParameter("opId");
		String appId =request.getParameter("appId");
		String imsi =request.getParameter("imsi");
		String fee =request.getParameter("fee");		
		String resultCode =request.getParameter("resultCode");
		String resultDesc =request.getParameter("resultDesc");		
		String channelId =request.getParameter("channelId")==null?"":request.getParameter("channelId");
		String exData =request.getParameter("exData")==null?"":request.getParameter("exData");
		String region =request.getParameter("region")==null?"":request.getParameter("region");
		
		if(orderNo != "" && orderNo != null && 
					opId != "" && opId != null && 
						appId != "" && appId != null && 
								imsi != "" && imsi != null && 
										fee != "" && fee != null && 
												resultCode != "" && resultCode != null && 
														resultDesc != "" && resultDesc != null ){
			SyncTtf syncttf= new SyncTtf();
			syncttf.setOrderno(Long.parseLong(orderNo));
			syncttf.setOpid(Short.parseShort(opId));
			syncttf.setAppid(Long.parseLong(appId));
			syncttf.setImsi(Long.parseLong(imsi));
			syncttf.setFee(Short.parseShort(fee));
			syncttf.setResultcode(resultCode);
			syncttf.setResultdesc(resultDesc);
			syncttf.setChannelid(channelId);
			syncttf.setExdata(exData);
			syncttf.setRegion(region);
			syncTtfService.insertSyncTtf(syncttf);
			status = "ok";
		}
	} catch (Exception e) {
		e.printStackTrace();
		status = "failure";
	}
	logger.info("通天富订单同步状态为：{}", status);
	return status;
		
		
		
	}
}
