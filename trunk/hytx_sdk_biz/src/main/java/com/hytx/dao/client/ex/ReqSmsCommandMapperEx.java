package com.hytx.dao.client.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.client.ReqSmsCommand;

public interface ReqSmsCommandMapperEx {

	/***
	 * 查询从什么时候起用户计费失败的记录
	 * 
	 * @param imsi
	 * @param startDate
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年7月10日
	 */
	List<ReqSmsCommand> selectUserFailCommandList(@Param("imsi") String imsi,
			@Param("startDate") String startDate,
			@Param("serverType") Integer serverType);

	/***
	 * 统计用户发送短信的条数
	 * 
	 * @param imsi
	 * @param appId
	 * @param channelId
	 * @return
	 * @author houzz
	 * @date 2015年7月30日
	 */
	Integer countUserSendCmd(@Param("imsi") String imsi,
			@Param("appId") Integer appId, @Param("channelId") Integer channelId);

	/***
	 * 查询当天serialNum的最大值
	 * 
	 * @param toDay
	 * @return
	 * @author houzz
	 * @date 2015年7月31日
	 */
	Integer selectDayMaxSerialNum(@Param("toDay") String toDay);

	/***
	 * 查询当天某serialNum的发送指令记录
	 * 
	 * @param serialNum
	 * @param toDay
	 *            yyyyMMdd格式日期字符串
	 * @return
	 * @author houzz
	 * @date 2015年7月31日
	 */
	List<ReqSmsCommand> selectBySerialNum(
			@Param("serialNum") Integer serialNum, @Param("toDay") String toDay);

	/***
	 * 对于某应用的精确指令，根据通道订单时间匹配发送短串记录
	 * 
	 * @param appId
	 * @param feeValue
	 * @param orderDt
	 *            yyyyMMddHHmiss格式字符串
	 * @return
	 * @author houzz
	 * @date 2015年8月5日
	 */
	List<ReqSmsCommand> selectNoSyncByOrderTime(@Param("appId") Integer appId,
			@Param("feeValue") Integer feeValue,
			@Param("orderDt") String orderDt);
}
