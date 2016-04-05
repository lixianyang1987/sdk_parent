package com.hytx.service.count;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hytx.dao.count.ex.SyncQsxxbyCountMapperEx;
import com.hytx.dto.count.SyncQsxxbyDto;
import com.hytx.util.Page;

@Service("syncQsxxbyCountServiceImpl")
public class SyncQsxxbyCountServiceImpl implements ISyncQsxxbyCountService {
	
	@Autowired
	private SyncQsxxbyCountMapperEx syncQsxxbyMapperEx;
	@Override
	public List<SyncQsxxbyDto> countSyncQsxxby(SyncQsxxbyDto syncQsxxbyDto,
			Page<SyncQsxxbyDto> page) {
		List<SyncQsxxbyDto> resultList = syncQsxxbyMapperEx
				.selectSyncQsxxbyListByPage(syncQsxxbyDto, page);
		page.setResultList(resultList);
		page.setTotalCount(syncQsxxbyMapperEx.countSyncQsxxby(syncQsxxbyDto));
		return resultList;
	}
}
