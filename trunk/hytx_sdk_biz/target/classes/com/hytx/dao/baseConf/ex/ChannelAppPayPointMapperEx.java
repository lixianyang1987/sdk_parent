package com.hytx.dao.baseConf.ex;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hytx.model.baseConf.ChannelAppPayPoint;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.util.Page;

public interface ChannelAppPayPointMapperEx {
	
	/**
	 * 功能描述：按条件分页查询计费点列表
	 * 
	 * @param ChannelAppPayPoint
	 * @param page
	 * @return
	 * @author lxy
	 * @since 2015年9月18日
	 */
	public List<PayPoint> selectPayPointListByPage(
			@Param("channelAppPayPoint") ChannelAppPayPoint channelAppPayPoint,
			@Param("page") Page<PayPoint> page);

	/**
	 * 功能描述：按条件查询计费点总数
	 * 
	 * @param channelAppPayPoint
	 * @return
	 * @author lxy
	 * @since 2015年9月18日
	 */
	public int countPayPoint(@Param("channelAppPayPoint") ChannelAppPayPoint channelAppPayPoint);
	/**
	 * 功能描述：按条件分页查询待添加指令列表
	 * 
	 * @param channelAppPayPoint
	 * @param page
	 * @return
	 * @author lxy
	 * @since 2015年9月18日
	 */
	public List<PayPoint>selectNotAddedPayPointList(
			@Param("channelAppPayPoint") ChannelAppPayPoint channelAppPayPoint,
			@Param("page") Page<PayPoint> page);
	/**
	 * 功能描述：按条件查询待添加指令总数
	 * 
	 * @param channelAppPayPoint
	 * @return
	 * @author lxy
	 * @since 2015年9月18日
	 */
	public int countNotAddedPayPoint(@Param("channelAppPayPoint") ChannelAppPayPoint channelAppPayPoint);
}