package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncYlel;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.sync.ISyncSzqcService;
import com.hytx.service.sync.ISyncYlelService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncYlelController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncYlelService syncYlelService;

	/****
	 * 1020订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月31日
	 */
	@RequestMapping(value = "ylel")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		//mo_from=13800000000&mo_to=106688882&content=good&linkid=234234232&status=1
		logger.info("1020订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String phone = request.getParameter("mo_from");
			String linkid = request.getParameter("linkid");
			String message = request.getParameter("content");
			String spnumber = request.getParameter("mo_to");
			String statu = request.getParameter("status");
			if (phone != "" && phone != null && linkid != "" && linkid != null
					&& message != "" && message != null && spnumber != ""
					&& spnumber != null&&
							statu != ""
					&& statu != null) {
				if(statu.equals("1")){
					statu="DELIVRD";
				}
				SyncYlel syncYlel = new SyncYlel();
				syncYlel.setMoFrom(phone);
				syncYlel.setLinkid(linkid);
				syncYlel.setContent(message);
				syncYlel.setMoTo(spnumber);				
				syncYlel.setStatus(statu);
				//syncZjhy.setCpparam(message.substring(message.length() - 7));
				syncYlelService.insertSyncYlel(syncYlel);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("1020订单同步状态为：{}", status);
		return status;
	}
}
