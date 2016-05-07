package com.hytx.dao.syncEx.ori;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.syncEx.TsyncexSky;
import com.hytx.model.syncEx.TsyncexSkyExample;

public interface TsyncexSkyMapper {
    int countByExample(TsyncexSkyExample example);

    int deleteByExample(TsyncexSkyExample example);

    int deleteByPrimaryKey(String linkid);

    int insert(TsyncexSky record);

    int insertSelective(TsyncexSky record);

    List<TsyncexSky> selectByExample(TsyncexSkyExample example);

    TsyncexSky selectByPrimaryKey(String linkid);

    int updateByExampleSelective(@Param("record") TsyncexSky record, @Param("example") TsyncexSkyExample example);

    int updateByExample(@Param("record") TsyncexSky record, @Param("example") TsyncexSkyExample example);

    int updateByPrimaryKeySelective(TsyncexSky record);

    int updateByPrimaryKey(TsyncexSky record);
}