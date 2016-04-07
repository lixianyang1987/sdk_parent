package com.hytx.web.sync;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncSjdy;
import com.hytx.service.sync.ISyncSjdyService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncSjdyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSjdyService syncSjdyService;

	/****
	 * 世纪电盈订单同步接口,包括移动小额支付和电信
	 * 
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年7月16日
	 */
	@RequestMapping(value = "sjdy")
	@ResponseBody
	public String sjdySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("世纪电盈订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			SyncSjdy syncSjdy = new SyncSjdy();
			syncSjdy.setLinkId(request.getParameter("LinkID"));
			String m = request.getParameter("Mobile");
			if (m != null) {
				if (m.length() > 11) {
					m = m.substring(m.length() - 11);
				}
				syncSjdy.setMobile(Long.parseLong(m));
			}
			syncSjdy.setMoContent(request.getParameter("MoContent"));
			syncSjdy.setRptStat(request.getParameter("RptStat"));
			syncSjdy.setSpNumber(request.getParameter("SpNumber"));
			syncSjdy.setFeeCode(Integer.parseInt(request
					.getParameter("FeeCode")));
			syncSjdy.setTelType(Integer.parseInt(request
					.getParameter("Teltype")));
			syncSjdy.setRptTime(request.getParameter("RptTime"));
			String citys = request.getParameter("City");
			logger.info("地区为：{}", citys);
			int index = citys.indexOf(",");
			if (index > 0) {
				syncSjdy.setProvinceName(citys.substring(0, index));
				syncSjdy.setCityName(citys.substring(index + 1));
			}
			if (!StringUtils.isBlank(syncSjdy.getMoContent())
					&& !StringUtils.isBlank(syncSjdy.getRptStat())) {
				syncSjdy.setUpdateDt(new Date());
				syncSjdy.setIp(IpUtil.getRealIp(request));
				String moContent = syncSjdy.getMoContent();
				if (moContent.length() > 7) {
					syncSjdy.setSpParam(moContent.substring(moContent.length() - 7));// 透传7位
				}
				syncSjdyService.insertSyncSjdy(syncSjdy);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("世纪电盈订单同步状态为：{}", status);
		return status;
	}

	/****
	 * 世纪电盈订单同步接口,包括移动大额支付
	 * 
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年7月16日
	 */
	@RequestMapping(value = "sjdy_mp")
	@ResponseBody
	public String sjdySyncMp(HttpServletRequest request) {
		String status = "failure";
		logger.info("世纪电盈移动MP订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			SyncSjdy syncSjdy = new SyncSjdy();
			syncSjdy.setFeeCode(Integer.parseInt(request
					.getParameter("FeeCode")));
			syncSjdy.setLinkId(request.getParameter("LinkID"));
			syncSjdy.setMoContent(request.getParameter("MoContent"));
			syncSjdy.setRptStat(request.getParameter("RptStat"));
			syncSjdy.setSpNumber(request.getParameter("Spnumber"));
			syncSjdy.setSpParam(request.getParameter("ExtData"));// 透传
			syncSjdy.setRptTime(DateFormatUtils.format(new Date(),
					"yyyyMMddHHmmss"));
			syncSjdy.setUpdateDt(new Date());
			syncSjdy.setIp(IpUtil.getRealIp(request));
			syncSjdyService.insertSyncSjdyMp(syncSjdy);
			status = "ok";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("世纪电盈移动MP订单同步状态为：{}", status);
		return status;
	}

}
