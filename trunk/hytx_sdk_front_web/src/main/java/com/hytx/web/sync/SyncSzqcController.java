package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncSzqcController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSzqcService syncZjhyService;

	/****
	 * 上海力耀订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "shly")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("上海力耀订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String phone = request.getParameter("mobile");
			String linkid = request.getParameter("linkid");
			String message = request.getParameter("msg");
			String spnumber = request.getParameter("spnumber");
			String statu = request.getParameter("status");
			if (phone != "" && phone != null && linkid != "" && linkid != null
					&& message != "" && message != null && spnumber != ""
					&& spnumber != null&&
							statu != ""
					&& statu != null) {
				if(statu.equals("delivrd")){
					statu="DELIVRD";
				}
				SyncZjhy syncZjhy = new SyncZjhy();
				syncZjhy.setPhone(phone);
				syncZjhy.setLinkid(linkid);
				syncZjhy.setMessage(message);
				syncZjhy.setSpnumber(spnumber);
				syncZjhy.setIp(IpUtil.getRealIp(request));
				syncZjhy.setRptStat(statu);
				//syncZjhy.setCpparam(message.substring(message.length() - 7));
				syncZjhyService.insertSyncZjhy(syncZjhy);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("上海力耀订单同步状态为：{}", status);
		return status;
	}
}
