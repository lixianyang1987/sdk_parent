package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncSk;
import com.hytx.model.sync.SyncSkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncSkMapper {
    int countByExample(SyncSkExample example);

    int deleteByExample(SyncSkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncSk record);

    int insertSelective(SyncSk record);

    List<SyncSk> selectByExample(SyncSkExample example);

    SyncSk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncSk record, @Param("example") SyncSkExample example);

    int updateByExample(@Param("record") SyncSk record, @Param("example") SyncSkExample example);

    int updateByPrimaryKeySelective(SyncSk record);

    int updateByPrimaryKey(SyncSk record);
}