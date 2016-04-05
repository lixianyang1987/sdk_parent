package com.hytx.web.sync;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncQsxx;
import com.hytx.model.sync.SyncQsxxExample;
import com.hytx.model.sync.SyncQsxxby;
import com.hytx.service.sync.ISyncQsxxService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncQsxxController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncQsxxService syncQsxxService;

	/****
	 * 全盛信息订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 */
	@RequestMapping(value = "qsxx")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("全盛信息订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String moid = request.getParameter("moid");
			String gatewayid = request.getParameter("gatewayid");
			String productid = request.getParameter("productid");
			String desttermid = request.getParameter("desttermid");
			String phone = request.getParameter("phone");
			String linkid = request.getParameter("linkid");
			String msgcontent = request.getParameter("msgcontent");
			if (moid != "" && moid != null && linkid != "" && linkid != null
					&& gatewayid != "" && gatewayid != null && productid != ""
					&& productid != null && phone != "" && phone != null
					&& msgcontent != "" && msgcontent != null) {
				SyncQsxx syncQsxx = new SyncQsxx();
				syncQsxx.setMoid(moid);
				syncQsxx.setLinkid(linkid);
				syncQsxx.setGatewayid(gatewayid);
				syncQsxx.setDesttermid(desttermid);
				syncQsxx.setIp(IpUtil.getRealIp(request));
				syncQsxx.setPhone(phone);
				syncQsxx.setProductid(productid);
				syncQsxx.setMsgcontent(msgcontent);
				syncQsxx.setStatus("DELIVRD");
				syncQsxxService.insertSyncQsxx(syncQsxx);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("全盛信息订单同步状态为：{}", status);
		return status;
	}


	/****
	 * 全盛信息订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 */
	@RequestMapping(value = "qsxxreq")
	@ResponseBody
	public String qsxxSync(HttpServletRequest request) {
		String status = "failure";
		logger.info("全盛信息结果同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {

			String feecode = request.getParameter("feecode");
			String linkid = request.getParameter("linkid");
			String statu = request.getParameter("status");
			if (linkid != "" && linkid != null) {
				SyncQsxx syncQsxx = new SyncQsxx();
				syncQsxx.setFeecode(Integer.parseInt(feecode));
				syncQsxx.setStatus(statu);
				SyncQsxxExample e =new SyncQsxxExample();
				e.createCriteria().andLinkidEqualTo(linkid);
				syncQsxx.setLinkid(linkid);
				syncQsxxService.updateSyncQsxx(syncQsxx, e);
				if(syncQsxx.getReduceStatus()==0){
					SyncQsxx qsxx= syncQsxxService.Getqsxx(linkid);
					syncQsxxService.syncQsxxToOhers(syncQsxx, request.getQueryString()+"&msgcontent="+qsxx.getMsgcontent());
				}
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("全盛信息结果同步状态为：{}", status);
		return status;
	}

	/****
	 * 全盛信息包月订单同步接口 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月25日
	 */
	@RequestMapping(value = "qsxxby")
	@ResponseBody
	public String syncQsxxby(HttpServletRequest request) {
		String status = "failure";
		logger.info("全盛信息包月订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {
			String morid = request.getParameter("morid");
			String gatewayid = request.getParameter("gatewayid");
			String productid = request.getParameter("productid");
			String operatetype = request.getParameter("operatetype");
			String phone = request.getParameter("phone");
			String modatreceive = request.getParameter("modatreceive");
			String statu = request.getParameter("status");
			if (morid != "" && morid != null && gatewayid != ""
					&& gatewayid != null && productid != ""
					&& productid != null && phone != "" && phone != null) {
				Integer opType = Integer.parseInt(operatetype);
				if (!opType.equals(2) && !opType.equals(3)) {
					status = "failure";
					logger.info("全盛信息包月订单同步状态为：{}", status);
					return status;
				}
				SyncQsxxby syncQsxxby = new SyncQsxxby();
				syncQsxxby.setMorid(morid);
				syncQsxxby.setGatewayId(gatewayid);
				syncQsxxby.setPhone(Long.parseLong(phone));
				syncQsxxby.setProductId(productid);
				syncQsxxby.setStatus(statu);
				syncQsxxby.setModatReceive(modatreceive);
				syncQsxxby.setOperateType(opType);
				if (syncQsxxby.getOperateType().equals(2)) {
					syncQsxxby.setReduceStatus(0);// 订购初始默认设置为不扣量
				} else {
					syncQsxxby.setReduceStatus(1);// 退订初始默认设置为不扣量
				}
				syncQsxxby.setCreateTime(new Date());
				syncQsxxService.insertSyncQsxxby(syncQsxxby);
				status = "ok";
				if (syncQsxxby.getReduceStatus().equals(0)) {
					syncQsxxService.syncQsxxbyToOhers(syncQsxxby,
							request.getQueryString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("全盛信息包月订单同步状态为：{}", status);
		return status;
	}
}
