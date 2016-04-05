package com.hytx.service.list;

import java.util.List;

import com.hytx.model.list.UserFilterList;
import com.hytx.util.Page;

public interface IUserFilterListService {
	/***
	 * 功能描述：按条件分页查询黑白名单列表
	 * 
	 * @param findUserFilterList
	 * @param page
	 * @return 返回黑白名单列表
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public List<UserFilterList> selectUserFilterListsByPage(
			UserFilterList findUserFilterList, Page<UserFilterList> page);

	/***
	 * 功能描述：添加黑白名单
	 * 
	 * @param userFilterList
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public int insert(UserFilterList userFilterList);

	/***
	 * 功能描述：更新黑白名单
	 * 
	 * @param userFilterList
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public int updateByPrimaryKeySelective(UserFilterList userFilterList);

	/***
	 * 根据id获取黑白名单实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public UserFilterList selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除黑白名单记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public int deleteUserFilterListByIds(List<Integer> idList);

	/***
	 * 根据imsi检查用户的黑白名单类型，如果不在黑白名单中返回null
	 * 
	 * @param imsi
	 * @return
	 * @author houzz
	 * @date 2015年7月2日
	 */
	public Integer checkUserFilterType(String imsi);
}
