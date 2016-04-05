package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.ProvinceCity;
import com.hytx.model.baseConf.ProvinceCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceCityMapper {
    int countByExample(ProvinceCityExample example);

    int deleteByExample(ProvinceCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProvinceCity record);

    int insertSelective(ProvinceCity record);

    List<ProvinceCity> selectByExample(ProvinceCityExample example);

    ProvinceCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProvinceCity record, @Param("example") ProvinceCityExample example);

    int updateByExample(@Param("record") ProvinceCity record, @Param("example") ProvinceCityExample example);

    int updateByPrimaryKeySelective(ProvinceCity record);

    int updateByPrimaryKey(ProvinceCity record);
}