package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.client.SdkLoadDto;
import com.hytx.util.Page;

public interface SdkLoadCountMapperEx {

	/***
	 * 功能描述：按条件分页查询sdk启动记录列表
	 * 
	 * @param findDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年8月7日
	 */
	public List<SdkLoadDto> selectSdkLoadListByPage(
			@Param("findDto") SdkLoadDto findDto,
			@Param("page") Page<SdkLoadDto> page);

	/****
	 * 功能描述：按条件查询sdk启动记录总数
	 * 
	 * @param findDto
	 * @return
	 * @author houzz
	 * @date 2015年8月7日
	 */
	public int countSdkLoad(@Param("findDto") SdkLoadDto findDto);

}
