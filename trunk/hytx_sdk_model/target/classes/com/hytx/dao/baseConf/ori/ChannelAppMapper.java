package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelAppMapper {
    int countByExample(ChannelAppExample example);

    int deleteByExample(ChannelAppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChannelApp record);

    int insertSelective(ChannelApp record);

    List<ChannelApp> selectByExample(ChannelAppExample example);

    ChannelApp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChannelApp record, @Param("example") ChannelAppExample example);

    int updateByExample(@Param("record") ChannelApp record, @Param("example") ChannelAppExample example);

    int updateByPrimaryKeySelective(ChannelApp record);

    int updateByPrimaryKey(ChannelApp record);
}