package com.hytx.web.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.OrderSync;
import com.hytx.service.sync.IOrderSyncService;
import com.hytx.util.JaxbUtil;
import com.hytx.xml.SyncAppOrderResp;

@Controller
@RequestMapping("/sync")
public class OrderSyncController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private IOrderSyncService orderSyncService;

	@RequestMapping(value = "orderSync", method = RequestMethod.POST, produces = "application/xml")
	@ResponseBody
	public Object orderSync(@RequestBody OrderSync orderSync) {
		SyncAppOrderResp orderResp = new SyncAppOrderResp();
		logger.info("订单同步信息开始，订单信息为：\n{}", JaxbUtil.convertToXml(orderSync));
		try {
			orderResp.setTransactionID(orderSync.getTransactionId());
			orderSyncService.insert(orderSync);
			orderResp.sethRet("success");
		} catch (Exception e) {
			e.printStackTrace();
			orderResp.sethRet("failure");
		}
		logger.info("订单同步状态为：{}-->{}", orderResp.getTransactionID(),
				orderResp.gethRet());
		return orderResp;
	}

}
