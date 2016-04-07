package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncNjgy;
import com.hytx.service.sync.ISyncNjgyService;

import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncNjgyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncNjgyService syncNjgyService;

	/****
	 * 南京果园订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "njgy")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("南京果园订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			
			String mobile = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");
			String msg = request.getParameter("msg");
			String spnumber = request.getParameter("spnumber");	
			String statu = request.getParameter("status");				 
			String ip =IpUtil.getRealIp(request);
			
			if (mobile != "" && mobile != null && linkid != "" && linkid != null
					&& msg != "" && msg != null && spnumber != ""
					&& spnumber != null&& statu != ""
					&& statu != null) {
				if(statu.equals("1")){
					statu="DELIVRD";
				}
				SyncNjgy syncNjgy = new SyncNjgy();
				syncNjgy.setMobile(mobile);
				syncNjgy.setLinkid(linkid);
				syncNjgy.setMsg(msg);
				syncNjgy.setSpnumber(spnumber);
				syncNjgy.setIp(ip);
				syncNjgy.setStatus(statu);
				
				syncNjgyService.insertSyncNjgy(syncNjgy);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("南京果园订单同步状态为：{}", status);
		return status;
	}
}
