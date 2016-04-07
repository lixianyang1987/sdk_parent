package com.hytx.web.sync;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncMs;
import com.hytx.model.sync.SyncQsxx;
import com.hytx.model.sync.SyncQsxxExample;
import com.hytx.model.sync.SyncQsxxby;
import com.hytx.service.sync.ISyncMsService;
import com.hytx.service.sync.ISyncQsxxService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncMsController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncMsService syncMsService;

	/****
	 * 
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 * 
	 * 	 * 
	 * 
	 */
	@RequestMapping(value = "ms",method= RequestMethod.POST)
	@ResponseBody
	public String zjhySync(HttpServletRequest request,@ModelAttribute("sp_id") String spid,
			@ModelAttribute("mo_phone") String phone,
			@ModelAttribute("mo_code") String moCode,
			@ModelAttribute("mo_linkid") String linkid) {
		String status = "failure";
		StringBuilder sb = new StringBuilder();
		sb.append("sp_id=").append(spid)
		.append("&mo_phone=").append(phone)
		.append("&mo_code=").append(moCode)
		.append("&mo_linkid=").append(linkid);
		String moContent=sb.toString();
		logger.info("M3订单同步上行信息开始，订单信息为：\n{}",moContent );
		try {			
			if (!spid.equals("") && !phone.equals("")&&!linkid.equals("")&&!moCode.equals("")) {
				SyncMs syncMs = new SyncMs();
				syncMs.setSpId(spid);
				syncMs.setPhone(phone);
				syncMs.setMoCode(moCode);
				syncMs.setLinkid(linkid);
				syncMs.setCreatetime(new Date());
				syncMs.setMoContent(moContent);
				syncMsService.insertSyncMs(syncMs);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("M3订单同步上行状态为：{}", status);
		return status;
	}


	/****
	 * 全盛信息订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 */
	@RequestMapping(value = "msreq",method = RequestMethod.POST)
	@ResponseBody
	public String qsxxSync(HttpServletRequest request,@ModelAttribute("mr_phone") String phone,
			@ModelAttribute("mr_status") String statu,
			@ModelAttribute("mr_linkid") String linkid) {
		String status = "failure";
		StringBuilder sb = new StringBuilder();
		sb.append("mr_phone=").append(phone)
		.append("&mr_status=").append(statu)
		.append("&mr_linkid=").append(linkid);
		String msreq=sb.toString();
	
		logger.info("M3-M16结果同步信息开始，订单信息为：\n{}",msreq);
		try {
			
			if (!linkid.equals("") && !phone.equals("")&& !statu.equals("")) {
				SyncMs syncMs = new SyncMs();
				syncMs.setLinkid(linkid);
				syncMs.setPhone(phone);
				syncMs.setStatus(statu);
				syncMs.setMrContent(msreq);
				SyncMs qsxx= syncMsService.GetMs(linkid);
				if(qsxx==null){
					logger.info("M3-M16结果异常此LinkID无上行：{}", linkid);
					return status;
				}
				syncMs.setMoCode(qsxx.getMoCode());
				syncMsService.updateSyncMs(syncMs);
				if(syncMs.getReduceStatus()==0){					
					syncMs.setMoContent(qsxx.getMoContent());
					syncMs.setMrContent(msreq);				
					syncMsService.syncQsxxToMs(syncMs);;
				}
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("M3-M16结果同步状态为：{}", status);
		return status;
	}


}
