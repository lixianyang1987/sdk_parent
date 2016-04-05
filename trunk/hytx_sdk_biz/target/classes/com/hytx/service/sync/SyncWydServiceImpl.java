package com.hytx.service.sync;


import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.client.ori.ReqSmsMapper;
import com.hytx.dao.sync.ex.SyncAllMapperEx;
import com.hytx.dao.sync.ori.SyncAllMapper;
import com.hytx.dao.sync.ori.SyncWydFMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.sync.SyncWydF;
import com.hytx.model.sync.SyncWydFExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.client.IBaseReqService;
import com.hytx.util.HttpClientUtil;

@Service("syncWydServiceImpl")
public class SyncWydServiceImpl implements ISyncWydService {
	@Autowired
	private SyncWydFMapper syncWydMapper;
	@Autowired
	private IBaseReqService baseReqService;
	@Autowired
	private SyncAllMapperEx syncAllMapperEx;
	@Autowired
	private SyncAllMapper syncAllMapper;
	@Autowired
	private ReqSmsMapper reqSmsMapper;
	@Autowired
	private IProvinceService provinceService;
	private Random random = new Random();
	@Autowired
	private IChannelAppService channelAppService;
	private ChannelApp channelApp;
	@Autowired
	private IDictService dictService;


	/****
	 * 保存沃阅读订单记录，并整合成一条本地数据格式的订单记录
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertSyncWyd(SyncWydF syncWyd) {
		
		String key="";
		if ("0001".equals(syncWyd.getAppInfo())&&syncWyd.getPayFee()==1000) {
			key="wyd_key1_1000";
		} else if ("0002".equals(syncWyd.getAppInfo())&&syncWyd.getPayFee()==1000) {
			key="wyd_key2_1000";
		}
		if(key.equals("")){
			key="wyd_key1_"+syncWyd.getPayFee();
		}
	
		Dict dict= dictService.selectActiviteDictByKey(key);
		int channelappId = Integer.parseInt(dict.getVal());
		syncWyd.setChannelAppId(channelappId);
		channelApp = channelAppService.selectByPrimaryKey(channelappId);
		

		Integer reducePercent = channelApp.getReducePercent();
		syncWyd.setReduceStatus(0);
		if (reducePercent != null && syncWyd.getStatus().equals("00000")) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				syncWyd.setReduceStatus(1);
			}
		}
		syncWydMapper.insert(syncWyd);
		return 1;
		//SDK代码》》》》》》》》》》》》》》》》》》
//		SyncAll syncAll = new SyncAll();
//		syncAll.setOpAppId(appId);
//		syncAll.setServerType(BaseContance.SERVER_TYPE_UNICOM);
//		syncAll.setFeeValue(1000);
//		syncAll.settName("WYD");
//		List<ReqSmsCommand> list = baseReqService.selectNoSyncByOrderTime(
//				appId, syncWyd.getPayFee(), syncWyd.getOrderTime());
//		if (list != null && !list.isEmpty()) {
//			ReqSmsCommand cmd = list.get(0);
//			Province province = provinceService.selectByPrimaryKey(cmd
//					.getProvinceId());
//			syncAll.setProvinceName(province.getProvinceName());
//			ReqSms reqSms = reqSmsMapper.selectByPrimaryKey(cmd.getOrderId());
//			if (reqSms != null) {
//				syncAll.setChannelId(reqSms.getChannelId());
//				syncAll.setCnAppId(reqSms.getAppId());
//				syncAll.setServerType(reqSms.getServerType());
//				if (syncWyd.getHret().equals("0")) {
//					ChannelApp channelApp = baseReqService
//							.selectChannelAppByKey(reqSms.getChannelAppKey());
//					Integer reducePercent = channelApp.getReducePercent();
//					if (reducePercent != null) {
//						int n = random.nextInt(100000000) % 100;
//						if (n < reducePercent) {
//							syncAll.setReduceStatus(1);
//						}
//					}
//				}
//			}
//			syncAll.setOpId(cmd.getOperateId());
//			syncAll.setOpAppId(cmd.getAppId());
//			syncAll.setFeeValue(cmd.getFeeValue());
//			syncAll.setServerType(cmd.getServerType());
//			syncAll.setOrderId(cmd.getOrderId());
//			syncAll.setSerialNum(cmd.getSerialNum());
//			if (!cmd.getSendStatus().equals(BaseContance.ACTIVICE_STATUS)
//					&& syncWyd.getHret().equals("0")) {// 0为成功状态
//				cmd.setSendStatus(BaseContance.ACTIVICE_STATUS);
//				baseReqService.updateReqSmsCommandByPrimaryKey(cmd);
//			}
//		}
//		BigDecimal syncAllId = syncAllMapperEx.selectNextSyncAllId();
//		syncAll.setId(syncAllId);
//		syncAll.setCreateDt(new Date());
//		syncAll.setReduceStatus(BaseContance.NOT_ACTIVICE_STATUS);
//		syncAll.setRptTime(syncWyd.getOrderTime());
//		if (syncWyd.getHret().equals("0")) {
//			syncAll.setStatus(BaseContance.ACTIVICE_STATUS);
//		} else {
//			syncAll.setStatus(BaseContance.NOT_ACTIVICE_STATUS);
//		}
//		syncAllMapper.insert(syncAll);
//		syncWyd.setSyncAllId(syncAllId);
		//SDK代码《《《《《《《《《《《《《《《《《《《《
	}
	
	
	@Override
	public void syncToWydf(final SyncWydF syncWyd) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			@Override
			public void run() {
				// 根据指令内容确定是哪一家下游渠道包
				try {

				if(channelApp!=null){	
				String url = channelApp.getSyncUrl();				
				if (StringUtils.isBlank(url)
						) {
					return;
				}	
				
				StringBuilder sb = new StringBuilder();
				sb.append("phonenum=").append(syncWyd.getPhoneNum())
				.append("&payfee=").append(syncWyd.getPayFee())
				.append("&hRet=").append(syncWyd.getHret())
				.append("&ordertime=").append(syncWyd.getOrderTime())
				.append("&appid=").append(syncWyd.getAppInfo())
				.append("&status=").append(syncWyd.getStatus());
				url = url + "?" + sb.toString();								
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && "ok".equals(content.toLowerCase())) {
						syncWyd.setSyncStatus(1);
						SyncWydFExample example=new SyncWydFExample();
						example.createCriteria().andOrderTimeEqualTo(syncWyd.getOrderTime()).andPhoneNumEqualTo(syncWyd.getPhoneNum());
						syncWydMapper.updateByExampleSelective(syncWyd, example);
					}else{
						syncWyd.setSyncStatus(-1);		
						SyncWydFExample example=new SyncWydFExample();
						example.createCriteria().andOrderTimeEqualTo(syncWyd.getOrderTime()).andPhoneNumEqualTo(syncWyd.getPhoneNum());
						syncWydMapper.updateByExampleSelective(syncWyd, example);
					}
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();

	}
	@Override
	public void WydSync() {
		// TODO Auto-generated method stub
		try {
			SyncWydFExample example = new SyncWydFExample();
			example.createCriteria().andSyncStatusEqualTo(-1).andReduceStatusEqualTo(0);
			List<SyncWydF>	tdxltList=syncWydMapper.selectByExample(example);
			for (SyncWydF wydf : tdxltList) {
				if(wydf.getChannelAppId()!=null){
					channelApp=channelAppService.selectByPrimaryKey(wydf.getChannelAppId());
					String url = channelApp.getSyncUrl();				
					if (StringUtils.isBlank(url)
							) {
						continue;
					}
					StringBuilder sb = new StringBuilder();
					
					sb.append("phonenum=").append(wydf.getPhoneNum())
					.append("&payfee=").append(wydf.getPayFee())
					.append("&hRet=").append(wydf.getHret())
					.append("&ordertime=").append(wydf.getOrderTime())
					.append("&appid=").append(wydf.getAppInfo())
					.append("&status=").append(wydf.getStatus());
					url = url + "?" + sb.toString();
					String content="";
						try{
							 content = HttpClientUtil.simpleVisitUrl(url);
						}catch (Exception ee){
							continue;
						}
						
						if (content != null && "ok".equals(content.toLowerCase())) {
							wydf.setSyncStatus(1);	
							SyncWydFExample e = new SyncWydFExample();
							e.createCriteria().andPhoneNumEqualTo(wydf.getPhoneNum()).andOrderTimeEqualTo(wydf.getOrderTime());
							syncWydMapper.updateByExampleSelective(wydf, e);
						}else{
							wydf.setSyncStatus(-1);	
							SyncWydFExample e = new SyncWydFExample();
							e.createCriteria().andPhoneNumEqualTo(wydf.getPhoneNum()).andOrderTimeEqualTo(wydf.getOrderTime());
							syncWydMapper.updateByExampleSelective(wydf, e);
						}
				}			
			}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
}
