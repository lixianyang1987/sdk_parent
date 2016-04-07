package com.hytx.dao.baseConf.ori;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hytx.model.baseConf.ChannelAppPayPoint;
import com.hytx.model.baseConf.ChannelAppPayPointExample;

public interface ChannelAppPayPointMapper {
    int countByExample(ChannelAppPayPointExample example);

    int deleteByExample(ChannelAppPayPointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChannelAppPayPoint record);

    int insertSelective(ChannelAppPayPoint record);

    List<ChannelAppPayPoint> selectByExample(ChannelAppPayPointExample example);

    ChannelAppPayPoint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChannelAppPayPoint record, @Param("example") ChannelAppPayPointExample example);

    int updateByExample(@Param("record") ChannelAppPayPoint record, @Param("example") ChannelAppPayPointExample example);

    int updateByPrimaryKeySelective(ChannelAppPayPoint record);

    int updateByPrimaryKey(ChannelAppPayPoint record);
}