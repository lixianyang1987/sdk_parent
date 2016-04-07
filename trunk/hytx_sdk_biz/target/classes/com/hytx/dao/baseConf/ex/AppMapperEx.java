package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.baseConf.AppDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppExample;
import com.hytx.util.Page;

public interface AppMapperEx {

	/**
	 * 功能描述：按条件分页查询应用列表
	 * 
	 * @param findApp
	 * @param page
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<AppDto> selectAppListByPage(@Param("findApp") App findApp,
			@Param("page") Page<AppDto> page);

	/**
	 * 功能描述：按条件查询应用总数
	 * 
	 * @param findApp
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int countApp(@Param("findApp") App findApp);

	/**
	 * 功能描述：查询某渠道的所有应用
	 * 
	 * @param channelId
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<App> selectAppsOfChannel(@Param("channelId") Integer channelId);

	/**
	 * 功能描述：查询某渠道或cp的所有应用
	 * 
	 * @param channelId
	 * @param cpId
	 * @return
	 * @author houzz
	 * @since 2015年5月26日
	 */
	public List<App> selectAppsByChannelAndCp(
			@Param("channelId") Integer channelId, @Param("cpId") Integer cpId);
}