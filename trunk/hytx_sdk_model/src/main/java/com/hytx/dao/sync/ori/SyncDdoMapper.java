package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncDdo;
import com.hytx.model.sync.SyncDdoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncDdoMapper {
    int countByExample(SyncDdoExample example);

    int deleteByExample(SyncDdoExample example);

    int insert(SyncDdo record);

    int insertSelective(SyncDdo record);

    List<SyncDdo> selectByExample(SyncDdoExample example);

    int updateByExampleSelective(@Param("record") SyncDdo record, @Param("example") SyncDdoExample example);

    int updateByExample(@Param("record") SyncDdo record, @Param("example") SyncDdoExample example);
}