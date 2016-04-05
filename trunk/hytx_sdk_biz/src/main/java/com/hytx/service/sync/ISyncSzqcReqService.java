package com.hytx.service.sync;

import com.hytx.model.sync.SyncSzqcReq;
import com.hytx.model.sync.SyncSzqcSms;

public interface ISyncSzqcReqService {
	public  SyncSzqcSms syncZjhyReq(SyncSzqcReq syncSzqcReq);
}
