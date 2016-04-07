package com.hytx.service.syncEx;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hytx.constance.ResourceUtil;
import com.hytx.dao.sync.ori.SyncProvinceZjhyMapper;
import com.hytx.dao.sync.ori.TsyskmmMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.sync.SyncProvinceZjhy;
import com.hytx.model.sync.Tsyskmm;
import com.hytx.model.sync.TsyskmmExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.HttpClientUtil;
@Service("syncSyskmmServiceImpl")
public class SyncSyskmmServiceImpl implements ISyncSyskmmService {
	@Autowired
	private TsyskmmMapper tsyskmmMapper;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private SyncProvinceZjhyMapper syncProvinceZjhyMapper;
	private ChannelApp channelApp;
	private Random random = new Random();
	private SyncProvinceZjhy syncProvince;
	@Override
	public int addSyncSyskmm(Tsyskmm syskmm) {
		// TODO Auto-generated method stub
		syskmm.setCreatetime(new Date());
		int channelappId=Integer.parseInt(ResourceUtil.getDxltChannelIdTo());
		syskmm.setChannelAppId(channelappId);
		channelApp=channelAppService.selectByPrimaryKey(channelappId);
		syskmm.setCoopid(channelApp.getChannelId());
		if(syskmm.getProvince()!=null){
		syncProvince=syncProvinceZjhyMapper.selectByPrimaryKey(Integer.parseInt(syskmm.getProvince()));
		}else{
			syskmm.setProvince("");
		}
		if(syncProvince!=null){
			syskmm.setProvince(syncProvince.getProvincename());
		}		
		Integer reducePercent = channelApp.getReducePercent();		
		syskmm.setReduceStatus(0);
		if (reducePercent != null) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				syskmm.setReduceStatus(1);
			}
		}
		return tsyskmmMapper.insertSelective(syskmm);
	}
	@Override
	public void syncToSysk(final Tsyskmm tsyskmm) {
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
				sb.append("order_id=").append(tsyskmm.getOrderId())
				.append("&fee=").append(tsyskmm.getFee())
				.append("&ext=").append(tsyskmm.getExt())
				.append("&time=").append(tsyskmm.getTime())
				.append("&province=").append(0);
				url = url + "?" + sb.toString();								
					String content = HttpClientUtil.simpleVisitUrl(url);
					if (content != null && "ok".equals(content)) {
						tsyskmm.setSyncStatus(1);						
						tsyskmmMapper.updateByPrimaryKeySelective(tsyskmm);
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
	public void mmSync() {
		// TODO Auto-generated method stub
		try {
			TsyskmmExample example = new TsyskmmExample();
			example.createCriteria().andSyncStatusEqualTo(-1).andReduceStatusEqualTo(0);
			List<Tsyskmm>	tdxltList=tsyskmmMapper.selectByExample(example);
			for (Tsyskmm tsyskmm : tdxltList) {
				if(tsyskmm.getChannelAppId()!=null){
					channelApp=channelAppService.selectByPrimaryKey(tsyskmm.getChannelAppId());
					String url = channelApp.getSyncUrl();				
					if (StringUtils.isBlank(url)
							) {
						continue;
					}
					StringBuilder sb = new StringBuilder();
					sb.append("order_id=").append(tsyskmm.getOrderId())
					.append("&fee=").append(tsyskmm.getFee())
					.append("&ext=").append(tsyskmm.getExt())
					.append("&time=").append(tsyskmm.getTime())
					.append("&province=").append(0);
					url = url + "?" + sb.toString();
					String content="";
						try{
							 content = HttpClientUtil.simpleVisitUrl(url);
						}catch (Exception ee){
							continue;
						}
						
						if (content != null && "ok".equals(content)) {
							tsyskmm.setSyncStatus(1);						
							tsyskmmMapper.updateByPrimaryKeySelective(tsyskmm);
						}else{
							tsyskmm.setSyncStatus(-1);						
							tsyskmmMapper.updateByPrimaryKeySelective(tsyskmm);
						}
				}	
			}
			
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	
}
