package com.hytx.service.sync;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.sync.ori.SyncMsMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.sync.SyncMs;
import com.hytx.model.sync.SyncMsExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.util.HttpClientUtil;

@Service("syncMsServiceImpl")
public class SyncMsServiceImpl implements ISyncMsService {
	@Autowired
	private SyncMsMapper syncMsMapper;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IDictService dictService;
	private Integer CHANNEL_APP_ID = 0;// 渠道包id
	private Random random = new Random();
	private SyncMs ms = null;
	private ChannelApp channelApp = null;

	@Override
	public int insertSyncMs(SyncMs syncMs) {
		// TODO Auto-generated method stub
		return syncMsMapper.insertSelective(syncMs);
	}

	@Override
	public int updateSyncMs(SyncMs syncMs) {
		// TODO Auto-generated method stub
		Dict d = dictService
				.selectActiviteDictByKey("jl_" + syncMs.getMoCode());
		CHANNEL_APP_ID = Integer.parseInt(d.getVal());
		channelApp = channelAppService.selectByPrimaryKey(CHANNEL_APP_ID);
		syncMs.setCoopid(channelApp.getChannelId());
		Integer reducePercent = channelApp.getReducePercent();
		syncMs.setReduceStatus(0);
		syncMs.setChannelAppId(CHANNEL_APP_ID);
		if (reducePercent != null && syncMs.getStatus().equals("DELIVRD")) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				syncMs.setReduceStatus(1);
			}
		}
		return syncMsMapper.updateByPrimaryKeySelective(syncMs);
	}

	@Override
	public SyncMs GetMs(String LinkId) {
		// TODO Auto-generated method stub
		return syncMsMapper.selectByPrimaryKey(LinkId);
	}

	@Override
	public void syncQsxxToMs(SyncMs syncMs) {
		// TODO Auto-generated method stub
		ms = syncMs;
		Thread t = new Thread() {
			@Override
			public void run() {
				// 根据指令内容确定是哪一家下游渠道包
				try {
					String url = channelApp.getSyncUrl();
					String[] urls = url.split("&");
					url = urls[0];
					String url2 = urls[1];
					if (StringUtils.isBlank(url)
							|| StringUtils.isEmpty(ms.getMoContent())) {
						return;
					}
					System.out.println(1);
					url = url + "?" + ms.getMoContent();
					url2 = url2 + "?" + ms.getMrContent();
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && "OK".equals(content)) {
						String content2 = HttpClientUtil.simpleVisitUrl(url2);
						if (content2 != null && "OK".equals(content2)) {
							ms.setSyncStatus(1);
							syncMsMapper.updateByPrimaryKeySelective(ms);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	public void syncAllMs() {
		SyncMsExample example = new SyncMsExample();
		example.createCriteria().andSyncStatusEqualTo(-1);
		List<SyncMs> list = syncMsMapper.selectByExample(example);
		for (SyncMs syncMs : list) {
			channelApp = channelAppService.selectByPrimaryKey(syncMs
					.getChannelAppId());
			syncQsxxToMs(syncMs);
		}
	}
}
