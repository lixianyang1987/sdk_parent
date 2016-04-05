package com.hytx.service.syncEx;

import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.syncEx.ori.SyncXlMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.syncEx.SyncXl;
import com.hytx.model.syncEx.SyncXlExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.util.HttpClientUtil;
@Service
public class SyncXlServiceImpl implements ISyncXlService {
	@Autowired
	private SyncXlMapper syncXlMapper;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IDictService dictService;
	private ChannelApp channelApp;
	private Random random = new Random();

	@Override
	public int addXl(SyncXl syncXl) {
		// TODO Auto-generated method stub
		try {

			String type = "";
			if (syncXl.getChannel().equals("CTCC")) {
				type = "tykj_";
			} else if (syncXl.getChannel().equals("CMCC")) {
				type = "ddo2_";
			}
			Dict dict = dictService.selectActiviteDictByKey(type
					+ syncXl.getFee());
			channelApp = channelAppService.selectByPrimaryKey(Integer
					.parseInt(dict.getVal()));
			syncXl.setChannelAppId(Integer.parseInt(dict.getVal()));
			Integer reducePercent = channelApp.getReducePercent();
			syncXl.setReduceStatus(0);
			if (reducePercent != null && syncXl.getStatus().equals("success")) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					syncXl.setReduceStatus(1);
				}
			}
		} catch (Exception e) {
				return -1;
		}
		return syncXlMapper.insertSelective(syncXl);
	}

	@Override
	public void syncToXl( final SyncXl syncXl) {
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
				sb.append("{")
				.append("\"").append("mchid").append("\":")
				.append("\"").append(syncXl.getMchid()).append("\"").append(",")
				.append("\"").append("phone").append("\":")
				.append("\"").append(syncXl.getPhone()).append("\"").append(",")
				.append("\"").append("fee").append("\":")
				.append(syncXl.getFee()).append(",")
				.append("\"").append("pdorderid").append("\":")
				.append("\"").append(syncXl.getPdorderid()).append("\"").append(",")
				.append("\"").append("orderid").append("\":")
				.append("\"").append(syncXl.getOrderid()).append("\"").append(",")
				.append("\"").append("unit").append("\":")
				.append("\"").append(syncXl.getUnit()).append("\"").append(",")
				.append("\"").append("status").append("\":")
				.append("\"").append(syncXl.getStatus()).append("\"").append(",")
				.append("\"").append("channel").append("\":")
				.append("\"").append(syncXl.getChannel()).append("\"").append(",")
				.append("\"").append("paychannel").append("\":")
				.append("\"").append(syncXl.getPaychannel()).append("\"").append(",")
				.append("\"").append("sign").append("\":")
				.append("\"").append(syncXl.getSign()).append("\"")
				.append("}");
					String data =sb.toString();		
					System.out.println(data);
					String content = HttpClientUtil.postJsonData(url,data);
					if (content != null && ("ok".equals(content)||"OK".equals(content))) {
						syncXl.setSyncStatus(1);						
						syncXlMapper.updateByPrimaryKeySelective(syncXl);
					}else{
						syncXl.setSyncStatus(-1);						
						syncXlMapper.updateByPrimaryKeySelective(syncXl);
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
	public void xlAllSync() {
		// TODO Auto-generated method stub		
		Thread t = new Thread() {
			@Override
			public void run() {

				// 根据指令内容确定是哪一家下游渠道包
				try {
					
				SyncXlExample e = new SyncXlExample();
				e.createCriteria().andReduceStatusEqualTo(0).andSyncStatusEqualTo(-1);
				List<SyncXl> syncxls=syncXlMapper.selectByExample(e);
				for (SyncXl syncXl : syncxls) {
					StringBuilder sb = new StringBuilder();
					sb.append("{")
						.append("\"").append("mchid").append("\":")
				.append("\"").append(syncXl.getMchid()).append("\"").append(",")
				.append("\"").append("phone").append("\":")
				.append("\"").append(syncXl.getPhone()).append("\"").append(",")
				.append("\"").append("fee").append("\":")
				.append(syncXl.getFee()).append(",")
				.append("\"").append("pdorderid").append("\":")
				.append("\"").append(syncXl.getPdorderid()).append("\"").append(",")
				.append("\"").append("orderid").append("\":")
				.append("\"").append(syncXl.getOrderid()).append("\"").append(",")
				.append("\"").append("unit").append("\":")
				.append("\"").append(syncXl.getUnit()).append("\"").append(",")
				.append("\"").append("status").append("\":")
				.append("\"").append(syncXl.getStatus()).append("\"").append(",")
				.append("\"").append("channel").append("\":")
				.append("\"").append(syncXl.getChannel()).append("\"").append(",")
				.append("\"").append("paychannel").append("\":")
				.append("\"").append(syncXl.getPaychannel()).append("\"").append(",")
				.append("\"").append("sign").append("\":")
				.append("\"").append(syncXl.getSign()).append("\"")
				.append("}");
					ChannelApp channel =channelAppService.selectByPrimaryKey(syncXl.getChannelAppId());							
						String content = HttpClientUtil.postJsonData(channel.getSyncUrl(),sb.toString());
						if (content != null && ("ok".equals(content)||"OK".equals(content))) {
							syncXl.setSyncStatus(1);						
							syncXlMapper.updateByPrimaryKeySelective(syncXl);
						}else{
							syncXl.setSyncStatus(-1);						
							syncXlMapper.updateByPrimaryKeySelective(syncXl);
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
