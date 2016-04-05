package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.OperateKeyword;

public interface IOperateKeywordService {
	/***
	 * 查询某指令的屏蔽信息
	 * 
	 * @param operateId
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	public List<OperateKeyword> selectOperateKeywordList(Integer operateId);

	/****
	 * 根据主键查询屏蔽信息
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @date 2015年7月13日
	 */
	public OperateKeyword selectByPrimaryKey(Integer id);

	/****
	 * 添加某指令的屏蔽信息
	 * 
	 * @param operateKeyword
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	public int insertOperateKeyword(OperateKeyword operateKeyword);

	/****
	 * 根据id列表删除指令屏蔽信息
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	public int deleteOperateKeywordByIds(List<Integer> idList);

	/****
	 * 编辑某指令的屏蔽信息
	 * 
	 * @param operateKeyword
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	public int updateOperateKeyword(OperateKeyword operateKeyword);
}
