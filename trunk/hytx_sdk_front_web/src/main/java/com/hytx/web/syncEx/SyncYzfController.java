package com.hytx.web.syncEx;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.syncEx.SyncYzf;
import com.hytx.service.syncEx.ISyncYzfService;

@Controller
@RequestMapping("/sync")
public class SyncYzfController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncYzfService syncYzfService;
	

	/**** 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 *  
	 */
	@RequestMapping(value = "yzf")
	@ResponseBody
	public String zqrdSync(HttpServletRequest request) {
		String status = "failure";
		String moContent = request.getQueryString();
		logger.info("  翼支付订单同步信息开始，订单信息为：\n{}", moContent);
		try {	
		String orderid=	request.getParameter("order_id");
		String fee=	request.getParameter("fee");
		String ext=	request.getParameter("ext");
		String time=	request.getParameter("time");
		String mobile=	request.getParameter("mobile");
		SyncYzf yzf = new SyncYzf();
		yzf.setCreatetime(new Date());
		yzf.setOrderId(orderid);
		yzf.setFee(fee);
		yzf.setExt(ext);
		yzf.setTime(time);
		yzf.setMobile(mobile);
		syncYzfService.addYzf(yzf);	
		if(yzf.getReduceStatus()==0){
			syncYzfService.syncToYzf(yzf);
		}		
		status="ok";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("翼支付订单同步上行状态为：{}", status);
		return status;
	}
	@RequestMapping(value = "syncallyzf")
	@ResponseBody
	public String DxltSyncall(HttpServletRequest request) {
		syncYzfService.yzfallSync();
		return "ok";
	}
	

	/**** 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 *  
	 */
	@RequestMapping(value = "mdo")
	@ResponseBody
	public String mdoSync(HttpServletRequest request) {
		String status = "failure";
		String moContent = request.getQueryString();
		logger.info("  MDO订单同步信息开始，订单信息为：\n{}", moContent);
		try {	
		String orderid=	request.getParameter("order_id");
		String fee=	request.getParameter("fee");
		String spnumber=	request.getParameter("spnumber");
		String time=	request.getParameter("time");
		String mobile=	request.getParameter("mobile");
		String msg=	request.getParameter("msg");
		SyncYzf yzf = new SyncYzf();
		yzf.setCreatetime(new Date());
		yzf.setOrderId(orderid);
		yzf.setFee(fee);
		yzf.setMsg(msg);
		yzf.setTime(time);
		yzf.setMobile(mobile);
		yzf.setSpnumber(spnumber);
		syncYzfService.addMdo(yzf);	
		if(yzf.getReduceStatus()==0){
			syncYzfService.syncToMdo(yzf);
		}		
		status="ok";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("MDO订单同步上行状态为：{}", status);
		return status;
	}



}
