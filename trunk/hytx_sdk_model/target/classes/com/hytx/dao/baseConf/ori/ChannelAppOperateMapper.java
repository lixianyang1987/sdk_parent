package com.hytx.dao.baseConf.ori;

import com.hytx.model.baseConf.ChannelAppOperate;
import com.hytx.model.baseConf.ChannelAppOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelAppOperateMapper {
    int countByExample(ChannelAppOperateExample example);

    int deleteByExample(ChannelAppOperateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChannelAppOperate record);

    int insertSelective(ChannelAppOperate record);

    List<ChannelAppOperate> selectByExample(ChannelAppOperateExample example);

    ChannelAppOperate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChannelAppOperate record, @Param("example") ChannelAppOperateExample example);

    int updateByExample(@Param("record") ChannelAppOperate record, @Param("example") ChannelAppOperateExample example);

    int updateByPrimaryKeySelective(ChannelAppOperate record);

    int updateByPrimaryKey(ChannelAppOperate record);
}