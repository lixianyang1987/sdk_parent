package com.hytx.service.count;

import java.util.List;

import com.hytx.dto.client.ReqSmsCommandDto;
import com.hytx.dto.client.ReqSmsLogDto;
import com.hytx.util.Page;

public interface IReqSmsCountService {
	/***
	 * 功能描述：按条件分页查询sdk请求短信列表
	 * 
	 * @param findReqSms
	 * @param page
	 * @return 返回sdk请求短信列表
	 * @author houzz
	 * @since 2015年05月13日
	 */
	public List<ReqSmsLogDto> selectReqSmssByPage(ReqSmsLogDto findReqSms,
			Page<ReqSmsLogDto> page);

	/***
	 * 查询请求短串数据
	 * 
	 * @param orderId
	 * @return
	 * @author houzz
	 * @date 2015年6月25日
	 */
	public List<ReqSmsCommandDto> findReqSmsCommands(String orderId);
}
