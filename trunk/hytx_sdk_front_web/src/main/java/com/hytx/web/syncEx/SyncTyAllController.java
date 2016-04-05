package com.hytx.web.syncEx;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.baseConf.Dict;
import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByLogExample;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
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

	// 电信包月短信
	@RequestMapping(value = "dxbysms")
	@ResponseBody
	public String zxjmbysmsSync(HttpServletRequest request) {
		String status = "failure";
		try {
			logger.info("电信包月短信-订单同步上行信息开始，订单信息为：\n{}",
					request.getQueryString());
			SyncTyAll tyall = new SyncTyAll();
			String tranid = request.getParameter("streaming_no") != null ? request
					.getParameter("streaming_no") : ""; // 计费流水号
			String productId = request.getParameter("productId") != null ? request
					.getParameter("productId") : ""; // 上行内容
			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String feecode = request.getParameter("order") != null ? request
					.getParameter("order").toLowerCase() : ""; // 订购指令
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String statu = request.getParameter("status") != null ? request
					.getParameter("status") : "";

			Dict dict = dictService.selectActiviteDictByKey(feecode);
			// 0 为计费金额 1 为 渠道包
			String[] str = dict.getVal().split("_");

			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));
			if (feecode.equals("d1"))
				tyall.setAppId("840"); // 电信d1包月-10元的应用id
			else if (feecode.equals("dy2"))
				tyall.setAppId("841"); // 电信dy2包月-15元的应用id
			else
				tyall.setAppId("");
			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setMsg(feecode);
			if (statu.equals("0")) {
				statu = "DELIVRD";
			}
			tyall.setStatus(statu);
			// 订购
			if (statu.equals("DELIVRD")) {
				syncTyAllService.addTyAll(tyall);
			} else if (statu.equals("3")) {
				// 退订
				SyncTyAllExample example = new SyncTyAllExample();
				example.createCriteria().andLinkidEqualTo(tyall.getLinkid())
						.andMobileEqualTo(tyall.getMobile());
				SyncTyAll ty = syncTyAllService.SelectSyncTyAll(example);
				syncTyAllService.UpdateTyAll(tyall, example);
			}

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
			String msg = request.getParameter("msg") != null ? request
					.getParameter("msg") : ""; // 上行内容

			String mobile = request.getParameter("mobile") != null ? request
					.getParameter("mobile") : "";
			String feecode = request.getParameter("product_id") != null ? request
					.getParameter("product_id").toLowerCase() : ""; // 业务代码
			String lnum = request.getParameter("spnumber") != null ? request
					.getParameter("spnumber") : ""; // 长号
			String statu = request.getParameter("report") != null ? request
					.getParameter("report") : "";
			if (statu.equals("0")) {
				statu = "DELIVRD";
			}

			Dict dict = dictService.selectActiviteDictByKey(msg);
			// 0 为计费金额 1 为 渠道包 2为 appid
			String[] str = dict.getVal().split("_");

			int channelappId = Integer.parseInt(str[1]);
			tyall.setChannelAppId(channelappId); // 下游渠道编号
			tyall.setPayFee(Integer.parseInt(str[0]));

			tyall.setAppId(str[2]); //

			tyall.setLinkid(tranid);
			tyall.setMobile(mobile);
			tyall.setPort(lnum);
			tyall.setMsg(msg);
			tyall.setStatus(statu);
			tyall.setReserveTwo(feecode);
			syncTyAllService.addTyAll(tyall);

			// 给下游渠道同步
			if (tyall.getReduceStatus() != 1) {
				syncTyAllService.syncToTyAll(tyall);
			}
			status = "{\"ret\":0, \"desc\":\"OK\"}";
		} catch (Exception e) {
			logger.info("电信MO-error：{}", e.getMessage());
			status = "{\"ret\":1, \"desc\":\"ERROR\"}";
		}
		logger.info("电信点播-订单同步上行状态为：{}", status);
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

}
