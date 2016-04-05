package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.hytx.model.sync.SyncSzzb;

import com.hytx.service.sync.ISyncSzzbService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncSzzbController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSzzbService syncSzzbService;

	/****
	 * 深圳卓宝订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 */
	@RequestMapping(value = "szzb")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("深圳卓宝订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String mobile = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");
			String msg = request.getParameter("msg");
			String spnumber = request.getParameter("spnumber");
			
			String statu =request.getParameter("status");
			
			if (mobile != "" && mobile != null && linkid != "" && linkid != null
					&& msg != "" && msg != null && spnumber != ""
					&& spnumber != null&&
							statu != ""
					&& statu != null) {
				
				SyncSzzb syncSzzb =new SyncSzzb();
				syncSzzb.setMobile(mobile);
				syncSzzb.setLinkid(linkid);
				syncSzzb.setMsg(msg);
				syncSzzb.setSpnumber(spnumber);
				syncSzzb.setIp(IpUtil.getRealIp(request));
				syncSzzb.setStatus(statu);
		
				syncSzzbService.insertSyncSzzb(syncSzzb);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("深圳卓宝订单同步状态为：{}", status);
		return status;
	}
}
