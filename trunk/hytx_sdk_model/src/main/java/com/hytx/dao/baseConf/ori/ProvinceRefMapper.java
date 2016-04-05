package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.ProvinceRef;
import com.hytx.model.baseConf.ProvinceRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceRefMapper {
    int countByExample(ProvinceRefExample example);

    int deleteByExample(ProvinceRefExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProvinceRef record);

    int insertSelective(ProvinceRef record);

    List<ProvinceRef> selectByExample(ProvinceRefExample example);

    ProvinceRef selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProvinceRef record, @Param("example") ProvinceRefExample example);

    int updateByExample(@Param("record") ProvinceRef record, @Param("example") ProvinceRefExample example);

    int updateByPrimaryKeySelective(ProvinceRef record);

    int updateByPrimaryKey(ProvinceRef record);
}