package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.Channel;
import com.hytx.util.Page;

public interface IChannelService {
	/***
	 * 功能描述：查询渠道列表
	 * 
	 * @param findChannel
	 * @param page
	 * @return 返回渠道列表
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<Channel> selectChannelsByPage(Channel findChannel,
			Page<Channel> page);

	/***
	 * 功能描述：添加渠道
	 * 
	 * @param channel
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int insert(Channel channel);

	/***
	 * 功能描述：更新渠道
	 * 
	 * @param channel
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int updateByPrimaryKeySelective(Channel channel);

	/***
	 * 根据id获取渠道实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public Channel selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除渠道记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int deleteChannelByIds(List<Integer> idList);

	/***
	 * 查询所有有效的渠道记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<Channel> selectAllActiveChannel();

	public List<Channel> selectByCpId(Integer cpId);
	public List<Channel> selectByAppId(Integer appId);
}
