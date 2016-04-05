package com.hytx.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.client.ori.SdkLoadMapper;
import com.hytx.dao.count.ex.SdkLoadCountMapperEx;
import com.hytx.dto.client.SdkLoadDto;
import com.hytx.model.client.SdkLoad;
import com.hytx.util.Page;

@Service("sdkLoadServiceImpl")
public class SdkLoadServiceImpl implements ISdkLoadService {
	@Autowired
	private SdkLoadMapper sdkLoadMapper;
	@Autowired
	private SdkLoadCountMapperEx sdkLoadCountMapperEx;

	public List<SdkLoadDto> selectAppsByPage(SdkLoadDto findDto,
			Page<SdkLoadDto> page) {
		List<SdkLoadDto> resultList = sdkLoadCountMapperEx
				.selectSdkLoadListByPage(findDto, page);
		page.setResultList(resultList);
		page.setTotalCount(sdkLoadCountMapperEx.countSdkLoad(findDto));
		return resultList;
	}

	public int insertSdkLoad(SdkLoad record) {
		return sdkLoadMapper.insert(record);
	}
}
