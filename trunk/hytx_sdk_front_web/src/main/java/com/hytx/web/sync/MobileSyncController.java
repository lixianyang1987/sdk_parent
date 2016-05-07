package com.hytx.web.sync;

import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.sync.YgdmDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.syncEx.DdoreqService;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.ISyncTyAllService;
import com.hytx.util.HttpClientUtil;

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
			logger.info("移动动漫基地请求计费点信息开始，订单信息为：\n{}", request.getQueryString());

			String imsi = request.getParameter("imsi") != null ? request
					.getParameter("imsi") : "";
			String feecode = request.getParameter("amount") != null ? request
					.getParameter("amount") : ""; // 业务代码
			String cpparam = request.getParameter("channelId") != null ? request
					.getParameter("channelId") : "";
			String itemId = "";
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
			sb.append(
					"http://cartoon.yiqiao580.com:9800/crack/cartoon/paysms.do?")
					.append("ptid=42001&itemSafeLevel=2&itemMethod=11&version=1.0.0&itemExt=")
					.append("&imsi=").append(imsi).append("&itemId=")
					.append(itemId).append("&itemPrice=").append(feecode)
					.append("&cpparam=").append(cpparam);
			String content = HttpClientUtil.simpleVisitUrl(sb.toString());
			if (content != null && !content.equals("error")) {
				JSONObject jsons = JSONObject.fromObject(content);
				if (jsons.getInt("result") == 0) {
					return content;
				} else {
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
			String tranid = request.getParameter("linkId") != null ? request
					.getParameter("linkId") : ""; // 计费流水号
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String monum = request.getParameter("monum") != null ? request
					.getParameter("monum") : "";
			String sid = request.getParameter("sid") != null ? request
					.getParameter("sid") : "";
			String imsi = request.getParameter("imsi") != null ? request
					.getParameter("imsi") : "";

			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String cpparam = request.getParameter("cpparam") != null ? request
					.getParameter("cpparam") : "";
			if (statu.equals("0")) {
				statu = "DELIVRD";
			}
			Dict dict = dictService.selectDictByKey(sid);
			String[] str = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道包编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setStatus(statu);
			tyall.setErrorContent(imsi);
			channelApp = channelAppService.selectByPrimaryKey(channelappId);
			tyall.setMsg(sid);
			tyall.setAppId(channelApp.getAppId() + "");
			tyall.setPort(monum);
			tyall.setOrderid(cpparam);
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

	// 移动动漫基地同步
	@RequestMapping(value = "ygdm",method =RequestMethod.POST)
	@ResponseBody
	public String ygdmSync(HttpServletRequest request,@RequestBody String ygdm ) {
		String status = "failure";
		try {
			
			logger.info("移动动漫基地-订单同步上行信息开始，订单信息为：\n{}",
					ygdm);
			JAXBContext context = JAXBContext.newInstance(YgdmDto.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            YgdmDto ygdmdto = (YgdmDto)unmarshaller.unmarshal(new StringReader(ygdm)); 
            
            
            SyncTyAll tyall = new SyncTyAll();
            String statu ="DELIVRD";
            if (!ygdmdto.getStatus().equals("0")) {
				statu = ygdmdto.getStatus();
			}
			Dict dict = dictService.selectDictByKey(ygdmdto.getSid());
			String[] str = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道包编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid(ygdmdto.getTrans_id());
			tyall.setMobile(ygdmdto.getPhone_number());
			
			tyall.setStatus(statu);
			tyall.setErrorContent(ygdmdto.getImsi());
			channelApp = channelAppService.selectByPrimaryKey(channelappId);
			tyall.setMsg(ygdmdto.getItem_id());
			tyall.setAppId(channelApp.getAppId() + "");
			tyall.setPort("1065842230");
			tyall.setOrderid(ygdmdto.getCpparam());
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
