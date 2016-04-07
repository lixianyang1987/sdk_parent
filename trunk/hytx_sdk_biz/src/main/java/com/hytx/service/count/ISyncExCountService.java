package com.hytx.service.count;

import java.util.List;

import com.hytx.dto.count.KeyValueDto;
import com.hytx.dto.count.SyncExCountDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.util.Page;

public interface ISyncExCountService {
	/****
	 * 分页统计放代码各下游渠道订单数据
	 * 
	 * @param syncExCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	List<SyncExCountDto> countSyncEx(SyncExCountDto syncExCountDto,
			Page<SyncExCountDto> page);

	/****
	 * 查询放代码的下游渠道包数据
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	List<ChannelApp> findSyncExChannelApp();

	/****
	 * 分页统计放代码各下游渠道订单详情数据
	 * 
	 * @param syncExCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	List<SyncExCountDto> countSyncExDetail(SyncExCountDto syncExCountDto,
			Page<SyncExCountDto> page);

	List<KeyValueDto<Long>> selectMonthDayIncome(SyncExCountDto syncExCountDto);

	List<KeyValueDto<Long>> selectDayHourIncome(SyncExCountDto syncExCountDto);

}
