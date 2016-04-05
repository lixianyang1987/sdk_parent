package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncHhai;
import com.hytx.model.sync.SyncHhaiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncHhaiMapper {
    int countByExample(SyncHhaiExample example);

    int deleteByExample(SyncHhaiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncHhai record);

    int insertSelective(SyncHhai record);

    List<SyncHhai> selectByExample(SyncHhaiExample example);

    SyncHhai selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncHhai record, @Param("example") SyncHhaiExample example);

    int updateByExample(@Param("record") SyncHhai record, @Param("example") SyncHhaiExample example);

    int updateByPrimaryKeySelective(SyncHhai record);

    int updateByPrimaryKey(SyncHhai record);
}