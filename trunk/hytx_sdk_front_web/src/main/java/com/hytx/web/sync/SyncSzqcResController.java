package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hytx.model.sync.SyncSzqcSms;
import com.hytx.service.sync.ISyncSzqcResService;
@Controller
@RequestMapping("/sync")
public class SyncSzqcResController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSzqcResService syncSzqcResService;

	/****
	 * 深圳启程短信内容返回接口 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "szqcres")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String err = "failure";
		logger.info("深圳启程短信内容返回接口开始，订单信息为：\n{}", request.getQueryString());
		try {
			String tradeid = request.getParameter("tradeid");
			String status = request.getParameter("status");
			
			if (tradeid != "" && tradeid != null && status != "" && status != null
					) {
				SyncSzqcSms s= new SyncSzqcSms();
				s.setStatus(Integer.parseInt(status));
				s.setTradeid(tradeid);
			err=	syncSzqcResService.syncSzqcRes(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			err = "failure";
		}
		logger.info("深圳启程订单同步状态为：{}", err);
		return err;
	}
}
