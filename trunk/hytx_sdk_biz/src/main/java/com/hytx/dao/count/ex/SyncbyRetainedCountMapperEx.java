package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.count.SyncQsxxbyDto;
import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.util.Page;

public interface SyncbyRetainedCountMapperEx {

	/**
	 * 功能描述：按条件分页查询列表
	 * 
	 * @param findDto
	 * @param page
	 * @return
	 * @author houzz
	 * @since 2015年10月12日
	 */
	public List<SyncByRetained> selectSyncRetainedListByPage(
			@Param("findDto") SyncByRetained findDto,
			@Param("page") Page<SyncByRetained> page);

	/**
	 * 功能描述：按条件查询总数
	 * 
	 * @param findDto
	 * @return
	 * @author houzz
	 * @since 2015年10月12日
	 */
	public int countSyncbyRetained(@Param("findDto") SyncByRetained findDto);
}