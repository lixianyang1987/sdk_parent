package com.hytx.service.sync;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.BaseContance;
import com.hytx.dao.baseConf.ori.OperateMapper;
import com.hytx.dao.client.ex.ReqSmsCommandMapperEx;
import com.hytx.dao.client.ori.ReqSmsMapper;
import com.hytx.dao.sync.ex.SyncAllMapperEx;
import com.hytx.dao.sync.ori.SyncAllMapper;
import com.hytx.dao.sync.ori.SyncSjdyMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncAll;
import com.hytx.model.sync.SyncSjdy;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;

@Service("syncSjdyServiceImpl")
public class SyncSjdyServiceImpl implements ISyncSjdyService {
	@Autowired
	private SyncSjdyMapper syncSjdyMapper;
	@Autowired
	private SyncAllMapperEx syncAllMapperEx;
	@Autowired
	private SyncAllMapper syncAllMapper;
	@Autowired
	private OperateMapper operateMapper;
	@Autowired
	private ReqSmsMapper reqSmsMapper;
	@Autowired
	private ReqSmsCommandMapperEx reqSmsCommandMapperEx;
	@Autowired
	private IBaseReqService baseReqService;
	@Autowired
	private IProvinceService provinceService;
	private Random random = new Random();

	@Transactional(propagation = Propagation.REQUIRED)
	public int insertSyncSjdy(SyncSjdy syncSjdy) {
		java.math.BigDecimal syncAllId = syncAllMapperEx.selectNextSyncAllId();
		syncSjdy.setSyncAllId(syncAllId);
		syncSjdyMapper.insert(syncSjdy);
		SyncAll syncAll = new SyncAll();
		syncAll.setId(syncAllId);
		syncAll.setCreateDt(new Date());
		syncAll.settName("SJDY");
		syncAll.setMo(syncSjdy.getMoContent());
		syncAll.setMobile(syncSjdy.getMobile());
		syncAll.setReduceStatus(BaseContance.NOT_ACTIVICE_STATUS);
		syncAll.setSpNumber(syncSjdy.getSpNumber());
		syncAll.setProvinceName(syncSjdy.getProvinceName());
		syncAll.setCityName(syncSjdy.getCityName());
		syncAll.setRptTime(syncSjdy.getRptTime());
		initSyncAllBySjdy(syncSjdy, syncAll);
		if (syncSjdy.getRptStat().equals("DELIVRD")) {
			syncAll.setStatus(BaseContance.ACTIVICE_STATUS);
		} else {
			syncAll.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
		}
		syncAllMapper.insert(syncAll);
		return 1;
	}

