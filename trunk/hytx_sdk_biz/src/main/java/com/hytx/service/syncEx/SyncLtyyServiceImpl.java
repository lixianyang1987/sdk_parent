package com.hytx.service.syncEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dao.syncEx.ori.SyncLtyyMapper;
import com.hytx.model.sms.SmsLtyy;
import com.hytx.model.syncEx.SyncLtyy;
import com.hytx.service.sms.ISmsLtyyService;
import com.hytx.util.HttpClientUtil;

@Service("syncLtyyServiceImpl")
public class SyncLtyyServiceImpl implements ISyncLtyyService {
	@Autowired
	private SyncLtyyMapper syncLtyyMapper;

	@Autowired
	private ISmsLtyyService smsLtyyService;

	@Override
	public int insertSyncLtyy(SyncLtyy syncLtyy) {
		return syncLtyyMapper.insert(syncLtyy);
	}

	@Override
	public int updateSyncLtyyStatus(SyncLtyy syncLtyy) {
		return syncLtyyMapper.updateByPrimaryKeySelective(syncLtyy);
	}

	@Override
	public SyncLtyy selectByPrimaryKey(String linkId) {
		return syncLtyyMapper.selectByPrimaryKey(linkId);
	}

	@Override
	public boolean syncLtyyToLowerChannel(final String uri,
			final SyncLtyy record) {
		final String linkId = record.getLinkId();
		if (linkId == null || linkId.length() < 15) {
			return false;
		}
		String orderIdStr = linkId.substring(linkId.length() - 14);
		Long orderId = Long.parseLong(orderIdStr);
		SmsLtyy smsLtyy = smsLtyyService.selectByPrimaryKey(orderId);
		if (smsLtyy == null) {
			return false;
		}
		final SyncLtyy entity = selectByPrimaryKey(linkId);
		if (entity == null) {
			return false;
		}
		Thread t = new Thread() {
			@Override
			public void run() {
				Integer status = BaseContance.NOT_ACTIVICE_STATUS;
				try {
					String url = uri + "?msg=" + entity.getMsg() + "&spnumber="
							+ entity.getSpNumber() + "&linkid=" + linkId
							+ "&mobileid=" + entity.getMobileId() + "&status="
							+ record.getStatus();
					String result = HttpClientUtil.simpleVisitUrl(url);
					if (result != null && result.equals("ok")) {
						status = BaseContance.ACTIVICE_STATUS;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				record.setSyncStatus(status);
				syncLtyyMapper.updateByPrimaryKeySelective(record);
			}
		};
		t.start();
		return true;
	}

}
