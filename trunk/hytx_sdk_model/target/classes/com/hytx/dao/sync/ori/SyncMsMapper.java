package com.hytx.dao.sync.ori;

import com.hytx.model.sync.SyncMs;
import com.hytx.model.sync.SyncMsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyncMsMapper {
    int countByExample(SyncMsExample example);

    int deleteByExample(SyncMsExample example);

    int deleteByPrimaryKey(String linkid);

    int insert(SyncMs record);

    int insertSelective(SyncMs record);

    List<SyncMs> selectByExample(SyncMsExample example);

    SyncMs selectByPrimaryKey(String linkid);

    int updateByExampleSelective(@Param("record") SyncMs record, @Param("example") SyncMsExample example);

    int updateByExample(@Param("record") SyncMs record, @Param("example") SyncMsExample example);

    int updateByPrimaryKeySelective(SyncMs record);

    int updateByPrimaryKey(SyncMs record);
}