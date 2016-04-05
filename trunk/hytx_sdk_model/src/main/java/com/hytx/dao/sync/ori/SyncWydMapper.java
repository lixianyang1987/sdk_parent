package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncWyd;
import com.hytx.model.sync.SyncWydExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncWydMapper {
    int countByExample(SyncWydExample example);

    int deleteByExample(SyncWydExample example);

    int insert(SyncWyd record);

    int insertSelective(SyncWyd record);

    List<SyncWyd> selectByExample(SyncWydExample example);

    int updateByExampleSelective(@Param("record") SyncWyd record, @Param("example") SyncWydExample example);

    int updateByExample(@Param("record") SyncWyd record, @Param("example") SyncWydExample example);
}