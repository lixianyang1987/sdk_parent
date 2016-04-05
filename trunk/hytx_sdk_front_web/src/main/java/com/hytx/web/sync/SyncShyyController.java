package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncShyy;
import com.hytx.service.sync.ISyncShyyService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncShyyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncShyyService syncShyyService;

	/****
	 * 上海幽宇订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月31日
	 */
	@RequestMapping(value = "shyy")
	@ResponseBody
	public String shyySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("上海幽宇订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String mobile = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");
			String msg = request.getParameter("msg");
			String port = request.getParameter("port");
			String statu = request.getParameter("status");
			String ip =IpUtil.getRealIp(request);
			if(!(ip.equals("117.135.154.97"))){
				return status;
			}
			if (mobile != "" && mobile != null && linkid != ""
					&& linkid != null && msg != "" && msg != null && port != ""
					&& port != null && statu != "" && statu != null) {
				SyncShyy syncShyy = new SyncShyy();
				syncShyy.setMobile(mobile);
				syncShyy.setLinkid(linkid);
				syncShyy.setMsg(msg);
				syncShyy.setPort(port);				
				syncShyy.setIp(ip);
				syncShyy.setStatus(statu);

				syncShyyService.insertSyncShyy(syncShyy);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("上海幽宇订单同步状态为：{}", status);
		return status;
	}
}
