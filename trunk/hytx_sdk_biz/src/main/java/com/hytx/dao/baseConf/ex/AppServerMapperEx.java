package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.AppServer;
import com.hytx.util.Page;

public interface AppServerMapperEx {
	/***
	 * 功能描述：按条件分页查询应用运营商配置列表
	 * 
	 * @param findAppServer
	 * @param page
	 * @return 返回应用运营商配置列表
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public List<AppServer>selectAppServerListByPage(@Param("findAppServer")AppServer findAppServer,@Param("page")Page<AppServer>page);
	/***
	 * 功能描述：按条件查询应用运营商配置记录数
	 * 
	 * @param findAppServer
	 * @param page
	 * @return 返回应用运营商配置列表
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public int countAppServer(@Param("findAppServer")AppServer findAppServer);
}