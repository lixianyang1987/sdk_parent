package com.hytx.dao.list.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.list.UserFilterList;
import com.hytx.util.Page;

public interface UserFilterListMapperEx {
	/***
	 * 功能描述：按条件分页查询黑白名单列表
	 * 
	 * @param findUserFilterList
	 * @param page
	 * @return 返回黑白名单列表
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public List<UserFilterList>selectUserFilterListListByPage(@Param("findUserFilterList")UserFilterList findUserFilterList,@Param("page")Page<UserFilterList>page);
	/***
	 * 功能描述：按条件查询黑白名单记录数
	 * 
	 * @param findUserFilterList
	 * @param page
	 * @return 返回黑白名单列表
	 * @author houzz
	 * @since 2015年07月02日
	 */
	public int countUserFilterList(@Param("findUserFilterList")UserFilterList findUserFilterList);
}