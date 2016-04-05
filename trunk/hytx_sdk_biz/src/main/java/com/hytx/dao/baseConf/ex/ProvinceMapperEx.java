package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.dto.baseConf.ProvinceDto;
import com.hytx.model.baseConf.Province;
import com.hytx.util.Page;

public interface ProvinceMapperEx {

	public List<Province> selectProvinceListByPage(
			@Param("findProvince") Province findProvince,
			@Param("page") Page<Province> page);

	public int countProvince(@Param("findProvince") Province findProvince);

	public List<ProvinceDto> selectChannelAppProvinceDtoList(
			@Param("recordId") Integer recordId);

	public List<ProvinceDto> selectOperateProvinceDtoList(
			@Param("recordId") Integer recordId);

	public List<ProvinceDto> selectAppProvinceDtoList(
			@Param("recordId") Integer recordId);
}