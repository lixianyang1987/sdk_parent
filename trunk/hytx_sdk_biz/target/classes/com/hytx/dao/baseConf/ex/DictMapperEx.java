package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.Dict;
import com.hytx.util.Page;

public interface DictMapperEx {
	/***
	 * 功能描述：按条件分页查询字典列表
	 * 
	 * @param findDict
	 * @param page
	 * @return 返回字典列表
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public List<Dict>selectDictListByPage(@Param("findDict")Dict findDict,@Param("page")Page<Dict>page);
	/***
	 * 功能描述：按条件查询字典记录数
	 * 
	 * @param findDict
	 * @param page
	 * @return 返回字典列表
	 * @author houzz
	 * @since 2015年08月04日
	 */
	public int countDict(@Param("findDict")Dict findDict);
}