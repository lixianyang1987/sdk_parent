package com.hytx.service.baseConf;

import java.util.List;

import com.hytx.model.baseConf.ProvinceCity;
import com.hytx.util.Page;

public interface IProvinceCityService {
	/***
	 * 功能描述：查询城市列表
	 * 
	 * @param findProvinceCity
	 * @param page
	 * @return 返回城市列表
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public List<ProvinceCity> selectProvinceCitysByPage(
			ProvinceCity findProvinceCity, Page<ProvinceCity> page);

	/***
	 * 功能描述：按省份统计城市数
	 * 
	 * @param findProvinceCity
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public int countCitys(List<Integer> provinceIds);

	/***
	 * 功能描述：添加城市
	 * 
	 * @param provinceCity
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public int insert(ProvinceCity provinceCity);

	/***
	 * 功能描述：更新城市
	 * 
	 * @param provinceCity
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public int updateByPrimaryKeySelective(ProvinceCity provinceCity);

	/***
	 * 根据id获取城市实体
	 * 
	 * @param id
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public ProvinceCity selectByPrimaryKey(Integer id);

	/***
	 * 根据idList删除城市记录
	 * 
	 * @param idList
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public int deleteProvinceCityByIds(List<Integer> idList);

	/***
	 * 查询所有有效的城市记录
	 * 
	 * @return
	 * @author houzz
	 * @since 2015年04月29日
	 */
	public List<ProvinceCity> selectAllActiveProvinceCity();
}
