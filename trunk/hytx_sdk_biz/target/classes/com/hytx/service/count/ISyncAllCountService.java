package com.hytx.service.count;

import java.util.List;

import com.hytx.dto.count.CpOrderCountDto;
import com.hytx.dto.count.SyncAllCountDto;
import com.hytx.util.Page;

public interface ISyncAllCountService {

	/***
	 * 统计订单数据
	 * 
	 * @param syncAllCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年7月23日
	 */
	public List<SyncAllCountDto> countSyncAll(SyncAllCountDto syncAllCountDto,
			Page<SyncAllCountDto> page);

	/****
	 * 统计应用订单数据
	 * 
	 * @param syncAllCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年8月17日
	 */
	public List<SyncAllCountDto> countSyncApp(SyncAllCountDto syncAllCountDto,
			Page<SyncAllCountDto> page);

	public List<CpOrderCountDto> countCpOrder(CpOrderCountDto cpOrderCountDto);

}
