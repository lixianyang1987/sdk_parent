package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.ChannelAppOperate;
import com.hytx.model.baseConf.Operate;
import com.hytx.util.Page;

public interface ChannelAppOperateMapperEx {
	
	/**
	 * 功能描述：按条件分页查询指令列表
	 * 
	 * @param channelAppOperate
	 * @param page
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<Operate> selectOperateListByPage(
			@Param("channelAppOperate") ChannelAppOperate channelAppOperate,
			@Param("page") Page<Operate> page);

	/**
	 * 功能描述：按条件查询指令总数
	 * 
	 * @param channelAppOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int countOperate(@Param("channelAppOperate") ChannelAppOperate channelAppOperate);
	/**
	 * 功能描述：按条件分页查询待添加指令列表
	 * 
	 * @param channelAppOperate
	 * @param page
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<Operate>selectNotAddedOperateList(
			@Param("channelAppOperate") ChannelAppOperate channelAppOperate,
			@Param("page") Page<Operate> page);
	/**
	 * 功能描述：按条件查询待添加指令总数
	 * 
	 * @param channelAppOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int countNotAddedOperate(@Param("channelAppOperate") ChannelAppOperate channelAppOperate);
}