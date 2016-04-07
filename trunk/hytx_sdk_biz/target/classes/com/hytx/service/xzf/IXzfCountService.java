package com.hytx.service.xzf;

import java.util.List;

import com.hytx.dto.xzf.XzfCountDto;
import com.hytx.dto.xzf.XzfFlowLogDto;
import com.hytx.util.Page;

public interface IXzfCountService {

	List<XzfCountDto> countXzfOrders(XzfCountDto xzfCountDto,
			Page<XzfCountDto> page);

	List<XzfFlowLogDto> selectXzfLogsByPage(XzfFlowLogDto findDto,
			Page<XzfFlowLogDto> page);

}
