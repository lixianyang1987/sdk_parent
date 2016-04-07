package com.hytx.dao.client.ori;

import com.hytx.model.client.SdkInfo;
import com.hytx.model.client.SdkInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SdkInfoMapper {
    int countByExample(SdkInfoExample example);

    int deleteByExample(SdkInfoExample example);

    int deleteByPrimaryKey(String imsi);

    int insert(SdkInfo record);

    int insertSelective(SdkInfo record);

    List<SdkInfo> selectByExample(SdkInfoExample example);

    SdkInfo selectByPrimaryKey(String imsi);

    int updateByExampleSelective(@Param("record") SdkInfo record, @Param("example") SdkInfoExample example);

    int updateByExample(@Param("record") SdkInfo record, @Param("example") SdkInfoExample example);

    int updateByPrimaryKeySelective(SdkInfo record);

    int updateByPrimaryKey(SdkInfo record);
}