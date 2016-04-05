package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.CpInfo;
import com.hytx.model.baseConf.CpInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CpInfoMapper {
    int countByExample(CpInfoExample example);

    int deleteByExample(CpInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CpInfo record);

    int insertSelective(CpInfo record);

    List<CpInfo> selectByExample(CpInfoExample example);

    CpInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CpInfo record, @Param("example") CpInfoExample example);

    int updateByExample(@Param("record") CpInfo record, @Param("example") CpInfoExample example);

    int updateByPrimaryKeySelective(CpInfo record);

    int updateByPrimaryKey(CpInfo record);
}