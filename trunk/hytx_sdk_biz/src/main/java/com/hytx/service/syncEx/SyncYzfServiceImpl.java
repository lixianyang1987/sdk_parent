package com.hytx.service.syncEx;


import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.syncEx.ori.SyncYzfMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;

import com.hytx.model.syncEx.SyncYzf;
import com.hytx.model.syncEx.SyncYzfExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.util.HttpClientUtil;
@Service("syncYzfServiceImpl")
public class SyncYzfServiceImpl implements ISyncYzfService {
	@Autowired
	private SyncYzfMapper syncYzfMapper;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IDictService dictService;
	private ChannelApp channelApp;
	private Random random = new Random();
	@Override
	public int addYzf(SyncYzf yzf) {		
		try{
			
			Dict dict=dictService.selectActiviteDictByKey("yzf_key_"+yzf.getFee());
			int channelappId = Integer.parseInt(dict.getVal());
			yzf.setChannelAppId(channelappId);
			channelApp = channelAppService.selectByPrimaryKey(channelappId);
			yzf.setCoopid(channelApp.getChannelId());
			Integer reducePercent = channelApp.getReducePercent();
			yzf.setReduceStatus(0);
			if (reducePercent != null ) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					yzf.setReduceStatus(1);
				}
			}			
			syncYzfMapper.insertSelective(yzf);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}

	@Override
	public void syncToYzf(final SyncYzf yzf) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Thread t = new Thread() {
					@Override
					public void run() {

						// 根据指令内容确定是哪一家下游渠道包
						try {
							channelApp=channelAppService.selectByPrimaryKey(yzf.getChannelAppId());
						if(channelApp!=null){	
						String url = channelApp.getSyncUrl();				
						if (StringUtils.isBlank(url)
								) {
							return;
						}	
						StringBuilder sb = new StringBuilder();

						sb.append("order_id=").append(yzf.getOrderId())
						.append("&fee=").append(yzf.getFee())
						.append("&ext=").append(yzf.getExt())
						.append("&time=").append(yzf.getTime())
						.append("&spnumber=").append(yzf.getSpnumber())
						.append("&msg=").append(yzf.getMsg())
						.append("&mobile=").append(yzf.getMobile());
						url = url + "?" + sb.toString();								
							String content = HttpClientUtil.simpleVisitUrl(url);
							if (content != null && ("ok".equals(content)||"OK".equals(content))) {
								yzf.setSyncStatus(1);		
								syncYzfMapper.updateByPrimaryKeySelective(yzf);
								
							}else{
								yzf.setSyncStatus(-1);							
								
								syncYzfMapper.updateByPrimaryKeySelective(yzf);
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
	public void yzfallSync() {
		// TODO Auto-generated method stub
		try {
			SyncYzfExample example = new SyncYzfExample();
			example.createCriteria().andSyncStatusEqualTo(-1).andReduceStatusEqualTo(0);
			List<SyncYzf>	tdxltList=syncYzfMapper.selectByExample(example);
			for (SyncYzf yzf : tdxltList) {
				if(yzf.getChannelAppId()!=null){
					channelApp=channelAppService.selectByPrimaryKey(yzf.getChannelAppId());
					String url = channelApp.getSyncUrl();				
					if (StringUtils.isBlank(url)
							) {
						continue;
					}
					StringBuilder sb = new StringBuilder();
					sb.append("order_id=").append(yzf.getOrderId())
					.append("&fee=").append(yzf.getFee())
					.append("&ext=").append(yzf.getExt())
					.append("&time=").append(yzf.getTime())
					.append("&spnumber=").append(yzf.getSpnumber())
					.append("&msg=").append(yzf.getMsg())
					.append("&mobile=").append(yzf.getMobile());
					url = url + "?" + sb.toString();
					String content="";
						try{
							 content = HttpClientUtil.simpleVisitUrl(url);
						}catch (Exception ee){
							continue;
						}						
						if (content != null && ("ok".equals(content)||"OK".equals(content))) {
							yzf.setSyncStatus(1);		
							syncYzfMapper.updateByPrimaryKeySelective(yzf);
							
						}else{
							yzf.setSyncStatus(-1);							
							syncYzfMapper.updateByPrimaryKeySelective(yzf);
						}
				}			
			}
			} catch (Exception e){
				e.printStackTrace();
			}
		}

	@Override
	public int addMdo(SyncYzf yzf) {
		// TODO Auto-generated method stub
		try {

			Dict dict = dictService.selectActiviteDictByKey("mdo_key_"
					+ yzf.getFee());
			int channelappId = Integer.parseInt(dict.getVal());
			yzf.setChannelAppId(channelappId);
			channelApp = channelAppService.selectByPrimaryKey(channelappId);
			yzf.setCoopid(channelApp.getChannelId());
			Integer reducePercent = channelApp.getReducePercent();
			yzf.setReduceStatus(0);
			if (reducePercent != null) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					yzf.setReduceStatus(1);
				}
			}
			syncYzfMapper.insertSelective(yzf);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public void syncToMdo(final SyncYzf ysf) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			@Override
			public void run() {

				// 根据指令内容确定是哪一家下游渠道包
				try {
					channelApp=channelAppService.selectByPrimaryKey(ysf.getChannelAppId());
				if(channelApp!=null){	
				String url = channelApp.getSyncUrl();				
				if (StringUtils.isBlank(url)
						) {
					return;
				}	
				StringBuilder sb = new StringBuilder();

				sb.append("order_id=").append(ysf.getOrderId())
				.append("&fee=").append(ysf.getFee())
				.append("&ext=").append(ysf.getExt())
				.append("&time=").append(ysf.getTime())
				.append("&spnumber=").append(ysf.getSpnumber())
				.append("&msg=").append(ysf.getMsg())
				.append("&mobile=").append(ysf.getMobile());
				url = url + "?" + sb.toString();								
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && ("ok".equals(content)||"OK".equals(content))) {
						ysf.setSyncStatus(1);		
						syncYzfMapper.updateByPrimaryKeySelective(ysf);
						
					}else{
						ysf.setSyncStatus(-1);							
						
						syncYzfMapper.updateByPrimaryKeySelective(ysf);
					}
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}
	
}
