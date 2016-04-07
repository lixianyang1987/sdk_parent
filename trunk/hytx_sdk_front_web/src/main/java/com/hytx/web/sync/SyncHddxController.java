package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncHddx;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncHddxService;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncHddxController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncHddxService syncHddxService;

	/****
	 * 恒大短信订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "hddx")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("恒大短信订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String from = request.getParameter("from");
			String msg = request.getParameter("msg");
			String to = request.getParameter("to");
			String linkid = request.getParameter("linkid");
			String serviceid = request.getParameter("serviceid");
			String msgtype = request.getParameter("msgtype");
			String backurl = request.getParameter("backurl");
			String ip =IpUtil.getRealIp(request);
			if(!(ip.equals("118.144.79.163"))){
				return status;
			}
			if (from != "" && from != null && linkid != "" && linkid != null
					&& to != "" && to != null && serviceid != ""
					&& serviceid != null && msgtype != "" && msgtype != null
					&& backurl != "" && backurl != null) {
				
				SyncHddx syncHddx = new SyncHddx();
				syncHddx.setBackurl(backurl);
				syncHddx.setFromphone(from);
				syncHddx.setTophone(to);
				syncHddx.setLinkid(linkid);
				syncHddx.setMsg(msg);
				syncHddx.setMsgtype(msgtype);
				syncHddx.setServiceid(serviceid);
				syncHddxService.insertSyncHddx(syncHddx);				
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("恒大短信订单同步状态为：{}", status);
		return status;
	}
}
