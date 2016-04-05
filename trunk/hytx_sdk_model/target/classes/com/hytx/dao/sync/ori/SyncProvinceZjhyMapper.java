package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncProvinceZjhy;
import com.hytx.model.sync.SyncProvinceZjhyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncProvinceZjhyMapper {
    int countByExample(SyncProvinceZjhyExample example);

    int deleteByExample(SyncProvinceZjhyExample example);

    int deleteByPrimaryKey(Integer provinceid);

    int insert(SyncProvinceZjhy record);

    int insertSelective(SyncProvinceZjhy record);

    List<SyncProvinceZjhy> selectByExample(SyncProvinceZjhyExample example);

    SyncProvinceZjhy selectByPrimaryKey(Integer provinceid);

    int updateByExampleSelective(@Param("record") SyncProvinceZjhy record, @Param("example") SyncProvinceZjhyExample example);

    int updateByExample(@Param("record") SyncProvinceZjhy record, @Param("example") SyncProvinceZjhyExample example);

    int updateByPrimaryKeySelective(SyncProvinceZjhy record);

    int updateByPrimaryKey(SyncProvinceZjhy record);
}