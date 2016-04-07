package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.AppServer;
import com.hytx.util.Page;

public interface IAppServerService {
	/***
	 * 功能描述：按条件分页查询应用运营商配置列表
	 * 
	 * @param findAppServer
	 * @param page
	 * @return 返回应用运营商配置列表
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public List<AppServer> selectAppServersByPage(AppServer findAppServer,
			Page<AppServer> page);

	/***
	 * 功能描述：添加应用运营商配置
	 * 
	 * @param appServer
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public int insert(AppServer appServer);

	/***
	 * 功能描述：更新应用运营商配置
	 * 
	 * @param appServer
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public int updateByPrimaryKeySelective(AppServer appServer);

	/***
	 * 根据id获取应用运营商配置实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public AppServer selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除应用运营商配置记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public int deleteAppServerByIds(List<Integer> idList);

	/***
	 * 查询所有有效的应用运营商配置记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年06月23日
	 */
	public List<AppServer> selectAllActiveAppServer();

	/***
	 * 根据应用ids删除应用配置
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @date 2015年6月24日
	 */
	public int deleteByAppIds(List<Integer> idList);

	/****
	 * 根据应用ids查询应用配置
	 * 
	 * @param appIds
	 * @return
	 * @author houzz
	 * @date 2015年8月27日
	 */
	List<AppServer> selectAppServersByAppIds(List<Integer> appIds);
}
