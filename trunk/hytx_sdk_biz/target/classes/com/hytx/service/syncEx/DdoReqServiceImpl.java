package com.hytx.service.syncEx;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.constance.ResourceUtil;
import com.hytx.dao.sync.ori.SyncDdoMapper;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Dict;
import com.hytx.model.sync.SyncDdo;
import com.hytx.model.sync.SyncDdoExample;
import com.hytx.model.sync.Tdxlt;
import com.hytx.service.baseConf.IChannelAppService;
import com.hytx.service.baseConf.IDictService;
import com.hytx.util.HttpClientUtil;

@Service("ddoReqServiceImpl")
public class DdoReqServiceImpl implements DdoreqService {
	@Autowired
	private SyncDdoMapper ddoreqMapper;
	@Autowired
	private IChannelAppService channelAppService;
	@Autowired
	private IDictService dictService;
	private ChannelApp channelApp;
	private Random random = new Random();

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addDdoreq(SyncDdo ddo) {
		try {
			// TODO Auto-generated method stub
			Dict dict = dictService.selectActiviteDictByKey(ddo.getPayCode());
			int channelappId = Integer.parseInt(dict.getVal());
			ddo.setChannelAppId(channelappId + "");
			channelApp = channelAppService.selectByPrimaryKey(channelappId);
			ddo.setCoopid(channelApp.getChannelId() + "");
			Integer reducePercent = channelApp.getReducePercent();
			ddo.setReduceStatus(BigDecimal.valueOf(0));
			if (reducePercent != null && ddo.getStat().equals("0")) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					ddo.setReduceStatus(BigDecimal.valueOf(1));
				}
			}
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}

	@Override
	public void syncToDdoreq(final SyncDdo ddo) {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			@Override
			public void run() {

				// 根据指令内容确定是哪一家下游渠道包
				try {

					if (channelApp != null) {
						String url = channelApp.getSyncUrl();
						if (StringUtils.isBlank(url)) {
							return;
						}
						StringBuilder sb = new StringBuilder();
						sb.append("tradeId=")
								.append(ddo.getUuid())
								.append("&paycode=")
								.append(ddo.getPayCode())
								.append("&chargeTime=")
								.append(URLEncoder.encode(ddo.getMotime(),
										"UTF-8")).append("&exData=")
								.append(ddo.getLinkid()).append("&status=")
								.append(ddo.getStat()).append("&SubsId=")
								.append(ddo.getTelno());
						url = url + "?" + sb.toString();
						String content = HttpClientUtil.simpleVisitUrl(url);
						if (content != null && "ok".equals(content)) {
							ddo.setSyncStatus(BigDecimal.valueOf(1));
							SyncDdoExample sde = new SyncDdoExample();
							sde.createCriteria()
									.andLinkidEqualTo(ddo.getLinkid())
									.andUuidEqualTo(ddo.getUuid());
							ddoreqMapper.updateByExampleSelective(ddo, sde);
						} else {
							ddo.setSyncStatus(BigDecimal.valueOf(-1));
							SyncDdoExample sde = new SyncDdoExample();
							sde.createCriteria()
									.andLinkidEqualTo(ddo.getLinkid())
									.andUuidEqualTo(ddo.getUuid());
							ddoreqMapper.updateByExampleSelective(ddo, sde);
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
