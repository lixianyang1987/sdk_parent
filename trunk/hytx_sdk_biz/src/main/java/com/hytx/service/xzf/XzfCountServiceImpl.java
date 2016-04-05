package com.hytx.service.xzf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.xzf.ex.XzfCountMapperEx;
import com.hytx.dto.xzf.XzfCountDto;
import com.hytx.dto.xzf.XzfFlowLogDto;
import com.hytx.util.Page;

@Service("xzfCountServiceImpl")
public class XzfCountServiceImpl implements IXzfCountService {
	@Autowired
	private XzfCountMapperEx xzfCountMapperEx;

	@Override
	public List<XzfCountDto> countXzfOrders(XzfCountDto xzfCountDto,
			Page<XzfCountDto> page) {
		List<XzfCountDto> resultData = xzfCountMapperEx.countXzfOrders(
				xzfCountDto, page);
		page.setTotalCount(xzfCountMapperEx.countXzfOrdersTotal(xzfCountDto));
		page.setResultList(resultData);
		return resultData;
	}

	@Override
	@Transactional(readOnly = true)
	public List<XzfFlowLogDto> selectXzfLogsByPage(XzfFlowLogDto findDto,
			Page<XzfFlowLogDto> page) {
		List<XzfFlowLogDto> resultList = xzfCountMapperEx
				.selectFlowLogListByPage(findDto, page);
		page.setResultList(resultList);
		page.setTotalCount(xzfCountMapperEx.countFlowLog(findDto));
		return resultList;
	}
}
