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
import com.hytx.model.syncEx.TsyncexSky;
import com.hytx.service.sync.ISyncZqrdService;
import com.hytx.service.syncEx.ISyncDxltService;
import com.hytx.service.syncEx.ISyncSkyService;

@Controller
@RequestMapping("/sync")
public class SyncSkyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSkyService syncSkyService;
	

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
	@RequestMapping(value = "reqsms")
	@ResponseBody
	public String reqSms(HttpServletRequest request,TsyncexSky syncexSky) {
		String status = "failure";
		String moContent = request.getQueryString();
		logger.info("世坤远请求Sms信息为：\n{}", moContent);
		try {				
			syncexSky.setPhonenum(request.getParameter("phoneNum"));
			status= syncSkyService.reqSms(syncexSky);
			
		} catch (Exception e) {
			e.printStackTrace();
			status = "error";
		}
		logger.info("世坤远返回状态为：{}", status);
		return status;
	}

	@RequestMapping(value = "reqresult")
	@ResponseBody
	public String reqResult(HttpServletRequest request,TsyncexSky syncexSky) {
		
		String moContent = request.getQueryString();
		logger.info("世坤远请求结果信息为：\n{}", moContent);
		String str= syncSkyService.reqResult(syncexSky,request.getParameter("paymentCode"));
		logger.info("世坤远返回结果信息为：\n{}", str);
		return 	str;	
	}

}
