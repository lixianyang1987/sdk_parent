package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncShyy;
import com.hytx.model.sync.SyncShyyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncShyyMapper {
    int countByExample(SyncShyyExample example);

    int deleteByExample(SyncShyyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncShyy record);

    int insertSelective(SyncShyy record);

    List<SyncShyy> selectByExample(SyncShyyExample example);

    SyncShyy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncShyy record, @Param("example") SyncShyyExample example);

    int updateByExample(@Param("record") SyncShyy record, @Param("example") SyncShyyExample example);

    int updateByPrimaryKeySelective(SyncShyy record);

    int updateByPrimaryKey(SyncShyy record);
}