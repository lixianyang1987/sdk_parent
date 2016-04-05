package com.hytx.service.syncEx;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.ResourceUtil;
import com.hytx.dao.sync.ori.TdxltMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.sync.Tdxlt;
import com.hytx.model.sync.TdxltExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.util.HttpClientUtil;

@Service("syncDxltServiceImpl")
public class SyncDxltServiceImpl implements ISyncDxltService {
	@Autowired
	private TdxltMapper tdxltMapper;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IDictService dictService;
	private ChannelApp channelApp;
	private Random random = new Random();

	@Override
	public int addDxlt(Tdxlt dxlt) {
		// TODO Auto-generated method stub
		dxlt.setCreatetime(new Date());
		Dict dict=dictService.selectActiviteDictByKey("dxlt_"+dxlt.getMomsg());
		int channelappId = Integer.parseInt(dict.getVal());
		dxlt.setChannelAppId(channelappId);
		channelApp = channelAppService.selectByPrimaryKey(channelappId);
		dxlt.setCoopid(channelApp.getChannelId());

		Integer reducePercent = channelApp.getReducePercent();
		dxlt.setReduceStatus(0);
		if (reducePercent != null && dxlt.getStat().equals("DELIVRD")) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				dxlt.setReduceStatus(1);
			}
		}
		return tdxltMapper.insertSelective(dxlt);
	}

	@Override
	public void syncToDxlt(final Tdxlt dxlt) {
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
				sb.append("msgtype=").append(dxlt.getMsgtype())
				.append("&usernumber=").append(dxlt.getUsernumber())
				.append("&linkid=").append(dxlt.getLinkid())
				.append("&feecode=").append(dxlt.getFeecode())
				.append("&stat=").append(dxlt.getStat())
				.append("&reporttime=").append(URLEncoder.encode(dxlt.getReporttime(), "UTF-8"))
				.append("&gateway=").append(dxlt.getGateway())
				.append("&momsg=").append(dxlt.getMomsg())
				.append("&spnumber=").append(dxlt.getSpnumber())
				.append("&productid=").append(dxlt.getProductid())
				.append("&serviceid=").append(dxlt.getServiceid());
				url = url + "?" + sb.toString();								
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && ("ok".equals(content.trim())||"OK".equals(content.trim()))) {
						dxlt.setSyncStatus(1);						
						tdxltMapper.updateByPrimaryKeySelective(dxlt);
					}else{
						dxlt.setSyncStatus(-1);						
						tdxltMapper.updateByPrimaryKeySelective(dxlt);
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
	public void dxltSync() {
		// TODO Auto-generated method stub
		try {
			TdxltExample example = new TdxltExample();
			example.createCriteria().andSyncStatusEqualTo(-1).andReduceStatusEqualTo(0);
			List<Tdxlt>	tdxltList=tdxltMapper.selectByExample(example);
			for (Tdxlt dxlt : tdxltList) {
				if(dxlt.getChannelAppId()!=null){
					channelApp=channelAppService.selectByPrimaryKey(dxlt.getChannelAppId());
					String url = channelApp.getSyncUrl();				
					if (StringUtils.isBlank(url)
							) {
						continue;
					}
					StringBuilder sb = new StringBuilder();
					sb.append("msgtype=").append(dxlt.getMsgtype())
					.append("&usernumber=").append(dxlt.getUsernumber())
					.append("&linkid=").append(dxlt.getLinkid())
					.append("&feecode=").append(dxlt.getFeecode())
					.append("&stat=").append(dxlt.getStat())
					.append("&reporttime=").append(URLEncoder.encode(dxlt.getReporttime(), "UTF-8"))
					.append("&gateway=").append(dxlt.getGateway())
					.append("&momsg=").append(dxlt.getMomsg())
					.append("&spnumber=").append(dxlt.getSpnumber())
					.append("&productid=").append(dxlt.getProductid())
					.append("&serviceid=").append(dxlt.getServiceid());
					url = url + "?" + sb.toString();
					String content="";
						try{
							 content = HttpClientUtil.simpleVisitUrl(url);
						}catch (Exception ee){
							continue;
						}
						
						if (content != null && ("ok".equals(content.trim())||"OK".equals(content.trim()))) {
							dxlt.setSyncStatus(1);						
							tdxltMapper.updateByPrimaryKeySelective(dxlt);
						}else{
							dxlt.setSyncStatus(-1);						
							tdxltMapper.updateByPrimaryKeySelective(dxlt);
						}
				}			
			}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}