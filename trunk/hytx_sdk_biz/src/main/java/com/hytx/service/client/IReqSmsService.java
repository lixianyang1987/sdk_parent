package com.hytx.service.client;

import java.util.Date;
import java.util.List;

import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;

public interface IReqSmsService {
	/***
	 * 功能描述：添加sdk请求短信
	 * 
	 * @param reqSms
	 * @return
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public int insert(ReqSms reqSms);

	/***
	 * 功能描述：更新sdk请求短信
	 * 
	 * @param reqSms
	 * @return
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public int updateByPrimaryKeySelective(ReqSms reqSms);

	/***
	 * 根据id获取sdk请求短信实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public ReqSms selectByPrimaryKey(String id);

	/***
	 * 功能描述：查询订单指令
	 * 
	 * @param orderId
	 * @return
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public List<ReqSmsCommand> selectReqSmsCommandByOrderId(String orderId);

	/***
	 * 功能描述：查询订单指令
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @return
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public List<ReqSmsCommand> findCommandList(ReqSms smsReq,
			BaseReqDto baseReqDto);

	/****
	 * 更新指令发送状态
	 * 
	 * @param commandIdList
	 * @param statusList
	 * @param orderDt
	 * @return
	 */
	public int updateReqSmsResult(List<Long> commandIdList,
			List<Integer> statusList, Date orderDt, BaseReqDto baseReqDto);

	/*****
	 * 查找某资费的最佳计费点，优先顺序为1：同应用内相同paycode的静态计费点，2：同应用内的静态计费点，
	 * 3:同应用的动态计费点,4不同应用的静态计费点，5不同应用的态动计费点,暂时只找相同应用的计费点
	 * 
	 * @param smsReq
	 * @param baseReqDto
	 * @return
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public PayPoint findBestPayPoint(ReqSms smsReq, BaseReqDto baseReqDto);

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
	public List<ReqSmsCommand> selectUserFailCommandList(String imsi,
			String startDate, Integer serverType);

	Integer getNextSerialNum();
	// String getSevenFormatSerialNum();

}
