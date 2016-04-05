package com.hytx.service.sync;


import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.hytx.dao.baseConf.ori.OperateMapper;
import com.hytx.dao.client.ex.ReqSmsCommandMapperEx;
import com.hytx.dao.client.ori.ReqSmsMapper;
import com.hytx.dao.sync.ex.SyncAllMapperEx;
import com.hytx.dao.sync.ori.SyncAllMapper;
import com.hytx.dao.sync.ori.SyncZjhyMapper;

import com.hytx.model.sync.SyncZjhy;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;

@Service("syncSzqcServiceImpl")
public class SyncSzqcServiceImpl implements ISyncSzqcService {
	@Autowired
	private SyncZjhyMapper syncZjhyMapper;
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertSyncZjhy(SyncZjhy syncZjhy) {
		// TODO Auto-generated method stub
			
		syncZjhy.setCreatetime(new Date());				
		syncZjhyMapper.insert(syncZjhy);
		
		
		

		
		return 1;

	}

//	public void initSyncAllByzjhy(SyncZjhy syncZjhy, SyncAll syncAll) {
//		try {
//			SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");
//
//			String toDay = time.format(syncZjhy.getCreatetime());
//			List<ReqSmsCommand> cmdList = reqSmsCommandMapperEx
//					.selectBySerialNum(Integer.valueOf(syncZjhy.getCpparam()),
//							toDay);
//			if (cmdList == null || cmdList.isEmpty()) {
//				return;
//			}
//			ReqSmsCommand cmd = cmdList.get(0);
//			ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(cmd.getOrderId());
//			if (reqSms == null) {
//				return;
//			}
//			int serverType = 1;
//			Province province = provinceService.selectByPrimaryKey(reqSms
//					.getProvinceId());
//			syncZjhy.setProvinceName(province.getProvinceName());
//			syncAll.setChannelId(reqSms.getChannelId());
//			syncAll.setCnAppId(reqSms.getAppId());
//			syncAll.setServerType(serverType);
//			syncAll.setOpId(cmd.getOperateId());
//			syncAll.setOpAppId(cmd.getAppId());
//			syncAll.setFeeValue(cmd.getFeeValue());
//			syncAll.setServerType(cmd.getServerType());
//			syncAll.setOrderId(cmd.getOrderId());
//			syncAll.setSerialNum(cmd.getSerialNum());
//			if (!cmd.getSendStatus().equals(BaseContance.ACTIVICE_STATUS)
//					&& syncZjhy.getRptStat().equals("DELIVRD")) {
//				cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
//				baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
//			}
//			if (syncZjhy.getRptStat().equals("DELIVRD")) {
//				ChannelApp channelApp = baseReqService
//						.selectChannelAppByKey(reqSms.getChannelAppKey());
//				Integer reducePercent = channelApp.getReducePercent();
//				if (reducePercent != null) {
//					int n = random.nextInt(100000000) % 100;
//					if (n < reducePercent) {
//						syncAll.setReduceStatus(1);
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return;
//	}

}
