package com.hytx.web.syncUniPay;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.unipay.UnipayState;
import com.hytx.service.unipay.IUnipayService;

@Controller
@RequestMapping("/sync")
public class UnionPaySyncController {
	private Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private IUnipayService unipayService;

	/***
	 * 银联订单同步接口
	 * 
	 * @param content
	 * @return
	 * @author houzz
	 * @date 2015年9月6日
	 */
	@RequestMapping(value = "unionPay", method = RequestMethod.POST)
	@ResponseBody
	public String orderSync(@RequestBody String content,
			HttpServletRequest request) {
		logger.info("银联订单同步信息开始，订单信息为：\n{}", content);
		String status = "failure";
		try {
			if (!StringUtils.isBlank(content)) {
				UnipayState unipayState = new UnipayState();
				unipayState.setOrderId(request.getParameter("orderId"));
				unipayState.setOrderTime(request.getParameter("orderTime"));
				unipayState.setRespCode(request.getParameter("respCode"));
				unipayState.setRespMsg(request.getParameter("respMsg"));
				unipayState.setTxnAmt(request.getParameter("orderAmt"));
				if (unipayState.getOrderId() != null) {
					unipayState.setCreateDt(new Date());
					unipayService.insertUnipayState(unipayState);
					status = "ok";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("银联订单同步状态为：{}", status);
		return status;
	}

}
