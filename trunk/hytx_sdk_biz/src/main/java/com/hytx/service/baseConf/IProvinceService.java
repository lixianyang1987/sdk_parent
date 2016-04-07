package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.dto.baseConf.ProvinceDto;
import com.hytx.model.baseConf.Province;
import com.hytx.model.system.User;
import com.hytx.util.Page;

public interface IProvinceService {
	/***
	 * 功能描述：查询省份列表
	 * 
	 * @param findProvince
	 * @param page
	 * @return 返回省份列表
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<Province> selectProvincesByPage(Province findProvince,
			Page<Province> page);

	/***
	 * 功能描述：添加省份
	 * 
	 * @param province
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int insert(Province province);

	/***
	 * 功能描述：更新省份
	 * 
	 * @param province
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int updateByPrimaryKeySelective(Province province);

	/***
	 * 根据id获取省份实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public Province selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除省份记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public int deleteProvinceByIds(List<Integer> idList);

	/***
	 * 查询所有有效的省份记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<Province> selectAllActiveProvince();

	/**
	 * 查询所有的省份dto记录，标识每个省份是否被某类型记录关联过
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年4月15日
	 */
	public List<ProvinceDto> selectChannelAppProvinceDtoList(Integer recordId);

	/**
	 * 功能描述:设置渠道包省份
	 * 
	 * @param ids
	 * @param recordId
	 * @param userSession
	 * @return
	 * @author houzz
	 * @since 2015年4月22日
	 */
	public int insertChannelAppProvinceRefs(Integer ids[], Long limits[],
			Integer recordId, User userSession);

	/**
	 * 查询所有的省份dto记录，标识每个省份是否被某应用记录关联过
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年5月25日
	 */
	public List<ProvinceDto> selectAppProvinceDtoList(Integer recordId);

	/**
	 * 功能描述:设置应用省份
	 * 
	 * @param ids
	 * @param recordId
	 * @param userSession
	 * @return
	 * @author houzz
	 * @since 2015年5月25日
	 */
	public int insertAppProvinceRefs(Integer ids[], Long limits[],
			Integer recordId, User userSession);

	/***
	 * 删除某类型数据记录也省份的关联数据
	 * 
	 * @param idList
	 * @param refType
	 *            关联数据类型 1为渠道包 2为指令 3为应用
	 * @return
	 * @author houzz
	 * @since 2015年5月25日
	 */
	public int deleteProvinceRefByRecordIdsAndType(List<Integer> idList,
			Integer refType);

	/***
	 * 根据省份名称查询省份记录
	 * 
	 * @param name
	 * @return
	 * @author houzz
	 * @date 2015年7月6日
	 */
	public Province findProvinceByName(String name);
}
