package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.count.KeyValueDto;
import com.hytx.dto.count.SyncExCountDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.util.Page;

public interface SyncExCountMapperEx {
	/***
	 * 查询放代码的下游渠道包
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	List<ChannelApp> findSyncExChannelApp();

	/****
	 * 分页统计放代码各下游渠道订单数据
	 * 
	 * @param syncExCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	List<SyncExCountDto> countSyncEx(
			@Param("findDto") SyncExCountDto syncExCountDto,
			@Param("page") Page<SyncExCountDto> page);

	/****
	 * 统计放代码各下游渠道订单数据总数
	 * 
	 * @param syncExCountDto
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	Integer countSyncExTotal(@Param("findDto") SyncExCountDto syncExCountDto);

	/****
	 * 分页统计放代码各下游渠道订单详情数据
	 * 
	 * @param syncExCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	List<SyncExCountDto> countSyncExDetail(
			@Param("findDto") SyncExCountDto syncExCountDto,
			@Param("page") Page<SyncExCountDto> page);

	/****
	 * 统计放代码各下游渠道订单详情数据总数
	 * 
	 * @param syncExCountDto
	 * @return
	 * @author houzz
	 * @date 2015年10月28日
	 */
	Integer countSyncExDetailTotal(
			@Param("findDto") SyncExCountDto syncExCountDto);

	/****
	 * 查询当月每一天的收入数据
	 * 
	 * @param syncExCountDto
	 * @return
	 * @author houzz
	 * @date 2015年12月22日
	 */
	List<KeyValueDto<Long>> selectMonthDayIncome(
			@Param("findDto") SyncExCountDto syncExCountDto);

	/****
	 * 查询当天每小时的收入数据
	 * 
	 * @param syncExCountDto
	 * @return
	 * @author houzz
	 * @date 2015年12月22日
	 */
	List<KeyValueDto<Long>> selectDayHourIncome(
			@Param("findDto") SyncExCountDto syncExCountDto);
}
