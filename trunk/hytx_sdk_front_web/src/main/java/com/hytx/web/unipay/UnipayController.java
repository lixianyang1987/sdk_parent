package com.hytx.web.unipay;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.unipay.UnipayBill;
import com.hytx.service.unipay.IUnipayService;

@Controller
@RequestMapping("/unipay")
public class UnipayController {
	@Autowired
	private IUnipayService unipayService;

	@RequestMapping(value = "unipayBill")
	@ResponseBody
	public boolean saveUnipayBill(UnipayBill unipayBill) {
		try {
			unipayBill.setCreateDt(new Date());
			System.out.println("生成银联订单:" + unipayBill.toString());
			unipayService.insertUnipayBill(unipayBill);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@RequestMapping(value = "checkUserOrder")
	@ResponseBody
	public boolean checkUserOrder(@RequestParam("imsi") String imsi) {
		return unipayService.countUserUnipayOrder(imsi) > 0;
	}

}
