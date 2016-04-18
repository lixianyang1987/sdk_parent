package com.hytx.web.sync;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.sync.CpOrderSync;
import com.hytx.model.sync.MobileSync;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.sync.IMobileSyncService;
import com.hytx.service.syncEx.DdoreqService;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.ISyncTyAllService;
import com.hytx.util.HttpClientUtil;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/syncdm")
public class MobileSyncController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");

	@Autowired
	private DdoreqService ddoReqService;
	@Autowired
	private ISyncTyAllService syncTyAllService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private ISyncByLogService syncByLogService;
	private ChannelApp channelApp;
	@Autowired
	private IChannelAppService channelAppService;

	// 移动动漫基地同步
		@RequestMapping(value = "yddmpjreq")
		@ResponseBody
		public String yddmpjreq(HttpServletRequest request) {
			String status = "计费点请求失败";
			try {
				logger.info("移动动漫基地请求计费点信息开始，订单信息为：\n{}",
						request.getQueryString());
		
				String imsi = request.getParameter("imsi") != null ? request
						.getParameter("imsi") : "";
				String feecode = request.getParameter("amount") != null ? request
						.getParameter("amount") : ""; // 业务代码				
				String cpparam = request.getParameter("channelId") != null ? request
						.getParameter("channelId") : "";
						String itemId="";
						switch (Integer.parseInt(feecode)) {
						case 10:
							itemId = "300007092001";
							break;
						case 300:
							itemId = "300007092002";
							break;
						case 500:
							itemId = "300007092003";
							break;
						case 600:
							itemId = "300007092004";
							break;
						case 800:
							itemId = "300007092005";
							break;
						case 1000:
							itemId = "300007092006";
							break;

						default:
							break;
						}
				StringBuilder sb = new StringBuilder();
				sb.append("http://cartoon.yiqiao580.com:9800/crack/cartoon/paysms.do?")
				.append("ptid=42001&itemSafeLevel=2&itemMethod=11&version=1.0.0&itemExt=")
				.append("&imsi=").append(imsi)
				.append("&itemId=").append(itemId)
				.append("&itemPrice=").append(feecode)
				.append("&cpparam=").append(cpparam);			
				String content = HttpClientUtil.simpleVisitUrl(sb.toString());
				if (content != null && !content.equals("error")) {
					JSONObject jsons = JSONObject.fromObject(content);
					if (jsons.getInt("result") == 0) {
						return content;
					}else{
						return "请求计费点失败";
					}
				}
			
			} catch (Exception e) {
				logger.info("移动动漫基地请求计费点-error：{}", e.getMessage());
				status = "1";
			}
			logger.info("移动动漫基地请求计费点状态为：{}", status);
			return status;
		}
	
	// 移动动漫基地同步
	@RequestMapping(value = "yddmpj")
	@ResponseBody
	public String yddmpjSync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("移动动漫基地-订单同步上行信息开始，订单信息为：\n{}",
					request.getQueryString());
			SyncTyAll tyall = new SyncTyAll();
			String tranid = request.getParameter("orderno") != null ? request
					.getParameter("orderno") : ""; // 计费流水号
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String imsi = request.getParameter("imsi") != null ? request
					.getParameter("imsi") : "";
			String feecode = request.getParameter("amount") != null ? request
					.getParameter("amount").toLowerCase() : ""; // 业务代码
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String cpparam = request.getParameter("cpparam") != null ? request
					.getParameter("cpparam") : "";
			if (statu.equals("0")) {
				statu = "DELIVRD";
			}
			
			int channelappId = Integer.parseInt(cpparam);
			tyall.setChannelAppId(channelappId); // 下游渠道包编号
			tyall.setPayFee(Integer.parseInt(feecode));
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setStatus(statu);
			tyall.setReserveTwo(imsi);
			channelApp = channelAppService.selectByPrimaryKey(channelappId);
			tyall.setMsg(channelApp.getAppId()+"");
			tyall.setAppId(channelApp.getAppId()+"");
			tyall.setPort("1065842230");
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("移动动漫基地-订单同步-error：{}", e.getMessage());
			status = "1";
		}
		logger.info("移动动漫基地-订单同步状态为：{}", status);
		return status;
	}
}
