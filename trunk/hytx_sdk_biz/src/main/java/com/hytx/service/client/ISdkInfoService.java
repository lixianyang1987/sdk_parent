package com.hytx.service.client;

import com.hytx.model.client.SdkInfo;

public interface ISdkInfoService {

	SdkInfo selectByPrimaryKey(String imsi);

	int insert(SdkInfo sdkInfo);

}
