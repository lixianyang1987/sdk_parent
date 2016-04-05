package com.hytx.dao.syncEx.ori;

import com.hytx.model.syncEx.SyncLtyy;
import com.hytx.model.syncEx.SyncLtyyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncLtyyMapper {
    int countByExample(SyncLtyyExample example);

    int deleteByExample(SyncLtyyExample example);

    int deleteByPrimaryKey(String linkId);

    int insert(SyncLtyy record);

    int insertSelective(SyncLtyy record);

    List<SyncLtyy> selectByExample(SyncLtyyExample example);

    SyncLtyy selectByPrimaryKey(String linkId);

    int updateByExampleSelective(@Param("record") SyncLtyy record, @Param("example") SyncLtyyExample example);

    int updateByExample(@Param("record") SyncLtyy record, @Param("example") SyncLtyyExample example);

    int updateByPrimaryKeySelective(SyncLtyy record);

    int updateByPrimaryKey(SyncLtyy record);
}