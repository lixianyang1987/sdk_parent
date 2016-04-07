package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncHhai;
import com.hytx.model.sync.SyncQhd;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncHhaiService;
import com.hytx.service.sync.ISyncQhdService;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncHhaiController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncHhaiService syncHhaiService;

	/****
	 * 瀚海订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "hhai")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("瀚海订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			
			
			String mobile = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");
			String momsg = request.getParameter("momsg");
			String spnumber = request.getParameter("spnumber");		
			String ip =IpUtil.getRealIp(request);
			
			if (mobile != "" && mobile != null && linkid != "" && linkid != null
					&& momsg != "" && momsg != null && spnumber != ""
					&& spnumber != null) {
				
				SyncHhai syncHhai = new SyncHhai();
				syncHhai.setMobile(mobile);
				syncHhai.setLinkid(linkid);
				syncHhai.setMomsg(momsg);
				syncHhai.setSpnumber(spnumber);
				syncHhai.setIp(ip);
				syncHhai.setStatus("DELIVRD");
				
				syncHhaiService.insertSyncHhai(syncHhai);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("瀚海订单同步状态为：{}", status);
		return status;
	}
}
