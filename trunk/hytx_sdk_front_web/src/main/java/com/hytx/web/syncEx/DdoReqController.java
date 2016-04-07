package com.hytx.web.syncEx;

import java.io.BufferedReader;

import java.io.InputStreamReader;


import java.util.Date;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncDdo;
import com.hytx.service.syncEx.DdoreqService;

@Controller
@RequestMapping("/sync")
public class DdoReqController {
	@Autowired
	private DdoreqService ddoReqService;

	@RequestMapping(value = "/ddoreq")
	@ResponseBody
	public String ddoreq(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		try {
			InputStreamReader isr = new InputStreamReader(
					request.getInputStream());
			BufferedReader b = new BufferedReader(isr, 1024 * 1024);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = b.readLine()) != null) {
				sb.append(line);
			}
			line = sb.toString();
			JSONObject jsonObject = JSONObject.fromObject(line);

			String tradeId = jsonObject.getString("tradeId") != null ? jsonObject
					.getString("tradeId") : "";
			String subsid = jsonObject.getString("subsId") != null ? jsonObject
					.getString("subsId") : "";
			String appId = jsonObject.getString("appId") != null ? jsonObject
					.getString("appId") : "";

			String cost = jsonObject.getString("cost") != null ? jsonObject
					.getString("cost") : "";
			String exData = jsonObject.getString("exData") != null ? jsonObject
					.getString("exData") : "";
			String statu = jsonObject.getString("status") != null ? jsonObject
					.getString("status") : "";
			String chargeTime = jsonObject.getString("chargeTime") != null ? jsonObject
					.getString("chargeTime") : "";

			if (tradeId != "" && appId != "" && cost != "" && exData != ""
					&& statu != "") {
				try {
					
					SyncDdo ddoreq = new SyncDdo();
					ddoreq.setLinkid(exData);
					ddoreq.setPayCode(ddoreq.getPaycoeds().get(cost));
					ddoreq.setUuid(tradeId);
					ddoreq.setMotime(chargeTime);
					ddoreq.setStat(statu);
					ddoreq.setTelno(subsid);
					ddoreq.setCreatetime(new Date());
					int i = ddoReqService.addDdoreq(ddoreq);
					if (i == -1) {
						return "-1";
					}
					if(ddoreq.getSyncStatus().equals(0)){
						ddoReqService.syncToDdoreq(ddoreq);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "{\"resultCode\":\"0\"}";

	}
	
	
	
}