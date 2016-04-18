package com.hytx.service.syncEx;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

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
	public int addByLog(SyncByLog syncByLog, String zl) {
		// TODO Auto-generated method stub
		Date date = new Date();
		syncByLog.setCreatetime(date);

		long createSeconds = date.getTime();
		System.out.println(createSeconds);
		syncByLog.setCreateseconds(createSeconds);
		channelApp = channelAppService.selectByPrimaryKey(syncByLog
				.getChannelAppId());
		syncByLog.setAppId(channelApp.getAppId() + "");
		String ext = channelApp.getExt();
		Integer sysStu = 0;
		if (ext != null && !(ext.equals(""))) {
			sysStu = Integer.parseInt(ext);
		}

		if (sysStu == 1) {
			Integer reducePercent = channelApp.getReducePercent();
			syncByLog.setCoopid(channelApp.getChannelId());
			syncByLog.setReduceStatus(0);
			// 扣量处理
			if (reducePercent != null) {
				int n = random.nextInt(100000000) % 100;
				if (n < reducePercent) {
					syncByLog.setReduceStatus(1);
				}
			}
		} else {
			syncByLog.setReduceStatus(1);
		}
		// 判断是否为退订信息
		Boolean tdstatus = false;
		if (syncByLog.getMsg().indexOf("td") > -1) {
			tdstatus = true;
			syncByLog.setExecuteStatus(1);
		}
		// 插入流水表
		byLogMapper.insertSelective(syncByLog);
		// 退订
		if (tdstatus) {
			SyncByLogExample example = new SyncByLogExample();
			example.createCriteria().andMobileEqualTo(syncByLog.getMobile())
					.andExecuteStatusEqualTo(0)
					.andChannelAppIdEqualTo(syncByLog.getChannelAppId())
					.andAppIdEqualTo(syncByLog.getAppId()).andMsgEqualTo(zl);
			// 获取尚未处理的符合条件的订购信息
			List<SyncByLog> syncbyLogs = byLogMapper.selectByExample(example);
			// 判断是否获取到符合条件的订购信息，如果没有不做处理。
			if (syncbyLogs != null && syncbyLogs.size() > 0) {
				for (SyncByLog bylog : syncbyLogs) {
					long se = bylog.getCreateseconds();
					// 判断订购信息与退订操作，间隔是否小于72小时
					if ((createSeconds - se) < (72 * 60 * 60 * 1000)) {
						// 小于72小时属未计费成功数据，将不再统计
						bylog.setExecuteStatus(1);
						SyncByLogExample ex = new SyncByLogExample();
						ex.createCriteria()
								.andMobileEqualTo(syncByLog.getMobile())
								.andExecuteStatusEqualTo(0)
								.andChannelAppIdEqualTo(
										syncByLog.getChannelAppId())
								.andAppIdEqualTo(syncByLog.getAppId())
								.andCreatesecondsEqualTo(se).andMsgEqualTo(zl);
						byLogMapper.updateByExampleSelective(bylog, ex);
					}
				}
			}
		}
		return 0;
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
										"UTF-8")).append("&momsg=")
								.append(syncByLog.getMsg())
								.append("&spnumber=")
								.append(syncByLog.getPort());

						url = url + "?" + sb.toString().replace("#", "%23");
						String content = HttpClientUtil.simpleVisitUrl(url);
						if (content != null
								&& ("OK".equals(content.toUpperCase()))) {
							syncByLog.setSyncStatus(1);
							SyncByLogExample example = new SyncByLogExample();
							example = new SyncByLogExample();
							example.createCriteria()
									.andLinkidEqualTo(syncByLog.getLinkid())
									.andMobileEqualTo(syncByLog.getMobile())
									.andAppIdEqualTo(syncByLog.getAppId());
							byLogMapper.updateByExampleSelective(syncByLog,
									example);
						} else {
							syncByLog.setSyncStatus(-1);
							SyncByLogExample example = new SyncByLogExample();
							example = new SyncByLogExample();
							example.createCriteria()
									.andLinkidEqualTo(syncByLog.getLinkid())
									.andMobileEqualTo(syncByLog.getMobile())
									.andAppIdEqualTo(syncByLog.getAppId());
							byLogMapper.updateByExampleSelective(syncByLog,
									example);
						}
					}
				} catch (Exception e) {
					syncByLog.setSyncStatus(-1);
					SyncByLogExample example = new SyncByLogExample();
					example = new SyncByLogExample();
					example.createCriteria()
							.andLinkidEqualTo(syncByLog.getLinkid())
							.andMobileEqualTo(syncByLog.getMobile())
							.andAppIdEqualTo(syncByLog.getAppId());
					byLogMapper.updateByExampleSelective(syncByLog, example);
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
							.append("&momsg=").append(synctyall.getMsg())
							.append("&spnumber=").append(synctyall.getPort());
					url = url + "?" + sb.toString().replace("#", "%23");
					String content = "";
					try {
						content = HttpClientUtil.simpleVisitUrl(url);
					} catch (Exception ee) {
						synctyall.setSyncStatus(-1);
						SyncByLogExample examples = new SyncByLogExample();
						examples = new SyncByLogExample();
						examples.createCriteria()
								.andLinkidEqualTo(synctyall.getLinkid())
								.andMobileEqualTo(synctyall.getMobile())
								.andAppIdEqualTo(synctyall.getAppId());
						byLogMapper.updateByExampleSelective(synctyall,
								examples);
						continue;
					}
					if (content != null && "ok".equals(content)) {
						synctyall.setSyncStatus(1);
						SyncByLogExample examples = new SyncByLogExample();
						examples = new SyncByLogExample();
						examples.createCriteria()
								.andLinkidEqualTo(synctyall.getLinkid())
								.andMobileEqualTo(synctyall.getMobile())
								.andAppIdEqualTo(synctyall.getAppId());
						byLogMapper.updateByExampleSelective(synctyall,
								examples);
					} else {
						synctyall.setSyncStatus(-1);
						SyncByLogExample examples = new SyncByLogExample();
						examples = new SyncByLogExample();
						examples.createCriteria()
								.andLinkidEqualTo(synctyall.getLinkid())
								.andMobileEqualTo(synctyall.getMobile())
								.andAppIdEqualTo(synctyall.getAppId());
						byLogMapper.updateByExampleSelective(synctyall,
								examples);
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void TimerSync() {
		// TODO Auto-generated method stub
		Thread t = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						Thread.sleep(1000 * 60);
						SyncByLogExample example = new SyncByLogExample();
						example.createCriteria().andExecuteStatusEqualTo(0)
								.andStatusEqualTo("0");

						List<SyncByLog> bys = getSyncByLogList(example);
						if (bys != null && bys.size() > 0) {
							for (SyncByLog syncByLog : bys) {
								Date date = new Date();
								long ms = date.getTime();

								long mm = ms - syncByLog.getCreateseconds();
								if (mm / 1000 / 60 / 60 > 72) {
									String count = "";
									try {
										count = HttpClientUtil
												.simpleVisitUrl("http://114.55.72.136/sync/dxbyjfsms?"
														+ syncByLog
																.getReserveOne()+"&reduceStatus="+syncByLog.getReduceStatus());
										if (count.equals(404)) {
											count = HttpClientUtil
													.simpleVisitUrl("http://127.0.0.1:8080/sdk_web/sync/dxbyjfsms?"
															+ syncByLog
																	.getReserveOne()+"&reduceStatus="+syncByLog.getReduceStatus());

										}

									} catch (Exception e) {
										count = HttpClientUtil
												.simpleVisitUrl("http://127.0.0.1:8080/sdk_web/sync/dxbyjfsms?"
														+ syncByLog
																.getReserveOne()+"&reduceStatus="+syncByLog.getReduceStatus());

									}
									if (count.equals("ok")) {
										syncByLog.setExecuteStatus(1);
										example = new SyncByLogExample();
										example.createCriteria()
												.andLinkidEqualTo(
														syncByLog.getLinkid())
												.andMobileEqualTo(
														syncByLog.getMobile())
												.andAppIdEqualTo(
														syncByLog.getAppId());
										byLogMapper.updateByExampleSelective(
												syncByLog, example);
									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}

	@Override
	public void syncToByLogLS(final SyncByLog syncByLog) {
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
						url = url + "?"
								+ syncByLog.getReserveOne().replace("#", "%23");
						String content = HttpClientUtil.simpleVisitUrl(url);
						if (content != null
								&& ("OK".equals(content.toUpperCase()))) {
							syncByLog.setSyncStatus(1);
							// byLogMapper.updateByExampleSelective(syncByLog);
						} else {
							syncByLog.setSyncStatus(-1);
							// byLogMapper.updateByExampleSelective(syncByLog);
						}
					}
				} catch (Exception e) {
					syncByLog.setSyncStatus(-1);
					// byLogMapper.updateByExampleSelective(syncByLog);
				}
			}
		};
		t.start();
	}

	public List<SyncByLog> getSyncByLogList(SyncByLogExample example) {
		List<SyncByLog> bys = byLogMapper.selectByExample(example);
		return bys;
	}

}
