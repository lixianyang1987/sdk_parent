package com.hytx.web.syncEx;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.dto.sync.HzdsDdoDto;
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
import com.hytx.util.HttpClientUtil;

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

	// 悦晨小额短信
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

			String msgs = "";
			if (msg.startsWith("080#KJ")) {
				msgs = msg.substring(0, 7);
			} else {
				msgs = msg.substring(0, 10);
			}
			Dict dict = dictService.selectActiviteDictByKey("ycxe_" + msgs);
			String str[] = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid("ycxe_" + linkid);
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

	/****
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 * 
	 *       *
	 * 
	 */
	@RequestMapping(value = "lad")
	@ResponseBody
	public String ladSync(HttpServletRequest request, SyncTyAll tyall) {
		String status = "failure";
		String moContent = request.getQueryString();
		logger.info("上海鑫竿订单同步上行信息开始，订单信息为：\n{}", moContent);
		try {
			String linkid = request.getParameter("linkid") != null ? request
					.getParameter("linkid") : ""; // 计费流水号
			String key = tyall.getMsg().substring(0, 4);
			Dict dict = dictService.selectActiviteDictByKey("shxg_" + key);
			int channelappId = Integer.parseInt(dict.getVal());
			tyall.setChannelAppId(channelappId);
			tyall.setPayFee(100);
			tyall.setLinkid(linkid);
			syncTyAllService.addTyAll(tyall);
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "OK";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("上海鑫竿订单同步上行状态为：{}", status);
		return status;
	}

	// 杭州东硕WO+ 请求
	//
	@RequestMapping(value = "wojiareq")
	@ResponseBody
	public String hzdsworeq(HttpServletRequest request, HzdsDdoDto hzdsDdodto,
			@RequestBody String smsReq) {

		String status = "failure";
		String result = "No results returned";
		String mobile = request.getParameter("mobile") != null ? request
				.getParameter("mobile") : ""; // 上行内容
		String chargeCode = request.getParameter("chargeCode") != null ? request
				.getParameter("chargeCode") : "";
		if (mobile.equals("")) {
			hzdsDdodto.setMobile(mobile);
			hzdsDdodto.setChargeCode(chargeCode);
		}
		logger.info("杭州东硕WO+接收：{}", smsReq);
		if (mobile == null || mobile.equals("")) {
			JSONObject jsonObject = JSONObject.fromObject(smsReq);
			hzdsDdodto.setMobile(jsonObject.getString("mobile"));
			hzdsDdodto.setChargeCode(jsonObject.getString("chargeCode"));
		}
		hzdsDdodto.setTransmissionData(hzdsDdodto.getMobile() + "_"
				+ hzdsDdodto.getChargeCode());
		hzdsDdodto.setCallbackUrl("http://123.206.52.71/sync/wojiasync");
		try {
			result = HttpClientUtil.postJsonData(
					"http://api.jiebasdk.com/SmsPayCuccYbk/pay", JSONObject
							.fromObject(hzdsDdodto).toString());
			status = "OK";
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		logger.info("杭州东硕WO+确认计费状态为：{}", status);

		return result;
	}

	// 杭州东硕WO+ 同步
	//
	@RequestMapping(value = "wojiasync", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String hzdswosync(HttpServletRequest request,
			@RequestBody String smsReq) {

		String status = "failure";
		String result = "No results returned";
		logger.info("杭州东硕WO+同步接收：{}", smsReq);
		SyncTyAll tyall = new SyncTyAll();
		try {
			JSONObject jsonObject = JSONObject.fromObject(smsReq);
			String msg = jsonObject.getString("msg") != null ? jsonObject
					.getString("msg") : "";
			String code = jsonObject.getString("code") != null ? jsonObject
					.getString("code") : "";
			String orderId = jsonObject.getString("orderId") != null ? jsonObject
					.getString("orderId") : "";
			String transmissionData = jsonObject.getString("transmissionData") != null ? jsonObject
					.getString("transmissionData") : "";
			String[] str = transmissionData.split("_");
			Dict dict = dictService.selectActiviteDictByKey("dswo_" + str[1]);
			String[] dicts = dict.getVal().split("_");
			int channelappId = Integer.parseInt(dicts[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setAppId("967"); // 上游的应用id
			tyall.setMobile(str[0]);
			tyall.setMsg(str[1]);
			tyall.setPort("1001011");
			tyall.setErrorContent(msg);
			if (code.equals("0")) {
				code = "DELIVRD";
			}
			tyall.setStatus(code);
			tyall.setPayFee(Integer.parseInt(dicts[0]));
			tyall.setLinkid(orderId);
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "OK";
			result = "OK";
		} catch (Exception e) {

			e.printStackTrace();
		}

		logger.info("杭州东硕WO+同步计费状态为：{}", status);

		return result;
	}

	// 天翼阅读
	@RequestMapping(value = "tyydsync")
	@ResponseBody
	public String tyydsync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("朝晖订单同步上行信息开始，订单信息为：\n{}", request.getQueryString()
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

			Dict dict = dictService.selectActiviteDictByKey("tyyd_"
					+ URLDecoder.decode(msg, "utf-8"));
			String str[] = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid("tyyd_" + linkid);
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
			logger.info("朝晖-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("朝晖订单同步上行状态为：{}", status);
		return status;
	}

	// 天翼空间
	@RequestMapping(value = "tykjsync")
	@ResponseBody
	public String tykjsync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("朝晖天翼空间订单同步上行信息开始，订单信息为：\n{}", request.getQueryString()
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

			Dict dict = dictService.selectActiviteDictByKey("tykj_"
					+msg.substring(0,6));
		
			String port="11803080";
			if(msg.startsWith("ZZW6Y")){
				 port="1065842230";
			}
			String str[] = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setLinkid("tykj_" + linkid);
			tyall.setMobile(mobile);
			tyall.setPort(port);
			tyall.setMsg(lnum);
			tyall.setStatus(statu);
			tyall.setReserveTwo(msg);
			// 订购
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "ok";
		} catch (Exception e) {
			logger.info("朝晖天翼空间-error：{}", e.getMessage());
			status = "failure";
		}
		logger.info("朝晖天翼空间订单同步上行状态为：{}", status);
		return status;
	}

	// 移动包月
	@RequestMapping(value = "ydbysync")
	@ResponseBody
	public String ydbysync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("移动包月订单同步上行信息开始，订单信息为：\n{}", request.getQueryString()
					.trim());
			// 端口号: spnumber 必须
			// 手机号码: mobile 必须
			// linkid : linkid 必须
			// 上行内容: msg 必须
			// 状态: status 必须 DELIVRD表示成功，其它失败`
			// 状态: SmsType 必须 Y表示订购，U表示退订`
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

			Dict dict = dictService.selectActiviteDictByKey("ydby_" + msg);
			String str = dict.getVal();
			int channelappId = Integer.parseInt(str);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(300);
			tyall.setLinkid("ydby_" + linkid);
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
			logger.info("移动包月-error：{}", e.getMessage());
			status = "failure";
		}

		logger.info("移动包月订单同步上行状态为：{}", status);
		return status;
	}



	// 3.订单数据同步接口
	@RequestMapping(value = "zhwlpc")
	@ResponseBody
	public String zhwlpcfee(HttpServletRequest request) {

		String status = "failure";
		logger.info("朝晖网络PC-3.订单接收，订单信息为：{}", request.getQueryString());
		SyncTyAll tyall = new SyncTyAll();
		try {
			String linkid = request.getParameter("linkid") != null ? request
					.getParameter("linkid") : "";
			String feeflag = request.getParameter("msg") != null ? request
					.getParameter("msg") : "";
			String port = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : "";
			String mobileid = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";
			Dict dict = dictService.selectActiviteDictByKey(feeflag);
			String str = dict.getVal();
			String[] fee = str.split("_");
			int channelappId = Integer.parseInt(fee[1]);
			tyall.setChannelAppId(channelappId);
			tyall.setPayFee(Integer.parseInt(fee[0]));
			tyall.setMobile(mobileid);
			tyall.setStatus(statu);
			tyall.setLinkid(linkid);
			tyall.setMsg(feeflag);
			tyall.setPort(port);
			syncTyAllService.addTyAll(tyall);
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "OK";
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("ERROR朝晖网络PC订单同步状态为：{}", e.getMessage());
		}
		logger.info("朝晖网络PC订单同步状态为：{}", status);
		return status;
	}

	/**
	 * 快游小额
	 * */
	@RequestMapping(value = "kyxe")
	@ResponseBody
	public String kyxesync(HttpServletRequest request) {
		String status = "no";
		logger.info("快游小额订单接收，订单信息为：{}", request.getQueryString());
		SyncTyAll tyall = new SyncTyAll();
		try {

			String linkid = request.getParameter("linkid") != null ? request
					.getParameter("linkid") : "";
			String feeflag = request.getParameter("msg") != null ? request
					.getParameter("msg") : "";
			String port = request.getParameter("addr") != null ? request
					.getParameter("addr") : "";
			String mobileid = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";

			String stra = feeflag.substring(0, 7);

			Dict dict = dictService.selectActiviteDictByKey(stra);
			String[] str = dict.getVal().split("_");
			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId);
			tyall.setPayFee(Integer.parseInt(str[0]));
			tyall.setMobile(mobileid);
			tyall.setStatus(statu);
			tyall.setLinkid(linkid);
			tyall.setMsg(feeflag);
			tyall.setPort(port);
			syncTyAllService.addTyAll(tyall);

			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}

			status = "ok";
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("ERROR_快游小额订单同步状态为：{}", e.getMessage());
		}
		logger.info("快游小额订单同步状态为：{}", status);
		return status;
	}

	// 互动时空 IVR订单同步
	@RequestMapping(value = "hdskivr")
	@ResponseBody
	public String hdskivrSync(HttpServletRequest request) {
		String status = "failure";

		SyncTyAll tyall = new SyncTyAll();
		try {

			String phone = request.getParameter("phone") != null ? request
					.getParameter("phone") : "";
			String spnumber = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : "";
			String num = request.getParameter("num") != null ? request
					.getParameter("num") : "";
			String fee = request.getParameter("fee") != null ? request
					.getParameter("fee") : "";
			String times = request.getParameter("times") != null ? request
					.getParameter("times") : "";
			StringBuilder sb = new StringBuilder();
			sb.append("phone=").append(phone).append("spnumber=")
					.append(spnumber).append("num=").append(num).append("fee=")
					.append(fee).append("times=").append(times);
			logger.info("互动时空 IVR订单接收，订单信息为：\n{}", sb.toString());
			Dict dict = dictService.selectActiviteDictByKey("hdskivr");
			int channelappId = Integer.parseInt(dict.getVal());
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setAppId("864"); // 上游的应用id
			tyall.setMobile(phone);
			tyall.setMsg(num);
			tyall.setPort(spnumber);
			tyall.setStatus("DELIVRD"); // 上游只给成功的
			tyall.setPayFee(Integer.parseInt(fee) * 100);
			tyall.setLinkid(UUID.randomUUID().toString().replace("-", ""));
			tyall.setReserveOne(URLEncoder.encode(times, "utf-8"));
			syncTyAllService.addTyAll(tyall);
			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "OK";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("互动时空 IVR同步状态为：{}", status);
		return status;
	}
	
	
	// 瑞博订单数据同步接口
		@RequestMapping(value = "rbrdosync")
		@ResponseBody
		public String rbrdosync(HttpServletRequest request) {

			String status = "failure";
			logger.info("瑞博订单接收，订单信息为：{}", request.getQueryString());
			SyncTyAll tyall = new SyncTyAll();
			try {
				String linkid = request.getParameter("linkid") != null ? request
						.getParameter("linkid") : "";
				String feeflag = request.getParameter("msg") != null ? request
						.getParameter("msg") : "";
				String port = request.getParameter("spnumber") != null ? request
						.getParameter("spnumber") : "";
				String mobileid = request.getParameter("mobile") != null ? request
						.getParameter("mobile") : "";
				String statu = request.getParameter("status") != null ? request
						.getParameter("status") : "";
				Dict dict = dictService.selectActiviteDictByKey("rbrdo_"+feeflag);
				String str = dict.getVal();
				String[] fee = str.split("_");
				int channelappId = Integer.parseInt(fee[1]);
				tyall.setChannelAppId(channelappId);
				tyall.setPayFee(Integer.parseInt(fee[0]));
				tyall.setMobile(mobileid);
				tyall.setStatus(statu);
				tyall.setLinkid("rbrdo_"+linkid);
				tyall.setMsg(feeflag);
				tyall.setPort(port);
				syncTyAllService.addTyAll(tyall);
				if (tyall.getReduceStatus() != 1) {
					syncTyAllService.syncToTyAll(tyall);
				}
				status = "OK";
			} catch (Exception e) {
				// e.printStackTrace();
				logger.info("ERROR瑞博订单同步状态为：{}", e.getMessage());
			}
			logger.info("瑞博订单同步状态为：{}", status);
			return status;
		}
	
		// 瑞博订单数据同步接口
				@RequestMapping(value = "jbsync")
				@ResponseBody
				public String jbsync(HttpServletRequest request) {

					String status = "failure";
					logger.info("金博订单接收，订单信息为：{}", request.getQueryString());
					SyncTyAll tyall = new SyncTyAll();
					try {
						String linkid = request.getParameter("linkid") != null ? request
								.getParameter("linkid") : "";
						String feeflag = request.getParameter("msg") != null ? request
								.getParameter("msg") : "";
						String port = request.getParameter("spnumber") != null ? request
								.getParameter("spnumber") : "";
						String mobileid = request.getParameter("mobile") != null ? request
								.getParameter("mobile") : "";
						String statu = request.getParameter("status") != null ? request
								.getParameter("status") : "";
						Dict dict = dictService.selectActiviteDictByKey("jb_"+feeflag);
						String str = dict.getVal();
						String[] fee = str.split("_");
						int channelappId = Integer.parseInt(fee[1]);
						tyall.setChannelAppId(channelappId);
						tyall.setPayFee(Integer.parseInt(fee[0]));
						tyall.setMobile(mobileid);
						tyall.setStatus(statu);
						tyall.setLinkid("jb_"+linkid);
						tyall.setMsg(feeflag);
						tyall.setPort(port);
						syncTyAllService.addTyAll(tyall);
						if (tyall.getReduceStatus() != 1) {
							syncTyAllService.syncToTyAll(tyall);
						}
						status = "OK";
					} catch (Exception e) {
						// e.printStackTrace();
						logger.info("ERROR金博订单同步状态为：{}", e.getMessage());
					}
					logger.info("金博订单同步状态为：{}", status);
					return status;
				}
				
				
				// 亚特无线订单数据同步接口
				@RequestMapping(value = "ytwxsync")
				@ResponseBody
				public String ytwxsync(HttpServletRequest request) {

					String status = "failure";
					logger.info("亚特订单接收，订单信息为：{}", request.getQueryString());
					SyncTyAll tyall = new SyncTyAll();
					try {
						
						String linkid = request.getParameter("linkid") != null ? request
								.getParameter("linkid") : "";
						String feeflag = request.getParameter("momsg") != null ? request
								.getParameter("momsg") : "";
						String port = request.getParameter("spnumber") != null ? request
								.getParameter("spnumber") : "";
						String mobileid = request.getParameter("mobile") != null ? request
								.getParameter("mobile") : "";
						String statu = request.getParameter("flag") != null ? request
								.getParameter("flag") : "";
								if(statu.equals("delivrd")){
									statu="DELIVRD";
								}
						Dict dict = dictService.selectActiviteDictByKey("yt_"+feeflag);
						String str = dict.getVal();
						String[] fee = str.split("_");
						int channelappId = Integer.parseInt(fee[1]);
						tyall.setChannelAppId(channelappId);
						tyall.setPayFee(Integer.parseInt(fee[0]));
						tyall.setMobile(mobileid);
						tyall.setStatus(statu);
						tyall.setLinkid("yt_"+linkid);
						tyall.setMsg(feeflag);
						tyall.setPort(port);
						syncTyAllService.addTyAll(tyall);
						if (tyall.getReduceStatus() != 1) {
							syncTyAllService.syncToTyAll(tyall);
						}
						status = "OK";
					} catch (Exception e) {
						// e.printStackTrace();
						logger.info("ERROR亚特订单同步状态为：{}", e.getMessage());
					}
					logger.info("亚特订单同步状态为：{}", status);
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
