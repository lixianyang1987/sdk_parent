package com.hytx.service.baseConf;

import java.util.List;
import java.util.Set;

import com.hytx.model.baseConf.ChannelAppOperate;
import com.hytx.model.baseConf.Operate;
import com.hytx.util.Page;

public interface IChannelAppOperateService {
	/***
	 * 功能描述：查询已添加的渠道包指令列表
	 * 
	 * @param findOperate
	 * @param page
	 * @return 返回指令列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<Operate> selectOperatesByPage(
			ChannelAppOperate channelAppOperate, Page<Operate> page);

	/***
	 * 功能描述：查询未添加的指令列表
	 * 
	 * @param findOperate
	 * @param page
	 * @return 返回指令列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<Operate> selectNotAddedOperatesByPage(
			ChannelAppOperate channelAppOperate, Page<Operate> page);

	/***
	 * 功能描述：添加的渠道包指令
	 * 
	 * @param record
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int addChannelAppOperate(ChannelAppOperate record);

	/***
	 * 功能描述：根据idList删除渠道包指令
	 * 
	 * @param idList
	 * @param channelAppId
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int deleteChannelAppOperateByIds(List<Integer> idList,
			Integer channelAppId);

	/****
	 * 根据渠道包id查询此渠道包配置的指令id
	 * 
	 * @param channelAppId
	 * @return
	 * @author houzz
	 * @date 2015年10月8日
	 */
	public Set<Integer> selectChannelAppOperateIds(Integer channelAppId);
}
