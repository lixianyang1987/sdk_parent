package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.dto.baseConf.OperateDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.util.Page;

public interface IOperateService {
	/***
	 * 功能描述：查询通道列表
	 * 
	 * @param findOperate
	 * @param page
	 * @return 返回通道列表
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public List<Operate> selectOperatesByPage(OperateDto findOperate,
			Page<Operate> page);

	/***
	 * 功能描述：添加通道
	 * 
	 * @param operate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int insert(Operate operate);

	/***
	 * 功能描述：更新通道
	 * 
	 * @param operate
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int updateByPrimaryKey(Operate operate);

	/***
	 * 根据id获取通道实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public Operate selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除通道记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月9日
	 */
	public int deleteOperateByIds(List<Integer> idList);

	/****
	 * 查询某运营商下某应用的指令，按资费升序排序返回
	 * 
	 * @param serverType
	 * @param appId
	 * @return
	 * @author houzz
	 * @since 2015年5月13日
	 */
	public List<Operate> selectReqSmsOperate(Integer serverType, Integer appId);

	/****
	 * 根据计费点查询指令
	 * 
	 * @param payPointId
	 * @return
	 * @author houzz
	 * @since 2015年5月26日
	 */
	public List<Operate> selectOperateByPayPointIds(Integer payPointId);

	/****
	 * 根据应用查询有效的指令
	 * 
	 * @param appId
	 * @param serverType
	 * @return
	 * @author houzz
	 * @since 2015年9月2日
	 */
	List<Operate> selectActivityOperatesByAppId(Integer appId,
			Integer serverType);
}