	/****
	 * 根据世纪电盈订单匹配出指令信息
	 * 
	 * @param syncSjdy
	 * @param syncAll
	 * @return
	 * @author houzz
	 * @date 2015年7月22日
	 */
	public void initSyncAllBySjdy(SyncSjdy syncSjdy, SyncAll syncAll) {
		String mo = null;
		Integer serverType = null;
		String serialNumStr = null;
		String moContent = syncSjdy.getMoContent();
		if (moContent.indexOf("#") == 3) {
			if (moContent.length() == 14) {
				serialNumStr = moContent.substring(7);
				mo = moContent.substring(0, 7);
				serverType = 1;
			}
		} else if (moContent.length() == 10) {
			serialNumStr = moContent.substring(3);
			mo = moContent.substring(0, 3);
			serverType = 3;
		}
		if (serialNumStr == null || mo == null || StringUtils.isBlank(mo)) {
			return;
		}
		String toDay = syncSjdy.getRptTime().substring(0, 8);
		List<ReqSmsCommand> cmdList = reqSmsCommandMapperEx.selectBySerialNum(
				Integer.valueOf(serialNumStr), toDay);
		if (cmdList == null || cmdList.isEmpty()) {
			return;
		}
		ReqSmsCommand cmd = cmdList.get(0);
		if (StringUtils.isBlank(syncSjdy.getProvinceName())) {
			Integer provinceId = cmd.getProvinceId();
			if (provinceId != null) {
				Province province = provinceService.selectByPrimaryKey(cmd
						.getProvinceId());
				syncAll.setProvinceName(province.getProvinceName());
			}
		}
		ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(cmd.getOrderId());
		if (reqSms == null) {
			return;
		}
		try {
			syncAll.setChannelId(reqSms.getChannelId());
			syncAll.setCnAppId(reqSms.getAppId());
			syncAll.setServerType(serverType);
			syncAll.setOpId(cmd.getOperateId());
			syncAll.setOpAppId(cmd.getAppId());
			syncAll.setFeeValue(cmd.getFeeValue());
			syncAll.setServerType(cmd.getServerType());
			syncAll.setOrderId(cmd.getOrderId());
			syncAll.setSerialNum(cmd.getSerialNum());
			if (!cmd.getSendStatus().equals(BaseContance.ACTIVICE_STATUS)
					&& syncSjdy.getRptStat().equals("DELIVRD")) {
				cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
				baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
			}
			if (syncSjdy.getRptStat().equals("DELIVRD")) {
				ChannelApp channelApp = baseReqService
						.selectChannelAppByKey(reqSms.getChannelAppKey());
				Integer reducePercent = channelApp.getReducePercent();
				if (reducePercent != null) {
					int n = random.nextInt(100000000) % 100;
					if (n < reducePercent) {
						syncAll.setReduceStatus(1);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int insertSyncSjdyMp(SyncSjdy syncSjdyMp) {
		BigDecimal syncAllId = syncAllMapperEx.selectNextSyncAllId();
		SyncAll syncAll = new SyncAll();
		syncAll.setId(syncAllId);
		syncAll.setCreateDt(new Date());
		syncAll.setMo(syncSjdyMp.getMoContent());
		syncAll.setReduceStatus(BaseContance.NOT_ACTIVICE_STATUS);
		syncAll.setSpNumber(syncSjdyMp.getSpNumber());
		syncAll.setRptTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		if (syncSjdyMp.getRptStat().equals("DELIVRD")) {
			syncAll.setStatus(BaseContance.ACTIVICE_STATUS);
		} else {
			syncAll.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
		}
		initSyncAllBySjdyMp(syncSjdyMp, syncAll);
		syncAllMapper.insert(syncAll);
		syncSjdyMp.setSyncAllId(syncAllId);
		syncSjdyMapper.insert(syncSjdyMp);
		return 1;
	}

	public void initSyncAllBySjdyMp(SyncSjdy syncSjdyMp, SyncAll syncAll) {
		String toDay = DateFormatUtils.format(new Date(), "yyyyMMdd");
		List<ReqSmsCommand> cmdList = reqSmsCommandMapperEx.selectBySerialNum(
				Integer.valueOf(syncSjdyMp.getSpParam()), toDay);
		if (cmdList == null || cmdList.isEmpty()) {
			syncAll.setOpAppId(280);
			syncAll.setServerType(1);
			return;
		}
		ReqSmsCommand cmd = cmdList.get(0);
		Province province = provinceService.selectByPrimaryKey(cmd
				.getProvinceId());
		syncAll.setProvinceName(province.getProvinceName());
		syncAll.setOpAppId(cmd.getAppId());
		syncAll.setServerType(cmd.getServerType());
		ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(cmd.getOrderId());
		if (reqSms != null) {
			syncAll.setChannelId(reqSms.getChannelId());
			syncAll.setCnAppId(reqSms.getAppId());
			syncAll.setServerType(reqSms.getServerType());
			if (syncSjdyMp.getRptStat().equals("DELIVRD")) {
				ChannelApp channelApp = baseReqService
						.selectChannelAppByKey(reqSms.getChannelAppKey());
				Integer reducePercent = channelApp.getReducePercent();
				if (reducePercent != null) {
					int n = random.nextInt(100000000) % 100;
					if (n < reducePercent) {
						syncAll.setReduceStatus(1);
					}
				}
			}
		}
		syncAll.setOpId(cmd.getOperateId());
		syncAll.setOpAppId(cmd.getAppId());
		syncAll.setFeeValue(cmd.getFeeValue());
		syncAll.setServerType(cmd.getServerType());
		syncAll.setOrderId(cmd.getOrderId());
		syncAll.setSerialNum(cmd.getSerialNum());
		if (!cmd.getSendStatus().equals(BaseContance.ACTIVICE_STATUS)
				&& syncSjdyMp.getRptStat().equals("DELIVRD")) {
			cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
			baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
		}
	}

}
