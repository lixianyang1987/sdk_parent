package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncQsxxby;
import com.hytx.model.sync.SyncQsxxbyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncQsxxbyMapper {
    int countByExample(SyncQsxxbyExample example);

    int deleteByExample(SyncQsxxbyExample example);

    int deleteByPrimaryKey(String morid);

    int insert(SyncQsxxby record);

    int insertSelective(SyncQsxxby record);

    List<SyncQsxxby> selectByExample(SyncQsxxbyExample example);

    SyncQsxxby selectByPrimaryKey(String morid);

    int updateByExampleSelective(@Param("record") SyncQsxxby record, @Param("example") SyncQsxxbyExample example);

    int updateByExample(@Param("record") SyncQsxxby record, @Param("example") SyncQsxxbyExample example);

    int updateByPrimaryKeySelective(SyncQsxxby record);

    int updateByPrimaryKey(SyncQsxxby record);
}