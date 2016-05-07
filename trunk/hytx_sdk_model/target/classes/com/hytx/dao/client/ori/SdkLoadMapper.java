package com.hytx.dao.client.ori;

import com.hytx.model.client.SdkLoad;
import com.hytx.model.client.SdkLoadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkLoadMapper {
    int countByExample(SdkLoadExample example);

    int deleteByExample(SdkLoadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SdkLoad record);

    int insertSelective(SdkLoad record);

    List<SdkLoad> selectByExample(SdkLoadExample example);

    SdkLoad selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SdkLoad record, @Param("example") SdkLoadExample example);

    int updateByExample(@Param("record") SdkLoad record, @Param("example") SdkLoadExample example);

    int updateByPrimaryKeySelective(SdkLoad record);

    int updateByPrimaryKey(SdkLoad record);
}