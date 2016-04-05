package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.baseConf.ChannelAppDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.util.Page;

public interface ChannelAppMapperEx {

	/**
	 * 功能描述：按条件分页查询渠道包列表
	 * 
	 * @param findChannelApp
	 * @param page
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 * 
	 */
	public List<ChannelAppDto> selectChannelAppListByPage(
			@Param("findChannelApp") ChannelApp findChannelApp,
			@Param("page") Page<ChannelAppDto> page);

	/**
	 * 功能描述：按条件查询渠道包总数
	 * 
	 * @param findChannelApp
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int countChannelApp(
			@Param("findChannelApp") ChannelApp findChannelApp);

	/**
	 * 功能描述：根据id查询渠道包dto数据
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public ChannelAppDto selectChannelAppDtoById(@Param("id") Integer id);
}