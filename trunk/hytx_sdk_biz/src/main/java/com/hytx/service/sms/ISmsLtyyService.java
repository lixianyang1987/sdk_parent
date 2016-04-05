package com.hytx.service.sms;

import com.hytx.model.sms.SmsLtyy;

public interface ISmsLtyyService {

	int insertSmsLtyy(SmsLtyy smsLtyy);

	Long selectSeqId();

	SmsLtyy selectByIpAndUpOrderId(String ip, String upOrderId);

	int updateSmsLtyy(SmsLtyy smsLtyy);

	SmsLtyy selectByPrimaryKey(Long orderId);

}
