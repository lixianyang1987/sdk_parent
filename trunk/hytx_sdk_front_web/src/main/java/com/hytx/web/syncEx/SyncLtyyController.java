package com.hytx.web.syncEx;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.constance.DictKeyInfo;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.syncEx.SyncLtyy;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.syncEx.ISyncLtyyService;

@Controller
@RequestMapping("/sync")
public class SyncLtyyController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISyncLtyyService syncLtyyService;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IDictService dictService;

	private Random random = new Random();

	/****
	 * 联通音乐上行订单记录接口
	 * 
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年10月23日
	 */
	@RequestMapping(value = "ltyyUp")
	@ResponseBody
	public String ltyyUpSync(HttpServletRequest request) {
		String status = "failure";
		logger.info("联通音乐上行订单同步信息开始，订单信息为：\n{}", request.getQueryString());
		String msg = request.getParameter("msg");
		String spnumber = request.getParameter("spnumber");
		String mobileId = request.getParameter("mobileid");
		String linkId = request.getParameter("linkid");
		try {
			if (!StringUtils.isBlank(msg) && !StringUtils.isBlank(spnumber)
					&& !StringUtils.isBlank(mobileId)
					&& !StringUtils.isBlank(linkId)) {
				SyncLtyy syncLtyy = new SyncLtyy();
				syncLtyy.setLinkId(linkId);
				syncLtyy.setMobileId(Long.parseLong(mobileId));
				syncLtyy.setMsg(msg);
				syncLtyy.setSpNumber(spnumber);
				syncLtyy.setCreateDt(new Date());
				syncLtyyService.insertSyncLtyy(syncLtyy);
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("联通音乐上行订单同步状态为：{}", status);
		return status;
	}

	/****
	 * 联通音乐订单状态同步记录接口
	 * 
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年10月23日
	 */
	@RequestMapping(value = "ltyyState")
	@ResponseBody
	public String ltyyStateSync(HttpServletRequest request) {
		String status = "failure";
		logger.info("联通音乐订单状态同步信息开始，订单信息为：\n{}", request.getQueryString());
		String dataStatus = request.getParameter("status");
		String mobileId = request.getParameter("mobileid");
		String linkId = request.getParameter("linkid");
		try {
			if (!StringUtils.isBlank(dataStatus)
					&& !StringUtils.isBlank(mobileId)
					&& !StringUtils.isBlank(linkId)) {
				SyncLtyy syncLtyy = new SyncLtyy();
				syncLtyy.setLinkId(linkId);
				syncLtyy.setStatus(Integer.parseInt(dataStatus));
				syncLtyy.setMobileId(Long.parseLong(mobileId));
				syncLtyy.setUpdateDt(new Date());
				Dict dict = dictService
						.selectActiviteDictByKey(DictKeyInfo.SMSLTYY_CHANNEL_APP_ID_KEY);
				if (dict == null || dict.getVal() == null) {
					syncLtyy.setReduceStatus(1);
					syncLtyyService.updateSyncLtyyStatus(syncLtyy);
					status = "ok";
					logger.info("联通音乐订单状态同步状态为：{}", status);
					return status;
				}
				ChannelApp channelApp = channelAppService
						.selectByPrimaryKey(Integer.parseInt(dict.getVal()));
				Integer reducePercent = channelApp.getReducePercent();
				syncLtyy.setReduceStatus(0);
				if (reducePercent != null && syncLtyy.getStatus().equals(1)) {
					int n = random.nextInt(100000000) % 100;
					if (n < reducePercent) {
						syncLtyy.setReduceStatus(1);
					}
				}
				syncLtyy.setUpdateDt(new Date());
				syncLtyyService.updateSyncLtyyStatus(syncLtyy);
				if (syncLtyy.getReduceStatus().equals(0)) {
					String uri = channelApp.getSyncUrl();
					syncLtyyService.syncLtyyToLowerChannel(uri, syncLtyy);
				}
				status = "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("联通音乐订单状态同步状态为：{}", status);
		return status;
	}
}
