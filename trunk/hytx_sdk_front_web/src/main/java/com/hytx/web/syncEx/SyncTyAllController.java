package com.hytx.web.syncEx;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByLogExample;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.syncEx.DdoreqService;
import com.hytx.service.syncEx.ISyncByLogService;
import com.hytx.service.syncEx.ISyncTyAllService;

@Controller
@RequestMapping("/sync")
public class SyncTyAllController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");

	@Autowired
	private DdoreqService ddoReqService;
	@Autowired
	private ISyncTyAllService syncTyAllService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private ISyncByLogService syncByLogService;
	@Autowired
	private IChannelAppService channelAppService;



	// 联通短信
	@RequestMapping(value = "ycxesync")
	@ResponseBody
	public String ycxesync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("悦晨小额订单同步上行信息开始，订单信息为：\n{}", request.getQueryString()
					.trim());
			SyncTyAll tyall = new SyncTyAll();
			String linkid = request.getParameter("linkid") != null ? request
					.getParameter("linkid") : ""; // 计费流水号
			String msg = request.getParameter("msg") != null ? request
					.getParameter("msg") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			// 0 为计费金额 1 为 渠道包2为appid
				Dict dict=	dictService.selectActiviteDictByKey(""+msg);
			String str[] =dict.getVal().split("_");
				int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid("ycxe"+linkid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setMsg(msg);
			tyall.setStatus(statu);
			// 订购
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("悦晨小额-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("悦晨小额订单同步上行状态为：{}", status);
		return status;
	}



	/**
	 * 用于给下游渠道补发数据
	 */
	@RequestMapping(value = "syncall")
	@ResponseBody
	public String Syncall(HttpServletRequest request) {
		syncTyAllService.SyncAll();
		return "ok";
	}

	/**
	 * 用于同步流水数据
	 */
	@RequestMapping(value = "synclogs")
	@ResponseBody
	public String SyncLogs(HttpServletRequest request) {
		syncByLogService.TimerSync();
		return "ok";
	}

	/**
	 * 用于给下游渠道补发数据
	 */
	@RequestMapping(value = "synclogsall")
	@ResponseBody
	public String SyncLogsall(HttpServletRequest request) {
		syncByLogService.SyncAll();
		return "ok";
	}

}
