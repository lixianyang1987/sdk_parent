package com.hytx.service.sync;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ex.SyncQsxxbyMapperEx;
import com.hytx.dao.sync.ori.SyncQsxxMapper;
import com.hytx.dao.sync.ori.SyncQsxxbyMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.sync.SyncQsxx;
import com.hytx.model.sync.SyncQsxxExample;
import com.hytx.model.sync.SyncQsxxby;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.HttpClientUtil;

@Service("syncQsxxServiceImpl")
public class SyncQsxxServiceImpl implements ISyncQsxxService {
	@Autowired
	private SyncQsxxMapper syncQsxxMapper;
	@Autowired
	private SyncQsxxbyMapper syncQsxxbyMapper;
	@Autowired
	private SyncQsxxbyMapperEx syncQsxxbyMapperEx;
	@Autowired
	private IChannelAppService channelAppService;
	private Random random = new Random();
	private final String MAX_END_TIME = "21150101000101";
	private final Integer CHANNEL_APP_ID = 380;// 渠道包id
	private final Integer CHANNEL_APP_ID1 = 421;// 5渠道包id
	private final Integer CHANNEL_APP_ID_XFWL = 420;// 雄方网络渠道包id
	private final String OP_VOD_YLXF = "49";// 全盛_A_娱乐先锋 电信点播指令

	@Override
	public int insertSyncQsxx(SyncQsxx syncqsxx) {
		// TODO Auto-generated method stub
		syncqsxx.setCreatetime(new Date());
		syncQsxxMapper.insert(syncqsxx);
		return 1;
	}

	@Override
	public int insertSyncQsxxby(SyncQsxxby syncqsxxby) {
		/*2为订购，3为退订*/
		if (syncqsxxby.getOperateType().equals(2)) {
			/*检查是否扣量*/
			ChannelApp channelApp = channelAppService
					.selectByPrimaryKey(CHANNEL_APP_ID);
			Integer reducePercent = channelApp.getReducePercent();
			if (reducePercent != null) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					syncqsxxby.setReduceStatus(1);
				}
			}
			try {
				syncqsxxby.setBeginTime(DateUtils.parseDate(
						syncqsxxby.getModatReceive(), "yyyyMMddHHmmss"));
				syncqsxxby.setEndTime(DateUtils.parseDate(MAX_END_TIME,
						"yyyyMMddHHmmss"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (syncqsxxby.getOperateType().equals(3)) {
			SyncQsxxby lastOrderRecord = selectLastOrderRecord(syncqsxxby
					.getPhone());
			if (lastOrderRecord != null
					&& lastOrderRecord.getEndTime().getTime() >= System
							.currentTimeMillis()) {
				syncqsxxby.setReduceStatus(lastOrderRecord.getReduceStatus());
				syncqsxxby.setBeginTime(lastOrderRecord.getBeginTime());
				try {
					syncqsxxby.setEndTime(DateUtils.parseDate(
							syncqsxxby.getModatReceive(), "yyyyMMddHHmmss"));
					lastOrderRecord.setEndTime(syncqsxxby.getEndTime());
					syncQsxxbyMapper.updateByPrimaryKey(lastOrderRecord);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		if (syncqsxxby.getReduceStatus().equals(0)) {
			// 不扣量则进行同步,始始值设置成0表示示同步成功
			syncqsxxby.setSyncStatus(0);
		}
		return syncQsxxbyMapper.insertSelective(syncqsxxby);
	}

	public SyncQsxxby selectLastOrderRecord(Long mobile) {
		return syncQsxxbyMapperEx.selectLastOrderRecord(mobile);
	}

	@Override
	public void syncQsxxbyToOhers(final SyncQsxxby syncqsxxby,
			final String queryString) {
		Thread t = new Thread() {
			@Override
			public void run() {
				ChannelApp channelApp = channelAppService
						.selectByPrimaryKey(CHANNEL_APP_ID);
				String url = channelApp.getSyncUrl();
				if (StringUtils.isBlank(url)
						|| StringUtils.isEmpty(queryString)) {
					return;
				}
				url = url + "?" + queryString;
				try {
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && "OK".equals(content)) {
						syncqsxxby.setSyncStatus(1);
						syncQsxxbyMapper
								.updateByPrimaryKeySelective(syncqsxxby);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	@Override
	public void syncQsxxToOhers(final SyncQsxx syncqsxx,
			final String queryString) {
		Thread t = new Thread() {
			@Override
			public void run() {
				// 根据指令内容确定是哪一家下游渠道包
				ChannelApp channelApp = null;
				if (OP_VOD_YLXF.equals(syncqsxx.getMsgcontent())) {
					channelApp = channelAppService
							.selectByPrimaryKey(CHANNEL_APP_ID1);
				} else {
					channelApp = channelAppService
							.selectByPrimaryKey(CHANNEL_APP_ID_XFWL);
				}
				String url = channelApp.getSyncUrl();
				if (StringUtils.isBlank(url)
						|| StringUtils.isEmpty(queryString)) {
					return;
				}
				url = url + "?" + queryString;
				try {
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && "OK".equals(content)) {
						syncqsxx.setSyncStatus(1);
						SyncQsxxExample e = new SyncQsxxExample();
						e.createCriteria().andLinkidEqualTo(
								syncqsxx.getLinkid());
						syncQsxxMapper.updateByExampleSelective(syncqsxx, e);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	@Override
	public int updateSyncQsxx(SyncQsxx syncqsxx, SyncQsxxExample e) {
		// TODO Auto-generated method stub
		// 根据指令内容确定是哪一家下游渠道包
		ChannelApp channelApp = null;
		if (OP_VOD_YLXF.equals(syncqsxx.getMsgcontent())) {
			channelApp = channelAppService.selectByPrimaryKey(CHANNEL_APP_ID1);
		} else {
			channelApp = channelAppService
					.selectByPrimaryKey(CHANNEL_APP_ID_XFWL);
		}
		Integer reducePercent = channelApp.getReducePercent();
		syncqsxx.setReduceStatus(0);
		if (reducePercent != null
				&& syncqsxx.getStatus().equals("DeliveredToTerminal")) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				syncqsxx.setReduceStatus(1);
			}
		}
		return syncQsxxMapper.updateByExampleSelective(syncqsxx, e);
	}
	
	public SyncQsxx Getqsxx(String LinkId){
		 SyncQsxxExample sy=new SyncQsxxExample();
		 sy.createCriteria().andLinkidEqualTo(LinkId);
		return syncQsxxMapper.selectByExample(sy).get(0);
		
	}

}
