package com.hytx.service.baseConf;

import java.util.List;
import java.util.Set;

import com.hytx.model.baseConf.ChannelAppPayPoint;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.util.Page;

public interface IChannelAppPayPointService {
	/***
	 * 功能描述：查询已添加的渠道包计费点列表
	 * 
	 * @param findOperate
	 * @param page
	 * @return 返回计费点列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<PayPoint> selectPayPointesByPage(
			ChannelAppPayPoint channelAppPayPoint, Page<PayPoint> page);

	/***
	 * 功能描述：查询未添加的计费点列表
	 * 
	 * @param findOperate
	 * @param page
	 * @return 返回计费点列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<PayPoint> selectNotAddedPayPointesByPage(
			ChannelAppPayPoint channelAppPayPoint, Page<PayPoint> page);

	/***
	 * 功能描述：添加的渠道包计费点
	 * 
	 * @param record
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int addChannelAppPayPoint(ChannelAppPayPoint channelAppPayPoint);

	/***
	 * 功能描述：根据idList删除渠道包计费点
	 * 
	 * @param idList
	 * @param channelAppId
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int deleteChannelAppPayPointByIds(List<Integer> idList,
			Integer channelAppId);

	/****
	 * 根据渠道包id查询此渠道包配置的计费点id
	 * 
	 * @param channelAppId
	 * @return
	 * @author houzz
	 * @date 2015年10月8日
	 */
	public Set<Integer> selectChannelAppPayPointIds(Integer channelAppId);
}
