package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hytx.model.sync.SyncTykj;
import com.hytx.service.sync.ISyncTykjService;
@Controller
@RequestMapping("/sync")
public class SyncTykjController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncTykjService syncTykjService;

	/****
	 * 天翼空间订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "tykj")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("天翼空间订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String result = request.getParameter("result");
			String appid = request.getParameter("appid");
			String exdata = request.getParameter("exdata");
			String price = request.getParameter("price");
			String paytime =request.getParameter("paytime");
			String operator =request.getParameter("operator");
			String orderid =request.getParameter("orderid");
			
			if (result != "" && result != null && appid != "" && appid != null
					&& exdata != "" && exdata != null && price != ""
					&& price != null&&
							paytime != ""
					&& paytime != null) {
				
				SyncTykj syncTykj= new SyncTykj();
				syncTykj.setAppid(appid);
				syncTykj.setExdata(exdata);
				syncTykj.setOperator(operator);
				syncTykj.setOrderid(orderid);
				syncTykj.setResult(result);
				syncTykj.setPaytime(paytime);
				syncTykj.setPrice(price);
				
				
				syncTykjService.insertSyncTykj(syncTykj);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("天翼空间订单同步状态为：{}", status);
		return status;
	}
}
