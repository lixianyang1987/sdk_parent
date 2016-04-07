package com.hytx.dao.baseConf.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.ProvinceCity;
import com.hytx.util.Page;

public interface ProvinceCityMapperEx {
	
	public List<ProvinceCity>selectProvinceCityListByPage(@Param("findProvinceCity")ProvinceCity findProvinceCity,@Param("page")Page<ProvinceCity>page);
	
	public int countProvinceCity(@Param("findProvinceCity")ProvinceCity findProvinceCity);
}