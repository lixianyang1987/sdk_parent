package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.PayPoint;
import com.hytx.util.Page;

public interface IPayPointService {
	/***
	 * 功能描述：按条件分页查询计费点列表
	 * 
	 * @param findPayPoint
	 * @param page
	 * @return 返回计费点列表
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public List<PayPoint> selectPayPointsByPage(PayPoint findPayPoint,
			Page<PayPoint> page);

	/***
	 * 功能描述：添加计费点
	 * 
	 * @param payPoint
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public int insert(PayPoint payPoint);

	/***
	 * 功能描述：更新计费点
	 * 
	 * @param payPoint
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public int updateByPrimaryKeySelective(PayPoint payPoint);

	/***
	 * 根据id获取计费点实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public PayPoint selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除计费点记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public int deletePayPointByIds(List<Integer> idList);

	/***
	 * 根据应用idList删除计费点记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年05月25日
	 */
	public int deletePayPointByAppIds(List<Integer> idList);

	/***
	 * 查询所有有效的计费点记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年05月18日
	 */
	public List<PayPoint> selectAllActivePayPoint();

	/***
	 * 根据指令idList删除计费点记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年05月25日
	 */
	public int deletePayPointByOpIds(List<Integer> idList);

	/****
	 * 假设指定appId的应用设置指令为私有，则查询不合法的计费点
	 * 
	 * @param appId
	 * @return
	 * @author houzz
	 * @date 2015年8月4日
	 */
	public List<PayPoint> selectIllegePayPoints(Integer appId,
			Integer serverType);

	/****
	 * 检查计费点是否合法，返回检查错误提示，无错误返回null
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @date 2015年8月27日
	 */
	String checkOpenConditionError(Integer id);

	int updatePayPointStatusByOpIds(List<Integer> idList, Integer status);
}
