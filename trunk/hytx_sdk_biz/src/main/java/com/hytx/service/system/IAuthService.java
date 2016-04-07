package com.hytx.service.system;

import java.util.List;

import com.hytx.model.system.Auth;
import com.hytx.util.Page;

public interface IAuthService {
	/***
	 * 功能描述：按条件分页查询权限名列表
	 * 
	 * @param findAuth
	 * @param page
	 * @return 返回权限名列表
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public List<Auth> selectAuthsByPage(Auth findAuth, Page<Auth> page);

	/***
	 * 功能描述：添加权限名
	 * 
	 * @param auth
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public int insert(Auth auth);

	/***
	 * 功能描述：更新权限名
	 * 
	 * @param auth
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public int updateByPrimaryKeySelective(Auth auth);

	/***
	 * 根据id获取权限名实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public Auth selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除权限名记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public int deleteAuthByIds(List<Integer> idList);
	/***
	 * 查询所有有效的权限名记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年04月30日
	 */
	public List<Auth>selectAllActiveAuth();
}
