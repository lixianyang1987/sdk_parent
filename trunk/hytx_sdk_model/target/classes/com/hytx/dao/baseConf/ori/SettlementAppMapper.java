package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.SettlementApp;
import com.hytx.model.baseConf.SettlementAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementAppMapper {
    int countByExample(SettlementAppExample example);

    int deleteByExample(SettlementAppExample example);

    int deleteByPrimaryKey(Integer appId);

    int insert(SettlementApp record);

    int insertSelective(SettlementApp record);

    List<SettlementApp> selectByExample(SettlementAppExample example);

    SettlementApp selectByPrimaryKey(Integer appId);

    int updateByExampleSelective(@Param("record") SettlementApp record, @Param("example") SettlementAppExample example);

    int updateByExample(@Param("record") SettlementApp record, @Param("example") SettlementAppExample example);

    int updateByPrimaryKeySelective(SettlementApp record);

    int updateByPrimaryKey(SettlementApp record);
}