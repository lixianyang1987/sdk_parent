package com.hytx.service.syncEx;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.syncEx.ori.SyncByLogMapper;
import com.hytx.dao.syncEx.ori.SyncTyAllMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.syncEx.SyncByLog;
import com.hytx.model.syncEx.SyncByLogExample;
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.HttpClientUtil;

@Service
public class SyncByLogServiceImpl implements ISyncByLogService {
	@Autowired
	private SyncByLogMapper byLogMapper;
	@Autowired
	private IChannelAppService channelAppService;

	private ChannelApp channelApp;
	private Random random = new Random();

	@Override
	public int addByLog(SyncByLog syncByLog) {
		// TODO Auto-generated method stub
		syncByLog.setCreatetime(new Date());	
		channelApp = channelAppService.selectByPrimaryKey(syncByLog
				.getChannelAppId());
		Integer sysStu=Integer.parseInt(channelApp.getExt());
		if(sysStu==1){
			Integer reducePercent = channelApp.getReducePercent();
			syncByLog.setCoopid(channelApp.getChannelId());
			syncByLog.setReduceStatus(0);
			// 扣量处理
			if (reducePercent != null ) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					syncByLog.setReduceStatus(1);
				}
			}
		}else{
			syncByLog.setReduceStatus(1);
		}
		
		return byLogMapper.insertSelective(syncByLog);
	}

	@Override
	public SyncByLog SelectSyncByLog(SyncByLogExample sk) {
		// TODO Auto-generated method stub

		return byLogMapper.selectByExample(sk).get(0);
	}

	@Override
	public void syncToByLog(final SyncByLog syncByLog) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			@Override
			public void run() {
				// 根据指令内容确定是哪一家下游渠道包
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"yyyyMMddHHmmss");
					if (channelApp != null) {
						String url = channelApp.getSyncUrl();
						if (StringUtils.isBlank(url)) {
							return;
						}
						StringBuilder sb = new StringBuilder();
						sb.append("mobile=")
								.append(syncByLog.getMobile())
								.append("&linkid=")
								.append(syncByLog.getLinkid())
								.append("&feecode=")
								.append(syncByLog.getPayFee())
								.append("&status=")
								.append(syncByLog.getStatus())
								.append("&reporttime=")
								.append(URLEncoder.encode(dateFormat
										.format(syncByLog.getCreatetime()),
										"UTF-8")).append("&appid=")
								.append(syncByLog.getAppId()).append("&momsg=")
								.append(syncByLog.getMsg()).append("&content=")
								.append(syncByLog.getErrorContent())
								.append("&orderid=")
								.append(syncByLog.getOrderid())
								.append("&spnumber=")
								.append(syncByLog.getPort())
								.append("&paytime=") // 增加电信包月业务计费时间
								.append(syncByLog.getReserveOne());
						url = url + "?" + sb.toString().replace("#", "%23");
						String content = HttpClientUtil.simpleVisitUrl(url);
						if (content != null
								&& ("OK".equals(content.toUpperCase()))) {
							syncByLog.setSyncStatus(1);
							byLogMapper.updateByPrimaryKeySelective(syncByLog);
						} else {
							syncByLog.setSyncStatus(-1);
							byLogMapper.updateByPrimaryKeySelective(syncByLog);
						}
					}
				} catch (Exception e) {
					syncByLog.setSyncStatus(-1);
					byLogMapper.updateByPrimaryKeySelective(syncByLog);
				}
			}
		};
		t.start();
	}

	@Override
	public void SyncAll() {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			SyncByLogExample example = new SyncByLogExample();
			example.createCriteria().andSyncStatusEqualTo(-1)
					.andReduceStatusEqualTo(0);
			List<SyncByLog> tdxltList = byLogMapper.selectByExample(example);
			for (SyncByLog synctyall : tdxltList) {
				if (synctyall.getChannelAppId() != null) {
					channelApp = channelAppService.selectByPrimaryKey(synctyall
							.getChannelAppId());
					String url = channelApp.getSyncUrl();
					if (StringUtils.isBlank(url)) {
						continue;
					}
					StringBuilder sb = new StringBuilder();
					sb.append("mobile=")
							.append(synctyall.getMobile())
							.append("&linkid=")
							.append(synctyall.getLinkid())
							.append("&feecode=")
							.append(synctyall.getPayFee())
							.append("&status=")
							.append(synctyall.getStatus())
							.append("&reporttime=")
							.append(URLEncoder.encode(dateFormat
									.format(synctyall.getCreatetime()), "UTF-8"))
							.append("&appid=").append(synctyall.getAppId())
							.append("&momsg=").append(synctyall.getMsg())
							.append("&content=")
							.append(synctyall.getErrorContent())
							.append("&spnumber=").append(synctyall.getPort());
					url = url + "?" + sb.toString().replace("#", "%23");
					String content = "";
					try {
						content = HttpClientUtil.simpleVisitUrl(url);
					} catch (Exception ee) {
						synctyall.setSyncStatus(-1);
						byLogMapper.updateByPrimaryKeySelective(synctyall);
						continue;
					}
					if (content != null && "ok".equals(content)) {
						synctyall.setSyncStatus(1);
						byLogMapper.updateByPrimaryKeySelective(synctyall);
					} else {
						synctyall.setSyncStatus(-1);
						byLogMapper.updateByPrimaryKeySelective(synctyall);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
