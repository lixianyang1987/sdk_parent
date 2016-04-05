package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.dto.baseConf.ChannelAppDto;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import com.hytx.util.Page;

public interface IChannelAppService {
	/***
	 * 功能描述：查询渠道包列表
	 * 
	 * @param findChannelApp
	 * @param page
	 * @return 返回渠道包列表
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<ChannelAppDto> selectChannelAppsByPage(
			ChannelApp findChannelApp, Page<ChannelAppDto> page);

	/***
	 * 功能描述：添加渠道包
	 * 
	 * @param channelApp
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int insert(ChannelApp channelApp);

	/***
	 * 功能描述：更新渠道包
	 * 
	 * @param channelApp
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int updateByPrimaryKey(ChannelApp channelApp);

	/***
	 * 根据id获取渠道包实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public ChannelApp selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除渠道包记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int deleteChannelAppByIds(List<Integer> idList);

	/**
	 * 功能描述：根据id查询渠道包dto数据
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public ChannelAppDto selectChannelAppDtoById(Integer id);

	/***
	 * 根据渠道ids删除渠道包记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int deleteChannelAppByChannelIds(List<Integer> idList);

	/***
	 * 根据应用ids删除渠道包记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int deleteChannelAppByAppIds(List<Integer> idList);

	ChannelApp selectChannelAppId(ChannelAppExample example);
	
	List<ChannelApp> selectChannelAppIdlist(ChannelAppExample example);

}
