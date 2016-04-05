package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.PayPointOperate;

public interface IPayPointOperateService {
	/***
	 * 功能描述：查询已添加的计费点指令列表
	 * 
	 * @param payPointOperate
	 * @return 返回指令列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<OperateDto> selectPayPointOperates(
			PayPointOperate payPointOperate);

	/***
	 * 功能描述：添加的计费点指令
	 * 
	 * @param payPointOperate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int insertPayPointOperate(PayPointOperate payPointOperate);

	/***
	 * 功能描述：根据idList删除计费点指令
	 * 
	 * @param idList
	 * @param payPointId
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int deletePayPointOperateByIds(List<Integer> idList,
			Integer payPointId);
}
