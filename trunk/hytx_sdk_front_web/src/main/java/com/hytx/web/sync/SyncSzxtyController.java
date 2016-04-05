package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncSzxty;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncSzxtyService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")

public class SyncSzxtyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSzxtyService syncSzxtyservice;
	/****
	 * 深圳星天元订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "szxty")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("深圳星天元订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String mobile = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");			
			String state = request.getParameter("state");
			String fee = request.getParameter("fee");
			if (linkid != "" && linkid != null
					&& fee != "" && fee != null && state != ""
					&& state != null) {
			
				SyncSzxty syncszxty = new SyncSzxty();
				syncszxty.setMobile(mobile);
				syncszxty.setLinkid(linkid);
				syncszxty.setState(Integer.parseInt(state));				
				syncszxty.setIp(IpUtil.getRealIp(request));		
				
				syncszxty.setCpparam(linkid.substring(linkid.length() - 7));
				syncSzxtyservice.insertSyncSzxty(syncszxty);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("深圳星天元订单同步状态为：{}", status);
		return status;
		
	}
}
