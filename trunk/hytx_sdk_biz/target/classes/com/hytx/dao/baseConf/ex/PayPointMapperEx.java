package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.PayPoint;
import com.hytx.util.Page;

public interface PayPointMapperEx {
	/***
	 * 功能描述：按条件分页查询计费点列表
	 * 
	 * @param findPayPoint
	 * @param page
	 * @return 返回计费点列表
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public List<PayPoint> selectPayPointListByPage(
			@Param("findPayPoint") PayPoint findPayPoint,
			@Param("page") Page<PayPoint> page);

	/***
	 * 功能描述：按条件查询计费点记录数
	 * 
	 * @param findPayPoint
	 * @param page
	 * @return 返回计费点列表
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public int countPayPoint(@Param("findPayPoint") PayPoint findPayPoint);

	/****
	 * 假设指定appId的应用设置指令为私有，则查询不合法的计费点
	 * 
	 * @param appId
	 * @return
	 * @author houzz
	 * @date 2015年8月4日
	 */
	public List<PayPoint> selectIllegePayPoints(@Param("appId") Integer appId,
			@Param("serverType") Integer serverType);
}