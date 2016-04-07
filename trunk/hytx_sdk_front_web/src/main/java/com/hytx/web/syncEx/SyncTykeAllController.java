package com.hytx.web.syncEx;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.sync.Keadm;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.syncEx.DdoreqService;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.ISyncTyAllService;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.MD5;
@Controller
@RequestMapping("/syncke")
public class SyncTykeAllController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	
	@Autowired
	private DdoreqService ddoReqService;
	@Autowired
	private ISyncTyAllService syncTyAllService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private ISyncByLogService syncByLogService;

	// 克总爱游戏请求 计费指令 和端口 接口
	//
	@RequestMapping(value = "kedxayxreq", method = RequestMethod.POST)
	@ResponseBody
	public String kedxayxreq(HttpServletRequest request, Keadm keadm) {
		// 渠道id +计费金额+客户端ip +扩展字段+游戏名称（urlencode）+计费点名称（urlencode）+key

		String status = "failure";
		String result = "No results returned";
		try {
			logger.info("明威爱游戏请求 ：{}", keadm.toString());
			keadm.setChannelId("1262");
			String key = "8GHLk444";
			keadm.setGameName(URLEncoder.encode(keadm.getGameName(), "UTF-8"));
			keadm.setChargeName(URLEncoder.encode(keadm.getChargeName(), "UTF-8"));
			StringBuilder sb = new StringBuilder();
			sb.append(keadm.getChannelId()).append(keadm.getFee())
					.append(keadm.getIp()).append(keadm.getExtra())
					.append(keadm.getGameName())
					.append(keadm.getChargeName())
					.append(key);
			keadm.setMac(MD5.getMD5(sb.toString()).toUpperCase());

			String uri = "http://121.41.58.237:8981/center/getCommand.sys";
			NameValuePair[] nameValuePairs = new NameValuePair[] {
					new NameValuePair("fee",keadm.getFee()+""),
					new NameValuePair("channelId",keadm.getChannelId()),
					new NameValuePair("extra",keadm.getExtra()),
					new NameValuePair("iccid",keadm.getIccid()),
					new NameValuePair("chargeName",keadm.getChargeName()),
					new NameValuePair("mac", keadm.getMac()),
					new NameValuePair("gameName",keadm.getGameName()),
					new NameValuePair("ip",keadm.getIp()),
					new NameValuePair("imsi",keadm.getImsi()) };
			result = HttpClientUtil.postData(uri, nameValuePairs);					
			status = "OK";

			logger.info("明威爱游戏请求 ：{}", status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 克总电信爱游戏

	// 克总电信爱游戏，数据同步接口
	@RequestMapping(value = "kedxayxsync", method = RequestMethod.POST)
	@ResponseBody
	public String kedxayx(HttpServletRequest request ,@RequestBody String smsReq) {

		String status = "failure";
		logger.info("明威电信爱游戏接收，订单信息为：{}", smsReq);
		SyncTyAll tyall = new SyncTyAll();
		try {
			String linkid = request.getParameter("linkId") != null ? request
					.getParameter("linkId") : "";
			String feeflag = request.getParameter("msg") != null ? request
					.getParameter("msg") : "";
			String port = request.getParameter("longCode") != null ? request
					.getParameter("longCode") : "";
			String mobileid = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String fee = request.getParameter("fee") != null ? request
					.getParameter("fee") : "";
			String extra = request.getParameter("extra") != null ? request
					.getParameter("extra") : "";
			Dict dict = dictService.selectActiviteDictByKey("keaiyx_"
					+ extra.substring(0, 2));
			
			String str = dict.getVal();
			int channelappId = Integer.parseInt(str);
			tyall.setChannelAppId(channelappId);
			tyall.setPayFee(Integer.parseInt(fee) * 100);
			tyall.setAppId("940");
			tyall.setMobile(mobileid);
			if (statu.trim().equals("00")) {
				statu = "DELIVRD";
			}
			tyall.setStatus(statu);
			tyall.setLinkid(linkid);
			tyall.setMsg(feeflag);
			tyall.setPort(port);
			tyall.setReserveTwo(extra);
			syncTyAllService.addTyAll(tyall);
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "success";
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("明威电信爱游戏同步状态为：{}", e.getMessage());
		}
		logger.info("明威电信爱游戏同步状态为：{}", status);
		return status;
	}

}
