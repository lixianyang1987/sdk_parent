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
import com.hytx.dao.sync.ori.SyncHddxMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncAll;
import com.hytx.model.sync.SyncHddx;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;
@Service("syncHddxServiceImpl")
public class SyncHddxServiceImpl implements ISyncHddxService {
	@Autowired
	private SyncHddxMapper syncHddxMapper;
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
	public int insertSyncHddx(SyncHddx syncHddx) {
		// TODO Auto-generated method stub
		java.math.BigDecimal syncAllId = syncAllMapperEx.selectNextSyncAllId();
		syncHddx.setSyncAllId(syncAllId.toString());		
		syncHddx.setCreatetime(new Date());
		SyncAll syncAll = new SyncAll();
		initSyncAllByHddx(syncHddx, syncAll);
		syncHddxMapper.insert(syncHddx);
		syncAll.setId(syncAllId);
		syncAll.settName("HDDX");
		syncAll.setCreateDt(new Date());		
		syncAll.setReduceStatus(BaseContance.NOT_ACTIVICE_STATUS);		
		syncAll.setCityName("");
		SimpleDateFormat time1 = new SimpleDateFormat("yyyyMMddHHmmss");
		syncAll.setRptTime(time1.format(syncHddx.getCreatetime()));
		syncAll.setStatus(BaseContance.ACTIVICE_STATUS);
		syncAllMapper.insert(syncAll);
		return 1;

	}
	public void initSyncAllByHddx(SyncHddx syncHddx, SyncAll syncAll) {
		try {
			SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

			String toDay = time.format(syncHddx.getCreatetime());
			List<ReqSmsCommand> cmdList = reqSmsCommandMapperEx
					.selectBySerialNum(Integer.valueOf(syncHddx.getMsg().substring(syncHddx.getMsg().length()-7)),
							toDay);
			if (cmdList == null || cmdList.isEmpty()) {
				return;
			}
			ReqSmsCommand cmd = cmdList.get(0);
			ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(cmd.getOrderId());
			if (reqSms == null) {
				return;
			}
			int serverType = 1;
			Province province = provinceService.selectByPrimaryKey(reqSms
					.getProvinceId());
			syncHddx.setProvincename(province.getProvinceName());
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
					&& syncHddx.getMsgtype().equals("10")) {
				cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
				baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
			}
			if (syncHddx.getMsgtype().equals("10")) {
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



}
