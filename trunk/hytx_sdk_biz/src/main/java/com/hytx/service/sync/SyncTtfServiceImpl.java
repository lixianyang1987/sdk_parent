package com.hytx.service.sync;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import com.hytx.dao.sync.ori.SyncTtfMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncAll;
import com.hytx.model.sync.SyncTtf;
import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;
@Service("syncTtfServiceImpl")
public class SyncTtfServiceImpl implements ISyncTtfService {
	@Autowired
	private SyncTtfMapper syncTtfMapper;
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
	private IProvinceService provinceService;
	@Autowired
	private IBaseReqService baseReqService;
	
	private Random random = new Random();
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertSyncTtf(SyncTtf syncTtf) {
		// TODO Auto-generated method stub
		java.math.BigDecimal syncAllId = syncAllMapperEx.selectNextSyncAllId();
		syncTtf.setSyncAllId(syncAllId.toString());
		syncTtf.setCreatetime(new Date());
		SimpleDateFormat time1 = new SimpleDateFormat("yyyyMMddHHmmss");
		syncTtf.setRpttime(time1.format(syncTtf.getCreatetime()));
		if(syncTtf.getResultcode().equals("000000")){
			syncTtf.setResultcode("DELIVRD");
		}
		syncTtfMapper.insert(syncTtf);
		SyncAll syncall= new SyncAll();		
		syncall.settName("TTF");
		initSyncAllByttf(syncTtf, syncall);
		syncall.setId(syncAllId);
		syncall.setCreateDt(new Date());
		syncall.setMo(syncTtf.getExdata());		
		syncall.setReduceStatus(BaseContance.NOT_ACTIVICE_STATUS);
		syncall.setSpNumber("118030831072640");		
		syncall.setCityName("");		
		syncall.setRptTime(syncTtf.getRpttime());
		syncall.setStatus(BaseContance.ACTIVICE_STATUS);
		syncAllMapper.insert(syncall);
		return 1;
	}
	
	public void initSyncAllByttf(SyncTtf syncTtf, SyncAll syncAll) {
		try{
		String toDay = syncTtf.getRpttime().substring(0,7);
		List<ReqSmsCommand> cmdList = reqSmsCommandMapperEx
				.selectBySerialNum(Integer.valueOf(syncTtf.getExdata()),
						toDay);
		if (cmdList == null || cmdList.isEmpty()) {
			return;
		}
		ReqSmsCommand cmd = cmdList.get(0);
		ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(cmd.getOrderId());
		if (reqSms == null) {
			return;
		}
		Province province = provinceService.selectByPrimaryKey(reqSms
				.getProvinceId());
	
		syncAll.setProvinceName(province.getProvinceName());
		syncAll.setChannelId(reqSms.getChannelId());
		syncAll.setCnAppId(reqSms.getAppId());
		syncAll.setServerType(Integer.parseInt(syncTtf.getOpid().toString()));
		syncAll.setOpId(cmd.getOperateId());
		syncAll.setOpAppId(cmd.getAppId());
		syncAll.setFeeValue(cmd.getFeeValue());
		syncAll.setServerType(cmd.getServerType());
		syncAll.setOrderId(cmd.getOrderId());
		syncAll.setSerialNum(cmd.getSerialNum());
		if (!cmd.getSendStatus().equals(BaseContance.ACTIVICE_STATUS)
				&& syncTtf.getResultcode().equals("DELIVRD")) {
			cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
			baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
		}
		if (syncTtf.getResultcode().equals("DELIVRD")) {
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
		}catch (Exception e){
			e.printStackTrace();
		}
		return;
	}
	

}
