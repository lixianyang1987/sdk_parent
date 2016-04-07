package com.hytx.service.count;

import java.util.List;

import com.hytx.dto.count.SyncQsxxbyDto;
import com.hytx.util.Page;

public interface ISyncQsxxbyCountService {

	/***
	 * 分页查询数据
	 * 
	 * @param syncQsxxbyDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年7月23日
	 */
	public List<SyncQsxxbyDto> countSyncQsxxby(SyncQsxxbyDto syncQsxxbyDto,
			Page<SyncQsxxbyDto> page);

}
