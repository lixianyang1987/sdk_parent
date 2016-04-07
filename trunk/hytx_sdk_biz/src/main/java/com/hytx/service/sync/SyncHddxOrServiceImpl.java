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
import com.hytx.dao.sync.ori.SyncHddxOrMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncAll;
import com.hytx.model.sync.SyncHddxOr;
import com.hytx.model.sync.SyncHddxOrExample;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;

@Service("syncHddxOrServiceImpl")
public class SyncHddxOrServiceImpl implements ISyncHddxOrService {
	@Autowired
	private SyncHddxOrMapper syncHddxOrMapper;
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
	public int insertSyncHddxOr(SyncHddxOr syncHddxOr) {
		
				java.math.BigDecimal syncAllId = syncAllMapperEx.selectNextSyncAllId();
				syncHddxOr.setSyncAllId(syncAllId.toString());		
				syncHddxOr.setCreatetime(new Date());
				SyncAll syncAll = new SyncAll();
				initSyncAllByHddxOr(syncHddxOr, syncAll);
				try{
				syncHddxOrMapper.insert(syncHddxOr);
				}catch (Exception e){
					return -1;
				}
				syncAll.setId(syncAllId);
				syncAll.settName("HDDXOR");
				syncAll.setCreateDt(new Date());		
				syncAll.setReduceStatus(BaseContance.NOT_ACTIVICE_STATUS);		
				syncAll.setCityName("");
				SimpleDateFormat time1 = new SimpleDateFormat("yyyyMMddHHmmss");
				syncAll.setRptTime(time1.format(syncHddxOr.getCreatetime()));
				syncAll.setStatus(BaseContance.ACTIVICE_STATUS);
				syncAllMapper.insert(syncAll);
				return 1;
	}

	@Override
	public int updateSyncHddxOr(SyncHddxOr syncHddxOr, SyncHddxOrExample shdor) {
		try{
			syncHddxOrMapper.updateByExampleSelective(syncHddxOr, shdor);
		}catch(Exception ex){
			return -1;
		}
		return 1;
	}
	
	
	public void initSyncAllByHddxOr(SyncHddxOr syncHddxOr, SyncAll syncAll) {
		try {
			SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");

			String toDay = time.format(syncHddxOr.getCreatetime());
			List<ReqSmsCommand> cmdList = reqSmsCommandMapperEx
					.selectBySerialNum(Integer.valueOf(syncHddxOr.getMsg().substring(syncHddxOr.getMsg().length()-7)),
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
			syncHddxOr.setProvinceName(province.getProvinceName());
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
					&& syncHddxOr.getMsgtype().equals("0")) {
				cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
				baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
			}
			if (syncHddxOr.getMsgtype().equals("0")) {
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
