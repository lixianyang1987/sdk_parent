package com.hytx.dao.count.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.hytx.model.syncEx.TActivationVolume;
import com.hytx.util.Page;

public interface SyncActivationVolumeMapperEx {

	/**
	 * 功能描述：按条件分页查询列表
	 * 
	 * @param findDto
	 * @param page
	 * @return
	 * @author lixy
	 * @since 2016年3月23日
	 */
	public List<TActivationVolume> selectSyncActivationVolumeListPage(
			@Param("findDto") TActivationVolume findDto,
			@Param("page") Page<TActivationVolume> page);

	/**
	 * 功能描述：按条件查询总数
	 * 
	 * @param findDto
	 * @return
	 * @author lixy
	 * @since 2016年3月23日
	 */
	public int countSyncActivationVolume(@Param("findDto") TActivationVolume findDto);
}