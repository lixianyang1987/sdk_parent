package com.hytx.service.sync;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.ResourceUtil;
import com.hytx.dao.sync.ori.SyncZjhyMapper;
import com.hytx.dao.sync.ori.SyncZqrdMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.sync.SyncMs;
import com.hytx.model.sync.SyncZqrd;
import com.hytx.model.sync.SyncZqrdExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.HttpClientUtil;
@Service("syncZqrdServiceImpl")
public class SyncZqrdServiceImpl implements ISyncZqrdService {
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private SyncZqrdMapper syncZqrdMapper;
	
	private Timer timer;
	
	private int CHANNEL_APP_ID;
	
	private ChannelApp channelApp;
	
	private Random random = new Random();
	@Override
	public int insertSyncZqrd(SyncZqrd syncZqrd) {
		// TODO Auto-generated method stub
		syncZqrd.setCreatetime(new Date());
		if(syncZqrd.getContent().equals("168")){
			CHANNEL_APP_ID=Integer.parseInt(ResourceUtil.getZqrdChannelId());
		}else if(syncZqrd.getContent().equals("9812")){
			CHANNEL_APP_ID=Integer.parseInt(ResourceUtil.getZqrdChannelIdTo());
		}else if(syncZqrd.getContent().equals("27481")){
			CHANNEL_APP_ID=Integer.parseInt(ResourceUtil.getZqrdChannelIdFo());
		}else if(syncZqrd.getContent().equals("1612")){
			CHANNEL_APP_ID=Integer.parseInt(ResourceUtil.getZqrdChannelIdTh());
		}else{
			return -2;
		}
		
		channelApp=channelAppService.selectByPrimaryKey(CHANNEL_APP_ID);
		syncZqrd.setCoopid(channelApp.getChannelId());
		syncZqrd.setChannelappid(CHANNEL_APP_ID);
		Integer reducePercent = channelApp.getReducePercent();
		syncZqrd.setReduceStatus(0);
		if (reducePercent != null
				&& syncZqrd.getState().equals("DELIVRD")) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				syncZqrd.setReduceStatus(1);
			}
		}		
		return syncZqrdMapper.insertSelective(syncZqrd);
	}

	@Override
	public int updateSyncZqrd(SyncZqrd syncZqrd) {
		// TODO Auto-generated method stub
		return syncZqrdMapper.updateByPrimaryKey(syncZqrd);
	}

	@Override
	public SyncZqrd GetSyncZqrd(String LinkId) {
		// TODO Auto-generated method stub
		return syncZqrdMapper.selectByPrimaryKey(LinkId);
	}

	@Override
	public void syncToZqrd(final SyncZqrd syncMs) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			@Override
			public void run() {
				
				// 根据指令内容确定是哪一家下游渠道包				
				try {
				if(channelApp!=null){	
				String url = channelApp.getSyncUrl();				
				if (StringUtils.isBlank(url)
						|| StringUtils.isEmpty(syncMs.getReqContent())) {
					return;
				}			
				url = url + "?" + syncMs.getReqContent();								
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && "ok".equals(content)) {
						syncMs.setSyncStatus(1);						
						syncZqrdMapper.updateByPrimaryKey(syncMs);
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
	public void syncallZqrd() {
		// TODO Auto-generated method stub
		try {
		SyncZqrdExample exa = new SyncZqrdExample();
		exa.createCriteria().andSyncStatusEqualTo(-1).andReduceStatusEqualTo(0);
		List<SyncZqrd> syncZqrdList = syncZqrdMapper.selectByExample(exa);
		for (SyncZqrd syncZqrd : syncZqrdList) {			
			ChannelApp channelap=channelAppService.selectByPrimaryKey(syncZqrd.getChannelappid());
			if(channelap!=null){
				String url = channelap.getSyncUrl();
				url = url + "?" + syncZqrd.getReqContent();								
				String content = HttpClientUtil.simpleVisitUrl(url);
				if (content != null && "ok".equals(content)) {
					syncZqrd.setSyncStatus(1);						
					syncZqrdMapper.updateByPrimaryKeySelective(syncZqrd);
				}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}
