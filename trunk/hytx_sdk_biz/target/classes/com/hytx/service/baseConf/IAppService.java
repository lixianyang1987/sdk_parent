package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.dto.baseConf.AppDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppExample;
import com.hytx.util.Page;

public interface IAppService {
	/***
	 * 功能描述：查询应用列表
	 * 
	 * @param findApp
	 * @param page
	 * @return 返回应用列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<AppDto> selectAppsByPage(App findApp, Page<AppDto> page);

	/***
	 * 功能描述：添加应用
	 * 
	 * @param app
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int insert(App app);

	/***
	 * 功能描述：更新应用
	 * 
	 * @param app
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int updateByPrimaryKeySelective(App app);

	/***
	 * 根据id获取应用实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public App selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除应用记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int deleteAppByIds(List<Integer> idList);

	/***
	 * 查询所有有效的应用
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<App> selectAllActiveApp();

	/**
	 * 功能描述：查询某渠道的所有应用
	 * 
	 * @param channelId
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<App> selectAppsOfChannel(Integer channelId);

	/***
	 * 根据cpids统计应用记录数
	 * 
	 * @param cpIds
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int countByCpIds(List<Integer> cpIds);

	/**
	 * 功能描述：查询某渠道或cp的所有应用
	 * 
	 * @param channelId
	 * @param cpId
	 * @return
	 * @author houzz
	 * @since 2015年5月26日
	 */
	public List<App> selectAppsByChannelAndCp(Integer channelId, Integer cpId);

	/****
	 * 根据id集合查询记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @date 2015年8月27日
	 */
	List<App> selectAppsByIdList(List<Integer> idList);
	
	
}
