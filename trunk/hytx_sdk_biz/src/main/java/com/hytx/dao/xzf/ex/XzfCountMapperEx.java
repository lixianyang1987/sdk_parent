package com.hytx.dao.xzf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.xzf.XzfCountDto;
import com.hytx.dto.xzf.XzfFlowLogDto;
import com.hytx.util.Page;

public interface XzfCountMapperEx {
	/****
	 * 分页统计信支付订单数
	 * 
	 * @param xzfCountDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2016年1月11日
	 */
	List<XzfCountDto> countXzfOrders(@Param("findDto") XzfCountDto xzfCountDto,
			@Param("page") Page<XzfCountDto> page);

	/***
	 * 统计信支付订单总数
	 * 
	 * @param xzfCountDto
	 * @return
	 * @author houzz
	 * @date 2016年1月11日
	 */
	int countXzfOrdersTotal(@Param("findDto") XzfCountDto xzfCountDto);

	/****
	 * 分页查询信支付日志
	 * 
	 * @param flowLogDto
	 * @return
	 * @author houzz
	 * @date 2016年1月13日
	 */
	List<XzfFlowLogDto> selectFlowLogListByPage(
			@Param("findDto") XzfFlowLogDto flowLogDto,
			@Param("page") Page<XzfFlowLogDto> page);

	/****
	 * 统计信支付日志数
	 * 
	 * @param flowLogDto
	 * @return
	 * @author houzz
	 * @date 2016年1月13日
	 */
	int countFlowLog(@Param("findDto") XzfFlowLogDto flowLogDto);
}
