package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.CpInfo;
import com.hytx.util.Page;

public interface ICpInfoService {
	/***
	 * 功能描述：查询CP列表
	 * 
	 * @param findCpInfo
	 * @param page
	 * @return 返回CP列表
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<CpInfo> selectCpInfosByPage(CpInfo findCpInfo, Page<CpInfo> page);

	/***
	 * 功能描述：添加CP
	 * 
	 * @param cpInfo
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int insert(CpInfo cpInfo);

	/***
	 * 功能描述：更新CP
	 * 
	 * @param cpInfo
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int updateByPrimaryKey(CpInfo cpInfo);

	/***
	 * 根据id获取CP实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public CpInfo selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除CP记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int deleteCpInfoByIds(List<Integer> idList);
	
	/***
	 * 查询所有有效的cpInfo
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<CpInfo>selectAllActiveCpInfos();
}
