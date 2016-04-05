package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.SettlementChannelApp;
import com.hytx.model.baseConf.SettlementChannelAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettlementChannelAppMapper {
    int countByExample(SettlementChannelAppExample example);

    int deleteByExample(SettlementChannelAppExample example);

    int deleteByPrimaryKey(Integer channelAppId);

    int insert(SettlementChannelApp record);

    int insertSelective(SettlementChannelApp record);

    List<SettlementChannelApp> selectByExample(SettlementChannelAppExample example);

    SettlementChannelApp selectByPrimaryKey(Integer channelAppId);

    int updateByExampleSelective(@Param("record") SettlementChannelApp record, @Param("example") SettlementChannelAppExample example);

    int updateByExample(@Param("record") SettlementChannelApp record, @Param("example") SettlementChannelAppExample example);

    int updateByPrimaryKeySelective(SettlementChannelApp record);

    int updateByPrimaryKey(SettlementChannelApp record);
}