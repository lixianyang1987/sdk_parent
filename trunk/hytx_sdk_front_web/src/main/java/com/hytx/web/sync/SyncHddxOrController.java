package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncHddx;
import com.hytx.model.sync.SyncHddxOr;
import com.hytx.model.sync.SyncHddxOrExample;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncHddxOrService;
import com.hytx.service.sync.ISyncHddxService;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncHddxOrController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncHddxOrService syncHddxOrService;

	/****
	 * 恒大短信订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "hddxor")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("恒大短信订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			int i = 0;
			String from = request.getParameter("from");
			String msg = request.getParameter("msg");
			String to = request.getParameter("to");
			String linkid = request.getParameter("linkid");
			String serviceid = request.getParameter("serviceid");
			String msgtype = request.getParameter("msgtype");
			String backurl = request.getParameter("backurl");
			String ip = IpUtil.getRealIp(request);
			if (!(ip.equals("118.144.79.163"))&&!(ip.equals("127.0.0.1"))) {
				return status;
			}
			if (from != "" && from != null && linkid != "" && linkid != null
					&& to != "" && to != null && serviceid != ""
					&& serviceid != null && msgtype != "" && msgtype != null
					&& backurl != "" && backurl != null) {
				SyncHddxOr syncHddx = new SyncHddxOr();
				syncHddx.setBackurl(backurl);
				syncHddx.setFromPhone(from);
				syncHddx.setToPhone(to);
				syncHddx.setLinkid(linkid);
				syncHddx.setMsgtype(msgtype);
				syncHddx.setServiceid(serviceid);
				if (msgtype.equals("0")) {
					syncHddx.setMsg(msg);
					i = syncHddxOrService.insertSyncHddxOr(syncHddx);
				}else if(msgtype.equals("10")){
					SyncHddxOrExample shdor= new SyncHddxOrExample();
					shdor.createCriteria().andLinkidEqualTo(linkid);
					syncHddx.setStatus(msg);
					i=syncHddxOrService.updateSyncHddxOr(syncHddx, shdor);
				}
				if (i == 1) {
					status = "ok";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("恒大短信订单同步状态为：{}", status);
		return status;
	}
}
