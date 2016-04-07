package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.client.ReqSmsCommandDto;
import com.hytx.dto.client.ReqSmsLogDto;
import com.hytx.util.Page;

public interface ReqSmsLogMapperEx {
	/***
	 * 功能描述：按条件分页查询sdk请求短信列表
	 * 
	 * @param findReqSms
	 * @param page
	 * @return 返回sdk请求短信列表
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public List<ReqSmsLogDto> selectReqSmsListByPage(
			@Param("findReqSms") ReqSmsLogDto findReqSms,
			@Param("page") Page<ReqSmsLogDto> page);

	/***
	 * 功能描述：按条件查询sdk请求短信记录数
	 * 
	 * @param findReqSms
	 * @param page
	 * @return 返回sdk请求短信列表
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public int countReqSms(@Param("findReqSms") ReqSmsLogDto findReqSms);

	/***
	 * 查询请求短串数据
	 * 
	 * @param orderId
	 * @return
	 * @author houzz
	 * @date 2015年6月25日
	 */
	List<ReqSmsCommandDto> findReqSmsCommands(@Param("orderId") String orderId);
}
