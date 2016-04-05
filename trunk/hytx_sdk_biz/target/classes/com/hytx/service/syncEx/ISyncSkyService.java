package com.hytx.service.syncEx;

import com.hytx.model.syncEx.TsyncexSky;



public interface ISyncSkyService {
	String reqSms(TsyncexSky tSyncexSky);
	
	String reqResult(TsyncexSky tSyncexSky,String paymentCode);
	
}	
