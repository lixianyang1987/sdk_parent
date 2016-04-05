package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.Dict;
import com.hytx.util.Page;

public interface IDictService {
	/***
	 * 功能描述：按条件分页查询字典列表
	 * 
	 * @param findDict
	 * @param page
	 * @return 返回字典列表
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public List<Dict> selectDictsByPage(Dict findDict, Page<Dict> page);

	/***
	 * 功能描述：添加字典
	 * 
	 * @param dict
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public int insert(Dict dict);

	/***
	 * 功能描述：更新字典
	 * 
	 * @param dict
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public int updateByPrimaryKeySelective(Dict dict);

	/***
	 * 根据id获取字典实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public Dict selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除字典记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public int deleteDictByIds(List<Integer> idList);

	/***
	 * 查询所有有效的字典记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public List<Dict> selectAllActiveDict();

	/***
	 * 根据key查询字典
	 * 
	 * @param key
	 * @return
	 * @author houzz
	 * @date 2015年8月4日
	 */
	public Dict selectDictByKey(String key);

	/***
	 * 根据key查询生效的字典
	 * 
	 * @param key
	 * @return
	 * @author houzz
	 * @date 2015年8月4日
	 */
	public Dict selectActiviteDictByKey(String key);

	/***
	 * 检查是否是信支付白名单号码
	 * 
	 * @param mobile
	 * @return
	 * @author houzz
	 * @date 2016年1月8日
	 */
	boolean isInXzfWhiteList(String mobile);
}
