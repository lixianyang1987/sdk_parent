package com.hytx.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.client.ori.SdkInfoMapper;
import com.hytx.model.client.SdkInfo;

@Service("sdkInfoServiceImpl")
public class SdkInfoServiceImpl implements ISdkInfoService {
	@Autowired
	private SdkInfoMapper sdkInfoMapper;

	@Override
	public SdkInfo selectByPrimaryKey(String imsi) {
		return sdkInfoMapper.selectByPrimaryKey(imsi);
	}

	@Override
	public int insert(SdkInfo sdkInfo) {
		return sdkInfoMapper.insert(sdkInfo);
	}
}
