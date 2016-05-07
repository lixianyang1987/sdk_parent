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

	// 电信包月短信流水
	@RequestMapping(value = "dxbysms")
	@ResponseBody
	public String bysmsSync(HttpServletRequest request) {
		String status = "1";
		String reqStr = request.getQueryString().trim();
		try {
			logger.info("电信包月短信流水-订单同步上行信息开始，订单信息为：\n{}", reqStr);
			SyncByLog byLog = new SyncByLog();
			String tranid = request.getParameter("stream_no") != null ? request
					.getParameter("stream_no") : ""; // 计费流水号
			String productId = request.getParameter("productId") != null ? request
					.getParameter("productId") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String feecode = request.getParameter("order") != null ? request
					.getParameter("order").trim().toLowerCase() : ""; // 订购指令
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String paytime = request.getParameter("pay_time") != null ? request
					.getParameter("pay_time") : "";
			String province = request.getParameter("province") != null ? request
					.getParameter("province") : "";

			logger.info("电信包月短信流水-订单同步上行信息，订单时间为：\n{}", paytime);
			logger.info("电信包月短信流水-订单同步上行信息，订单省份为：\n{}", province);
			byLog.setProvince(province);
			byLog.setLinkid(tranid);
			byLog.setMobile(mobile);
			byLog.setStatus(statu);
			byLog.setPort(lnum);
			byLog.setMsg(feecode);
			byLog.setReserveOne(reqStr);
			byLog.setReserveTwo(productId);
			byLog.setOrderid(paytime);
			// 将同步信息写入流水表
			String zl = "";
			if (statu.equals("3")) {
				switch (feecode) {
				case "td1":
					zl = "kxyy";
					break;
				case "td2":
					zl = "hlyy";
					break;
				case "td3":
					zl = "dzys";
					break;
				case "td4":
					zl = "pmdy";
					break;
				case "td5":
					zl = "fc";
					break;
				case "td6":
					zl = "zx";
					break;
				case "td7":
					zl = "yltd";
					break;
				}
			} else if (statu.equals("0")) {
				zl = feecode;
			}
			Dict dict = dictService.selectActiviteDictByKey("dxby_" + zl);
			// 0 为计费金额 1 为 渠道包2为appid
			String[] str = dict.getVal().split("_");

			byLog.setPayFee(Integer.parseInt(str[0]));
			byLog.setChannelAppId(Integer.parseInt(str[1]));
			syncByLogService.addByLog(byLog, zl);
			if (byLog.getReduceStatus() != 1) {
				syncByLogService.syncToByLog(byLog);
			}
			status = "0";
			return status;

		} catch (Exception e) {
			logger.info("电信包月短信流水-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("电信包月短信流水-订单同步上行状态为：{}", status);
		return status;
	}

	// 电信包月短信
	@RequestMapping(value = "dxbyjfsms")
	@ResponseBody
	public String zxjmbysmsSync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("电信包月短信-订单同步上行信息开始，订单信息为：\n{}", request
					.getQueryString().trim());
			SyncTyAll tyall = new SyncTyAll();
			String tranid = request.getParameter("stream_no") != null ? request
					.getParameter("stream_no") : ""; // 计费流水号
			String productId = request.getParameter("productId") != null ? request
					.getParameter("productId") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String feecode = request.getParameter("order") != null ? request
					.getParameter("order").trim().toLowerCase() : ""; // 订购指令
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String reduceStatus = request.getParameter("reduceStatus") != null ? request
					.getParameter("reduceStatus") : "";
			String paytime = request.getParameter("pay_time") != null ? request
					.getParameter("pay_time") : "";
			String province = request.getParameter("province") != null ? request
					.getParameter("province") : "";

			Dict dict = dictService.selectActiviteDictByKey("dxby_" + feecode);
			// 0 为计费金额 1 为 渠道包2为appid
			String[] str = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setReduceStatus(Integer.parseInt(reduceStatus));
			tyall.setMsg(feecode);
			tyall.setReserveTwo(productId);
			tyall.setProvince(province);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			tyall.setCreatetime(sdf.parse(paytime));
			if (statu.equals("0")) {
				statu = "DELIVRD";
			}
			tyall.setStatus(statu);
			// 订购
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("电信包月短信-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("电信包月短信-订单同步上行状态为：{}", status);
		return status;
	}

	// 电信MOMR
	@RequestMapping(value = "dxdbsync")
	@ResponseBody
	public String dxmomrSync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("电信点播-订单同步上行信息开始，订单信息为：\n{}", request.getQueryString());

			SyncTyAll tyall = new SyncTyAll();

			String tranid = request.getParameter("linkid") != null ? request
					.getParameter("linkid") : ""; // 计费流水号
			String msg = request.getParameter("momsg") != null ? request
					.getParameter("momsg") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String product_id = request.getParameter("product_id") != null ? request
					.getParameter("product_id").toLowerCase() : ""; // 业务代码
			String feecode = request.getParameter("feecode") != null ? request
					.getParameter("feecode").toLowerCase() : ""; // 业务代码
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			String province = request.getParameter("province") != null ? request
					.getParameter("province") : "";
			if (statu.equals("DELIVERED_TO_TERMINAL")) {
				statu = "DELIVRD";
			}
			// 判断上量代码是否模糊
			String strmsg = "";
			if (msg.indexOf("_") > -1) {
				String[] strs = msg.split("_");
				strmsg = strs[0];
			} else {
				strmsg = msg;
			}

			// 获取字典配置参数
			Dict dict = dictService.selectActiviteDictByKey("dxdb_" + strmsg);

			// 0 为 渠道包1 为 appid
			String[] str = dict.getVal().split("_");

			int channelappId = Integer.parseInt(str[0]);
			tyall.setChannelAppId(channelappId); // 下游渠道包编号
			tyall.setPayFee(Integer.parseInt(feecode));
			tyall.setAppId(str[1]);
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setMsg(msg);
			tyall.setStatus(statu);
			tyall.setReserveTwo(product_id);// 产品编号
			tyall.setProvince(province);
			syncTyAllService.addTyAll(tyall);

			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "0";
		} catch (Exception e) {
			logger.info("电信MO-error：{}", e.getMessage());
			status = "1";
		}
		logger.info("电信点播-订单同步上行状态为：{}", status);
		return status;
	}

	// 联通短信
	@RequestMapping(value = "ltsync")
	@ResponseBody
	public String wojiasync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("联通计费订单同步上行信息开始，订单信息为：\n{}", request.getQueryString()
					.trim());
			SyncTyAll tyall = new SyncTyAll();
			String tranid = request.getParameter("tradeid") != null ? request
					.getParameter("tradeid") : ""; // 计费流水号
			String args = request.getParameter("args") != null ? request
					.getParameter("args") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String fee = request.getParameter("fee") != null ? request
					.getParameter("fee").trim().toLowerCase() : ""; // 订购指令
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String time = request.getParameter("time") != null ? request
					.getParameter("time") : "";
			// 0 为计费金额 1 为 渠道包2为appid
			ChannelAppExample example = new ChannelAppExample();
			example.createCriteria().andKeyEqualTo(args);
			ChannelApp ca = channelAppService.selectChannelAppId(example);
			int channelappId = ca.getId();
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(fee));
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setMsg(args);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			tyall.setCreatetime(sdf.parse(time));

			tyall.setStatus("DELIVRD");
			// 订购
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("联通计费-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("联通计费订单同步上行状态为：{}", status);
		return status;
	}

	// 咪咕视频短信
	@RequestMapping(value = "mgspsync")
	@ResponseBody
	public String mgspsync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("咪咕视频订单同步信息开始，订单信息为：\n{}", request.getQueryString()
					.trim());
			SyncTyAll tyall = new SyncTyAll();
			String tranid = request.getParameter("linkid") != null ? request
					.getParameter("linkid") : ""; // 计费流水号
			String args = request.getParameter("msg") != null ? request
					.getParameter("msg") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String statu = request.getParameter("status") != null ? request
					.getParameter("status").trim().toLowerCase() : ""; // 订购指令
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号

			// 0 为计费金额 1 为 渠道包2为appid
			Dict dict = dictService.selectActiviteDictByKey("mgsp_" + args);
			int channelappId = Integer.parseInt(dict.getVal());
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(1000);
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setMsg(args);
			tyall.setCreatetime(new Date());
			tyall.setStatus(statu);
			// 订购
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("咪咕视频订单同步-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("咪咕视频订单同步状态为：{}", status);
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
