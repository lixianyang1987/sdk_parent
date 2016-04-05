package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.count.CpOrderCountDto;

public interface CpOrderCountMapperEx {

	/***
	 * 统计cp订单激活量数据
	 * 
	 * @param cpOrderCountDto
	 * @return
	 * @author houzz
	 * @date 2015年8月6日
	 */
	List<CpOrderCountDto> countCpOrder(
			@Param("findDto") CpOrderCountDto cpOrderCountDto);

}
