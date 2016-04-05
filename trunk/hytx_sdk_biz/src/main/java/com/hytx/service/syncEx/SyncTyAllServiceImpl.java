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
import com.hytx.model.syncEx.SyncTyAll;
import com.hytx.model.syncEx.SyncTyAllExample;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.XmlRootUtil;
import com.hytx.util.root;

@Service("syncTyAllServiceImpl")
public class SyncTyAllServiceImpl implements ISyncTyAllService {
	@Autowired
	private SyncByLogMapper byLogMapper;
	@Autowired
	private SyncTyAllMapper tyAllMapper;
	@Autowired
	private IChannelAppService channelAppService;

	private ChannelApp channelApp;
	private Random random = new Random();

	@Override
	public int addTyAll(SyncTyAll synctyall) {
		// TODO Auto-generated method stub
		synctyall.setCreatetime(new Date());
		channelApp = channelAppService.selectByPrimaryKey(synctyall
				.getChannelAppId());
		Integer reducePercent = channelApp.getReducePercent();
		synctyall.setCoopid(channelApp.getChannelId());
		synctyall.setReduceStatus(0);
		// 扣量处理
		if (reducePercent != null && synctyall.getStatus().equals("DELIVRD")) {
			int n = random.nextInt(100000000) % 100;
			if (n < reducePercent) {
				synctyall.setReduceStatus(1);
			}
		}
		return tyAllMapper.insertSelective(synctyall);

	}

	@Override
	public int UpdateTyAll(SyncTyAll synctyall, SyncTyAllExample example) {
		// TODO Auto-generated method stub
		
		if (synctyall.getMobile().length() == 11) {
			root r = XmlRootUtil.getroot(synctyall.getMobile());
			synctyall.setProvince(r.getProvince());
		}
		return tyAllMapper.updateByExampleSelective(synctyall, example);
	}

	@Override
	public void syncToTyAll(final SyncTyAll synctyall) {
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
								.append(synctyall.getMobile())
								.append("&linkid=")
								.append(synctyall.getLinkid())
								.append("&feecode=")
								.append(synctyall.getPayFee())
								.append("&status=")
								.append(synctyall.getStatus())
								.append("&reporttime=")
								.append(URLEncoder.encode(dateFormat
										.format(synctyall.getCreatetime()),
										"UTF-8")).append("&appid=")
								.append(synctyall.getAppId()).append("&momsg=")
								.append(synctyall.getMsg())
								.append("&content=")
								.append(synctyall.getErrorContent())
								.append("&orderid=")
								.append(synctyall.getOrderid())
								.append("&spnumber=")
								.append(synctyall.getPort())
								.append("&paytime=")
								// 增加电信包月业务计费时间
								.append(synctyall.getReserveOne())
								//透传参数
								.append("&cpparam=")
								.append(synctyall.getReserveTwo());

						url = url + "?" + sb.toString().replace("#", "%23");
						String content = HttpClientUtil.simpleVisitUrl(url);
						content = content.trim().toUpperCase();
						if (content != null
								&& ("ok".equals(content) || "OK"
										.equals(content))) {
							synctyall.setSyncStatus(1);
							tyAllMapper.updateByPrimaryKeySelective(synctyall);
						} else {
							synctyall.setSyncStatus(-1);
							tyAllMapper.updateByPrimaryKeySelective(synctyall);
						}
					}
				} catch (Exception e) {
					synctyall.setSyncStatus(-1);
					tyAllMapper.updateByPrimaryKeySelective(synctyall);
				}
			}
		};
		t.start();
	}

	/**
	 * 用于给下游渠道补发数据
	 */
	@Override
	public void SyncAll() {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			SyncTyAllExample example = new SyncTyAllExample();
			example.createCriteria().andSyncStatusEqualTo(-1)
					.andReduceStatusEqualTo(0);
			List<SyncTyAll> tdxltList = tyAllMapper.selectByExample(example);
			for (SyncTyAll synctyall : tdxltList) {
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
						content = content.trim().toUpperCase();
					} catch (Exception ee) {
						synctyall.setSyncStatus(-1);
						tyAllMapper.updateByPrimaryKeySelective(synctyall);
						continue;
					}
					if (content != null
							&& ("ok".equals(content) || "OK"
									.equals(content))) {
						synctyall.setSyncStatus(1);
						tyAllMapper.updateByPrimaryKeySelective(synctyall);
					} else {
						synctyall.setSyncStatus(-1);
						tyAllMapper.updateByPrimaryKeySelective(synctyall);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SyncTyAll SelectSyncTyAll(SyncTyAllExample sk) {
		// TODO Auto-generated method stub

		return tyAllMapper.selectByExample(sk).get(0);
	}

}
