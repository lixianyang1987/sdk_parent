package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.count.SyncAllCountDto;
import com.hytx.util.Page;

public interface SyncAllCountMapperEx {

	/***
	 * 统计订单数据
	 * 
	 * @param syncAllCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年7月23日
	 */
	List<SyncAllCountDto> countSyncAll(
			@Param("findDto") SyncAllCountDto syncAllCountDto,
			@Param("page") Page<SyncAllCountDto> page);

	/****
	 * 统计订单数据总数
	 * 
	 * @param syncAllCountDto
	 * @return
	 * @author houzz
	 * @date 2015年8月17日
	 */
	Integer countSyncAllTotal(@Param("findDto") SyncAllCountDto syncAllCountDto);

	/****
	 * 统计应用订单数据
	 * 
	 * @param syncAllCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年8月17日
	 */
	List<SyncAllCountDto> countSyncApp(
			@Param("findDto") SyncAllCountDto syncAllCountDto,
			@Param("page") Page<SyncAllCountDto> page);

	/****
	 * 统计应用订单数据总数
	 * 
	 * @param syncAllCountDto
	 * @return
	 * @author houzz
	 * @date 2015年8月17日
	 */
	Integer countSyncAppTotal(@Param("findDto") SyncAllCountDto syncAllCountDto);

}
