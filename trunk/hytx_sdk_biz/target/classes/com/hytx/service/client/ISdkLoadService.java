package com.hytx.service.client;

import java.util.List;

import com.hytx.dto.client.SdkLoadDto;
import com.hytx.model.client.SdkLoad;
import com.hytx.util.Page;

public interface ISdkLoadService {
	/****
	 * 按条件分页查询sdk启动记录
	 * 
	 * @param findDto
	 * @param page
	 * @return
	 * @author houzz
	 * @date 2015年8月7日
	 */
	public List<SdkLoadDto> selectAppsByPage(SdkLoadDto findDto,
			Page<SdkLoadDto> page);

	/****
	 * 添加sdk启动记录
	 * 
	 * @param record
	 * @return
	 * @author houzz
	 * @date 2015年8月7日
	 */
	public int insertSdkLoad(SdkLoad record);
}
