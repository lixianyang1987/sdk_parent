package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sync.SyncSzzy;
import com.hytx.service.sync.ISyncSzzyService;
import com.hytx.web.base.IpUtil;

@Controller
@RequestMapping("/sync")
public class SyncSzzyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncSzzyService syncSzzyService;

	/****
	 * 深圳宅游订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月13日
	 */
	@RequestMapping(value = "szzy")
	@ResponseBody
	public String zjhySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("深圳宅游订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		try {

			String mob = request.getParameter("mob");
			String linkid = request.getParameter("linkID");
			String Instruction = request.getParameter("Instruction");
			String DestMob = request.getParameter("DestMob");
			String dt = request.getParameter("dt");
			if (mob != "" && mob != null && linkid != "" && linkid != null
					&& Instruction != "" && Instruction != null
					&& DestMob != "" && DestMob != null && dt != ""
					&& dt != null) {
				SyncSzzy syncszzy = new SyncSzzy();

				syncszzy.setMob(mob);
				syncszzy.setDt(dt);
				syncszzy.setLinkid(linkid);
				syncszzy.setInstruction(Instruction);
				syncszzy.setDestmob(DestMob);
				syncszzy.setIp(IpUtil.getRealIp(request));
				syncszzy.setRptStat("DELIVRD");
				syncszzy.setCpparam(Instruction.substring(Instruction.length() - 7));
				syncSzzyService.insertSyncZjhy(syncszzy);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("深圳宅游订单同步状态为：{}", status);
		return status;
	}
}
