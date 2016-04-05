package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncTtf;
import com.hytx.model.sync.SyncTtfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncTtfMapper {
    int countByExample(SyncTtfExample example);

    int deleteByExample(SyncTtfExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SyncTtf record);

    int insertSelective(SyncTtf record);

    List<SyncTtf> selectByExample(SyncTtfExample example);

    SyncTtf selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SyncTtf record, @Param("example") SyncTtfExample example);

    int updateByExample(@Param("record") SyncTtf record, @Param("example") SyncTtfExample example);

    int updateByPrimaryKeySelective(SyncTtf record);

    int updateByPrimaryKey(SyncTtf record);
}