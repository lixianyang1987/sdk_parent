package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncHddxOr;
import com.hytx.model.sync.SyncHddxOrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncHddxOrMapper {
    int countByExample(SyncHddxOrExample example);

    int deleteByExample(SyncHddxOrExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncHddxOr record);

    int insertSelective(SyncHddxOr record);

    List<SyncHddxOr> selectByExample(SyncHddxOrExample example);

    SyncHddxOr selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncHddxOr record, @Param("example") SyncHddxOrExample example);

    int updateByExample(@Param("record") SyncHddxOr record, @Param("example") SyncHddxOrExample example);

    int updateByPrimaryKeySelective(SyncHddxOr record);

    int updateByPrimaryKey(SyncHddxOr record);
}