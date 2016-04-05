package com.hytx.service.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hytx.dao.count.ex.SyncExCountMapperEx;
import com.hytx.dto.count.KeyValueDto;
import com.hytx.dto.count.SyncExCountDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.util.Page;

@Service("syncExCountServiceImpl")
public class SyncExCountServiceImpl implements ISyncExCountService {
	@Autowired
	private SyncExCountMapperEx syncExCountMapperEx;

	@Override
	@Transactional
	public List<ChannelApp> findSyncExChannelApp() {
		return syncExCountMapperEx.findSyncExChannelApp();
	}

	/****
	 * 分页统计放代码各下游渠道订单数据
	 * 
	 * @param page
	 * @param syncExCountDto
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	@Override
	public List<SyncExCountDto> countSyncEx(SyncExCountDto syncExCountDto,
			Page<SyncExCountDto> page) {
		List<SyncExCountDto> resultData = syncExCountMapperEx.countSyncEx(
				syncExCountDto, page);
		page.setTotalCount(syncExCountMapperEx.countSyncExTotal(syncExCountDto));
		page.setResultList(resultData);
		return resultData;
	}

	/****
	 * 分页统计放代码各下游渠道订单详情数据
	 * 
	 * @param syncExCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	@Override
	public List<SyncExCountDto> countSyncExDetail(
			SyncExCountDto syncExCountDto, Page<SyncExCountDto> page) {
		List<SyncExCountDto> resultData = syncExCountMapperEx
				.countSyncExDetail(syncExCountDto, page);
		page.setTotalCount(syncExCountMapperEx
				.countSyncExDetailTotal(syncExCountDto));
		page.setResultList(resultData);
		return resultData;
	}

	@Override
	public List<KeyValueDto<Long>> selectMonthDayIncome(
			SyncExCountDto syncExCountDto) {
		return syncExCountMapperEx.selectMonthDayIncome(syncExCountDto);
	}

	@Override
	public List<KeyValueDto<Long>> selectDayHourIncome(
			SyncExCountDto syncExCountDto) {
		return syncExCountMapperEx.selectDayHourIncome(syncExCountDto);
	}

}
