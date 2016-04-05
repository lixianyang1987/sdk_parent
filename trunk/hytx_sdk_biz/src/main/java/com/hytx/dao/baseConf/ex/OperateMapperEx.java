package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.util.Page;

public interface OperateMapperEx {

	/**
	 * 功能描述：按条件分页查询指令列表
	 * 
	 * @param findOperate
	 * @param page
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<Operate> selectOperateListByPage(
			@Param("findOperate") OperateDto findOperate,
			@Param("page") Page<Operate> page);

	/**
	 * 功能描述：按条件查询指令总数
	 * 
	 * @param findOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int countOperate(@Param("findOperate") OperateDto findOperate);

	/****
	 * 查询某运营商下某应用的指令，按资费升序排序返回
	 * 
	 * @param serverType
	 * @param appId
	 * @return
	 * @author houzz
	 * @since 2015年5月13日
	 */
	public List<Operate> selectServerAppOperates(
			@Param("serverType") Integer serverType,
			@Param("appId") Integer appId);

	/****
	 * 根据计费点查询指令
	 * 
	 * @param payPointId
	 * @return
	 * @author houzz
	 * @since 2015年5月26日
	 */
	public List<Operate> selectOperateByPayPointIds(
			@Param("payPointId") Integer payPointId);
}