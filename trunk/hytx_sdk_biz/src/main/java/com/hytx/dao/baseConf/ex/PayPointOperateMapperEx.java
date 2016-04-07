package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.PayPointOperate;

public interface PayPointOperateMapperEx {

	/**
	 * 功能描述：查询计费点指令列表
	 * 
	 * @param payPointOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<OperateDto> selectPayPointOperateList(
			@Param("payPointOperate") PayPointOperate payPointOperate);

}