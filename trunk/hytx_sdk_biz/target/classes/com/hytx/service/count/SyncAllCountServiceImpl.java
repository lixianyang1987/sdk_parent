package com.hytx.service.count;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.dao.count.ex.CpOrderCountMapperEx;
import com.hytx.dao.count.ex.SyncAllCountMapperEx;
import com.hytx.dto.count.CpOrderCountDto;
import com.hytx.dto.count.SyncAllCountDto;
import com.hytx.util.Page;

@Service("syncAllCountServiceImpl")
public class SyncAllCountServiceImpl implements ISyncAllCountService {
	@Autowired
	private SyncAllCountMapperEx syncAllCountMapperEx;
	@Autowired
	private CpOrderCountMapperEx cpOrderCountMapperEx;

	@Override
	public List<SyncAllCountDto> countSyncAll(SyncAllCountDto syncAllCountDto,
			Page<SyncAllCountDto> page) {
		List<SyncAllCountDto> list = syncAllCountMapperEx.countSyncAll(
				syncAllCountDto, page);
		page.setResultList(list);
		page.setTotalCount(syncAllCountMapperEx
				.countSyncAllTotal(syncAllCountDto));
		return list;
	}

	@Override
	public List<SyncAllCountDto> countSyncApp(SyncAllCountDto syncAllCountDto,
			Page<SyncAllCountDto> page) {
		List<SyncAllCountDto> list = syncAllCountMapperEx.countSyncApp(
				syncAllCountDto, page);
		page.setResultList(list);
		page.setTotalCount(syncAllCountMapperEx
				.countSyncAppTotal(syncAllCountDto));
		return list;
	}

	public List<CpOrderCountDto> countCpOrder(CpOrderCountDto cpOrderCountDto) {
		return cpOrderCountMapperEx.countCpOrder(cpOrderCountDto);
	}

}
