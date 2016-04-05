package com.hytx.dao.client.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.client.AppConsumerDto;

public interface ReqSmsMapperEx {

	/****
	 * 查询用户某日消费金额
	 * 
	 * @param imsi
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM-dd
	 * @return
	 */
	public Long selectDayConsumer(@Param("imsi") String imsi,
			@Param("dateStr") String dateStr);

	/****
	 * 查询用户某月消费金额
	 * 
	 * @param imsi
	 * @param monthStr
	 *            日期字符串，格式为yyyy-MM
	 * @return
	 */
	public Long selectMonthConsumer(@Param("imsi") String imsi,
			@Param("monthStr") String monthStr);

	/****
	 * 查询某渠道包某省份某日消费金额
	 * 
	 * @param provinceId
	 * @param channelAppId
	 * @param appId
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM-dd
	 * @return
	 */
	public Long selectDayChannelAppConsumer(
			@Param("provinceId") Integer provinceId,
			@Param("channelId") Integer channelAppId,
			@Param("appId") Integer appId, @Param("dateStr") String dateStr);

	/****
	 * 查询某应用某省份某日消费金额
	 * 
	 * @param provinceId
	 * @param appId
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM-dd
	 * @return
	 */
	public Long selectDayAppConsumer(@Param("provinceId") Integer provinceId,
			@Param("appId") Integer appId, @Param("dateStr") String dateStr);

	/****
	 * 查询某应用某用户某日消费金额
	 * 
	 * @param imsi
	 * @param appId
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM-dd
	 * @return
	 */
	public Long selectDayUserAppConsumer(@Param("imsi") String imsi,
			@Param("appId") Integer appId, @Param("dateStr") String dateStr);

	/****
	 * 查询某应用某用户某月消费金额
	 * 
	 * @param imsi
	 * @param appId
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM
	 * @return
	 */
	public Long selectMonthUserAppConsumer(@Param("imsi") String imsi,
			@Param("appId") Integer appId, @Param("dateStr") String dateStr);

	/****
	 * 查询某用户某日各应用的消费金额
	 * 
	 * @param imsi
	 * @param appId
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM-dd
	 * @return
	 */
	public List<AppConsumerDto> selectUserAppsDayConsumer(
			@Param("imsi") String imsi, @Param("dateStr") String dateStr);

	/****
	 * 查询某用户某月各应用消费金额
	 * 
	 * @param imsi
	 * @param appId
	 * @param dateStr
	 *            日期字符串，格式为yyyy-MM
	 * @return
	 */
	public List<AppConsumerDto> selectUserAppsMonthConsumer(
			@Param("imsi") String imsi, @Param("dateStr") String dateStr);
}