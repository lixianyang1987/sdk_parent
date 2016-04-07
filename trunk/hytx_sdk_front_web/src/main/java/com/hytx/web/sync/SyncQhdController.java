package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncQhd;
import com.hytx.service.sync.ISyncQhdService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncQhdController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncQhdService syncQhdService;

	/****
	 * 秦汉达订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "qhd")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("秦汉达订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String mobile = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");
			String msg = request.getParameter("msg");
			String spnumber = request.getParameter("spnumber");
			// String fee = request.getParameter("fee");
			String statu = request.getParameter("status");
			String ext = request.getParameter("ext");
			String ip = IpUtil.getRealIp(request);
			if (!(ip.equals("203.195.150.127"))) {
				return status;
			}
			if (mobile != "" && mobile != null && linkid != ""
					&& linkid != null && msg != "" && msg != null
					&& spnumber != "" && spnumber != null && statu != ""
					&& statu != null) {

				SyncQhd syncQhd = new SyncQhd();
				syncQhd.setMobile(mobile);
				syncQhd.setLinkid(linkid);
				syncQhd.setMsg(msg);
				syncQhd.setSpnumber(spnumber);
				syncQhd.setIp(ip);
				syncQhd.setStatus(statu);
				if (ext != null && ext.length() > 7) {
					syncQhd.setExt(ext.substring(ext.length() - 7));
				}
				syncQhdService.insertSyncQhd(syncQhd);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("秦汉达订单同步状态为：{}", status);
		return status;
	}
}
