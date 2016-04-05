package com.hytx.service.client;

import java.util.List;
import java.util.Map;

import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.baseConf.ProvinceRef;
import com.hytx.model.client.IpInfo;
import com.hytx.model.client.ReqSmsCommand;

public interface IBaseReqService {
	Integer APP_ID_LGQB = 263;// 灵光钱包应用id

	/**
	 * 功能描述：根据channelAppKey查询渠道包数据
	 * 
	 * @param ichannelAppKey
	 * @return
	 * @author houzz
	 * @since 2015年4月12日
	 */
	public ChannelApp selectChannelAppByKey(String channelAppKey);

	/****
	 * 查询某记录设置的关联省份数据
	 * 
	 * @param recordId
	 * @param refType
	 * @return
	 */
	public List<ProvinceRef> selectOpenProvinceRef(Integer recordId,
			Integer refType);

	/****
	 * 查询用户当月消费金额
	 * 
	 * @param imsi
	 * @return
	 */
	public long selectMonthConsumer(String imsi);

	/****
	 * 查询用户当天消费金额
	 * 
	 * @param imsi
	 * @return
	 */
	public long selectDayConsumer(String imsi);

	/****
	 * 根据运营商及计费金额查询静态计费点
	 * 
	 * @param serverType
	 * @param feeValue
	 * @return
	 */
	public List<PayPoint> selectAllActivityStaticPayPoint(Integer serverType,
			Integer feeValue);

	/***
	 * 根据运营商查询动态计费点
	 * 
	 * @param serverType
	 * @return
	 */
	public List<PayPoint> selectAllActivityDynaPayPoint(Integer serverType);

	/****
	 * 根据运营商及计费金额查询渠道包的静态计费点
	 * 
	 * @param channelAppId
	 * @param serverType
	 * @param feeValue
	 * @return
	 */
	public List<PayPoint> selectChannelAppStaticActivityPayPoint(
			Integer channelAppId, Integer serverType, Integer feeValue);

	/****
	 * 获取某渠道包某省份当日消费金额
	 * 
	 * @param provinceId
	 * @param channelId
	 * @param appId
	 * @return
	 */
	public Long getChannelAppDayLimit(Integer channelId, Integer appId,
			Integer provinceId);

	/****
	 * 增加某渠道某省份包当日消费金额
	 * 
	 * @param provinceId
	 * @param channelId
	 * @param appId
	 * @param addNum
	 * @return
	 */
	public Long appendChannelAppDayLimit(Integer channelId, Integer appId,
			Integer provinceId, long addNum);

	/****
	 * 获取某应用某省份当日消费金额
	 * 
	 * @param provinceId
	 * @param appId
	 * @return
	 */
	public Long getAppDayLimit(Integer appId, Integer provinceId);

	/****
	 * 增加某应用某省份当日消费金额
	 * 
	 * @param provinceId
	 * @param appId
	 * @param addNum
	 * @return
	 */
	public Long appendAppDayLimit(Integer appId, Integer provinceId, long addNum);

	/***
	 * 查询某运营商的静态指令
	 * 
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年6月1日
	 */
	public List<Operate> selectServerStaticOperates(Integer serverType);

	/***
	 * 查询某运营商的动态指令
	 * 
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年6月1日
	 */
	public List<Operate> selectServerDynaOperates(Integer serverType);

	/****
	 * 查询所有的屏蔽信息，以指令id为key，屏蔽信息列表为值组装成map返回
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	public Map<Integer, List<OperateKeyword>> selectAllOperateKeyword();

	/****
	 * 根据ip查询ip段信息
	 * 
	 * @param ip
	 * @return
	 * @author houzz
	 * @date 2015年6月5日
	 */
	public IpInfo selectIpInfoByIp(long ip);

	/****
	 * 验证渠道包计费是否超出省份限量,渠道包计费状态为打开也认为是超出限量
	 * 
	 * @param channelApp
	 * @param provinceId
	 *            省份id,为空时认为未超限量，返回true
	 * @param feeValue
	 *            本次消费金额
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年6月8日
	 */
	public boolean validChannelApp(ChannelApp channelApp, Integer provinceId,
			Integer feeValue);

	/****
	 * 根据id查询应用
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @date 2015年6月9日
	 */
	public App selectAppById(Integer id);

	/***
	 * 查询用户在某应用下的当日消费金额，使用缓存
	 * 
	 * @param imsi
	 * @param appId
	 * @return
	 * @author houzz
	 * @date 2015年6月17日
	 */
	public Long getDayUserAppConsumer(String imsi, Integer appId);

	/***
	 * 查询用户在某应用下的当月消费金额，使用缓存
	 * 
	 * @param imsi
	 * @param appId
	 * @return
	 * @author houzz
	 * @date 2015年6月17日
	 */
	public Long getMonthUserAppConsumer(String imsi, Integer appId);

	/***
	 * 添加用户本次消费金额到指定应用当日消费金额缓存里
	 * 
	 * @param imsi
	 * @param appId
	 * @param addNum
	 * @author houzz
	 * @date 2015年6月17日
	 */
	public void addDayUserAppConsumer(String imsi, Integer appId, long addNum);

	/***
	 * 添加用户本次消费金额到指定应用当月消费金额缓存里
	 * 
	 * @param imsi
	 * @param appId
	 * @param addNum
	 * @author houzz
	 * @date 2015年6月17日
	 */
	public void addMonthUserAppConsumer(String imsi, Integer appId, long addNum);

	/***
	 * 检查某应用的省份日限量是否在允许范围内
	 * 
	 * @param appId
	 * @param provinceId
	 * @return 未超出返回true 否则返回false
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public boolean checkAppProvinceLimit(Integer appId, Integer provinceId);

	/*****
	 * 检查用户计费是否超出某应用的用户日月限
	 * 
	 * @param imsi
	 * @param serverType
	 * @param app
	 * @param feeValue
	 * @return 未超出返回true 否则返回false
	 * @author houzz
	 * @date 2015年6月23日
	 */
	public boolean checkUserAppLimit(String imsi, Integer serverType, App app,
			long feeValue);

	/***
	 * 根据应用id和运营商类型返回配置对象，如果没对应配置，返回一个新的没值的对象
	 * 
	 * @param appId
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年6月24日
	 */
	public AppServer getAppServer(Integer appId, Integer serverType);

	/****
	 * 更新返回指令的记录
	 * 
	 * @param rsc
	 * @return
	 * @author houzz
	 * @date 2015年8月5日
	 */
	public int updateReqSmsCommandByPrimaryKey(ReqSmsCommand rsc);

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
	public List<ReqSmsCommand> selectNoSyncByOrderTime(Integer appId,
			Integer feeValue, String orderDt);

	/***
	 * 根据运营商查询运营商的动态计费点
	 * 
	 * @param channelAppId
	 * @param serverType
	 * @return
	 */
	public List<PayPoint> selectCaActivityDynaPayPoint(Integer channelAppId,
			Integer serverType);

	/****
	 * 根据运营商查询渠道包配置且是生效的静态指令
	 * 
	 * @param channelAppId
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年10月8日
	 */
	List<Operate> selectCaServerStaticOperates(Integer channelAppId,
			Integer serverType);

	/****
	 * 根据运营商查询渠道包配置且是生效的动态指令
	 * 
	 * @param channelAppId
	 * @param serverType
	 * @return
	 * @author houzz
	 * @date 2015年10月8日
	 */
	List<Operate> selectCaServerDynaOperates(Integer channelAppId,
			Integer serverType);
}
